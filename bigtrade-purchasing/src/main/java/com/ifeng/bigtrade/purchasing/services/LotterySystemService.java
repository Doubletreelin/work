package com.ifeng.bigtrade.purchasing.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.purchasing.entites.PApplicationDetail;
import com.ifeng.bigtrade.purchasing.entites.PApplicationDetailExample;
import com.ifeng.bigtrade.purchasing.entites.PIssuancePlan;
import com.ifeng.bigtrade.purchasing.entites.PLotteryResultDetail;
import com.ifeng.bigtrade.purchasing.entites.PLotteryResultDetailExample;
import com.ifeng.bigtrade.purchasing.entites.PLotteryResultDetailExample.Criteria;
import com.ifeng.bigtrade.purchasing.entites.PLotteryResultExample;
import com.ifeng.bigtrade.purchasing.entites.PLotteryResultWithBLOBs;
import com.ifeng.bigtrade.purchasing.entites.enumf.EApplicationDetailStatus;
import com.ifeng.bigtrade.purchasing.entites.enumf.EIssuanceplanType;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespCode;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.purchasing.filters.PageReq;
import com.ifeng.bigtrade.purchasing.mapper.PApplicationDetailMapper;
import com.ifeng.bigtrade.purchasing.mapper.PIssuancePlanMapper;
import com.ifeng.bigtrade.purchasing.mapper.PLotteryResultDetailMapper;
import com.ifeng.bigtrade.purchasing.mapper.PLotteryResultMapper;
import com.ifeng.bigtrade.purchasing.tools.CommUtil;

/**
 * 关于申购摇号的service
 * 
 * @author shaolin
 */
@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class LotterySystemService extends BaseService
{
	@Autowired
	private PApplicationDetailMapper applicationMapper;
	@Autowired
	private PIssuancePlanMapper issuanceMapper;
	@Autowired
	private PLotteryResultMapper resultMapper;
	@Autowired
	private PLotteryResultDetailMapper resultDetailMapper;

	public ResponseMessage allocateNumber(HttpServletRequest request, Long planid, Long operatorid, String operatorname,
			String operatorip) throws Exception
	{
		PIssuancePlan plan = this.issuanceMapper.selectByPrimaryKey(planid);
		if (plan == null)
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "未查询到该发行计划"), null);
		}
		if (!plan.getStatus().equals(EIssuanceplanType.normal.getId()) && !plan.getStatus().equals(EIssuanceplanType.auditSuccess.getId()))
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "该计划不是正常状态，不能分配号码"), null);
		}
		PApplicationDetailExample applicationExample = new PApplicationDetailExample();
		applicationExample.setOrderByClause("id asc");
		// 只有第二步的申购才能分配号码
		applicationExample.createCriteria().andIssuanceplan_idEqualTo(planid)
				.andStatusEqualTo(EApplicationDetailStatus.step2.getId());
		List<PApplicationDetail> detailList = this.applicationMapper.selectByExample(applicationExample);
		Integer num = 1;
		int allCount = 0;
		for (int i = 0; i < detailList.size(); i++)
		{
			PApplicationDetail detail = detailList.get(i);
			detail.setStartNo(CommUtil.addFrontZeroFor(num));
			allCount = allCount + detail.getCount();
			detail.setEndNo(CommUtil.addFrontZeroFor(num + detail.getCount() - 1));
			num = num + detail.getCount();
			detail.setStatus(EApplicationDetailStatus.allocated.getId());
			this.applicationMapper.updateByPrimaryKeySelective(detail);
		}
		plan.setStatus(EIssuanceplanType.allocated.getId());
		plan.setAllocateUserIp(operatorip);
		plan.setAllocateUserId(operatorid);
		plan.setAllocateUserName(operatorname);
		plan.setApplicationCount(allCount);
		this.issuanceMapper.updateByPrimaryKeySelective(plan);
		logger.info(
				"id为" + planid + "的发行计划已经分配号码，操作人id为" + operatorid + "，操作人为" + operatorname + ",操作人ip为" + operatorip);
		HashMap<String, Object> rmap = new HashMap<>();
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 摇号
	 * 
	 * @param request
	 * @param id
	 * @param operatorid
	 * @param operatorname
	 * @param operatorip
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月11日 下午5:33:28
	 */
	public ResponseMessage lotterySystem(HttpServletRequest request, Long id, Long operatorid, String operatorname,
			String operatorip) throws Exception
	{
		PIssuancePlan plan = this.issuanceMapper.selectByPrimaryKey(id);
		if (plan == null)
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "未查询到该发行计划"), null);
		}
		if (plan.getStatus() < EIssuanceplanType.allocated.getId())
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "该计划还没分配号码，不能摇号"), null);
		}
		if (plan.getStatus().equals(EIssuanceplanType.lottery.getId()))
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "该计划已经摇号，不能再次摇号"), null);
		}
		int distributeNum = plan.getTotalQuantity();// 发行计划发行总数
		// long purchaseNum = this.applicationMapper.countSumByIssuanceplanId(id);
		// 发行计划申购总数
		int purchaseNum = plan.getApplicationCount();// 直接根据计划字段获取总数
		double allocationRate = 0;
		if (distributeNum < purchaseNum)
		{
			allocationRate = CommUtil.formatMoneyByType(distributeNum * 1.0 / purchaseNum, "#.0000");
		} else
		{
			allocationRate = 1;
		}
		// 随机获取摇号结果
		Map<String, String> winner = this.lotterwinner(purchaseNum, distributeNum);
		// 添加摇号结果
		PLotteryResultWithBLOBs result = new PLotteryResultWithBLOBs();
		result.setAddTime(new Date());
		result.setDeleteStatus(false);
		result.setIssuanceplan_id(plan.getId());
		result.setLotteryResult(winner.get("winnerAll"));
		result.setLotteryResultShow(winner.get("winner"));
		result.setWinningRate(new BigDecimal(allocationRate));
		result.setOperatorId(operatorid);
		result.setOperatorName(operatorname);
		result.setOperatorIp(operatorip);
		this.resultMapper.insert(result);
		// 更新发行计划的状态
		plan.setStatus(EIssuanceplanType.lottery.getId());
		this.issuanceMapper.updateByPrimaryKeySelective(plan);
		// 返回
		this.lotterySystemDetail(request, id, result);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("result", result);
		logger.info("id为" + id + "的发型计划已经摇号成功，操作人id为" + operatorid + "，操作人姓名为" + operatorname + "，操作人ip为" + operatorip);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 获取摇号结果
	 * 
	 * @param purchaseNum
	 * @param distributeNum
	 * @return
	 * @author shaolin
	 * @time 2017年9月12日 上午10:01:37
	 */
	public Map<String, String> lotterwinner(long purchaseNum, long distributeNum)
	{
		Map<String, String> rmap = new HashMap<>();
		String winner = "";
		if (purchaseNum <= distributeNum)
		{
			for (int i = 1; i <= purchaseNum; i++)
			{
				winner = winner + CommUtil.addFrontZeroFor(i) + ",";
			}
			rmap.put("winnerAll", winner.substring(0, winner.length() - 1));
			rmap.put("winner", "末\"1\"位数为：0、1、2、3、4、5、6、7、8、9");
			return rmap;
		} else
		{
			Map<String, Integer> winnermap = this.getLottery(purchaseNum, distributeNum);
			rmap.put("winnerAll", formatWinnerStr(winnermap));
			String winnerResult = getWinnerResult(winnermap);
			rmap.put("winner", winnerResult);
			return rmap;
		}
	}

	/**
	 * 返回末“n”位数：a、b、c、d 样式的结果
	 * 
	 * @param winnermap
	 * @return
	 * @author shaolin
	 */
	public String getWinnerResult(Map<String, Integer> winnermap)
	{
		HashMap<Integer, List<String>> map = new HashMap<>();
		Iterator<String> it = winnermap.keySet().iterator();
		while (it.hasNext())
		{
			String key = it.next();
			List<String> list = map.get(key.length());
			if (list != null && list.size() > 0)
			{
				list.add(key);
			} else
			{
				list = new ArrayList<>();
				list.add(key);
				map.put(key.length(), list);
			}
		}
		List<Integer> keylist = new ArrayList<>();
		HashMap<Integer, String> keymap = new HashMap<>();
		Iterator<Integer> its = map.keySet().iterator();
		while (its.hasNext())
		{
			Integer key = its.next();
			keylist.add(key);
			List<String> list = map.get(key);
			String str = "末“" + key + "”位数：";
			for (int i = 0; i < list.size(); i++)
			{
				if (i < list.size() - 1)
				{
					str = str + list.get(i) + "、";
				} else
				{
					str = str + list.get(i);
				}
			}
			keymap.put(key, str);
		}
		Collections.sort(keylist, new Comparator<Integer>()
		{
			public int compare(Integer arg0, Integer arg1)
			{
				if (Integer.valueOf(arg0) > Integer.valueOf(arg1))
				{
					return 1;
				} else
				{
					return -1;
				}
			}
		});
		String rStr = "";
		for (int i = 0; i < keylist.size(); i++)
		{
			if (i < keylist.size() - 1)
			{
				rStr = rStr + keymap.get(keylist.get(i)) + ",";
			} else
			{
				rStr = rStr + keymap.get(keylist.get(i));
			}
		}
		return rStr;
	}

	/**
	 * 排序并去掉前面的0
	 * 
	 * @param distributeMap
	 * @return
	 * @author shaolin
	 */
	public String formatWinnerStr(Map<String, Integer> distributeMap)
	{
		List<String> respList = new ArrayList<>();
		Iterator<String> it = distributeMap.keySet().iterator();
		while (it.hasNext())
		{
			String key = it.next();
			int value = distributeMap.get(key);
			for (int i = 0; i < value; i++)
			{
				respList.add(i + "" + key);
			}
		}
		Collections.sort(respList, new Comparator<String>()
		{
			public int compare(String arg0, String arg1)
			{
				if (Integer.valueOf(arg0) < Integer.valueOf(arg1))
				{
					return -1;
				} else
				{
					return 1;
				}
			}
		});
		String rStr = "";
		for (int i = 0; i < respList.size(); i++)
		{
			rStr = rStr + CommUtil.addFrontZeroFor(respList.get(i)) + ",";
		}
		return rStr.substring(0, rStr.length() - 1);
	}

	/**
	 * 得到各个尾数的中签数量
	 * 
	 * @param purchaseNum 实际申购数量
	 * @param distributeNum 实际发行数量
	 * @return
	 */
	public Map<String, Integer> getLottery(long purchaseNum, long distributeNum)
	{
		// 中签尾数及数量
		Map<String, Integer> distributeMap = new LinkedHashMap<>();
		if (purchaseNum <= distributeNum)
		{// 如果申购数量小于发行数量，那么所有申购的数量都被发行
			int n1 = (int) (purchaseNum % 10);
			int n2 = (int) (purchaseNum / 10);
			for (int i = 0; i < 10; i++)
			{
				if (i >= n1)
				{
					distributeMap.put(i + "", n2);
				} else
				{
					distributeMap.put(i + "", n2 + 1);
				}
			}
			return distributeMap;
		}
		long chooseNum = 0;
		double allocationRate = distributeNum * 1.0 / purchaseNum;
		int len = getDigitNum(purchaseNum);
		long distributeX = (long) (allocationRate * Math.pow(10, len));
		List<Integer> digitList = getEachDigit(distributeX, len);
		int lenX = getDigitNum(distributeX);
		List<Long> distributeList = new ArrayList<>();
		for (int i = 0; i < digitList.size(); i++)
		{
			int rate = digitList.get(i);
			long temp = (long) (purchaseNum % Math.pow(10, len - lenX + 1 + i));
			for (int j = 0; j < rate; j++)
			{
				if (chooseNum == distributeNum)
				{
					return distributeMap;
				}
				String lotteryNum = getRandom(distributeList, len - lenX + 1 + i);
				int number = (int) (purchaseNum * Math.pow(10, -(len - lenX + 1 + i)));
				long lotteryLong = Long.parseLong(lotteryNum);
				if (lotteryLong <= temp && lotteryLong > 0)
				{
					number++;
				}
				if (chooseNum + number <= distributeNum)
				{
					chooseNum += number;
				} else
				{
					break;
				}
				distributeList.add(lotteryLong);
				distributeMap.put(lotteryNum, number);
			}
		}
		int left = (int) (distributeNum - chooseNum);
		while (left > 0)
		{
			String lotteryNum = getRandom(distributeList, len);
			long lotteryLong = Long.parseLong(lotteryNum);
			if (lotteryLong > purchaseNum || lotteryLong == 0)
			{
				continue;
			}
			distributeList.add(lotteryLong);
			distributeMap.put(lotteryNum, 1);
			left--;
		}
		return distributeMap;
	}

	/**
	 * 得到一个数的位数
	 * 
	 * @param value
	 * @return
	 */
	public int getDigitNum(long value)
	{
		return String.valueOf(value).length();
	}

	/**
	 * 得到一个num位的随机数
	 * 
	 * @param except
	 * @param num
	 * @return
	 */
	public String getRandom(List<Long> except, int num)
	{
		boolean confict = true;
		long obj = 0l;
		while (confict)
		{
			obj = (long) (Math.random() * Math.pow(10, num));
			while (except.contains(obj) || obj == 0)
			{// obj肯定不在except中
				obj = (long) (Math.random() * Math.pow(10, num));
			}
			confict = false;
			int len = getLen(obj);
			for (long temp : except)
			{
				int len2 = getLen(temp);
				if (len2 == len)
				{
					continue;
				}
				if (Math.abs(obj - temp) % Math.pow(10, len2) == 0) // 有冲突
				{
					confict = true;
					break;
				}
			}
		}
		return String.format("%0" + num + "d", obj);
	}

	/**
	 * 得到一个整数的位数
	 * 
	 * @param num
	 * @return
	 */
	public int getLen(long num)
	{
		int len = 0;
		while (num != 0)
		{
			num /= 10;
			len++;
		}
		return len;
	}

	/**
	 * 得到每位的中签比率
	 * 
	 * @param value
	 * @param len
	 * @return
	 */
	public List<Integer> getEachDigit(long value, int len)
	{
		String valueS = String.valueOf(value);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < valueS.length() - 1; i++)
		{
			result.add(Integer.parseInt(valueS.charAt(i) + ""));
		}
		return result;
	}

	/**
	 * 去掉str的前面的0
	 * 
	 * @param str
	 * @return
	 * @author shaolin
	 */
	public String removeFirstZero(String str)
	{
		return str.replaceFirst("^0*", "");
	}

	/**
	 * 查询摇号结果
	 * 
	 * @param request
	 * @param id
	 * @param pagereq
	 * @return
	 * @author shaolin
	 */
	public ResponseMessage selectLotteryResult(HttpServletRequest request, Long id, PageReq pagereq)
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		// 查询
		PLotteryResultExample example = new PLotteryResultExample();
		com.ifeng.bigtrade.purchasing.entites.PLotteryResultExample.Criteria c = example.createCriteria();
		if (CommUtil.isNotNull(id))
		{
			c.andIssuanceplan_idEqualTo(id);
		}
		List<PLotteryResultWithBLOBs> rlist = this.resultMapper.selectByExampleWithBLOBs(example);
		PageInfo<PLotteryResultWithBLOBs> page = new PageInfo<>(rlist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 查询摇号结果
	 * 
	 * @param request
	 * @param id
	 * @param pagereq
	 * @return
	 * @author shaolin
	 */
	public ResponseMessage selectLotteryResultDetail(HttpServletRequest request, Long id, PageReq pagereq)
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		// 查询
		PLotteryResultDetailExample example = new PLotteryResultDetailExample();
		Criteria c = example.createCriteria();
		if (CommUtil.isNotNull(id))
		{
			c.andIssuanceplan_idEqualTo(id);
		}
		List<PLotteryResultDetail> rlist = this.resultDetailMapper.selectByExample(example);
		PageInfo<PLotteryResultDetail> page = new PageInfo<>(rlist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 根据id增加摇号详情
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @author shaolin
	 */
	public ResponseMessage lotterySystemDetail(HttpServletRequest request, Long id, PLotteryResultWithBLOBs result)
	{
		if (result == null)
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "未查询到计划有摇号结果"), null);
		}
		if (!CommUtil.isNotNull(result.getLotteryResult()))
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "该摇号结果为空，不能进行详情对应"), null);
		}
		List<PLotteryResultDetail> resultDetailList = new ArrayList<>();
		String[] resultArr = result.getLotteryResult().split(",");// 详情结果的数组
		List<PApplicationDetail> applicationList = this.applicationMapper.selectForLotterSystem(id);
		int arrCount = 0;
		for (int i = 0; i < applicationList.size(); i++)
		{
			if (arrCount == resultArr.length)
			{// 如果已经计算到最后一个摇号时，停止
				break;
			}
			PApplicationDetail detail = applicationList.get(i);
			if (Integer.valueOf(resultArr[arrCount]) >= Integer.valueOf(detail.getStartNo())
					&& Integer.valueOf(resultArr[arrCount]) <= Integer.valueOf(detail.getEndNo()))
			{// 如果号码在这个申请范围之内
				PLotteryResultDetail resultdetail = new PLotteryResultDetail();
				resultdetail.setAddTime(new Date());
				resultdetail.setApplicationdetail_id(detail.getId());
				resultdetail.setDeleteStatus(false);
				resultdetail.setIssuanceplan_id(id);
				resultdetail.setWinningNo(resultArr[arrCount]);
				resultDetailList.add(resultdetail);
				arrCount++;
				i--;
				detail.setWinCount(detail.getWinCount()+1);
			}
		}
		for (int i = 0; i < applicationList.size(); i++)
		{
			PApplicationDetail detail = applicationList.get(i);
			detail.setStatus(EApplicationDetailStatus.alreadyLottery.getId());
			this.applicationMapper.updateByPrimaryKey(detail);
		}
		int count = this.resultDetailMapper.insertBatch(resultDetailList);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		return new ResponseMessage(CommUtil.respByCount(request, count));
	}

//	public HashMap<Long, HashMap<String, Object>> selectResultToFunds(Long planid)
//	{
//		PIssuancePlan plan = this.issuanceMapper.selectByPrimaryKey(planid);
//		if (plan == null)
//		{
//			return null;
//		}
//		// 查询所有申购记录
//		PApplicationDetailExample dexample = new PApplicationDetailExample();
//		com.ifeng.bigtrade.purchasing.entites.PApplicationDetailExample.Criteria dc = dexample.createCriteria();
//		dc.andIssuanceplan_idEqualTo(planid);
//		List<PApplicationDetail> detailList = this.applicationMapper.selectByExample(dexample);
//		// 查询所有中签记录
//		PLotteryResultDetailExample rexample = new PLotteryResultDetailExample();
//		Criteria rc = rexample.createCriteria();
//		rc.andIssuanceplan_idEqualTo(planid);
//		List<PLotteryResultDetail> resultList = this.resultDetailMapper.selectByExample(rexample);
//		HashMap<Long, Integer> resultCountMap = new HashMap<>();
//		for (int i = 0; i < resultList.size(); i++)
//		{
//			PLotteryResultDetail resultOne = resultList.get(i);
//			Long resultApplicationdetailId = resultOne.getApplicationdetail_id();
//			Integer Count = resultCountMap.get(resultApplicationdetailId);
//			if(Count!=null) {
//				Count = Count + 1;
//				resultCountMap.put(resultApplicationdetailId, Count);
//			}else {
//				resultCountMap.put(resultApplicationdetailId, 0);
//			}
//		}
//		HashMap<Long, HashMap<String, Object>> rmap = new HashMap<>();
//		for (int i = 0; i < detailList.size(); i++)
//		{
//			
//		}
//		return rmap;
//	}
}

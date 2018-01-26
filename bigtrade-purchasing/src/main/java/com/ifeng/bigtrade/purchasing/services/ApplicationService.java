package com.ifeng.bigtrade.purchasing.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.purchasing.entites.PApplicationDetail;
import com.ifeng.bigtrade.purchasing.entites.PApplicationDetailExample;
import com.ifeng.bigtrade.purchasing.entites.PApplicationDetailExample.Criteria;
import com.ifeng.bigtrade.purchasing.entites.PIssuancePlan;
import com.ifeng.bigtrade.purchasing.entites.enumf.EApplicationDetailStatus;
import com.ifeng.bigtrade.purchasing.entites.enumf.EIssuanceplanType;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespCode;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.purchasing.filters.PageReq;
import com.ifeng.bigtrade.purchasing.mapper.PApplicationDetailMapper;
import com.ifeng.bigtrade.purchasing.mapper.PIssuancePlanMapper;
import com.ifeng.bigtrade.purchasing.tools.CommUtil;
import com.ifeng.bigtrade.purchasing.vo.PApplicationDetailVO;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class ApplicationService extends BaseService
{
	@Autowired
	private PApplicationDetailMapper appliactionMapper;
	@Autowired
	private PIssuancePlanMapper issuanceMapper;

	/**
	 * 申购第一步
	 * 
	 * @param request
	 * @param commodityId 商品标识id
	 * @param firmId 用户标识id
	 * @param count 申购数量
	 * @param issuanceId 发行计划标识id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage applyStep1(HttpServletRequest request, Long commodityId, Long firmId, int count,
			Long issuanceId) throws Exception
	{
		PIssuancePlan issuance = this.issuanceMapper.selectByPrimaryKey(issuanceId);
		if (issuance == null)
		{
			return new ResponseMessage(ERespCode.ParamError.getId(), "该发行计划不存在");
		}
		if (issuance.getPlanStartTime().after(new Date()))
		{
			return new ResponseMessage(ERespCode.ParamError.getId(), "该计划还未开始，不能申请");
		}
		if (issuance.getMaxApplicationCount() != 0 && issuance.getMaxApplicationCount() < count)
		{
			return new ResponseMessage(ERespCode.ParamError.getId(), "申请数量超过限制，申请失败");
		}
		if (!issuance.getStatus().equals(EIssuanceplanType.normal.getId())
				&& !issuance.getStatus().equals(EIssuanceplanType.auditSuccess.getId()))
		{
			return new ResponseMessage(ERespCode.ParamError.getId(), "发行计划的状态，不允许申购");
		}
		// // 计算手续费
		// BigDecimal avgBrokerage = null;
		// if (issuance.getBrokerageType().equals(EBrokerageType.rate.getId()))
		// {// 手续费计算方式为费率
		// avgBrokerage = issuance.getBrokerageRate().multiply(issuance.getUnitPrice());
		// } else if
		// (issuance.getBrokerageType().equals(EBrokerageType.numerical.getId()))
		// {// 手续费计算方式为数值
		// avgBrokerage = issuance.getBrokerage();
		// } else
		// {// 无手续费
		// avgBrokerage = new BigDecimal(0);
		// }
		// 所需总资金
		BigDecimal allAmount = issuance.getUnitPrice().multiply(new BigDecimal(count));
		// 所需总手续费
		// BigDecimal allBrokerage = avgBrokerage.multiply(new BigDecimal(count));
		// 添加
		PApplicationDetail detail = new PApplicationDetail();
		detail.setAddTime(new Date());
		// detail.setBrokerage(allBrokerage);
		detail.setCommodityId(commodityId);
		detail.setCount(count);
		detail.setDeleteStatus(false);
		detail.setFirmId(firmId);
		detail.setIssuanceplan_id(issuanceId);
		detail.setStatus(EApplicationDetailStatus.step1.getId());
		detail.setTotalAmount(allAmount);
		detail.setBrokerage(new BigDecimal(0));
		detail.setWinCount(0);
		this.appliactionMapper.insertSelective(detail);
		logger.info("添加id为" + detail.getId() + "的申购,申购id为" + issuanceId + ",用户id为" + firmId + ",数量为" + count + ",总资金为"
				+ allAmount);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("result", detail);
		rmap.put("id", detail.getId());
		rmap.put("amount", detail.getTotalAmount());
		rmap.put("brokerate", detail.getBrokerage());
		rmap.put("firmid", detail.getFirmId());
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 申购第二步
	 * 
	 * @param request
	 * @param id
	 * @param result
	 * @param financeAccountId
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage applyStep2(HttpServletRequest request, Long id, boolean result, Long financeAccountId,
			BigDecimal brokerage) throws Exception
	{
		PApplicationDetail detail = this.appliactionMapper.selectByPrimaryKey(id);
		ResponseMessage resm = new ResponseMessage();
		if (detail == null)
		{
			resm = new ResponseMessage(new ResponseHeader(request, ERespCode.Error, "未查询到id为" + id + "的计划"), null);
			return resm;
		}
		if (result)
		{// 如果成功，则更新到第二步
			detail.setStatus(EApplicationDetailStatus.step2.getId());
		}
		detail.setFinanceAccountId(financeAccountId);
		detail.setBrokerage(brokerage);
		int count = this.appliactionMapper.updateByPrimaryKeySelective(detail);
		// 增加
		this.issuanceMapper.updateApplicationByPrimaryKey(detail.getIssuanceplan_id(), detail.getCount());
		logger.info("id为" + id + "的申购，已经完成到申购第二步");
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		resm = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		return resm;
	}

	/**
	 * 查询申购
	 * 
	 * @param request
	 * @param issuanceId
	 * @param applicationId
	 * @param firmId
	 * @param commodityId
	 * @param startTime
	 * @param endTime
	 * @param pagereq
	 * @return
	 * @throws ParseException
	 * @author shaolin
	 */
	public ResponseMessage selectAppliaction(HttpServletRequest request, Long issuanceId, Long applicationId,
			Long firmId, Long commodityId, String startTime, String endTime, PageReq pagereq) throws ParseException
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		PApplicationDetailExample example = new PApplicationDetailExample();
		Criteria c = example.createCriteria();
		if (CommUtil.isNotNull(issuanceId))
		{
			c.andIssuanceplan_idEqualTo(issuanceId);
		}
		if (CommUtil.isNotNull(applicationId))
		{
			c.andIdEqualTo(applicationId);
		}
		if (CommUtil.isNotNull(firmId))
		{
			c.andFirmIdEqualTo(firmId);
		}
		if (CommUtil.isNotNull(commodityId))
		{
			c.andCommodityIdEqualTo(commodityId);
		}
		if (CommUtil.isNotNull(startTime))
		{
			c.andAddTimeGreaterThanOrEqualTo(CommUtil.getStartTimeOfDay(CommUtil.addHmsForDate(startTime)));
		}
		if (CommUtil.isNotNull(endTime))
		{
			c.andAddTimeLessThanOrEqualTo(CommUtil.getEndTimeOfDay(CommUtil.addHmsForDate(endTime)));
		}
		List<PApplicationDetail> rlist = this.appliactionMapper.selectByExample(example);
		// 返回
		PageInfo<PApplicationDetail> page = new PageInfo<>(rlist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 撤销申购
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @author shaolin
	 */
	public ResponseMessage revokeAppliaction(HttpServletRequest request, Long id)
	{
		PApplicationDetail detail = this.appliactionMapper.selectByPrimaryKey(id);
		ResponseMessage rems = new ResponseMessage();
		if (detail == null)
		{
			rems = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "未查询到申购委托"), null);
			return rems;
		}
		if (detail.getStatus().equals(EApplicationDetailStatus.allocated.getId()))
		{
			rems = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "委托单已经分配号码，不能撤销"), null);
			return rems;
		}
		if (detail.getStatus().equals(EApplicationDetailStatus.alreadyLottery.getId()))
		{
			rems = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "委托单已经分配摇号，不能撤销"), null);
			return rems;
		}
		if (detail.getStatus().equals(EApplicationDetailStatus.alreadyPublish.getId()))
		{
			rems = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "委托单已经发行，不能撤销"), null);
			return rems;
		}
		if (detail.getStatus().equals(EApplicationDetailStatus.cancle.getId()))
		{
			rems = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "该委托单已经撤销"), null);
			return rems;
		}
		detail.setStatus(EApplicationDetailStatus.cancle.getId());
		int count = this.appliactionMapper.updateByPrimaryKeySelective(detail);
		this.issuanceMapper.updateApplicationByPrimaryKey(detail.getIssuanceplan_id(), -detail.getCount());
		logger.info("撤销id为" + id + "的申购单");
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		rmap.put("id", id);
		rems = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		return rems;
	}

	/**
	 * 查询申购详情
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @author shaolin
	 */
	public ResponseMessage selectApplicationDetail(HttpServletRequest request, Long id)
	{
		PApplicationDetail detail = this.appliactionMapper.selectByPrimaryKey(id);
		if (detail != null)
		{
			Long planId = detail.getIssuanceplan_id();
			PIssuancePlan plan = this.issuanceMapper.selectByPrimaryKey(planId);
			HashMap<String, Object> rmap = new HashMap<>();
			rmap.put("application", detail);
			rmap.put("plan", plan);
			return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		} else
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.Error, "未查到该id的数据"), null);
		}
	}

	public ResponseMessage selectDetailListByIssuanceidAndStatus(HttpServletRequest request, Long issuanceId,
			Integer[] status, PageReq pagereq) throws ParseException
	{
		// PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(),
		// pagereq.getOrderStr());
		PApplicationDetailExample example = new PApplicationDetailExample();
		Criteria c = example.createCriteria();
		if (CommUtil.isNotNull(issuanceId))
		{
			c.andIssuanceplan_idEqualTo(issuanceId);
		}
		List<Integer> statusList = new ArrayList<>();
		for (int i = 0; i < status.length; i++)
		{
			statusList.add(status[i]);
		}
		c.andStatusIn(statusList);
		List<PApplicationDetail> rlist = this.appliactionMapper.selectByExample(example);
		// 返回
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("rlist", rlist);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	public ResponseMessage selectAppliactionDetailList(HttpServletRequest request, Long issuanceId, PageReq pagereq)
			throws ParseException
	{
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		PApplicationDetailExample example = new PApplicationDetailExample();
		Criteria c = example.createCriteria();
		if (CommUtil.isNotNull(issuanceId))
		{
			c.andIssuanceplan_idEqualTo(issuanceId);
		}
		c.andStatusEqualTo(EApplicationDetailStatus.alreadyLottery.getId());
		List<PApplicationDetail> rlist = this.appliactionMapper.selectByExample(example);
		// 返回
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("rlist", rlist);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	public ResponseMessage selectMyApplicationDetailList(HttpServletRequest request, Long userid, List<Integer> status,
			PageReq pagereq)
	{
		String statusStr = "";
		if (CommUtil.isNotNull(status) && status.size() > 0)
		{
			for (int i = 0; i < status.size(); i++)
			{
				if (i < status.size() - 1)
				{
					statusStr = statusStr + status.get(i) + ",";
				} else
				{
					statusStr = statusStr + status.get(i);
				}
			}
		}
		pagereq.setOrderColumns("addTime");
		pagereq.setDesc("desc");
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		List<PApplicationDetailVO> rlist = this.appliactionMapper.selectVOByUseridInStatus(userid, statusStr);
		PageInfo<PApplicationDetailVO> page = new PageInfo<>(rlist);
		// 返回
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("rlist", page);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 撤销申购补偿接口
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @author shaolin
	 */
	public ResponseMessage revokeAppliaction_compensate(HttpServletRequest request, Long id)
	{
		PApplicationDetail detail = this.appliactionMapper.selectByPrimaryKey(id);
		if (detail == null)
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "未查询到申购委托"), null);
		}
		if (!detail.getStatus().equals(EApplicationDetailStatus.cancle.getId()))
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "申购单不是撤销状态，不能补偿"), null);
		}
		detail.setStatus(EApplicationDetailStatus.step2.getId());
		int count = this.appliactionMapper.updateByPrimaryKeySelective(detail);
		this.issuanceMapper.updateApplicationByPrimaryKey(detail.getIssuanceplan_id(), detail.getCount());
		logger.info("撤销补偿id为" + id + "的申购单");
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

}

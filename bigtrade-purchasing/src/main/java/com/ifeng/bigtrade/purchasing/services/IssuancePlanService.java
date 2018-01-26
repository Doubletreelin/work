package com.ifeng.bigtrade.purchasing.services;

import java.math.BigDecimal;
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
import com.ifeng.bigtrade.purchasing.entites.PFailedPlan;
import com.ifeng.bigtrade.purchasing.entites.PIssuancePlan;
import com.ifeng.bigtrade.purchasing.entites.PIssuancePlanExample;
import com.ifeng.bigtrade.purchasing.entites.PIssuancePlanExample.Criteria;
import com.ifeng.bigtrade.purchasing.entites.enumf.EApplicationDetailStatus;
import com.ifeng.bigtrade.purchasing.entites.enumf.EIssuanceplanType;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespCode;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.purchasing.filters.PageReq;
import com.ifeng.bigtrade.purchasing.mapper.PApplicationDetailMapper;
import com.ifeng.bigtrade.purchasing.mapper.PFailedPlanMapper;
import com.ifeng.bigtrade.purchasing.mapper.PIssuancePlanMapper;
import com.ifeng.bigtrade.purchasing.tools.CommUtil;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class IssuancePlanService extends BaseService
{
	@Autowired
	private PIssuancePlanMapper issuancePlanMapper;

	@Autowired
	private PApplicationDetailMapper detailMapper;

	@Autowired
	private PFailedPlanMapper failedplanMapper;

	public PIssuancePlan addIssuance(Long commodityId, String commodityName, String planStartTime, String planEndTime,
			String publicityStartTime, Integer totalQuantity, Integer maxSingleWinningCount, BigDecimal unitPrice,
			Long publisherId, Integer brokerageType, BigDecimal brokerage, Long operatorId, String operatorName,
			String operatorIp, String notes, Integer maxApplicationCount, String lotteryTime, String publicityEndTime)
			throws Exception
	{
		PIssuancePlan issuanceplan = new PIssuancePlan();
		issuanceplan.setAddTime(new Date());
		issuanceplan.setBrokerageType(brokerageType);
		issuanceplan.setBrokerage(brokerage);
		issuanceplan.setCommodityId(commodityId);
		issuanceplan.setCommodityName(commodityName);
		issuanceplan.setDeleteStatus(false);
		issuanceplan.setMaxSingleWinningCount(maxSingleWinningCount);
		issuanceplan.setMaxApplicationCount(maxApplicationCount);
		issuanceplan.setNotes(notes);
		issuanceplan.setOperatorId(operatorId);
		issuanceplan.setOperatorIp(operatorIp);
		issuanceplan.setOperatorName(operatorName);
		issuanceplan.setPlanEndTime(CommUtil.StringToDate(planEndTime, 2));
		issuanceplan.setPlanStartTime(CommUtil.StringToDate(planStartTime, 2));
		issuanceplan.setPublicityStartTime(
				publicityStartTime == null ? null : CommUtil.StringToDate(publicityStartTime, 2));
		issuanceplan
				.setPublicityEndTime(publicityEndTime == null ? null : CommUtil.StringToDate(publicityStartTime, 2));
		issuanceplan.setPublisherId(publisherId);
		issuanceplan.setStatus(EIssuanceplanType.normal.getId());
		issuanceplan.setTotalQuantity(totalQuantity);
		issuanceplan.setUnitPrice(unitPrice);
		issuanceplan.setApplicationCount(0);
		issuanceplan.setLotteryTime(
				lotteryTime == null ? null : CommUtil.StringToDate(CommUtil.addHmsForDate(lotteryTime, "00:00:00"), 2));
		this.issuancePlanMapper.insertSelective(issuanceplan);
		return issuanceplan;
	}

	/**
	 * 增加发行计划
	 * 
	 * @param request
	 * @param commodityId 商品标识 （必填） Long
	 * @param commodityName 商品名称（选填） String
	 * @param planStartTime 发行计划开始时间（必填） String
	 * @param planEndTime 发行计划结束时间（必填）String
	 * @param publicityStartTime 公示期开始时间（选填，如果没有则没有公示期）String
	 * @param totalQuantity 总共发行数量（必填）Integer
	 * @param maxSingleWinningCount 单个交易会员最大中签数量，如果不设置，那么此处传0（必填）Integer
	 * @param unitPrice 发行货物单价 （必填）BigDecimal
	 * @param publisherId 发布商标识（选填）Long
	 * @param brokerageType 手续费类型 （必填：无为0，费率为1，数值为2）Integer
	 * @param brokerageRate 手续费费率 （必填，如果没有则传0）BigDecimal
	 * @param brokerage 手续费 （必填，如果没有则传0）BigDecimal
	 * @param operatorId 操作员标识（必填）Long
	 * @param operatorName 操作员姓名（选填）String
	 * @param operatiorIp 操作员ip（必填）String
	 * @param notes 备注（选填） String
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage addIssuance(HttpServletRequest request, Long commodityId, String commodityName,
			String planStartTime, String planEndTime, String publicityStartTime, Integer totalQuantity,
			Integer maxSingleWinningCount, BigDecimal unitPrice, Long publisherId, Integer brokerageType,
			BigDecimal brokerage, Long operatorId, String operatorName, String operatorIp, String notes,
			Integer maxApplicationCount, String lotteryTime, String publicityEndTime) throws Exception
	{
		if (brokerageType.equals(2) && brokerage == null)
		{
			return new ResponseMessage(ERespCode.ParamError.getId(), "当类型选择使用数值时，手续费数值不能为空");
		}
		HashMap<String, Object> rmap = new HashMap<>();
		PIssuancePlan issuanceplan = this.addIssuance(commodityId, commodityName, planStartTime, planEndTime,
				publicityStartTime, totalQuantity, maxSingleWinningCount, unitPrice, publisherId, brokerageType,
				brokerage, operatorId, operatorName, operatorIp, notes, maxApplicationCount, lotteryTime,
				publicityEndTime);
		logger.info("添加id为" + issuanceplan.getId() + "的发行计划,操作人id为" + operatorId + ",操作人姓名为" + operatorName);
		rmap.put("result", issuanceplan);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 撤销发行计划
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月7日 下午3:47:28
	 */
	public ResponseMessage revokeIssuance(HttpServletRequest request, Long id) throws Exception
	{
		PIssuancePlan issuanceplan = this.issuancePlanMapper.selectByPrimaryKey(id);
		ResponseMessage rems = new ResponseMessage();
		if ((new Date()).after(issuanceplan.getPlanStartTime()))
		{
			rems = new ResponseMessage(ERespCode.ParamError.getId(), "该发行计划已经开始，不能撤销");
			return rems;
		} else
		{
			if (issuanceplan.getStatus() == EIssuanceplanType.revoke.getId())
			{
				rems = new ResponseMessage(ERespCode.ParamError.getId(), "改发行计划已经撤销");
				return rems;
			}
			HashMap<String, Object> rmap = new HashMap<>();
			issuanceplan.setDeleteStatus(true);
			issuanceplan.setStatus(EIssuanceplanType.revoke.getId());
			int count = this.issuancePlanMapper.updateByPrimaryKeySelective(issuanceplan);
			logger.info("撤销id为" + id + "的发行计划");
			rmap.put("count", count);
			return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		}
	}

	/**
	 * 查询发行计划
	 * 
	 * @param request
	 * @param commodityId 商品标识
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param status 状态
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage selectIssuance(HttpServletRequest request, Long commodityId, String startTime,
			Integer status[],String commodityName, PageReq pagereq) throws Exception
	{
		pagereq.setOrderColumns("addTime");
		pagereq.setDesc("desc");
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		// 查询
		String statusStr = "";
		if (status != null)
		{
			for (int i = 0; i < status.length; i++)
			{
				if (i < status.length - 1)
				{
					statusStr = statusStr + status[i] + ",";
				} else
				{
					statusStr = statusStr + status[i];
				}
			}
		}
		List<HashMap<String, Object>> rlist = this.issuancePlanMapper.selectIssuance(commodityId, startTime, statusStr,commodityName);
		PageInfo<HashMap<String, Object>> page = new PageInfo<>(rlist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 发行失败的第一步
	 * 
	 * @param request
	 * @param id
	 * @param operatorId
	 * @param operatorName
	 * @param operatorIP
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage failStep1(HttpServletRequest request, Long id, Long operatorId, String operatorName,
			String operatorIp) throws Exception
	{
		PIssuancePlan issuanceplan = this.issuancePlanMapper.selectByPrimaryKey(id);
		if (issuanceplan == null)
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "未查询到计划"), null);
		}
		// 更新计划状态为失败第一步状态
		issuanceplan.setStatus(EIssuanceplanType.failStep1.getId());
		this.issuancePlanMapper.updateByPrimaryKeySelective(issuanceplan);
		// 增加发行失败记录
		PFailedPlan failedPlan = new PFailedPlan();
		failedPlan.setIssuanceplan_id(issuanceplan.getId());
		failedPlan.setOperatorId(operatorId);
		failedPlan.setOperatorIp(operatorIp);
		failedPlan.setOperatorName(operatorName);
		this.failedplanMapper.insertSelective(failedPlan);
		// 查询所有计划中的申购
		PApplicationDetailExample example = new PApplicationDetailExample();
		com.ifeng.bigtrade.purchasing.entites.PApplicationDetailExample.Criteria c = example.createCriteria();
		c.andIssuanceplan_idEqualTo(issuanceplan.getId());
		List<Integer> list = new ArrayList<>();
		list.add(EApplicationDetailStatus.cancle.getId());
		list.add(EApplicationDetailStatus.step1.getId());
		c.andStatusNotIn(list);
		List<PApplicationDetail> result = this.detailMapper.selectByExample(example);
		HashMap<String, Object> rmap = new HashMap<>();
		logger.info("id为" + id + "的发行计划第一步发行失败成功,操作人为" + operatorName + ",操作人id为" + operatorId + ",操作ip为" + operatorIp);
		rmap.put("result", result);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 发行失败第二步
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage failStep2(HttpServletRequest request, Long id) throws Exception
	{
		// 更改每条申购的状态
		PApplicationDetailExample example = new PApplicationDetailExample();
		com.ifeng.bigtrade.purchasing.entites.PApplicationDetailExample.Criteria c = example.createCriteria();
		c.andIssuanceplan_idEqualTo(id);
		PApplicationDetail detail = new PApplicationDetail();
		detail.setStatus(EApplicationDetailStatus.cancle.getId());
		int count = this.detailMapper.updateByExampleSelective(detail, example);
		// 更改当前发行计划的状态
		PIssuancePlanExample iexample = new PIssuancePlanExample();
		Criteria ic = iexample.createCriteria();
		ic.andIdEqualTo(id);
		PIssuancePlan plan = new PIssuancePlan();
		plan.setStatus(EIssuanceplanType.failStep2.getId());
		int icount = this.issuancePlanMapper.updateByExampleSelective(plan, iexample);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		rmap.put("icount", icount);
		logger.info("id为" + id + "的发行计划，已经第二步发行失败成功");
		return new ResponseMessage(CommUtil.respByCount(request, icount), rmap);
	}

	/**
	 * 审核方法
	 * 
	 * @param request
	 * @param id
	 * @param status
	 * @param auditId
	 * @param auditName
	 * @param auditIp
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage audit(HttpServletRequest request, Long id, Integer status, Long auditorId,
			String auditorName, String auditorIp) throws Exception
	{
		ResponseMessage resm = new ResponseMessage();
		if(status == null) {
			resm = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "审核状态不能为空"), null);
			return resm;
		}
		if (!status.equals(EIssuanceplanType.auditSuccess.getId())
				&& !status.equals(EIssuanceplanType.auditFail.getId()))
		{
			resm = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "传入的状态不为审核状态"), null);
			return resm;
		}
		PIssuancePlanExample example = new PIssuancePlanExample();
		example.createCriteria().andIdEqualTo(id);
		PIssuancePlan plan = new PIssuancePlan();
		plan.setStatus(status);
		plan.setAuditorId(auditorId);
		plan.setAuditorIp(auditorIp);
		plan.setAuditorName(auditorName);
		int count = this.issuancePlanMapper.updateByExampleSelective(plan, example);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		logger.info("id为" + auditorId + ",姓名为" + auditorName + ",ip为" + auditorIp + "的审核员,正在对id为" + id
				+ "的发行计划进行审核,审核状态为" + EIssuanceplanType.getName(status));
		resm = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resm;
	}

	public ResponseMessage selectIssuanceOne(HttpServletRequest request, Long id) throws Exception
	{
		PIssuancePlan plan = this.issuancePlanMapper.selectByPrimaryKey(id);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("issuance", plan);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	public ResponseMessage updateIssuanceStatus(HttpServletRequest request, Long id, Integer status) throws Exception
	{
		PIssuancePlan plan = this.issuancePlanMapper.selectByPrimaryKey(id);
		if (plan != null)
		{
			plan.setStatus(status);
		}
		this.issuancePlanMapper.updateByPrimaryKey(plan);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("issuance", plan);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	public ResponseMessage deleteIssuance(HttpServletRequest request, Long id) throws Exception
	{
		PIssuancePlan plan = this.issuancePlanMapper.selectByPrimaryKey(id);
		ResponseMessage resm = new ResponseMessage();
		if (plan != null)
		{
			if (plan.getStatus() != EIssuanceplanType.normal.getId()
					&& plan.getStatus() != EIssuanceplanType.revoke.getId()
					&& plan.getStatus() != EIssuanceplanType.auditFail.getId()
					&& plan.getStatus() != EIssuanceplanType.failStep2.getId())
			{
				resm = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ,
						"该计划的状态为" + EIssuanceplanType.getName(plan.getStatus()) + ",不能删除"), null);
				return resm;
			} else
			{
				int count = this.issuancePlanMapper.deleteByPrimaryKey(id);
				HashMap<String, Object> rmap = new HashMap<>();
				rmap.put("deleteCount", count);
				resm = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
				return resm;
			}
		} else
		{
			resm = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, "未查询到计划"), null);
			return resm;
		}
	}

	/**
	 * 更新
	 * 
	 * @param request
	 * @param id
	 * @param commodityId
	 * @param commodityName
	 * @param planStartTime
	 * @param planEndTime
	 * @param lotteryTime
	 * @param publicityStartTime
	 * @param publicityEndTime
	 * @param totalQuantity
	 * @param maxSingleWinningCount
	 * @param maxApplicationCount
	 * @param unitPrice
	 * @param brokerageType
	 * @param brokerageRate
	 * @param brokerage
	 * @param operatorId
	 * @param operatorName
	 * @param operatiorIp
	 * @param notes
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage updateIssuance(HttpServletRequest request, Long id, Long commodityId, String commodityName,
			String planStartTime, String planEndTime, String lotteryTime, String publicityStartTime,
			String publicityEndTime, Integer totalQuantity, Integer maxSingleWinningCount, Integer maxApplicationCount,
			BigDecimal unitPrice, Integer brokerageType, BigDecimal brokerage, Long operatorId, String operatorName,
			String operatiorIp, String notes) throws Exception
	{
		PIssuancePlan plan = this.issuancePlanMapper.selectByPrimaryKey(id);
		if (plan != null)
		{
			if (plan.getStatus().equals(EIssuanceplanType.auditFail.getId()))
			{
				if (CommUtil.isNotNull(commodityId))
				{
					plan.setCommodityId(commodityId);
				}
				if (CommUtil.isNotNull(commodityName))
				{
					plan.setCommodityName(commodityName);
				}
				if (CommUtil.isNotNull(planStartTime))
				{
					plan.setPlanStartTime(CommUtil.StringToDate(planStartTime, 2));
				}
				if (CommUtil.isNotNull(planEndTime))
				{
					plan.setPlanEndTime(CommUtil.StringToDate(planEndTime, 2));
				}
				if (CommUtil.isNotNull(lotteryTime))
				{
					plan.setLotteryTime(CommUtil.StringToDate(lotteryTime, 2));
				}
				if (CommUtil.isNotNull(publicityStartTime))
				{
					plan.setPublicityStartTime(CommUtil.StringToDate(publicityStartTime, 2));
				}
				if (CommUtil.isNotNull(publicityEndTime))
				{
					plan.setPublicityEndTime(CommUtil.StringToDate(publicityEndTime, 2));
				}
				if (CommUtil.isNotNull(totalQuantity))
				{
					plan.setTotalQuantity(totalQuantity);
				}
				if (CommUtil.isNotNull(maxSingleWinningCount))
				{
					plan.setMaxSingleWinningCount(maxSingleWinningCount);
				}
				if (CommUtil.isNotNull(maxApplicationCount))
				{
					plan.setMaxApplicationCount(maxApplicationCount);
				}
				if (CommUtil.isNotNull(unitPrice))
				{
					plan.setUnitPrice(unitPrice);
				}
				if (CommUtil.isNotNull(brokerageType))
				{
					plan.setBrokerageType(brokerageType);
				}
				if (CommUtil.isNotNull(brokerage))
				{
					plan.setBrokerage(brokerage);
				}
				if (CommUtil.isNotNull(operatorId))
				{
					plan.setOperatorId(operatorId);
				}
				if (CommUtil.isNotNull(operatorName))
				{
					plan.setOperatorName(operatorName);
				}
				if (CommUtil.isNotNull(operatiorIp))
				{
					plan.setOperatorId(operatorId);
				}
				if (CommUtil.isNotNull(notes))
				{
					plan.setNotes(notes);
				}
				this.issuancePlanMapper.updateByPrimaryKeySelective(plan);
				HashMap<String, Object> rmap = new HashMap<>();
				rmap.put("issuance", plan);
				return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
			} else
			{
				return new ResponseMessage(new ResponseHeader(request, ERespCode.Error, "只有状态为发行失败的计划才能修改"), null);
			}

		} else
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.Error, "未查询到待修改的发行计划"), null);
		}

	}

	/**
	 * 查询能在用户界面展示的发行计划
	 * 
	 * @param request
	 * @param commodityId 商品标识
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param status 状态
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage selectIssuanceForUserShow(HttpServletRequest request, Long commodityId, Integer status[],
			PageReq pagereq) throws Exception
	{
		pagereq.setOrderColumns("addTime");
		pagereq.setDesc("desc");
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		// 查询
		String statusStr = "";
		if (status != null)
		{
			for (int i = 0; i < status.length; i++)
			{
				if (i < status.length - 1)
				{
					statusStr = statusStr + status[i] + ",";
				} else
				{
					statusStr = statusStr + status[i];
				}
			}
		}
		List<HashMap<String, Object>> rlist = this.issuancePlanMapper.selectIssuanceForUserShow(commodityId, statusStr);
		PageInfo<HashMap<String, Object>> page = new PageInfo<>(rlist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

}

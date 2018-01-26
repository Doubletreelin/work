package com.ifeng.bigtrade.purchasing.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifeng.bigtrade.purchasing.entites.enumf.ERespCode;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.purchasing.exceptions.MyException;
import com.ifeng.bigtrade.purchasing.filters.PageReq;
import com.ifeng.bigtrade.purchasing.services.IssuancePlanService;
import com.ifeng.bigtrade.purchasing.services.LotterySystemService;

import bigtrade.logger.BigtradeLoggerUtil;

/**
 * 关于发行计划的操作Controller
 * 
 * @author shaolin
 *
 */
@RestController
@RequestMapping("/issuance")
public class IssuancePlanController extends BaseController
{
	@Autowired
	private IssuancePlanService issuanceService;

	@Autowired
	private LotterySystemService lotteryService;

	/**
	 * 增加发行计划
	 * 
	 * @param request
	 * @param commodityId 商品标识 （必填） Long
	 * @param commodityName 商品名称（选填） String
	 * @param planStartTime 发行计划开始时间（必填） String
	 * @param planEndTime 发行计划结束时间（必填）String
	 * @param publicityStartTime 公示期开始时间（必填，如果没有则没有公示期）String
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
	@RequestMapping(path = "/addIssuance", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object addIssuance(HttpServletRequest request, Long commodityId, String commodityName, String planStartTime,
			String planEndTime, String lotteryTime, String publicityStartTime, String publicityEndTime,
			Integer totalQuantity, Integer maxSingleWinningCount, Integer maxApplicationCount, BigDecimal unitPrice,
			Long publisherId, Integer brokerageType, BigDecimal brokerage, Long operatorId, String operatorName,
			String operatiorIp, String notes) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.addIssuance(request, commodityId, commodityName, planStartTime, planEndTime,
					publicityStartTime, totalQuantity, maxSingleWinningCount, unitPrice, publisherId, brokerageType,
					brokerage, operatorId, operatorName, operatiorIp, notes, maxApplicationCount, lotteryTime,
					publicityEndTime);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-purchasing", "addIssuance",
					"id为" + operatorId + "的操作员增加" + commodityId + "商品的发布计划成功", null, resp);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "addIssuance", "增加发布计划addIssuance报错",
					null, e.toString());
			throw new MyException(ERespMessage.AddError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 撤销发行计划
	 * 
	 * @param request
	 * @param id 发行计划的id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/revokeIssuance", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object revokeIssuance(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.revokeIssuance(request, id);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-purchasing", "revokeIssuance",
					"撤销id为" + id + "发布计划revokeIssuance成功", null, resp);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "revokeIssuance",
					"撤销发布计划revokeIssuance报错", null, e.toString());
			throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询发行计划
	 * 
	 * @param request
	 * @param commodityId 商品标识
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param status 状态 0正常 1撤销 2已经摇号 3已经摇号 4失败第一步 5失败第二步 6审核成功 7审核失败
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectIssuance", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectIssuance(HttpServletRequest request, Long commodityId, String time, Integer[] status,String commodityName,
			PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.selectIssuance(request, commodityId, time, status,commodityName, pagereq);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "selectIssuance",
					"获取发布计划列表selectIssuance报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 发行摇号的方法
	 * 
	 * @param request
	 * @param id 发行计划的id
	 * @param operatorid 操作人员的id
	 * @param operatorname 操作人员的名称
	 * @param operatorip 操作人员的ip
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/lotterySystem", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object lotterySystem(HttpServletRequest request, Long id, Long operatorid, String operatorname,
			String operatorip) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.lotteryService.lotterySystem(request, id, operatorid, operatorname, operatorip);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-purchasing", "lotterySystem",
					"id为" + id + "的发行计划摇号lotterySystem成功", null, resp);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "lotterySystem",
					"id为" + id + "的发行计划摇号lotterySystem报错", null, e.toString());
			throw new MyException(ERespMessage.AddError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 为准备摇号的发型计划分配号码
	 * 
	 * @param request
	 * @param planid 待分配号的发行计划id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/allocateNumber", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object allocateNumber(HttpServletRequest request, Long planid, Long operatorid, String operatorname,
			String operatorip) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.lotteryService.allocateNumber(request, planid, operatorid, operatorname, operatorip);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-purchasing", "allocateNumber",
					"planid为" + planid + "的计划为准备摇号的发行计划分配号码allocateNumber成功", null, resp);

		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "allocateNumber",
					"planid为" + planid + "的计划为准备摇号的发行计划分配号码allocateNumber报错", null, e.toString());
			throw new MyException(ERespMessage.AddError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询摇号结果
	 * 
	 * @param request
	 * @param id
	 * @param pagereq PageReq
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectLotteryResult", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectLotteryResult(HttpServletRequest request, Long id, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.lotteryService.selectLotteryResult(request, id, pagereq);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "selectLotteryResult",
					"查询摇号结果selectLotteryResult报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询摇号结果
	 * 
	 * @param request
	 * @param id
	 * @param pagereq PageReq
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectLotteryResultDetail", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectLotteryResultDetail(HttpServletRequest request, Long id, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.lotteryService.selectLotteryResultDetail(request, id, pagereq);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "selectLotteryResultDetail",
					"查询摇号结果详情selectLotteryResultDetail报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 发行失败第一步
	 * 
	 * @param request
	 * @param id
	 * @param operatorId 操作人id
	 * @param operatorName 操作人姓名
	 * @param operatorIp 操作人ip
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/failStep1", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object failStep1(HttpServletRequest request, Long id, Long operatorId, String operatorName,
			String operatorIp) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.failStep1(request, id, operatorId, operatorName, operatorIp);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "failStep1",
					"id" + id + "发行失败第一步failStep1报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
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
	@RequestMapping(path = "/failStep2", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object failStep2(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.failStep2(request, id);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "failStep2",
					"id" + id + "发行失败第二步failStep2报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 审核计划
	 * 
	 * @param request
	 * @param id 计划id
	 * @param status 状态
	 * @param auditorId 审核人id
	 * @param auditorName 审核人姓名
	 * @param auditorIp 审核人ip
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/audit", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object audit(HttpServletRequest request, Long id, Integer status, Long auditorId, String auditorName,
			String auditorIp) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.audit(request, id, status, auditorId, auditorName, auditorIp);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "audit", "审核方法报错", null,
					e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询发行计划详情
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectIssuanceOne", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectIssuanceOne(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.selectIssuanceOne(request, id);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "selectIssuanceOne", "审核方法报错", null,
					e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	@RequestMapping(path = "/updateIssuanceStatus", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object updateIssuanceStatus(HttpServletRequest request, Long id, Integer status) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.updateIssuanceStatus(request, id, status);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "updateIssuanceStatus", "审核方法报错",
					null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/deleteIssuance", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object deleteIssuance(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.deleteIssuance(request, id);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "deleteIssuance", "审核方法报错", null,
					e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	@RequestMapping(path = "/updateIssuance", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object updateIssuance(HttpServletRequest request, Long id, Long commodityId, String commodityName,
			String planStartTime, String planEndTime, String lotteryTime, String publicityStartTime,
			String publicityEndTime, Integer totalQuantity, Integer maxSingleWinningCount, Integer maxApplicationCount,
			BigDecimal unitPrice, Long publisherId, Integer brokerageType, BigDecimal brokerage, Long operatorId,
			String operatorName, String operatiorIp, String notes) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.updateIssuance(request, id, commodityId, commodityName, planStartTime,
					planEndTime, lotteryTime, publicityStartTime, publicityEndTime, totalQuantity,
					maxSingleWinningCount, maxApplicationCount, unitPrice, brokerageType, brokerage, operatorId,
					operatorName, operatiorIp, notes);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "updateIssuance", "审核方法报错", null,
					e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询发行计划
	 * 
	 * @param request
	 * @param commodityId 商品标识
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param status 状态 0正常 1撤销 2已经摇号 3已经摇号 4失败第一步 5失败第二步 6审核成功 7审核失败
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectIssuanceForUserShow", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectIssuanceForUserShow(HttpServletRequest request, Long commodityId, Integer[] status,
			PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.issuanceService.selectIssuanceForUserShow(request, commodityId, status, pagereq);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "selectIssuance",
					"获取发布计划列表selectIssuanceForUserShow报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}
}

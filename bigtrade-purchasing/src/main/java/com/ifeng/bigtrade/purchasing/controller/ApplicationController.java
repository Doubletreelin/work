package com.ifeng.bigtrade.purchasing.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ifeng.bigtrade.purchasing.entites.enumf.EApplicationDetailStatus;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespCode;
import com.ifeng.bigtrade.purchasing.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.purchasing.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.purchasing.exceptions.MyException;
import com.ifeng.bigtrade.purchasing.filters.PageReq;
import com.ifeng.bigtrade.purchasing.services.ApplicationService;
import com.ifeng.bigtrade.purchasing.tools.CommUtil;

import bigtrade.logger.BigtradeLoggerUtil;

/**
 * 关于发行计划的操作Controller
 * 
 * @author shaolin
 *
 */
@RestController
@RequestMapping("/apply")
public class ApplicationController extends BaseController
{
	@Autowired
	private ApplicationService applicationService;

	/**
	 * 申请申购第一步
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
	@RequestMapping(path = "/applyStep1", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object applyStep1(HttpServletRequest request, Long commodityId, Long firmId, int count, Long issuanceId)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.applicationService.applyStep1(request, commodityId, firmId, count, issuanceId);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-purchasing", "applyStep1",
					"申请申购第一步applyStep1成功,商品标识id：" + commodityId + ",用户标识id：" + firmId + ",申购数量：" + count + ",发行计划标识id:"
							+ issuanceId,
					null, resp);
		} catch (Exception e)
		{
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger
					.loggerErrorRsp(
							"bigtrade-purchasing", "applyStep1", "申请申购第一步applyStep1报错,商品标识id：" + commodityId
									+ ",用户标识id：" + firmId + ",申购数量：" + count + ",发行计划标识id:" + issuanceId,
							null, e.toString());
			throw new MyException(ERespMessage.AddError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 申购第二步
	 * 
	 * @param request
	 * @param id 申购主键id
	 * @param result 结果
	 * @param financeAccountId 资金结算账号id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/applyStep2", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object applyStep2(HttpServletRequest request, Long id, boolean result, Long financeAccountId,
			BigDecimal brokerage) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.applicationService.applyStep2(request, id, result, financeAccountId, brokerage);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-purchasing", "applyStep2",
					"申请申购第二步applyStep2成功,申购主键id：" + id, null, resp);
		} catch (Exception e)
		{
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "applyStep2",
					"申请申购第二步applyStep2报错,申购主键id：" + id, null, e.toString());
			throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询申购
	 * 
	 * @param request
	 * @param issuanceId 发行计划id
	 * @param applicationId 申购委托id
	 * @param firmId 交易会员id
	 * @param commodityId 商品id
	 * @param startTime 申购委托时间大于该时间
	 * @param endTime 申购委托时间小于该时间
	 * @param pagereq PageReq 分页详情
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectAppliaction", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectAppliaction(HttpServletRequest request, Long issuanceId, Long applicationId, Long firmId,
			Long commodityId, String startTime, String endTime, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.applicationService.selectAppliaction(request, issuanceId, applicationId, firmId, commodityId,
					startTime, endTime, pagereq);
		} catch (Exception e)
		{
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "selectAppliaction",
					"查询申购selectAppliaction报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 撤销申购
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/revokeAppliaction", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object revokeAppliaction(HttpServletRequest request,Long id)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.applicationService.revokeAppliaction(request, id);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "revokeAppliaction",
					"撤销申购revokeAppliaction报错，申购id为" + id, null, e.toString());
			throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询申购详情
	 * 
	 * @param request
	 * @param id 申购主键id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectApplicationDetail", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectApplicationDetail(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.applicationService.selectApplicationDetail(request, id);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "selectApplicationDetail",
					"查询申购详情selectApplicationDetail报错", null, e.toString());
			throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询所有摇号后的申购详情
	 * 
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectAppliactionDetailList", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectAppliactionDetailList(HttpServletRequest request, Long issuanceId, PageReq pagereq)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.applicationService.selectAppliactionDetailList(request, issuanceId, pagereq);
		} catch (Exception e)
		{
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "selectAppliactionDetailList",
					"查询申购selectAppliaction报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 根据状态和计划id查询列表
	 * 
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectDetailListByIssuanceidAndStatus", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectDetailListByIssuanceidAndStatus(HttpServletRequest request, Long issuanceId, Integer[] status,
			PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.applicationService.selectDetailListByIssuanceidAndStatus(request, issuanceId, status, pagereq);
		} catch (Exception e)
		{
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing",
					"selectDetailListByIssuanceidAndStatus", "查询申购selectAppliaction报错", null, e.toString());
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询我的历史申购记录
	 * 
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectMyHistoryAppliactionList", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectMyHistoryAppliactionList(HttpServletRequest request, Long userid, PageReq pagereq)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(userid))
		{
			try
			{
				List<Integer> status = new ArrayList<>();
				status.add(EApplicationDetailStatus.alreadyPublish.getId());
				status.add(EApplicationDetailStatus.cancle.getId());
				resp = this.applicationService.selectMyApplicationDetailList(request, userid, status, pagereq);
			} catch (Exception e)
			{
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
			return resp;
		} else
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough),
					null);
		}
	}

	/**
	 * 查询我的历史申购记录
	 * 
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectMyNowAppliactionList", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectMyNowAppliactionList(HttpServletRequest request, Long userid, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(userid))
		{
			try
			{
				List<Integer> status = new ArrayList<>();
				status.add(EApplicationDetailStatus.step1.getId());
				status.add(EApplicationDetailStatus.step2.getId());
				status.add(EApplicationDetailStatus.allocated.getId());
				status.add(EApplicationDetailStatus.alreadyLottery.getId());
				resp = this.applicationService.selectMyApplicationDetailList(request, userid, status, pagereq);
			} catch (Exception e)
			{
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
			return resp;
		} else
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough),
					null);
		}
	}

	/**
	 * 查询我的全部的申购记录
	 * 
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectMyAllAppliactionList", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object selectMyAllAppliactionList(HttpServletRequest request, Long userid, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(userid))
		{
			try
			{
				resp = this.applicationService.selectMyApplicationDetailList(request, userid, null, pagereq);
			} catch (Exception e)
			{
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
			return resp;
		} else
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough),
					null);
		}
	}

	/**
	 * 撤销申购补偿接口
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/revokeAppliaction_compensate", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object revokeAppliaction_compensate(HttpServletRequest request, String requestParameter,
			String reponseParameter) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			JSONObject requestParameterJson = JSONObject.parseObject(requestParameter);
			Long id = requestParameterJson.getLong("id");
			resp = this.applicationService.revokeAppliaction_compensate(request, id);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-purchasing", "revokeAppliaction_compensate",
					"撤销补偿接口成功,id为" + id, null, resp);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-purchasing", "revokeAppliaction_compensate",
					"撤销补偿接口失败", null, e.toString());
			throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
		}
		return resp;
	}

}

package com.ifeng.bigtrade.finance.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.exceptions.MyException;
import com.ifeng.bigtrade.finance.services.SettlementService;
import com.ifeng.bigtrade.finance.tools.CommUtil;

import bigtrade.logger.BigtradeLoggerUtil;

/**
 * 关于结算的操作Controller
 * 
 * @author shaolin
 *
 */

@RestController
@RequestMapping("/settlement")
public class SettlementController extends BaseController
{
	@Autowired
	private SettlementService sservice;

	/**
	 * 获取最大的归属时间
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年8月31日 上午10:39:37
	 */
	@RequestMapping(path = "/selectMaxBdate")
	public Object selectMaxBdate(HttpServletRequest request) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.sservice.selectMaxBdate(request);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			throw new MyException(e.getCause().getMessage(), ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 获取能设置的归属日期
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年8月31日 上午10:39:51
	 */
	@RequestMapping(path = "/selectCanSetBdate")
	public Object selectCanSetBdate(HttpServletRequest request) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.sservice.selectCanSetBdate(request);
		} catch (Exception e)
		{// 添加报错
			e.printStackTrace();
			throw new MyException(e.getCause().getMessage(), ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 设置归属日期
	 * 
	 * @param request
	 * @param bdate 待设置的归属如期
	 * @param auditdate 要设置b_date的审核那天
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年8月31日 上午10:40:06
	 */
	@RequestMapping(path = "/setBdate")
	public Object setBdate(HttpServletRequest request, String bdate, String auditdate) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(bdate))
		{// 参数完整
			try
			{
				resp = this.sservice.setBdate(request, bdate, auditdate);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "setBdate", "设置归属日期成功,badate:"+bdate+",auditdate:"+auditdate, null, resp);
			} catch (Exception e)
			{// 添加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "setBdate", "设置归属日期失败", null, e.toString());
				e.printStackTrace();
				throw new MyException(e.getCause().getMessage(), ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 设置归属日期补偿
	 * 
	 * @param request
	 * @param bdate 待设置的归属如期
	 * @param auditdate 要设置b_date的审核那天
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/setBdateCompensation")
	public Object setBdateCompensation(HttpServletRequest request, String auditdate) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(auditdate))
		{// 参数完整
			try
			{
				resp = this.sservice.setBdateCompensation(request, auditdate);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "setBdateCompensation", "设置归属日期补偿成功,日期为" + auditdate, null, resp);
			} catch (Exception e)
			{// 添加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "setBdateCompensation", "设置归属日期失败", null, e.toString());
				e.printStackTrace();
				throw new MyException(e.getCause().getMessage(), ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 财务结算
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/settlement")
	public Object settlement(HttpServletRequest request) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.sservice.settlement(request);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "settlement", "财务结算成功", null, resp);
		} catch (Exception e)
		{// 添加报错
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "updateAccount", "财务结算失败", null, e.toString());
			e.printStackTrace();
			throw new MyException(e.getCause().getMessage(), ERespCode.MyBatiesError);
		}
		return resp;
	}

}

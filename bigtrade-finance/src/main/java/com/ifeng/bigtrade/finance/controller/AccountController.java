package com.ifeng.bigtrade.finance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.exceptions.MyException;
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.services.AccountService;
import com.ifeng.bigtrade.finance.tools.CommUtil;

import bigtrade.logger.BigtradeLoggerUtil;

/**
 * 关于科目的操作Controller
 * 
 * @author shaolin
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController
{
	@Resource
	AccountService accountService;

	/**
	 * 增加科目
	 * 
	 * @param request
	 * @param code 科目代码，不可空
	 * @param name 科目姓名，不可空
	 * @param dCFlag 借贷方向，D为借方，C为贷方
	 * @param accountLevel 科目级别，不为空 >=1的整数
	 * @param canDelete 是否能删除
	 * @param higherCode 上级科目
	 * @return ResponseMessage
	 * @throws Exception
	 */
	@RequestMapping(path = "/addAccountItem")
	public Object addAccount(HttpServletRequest request, String code, String name, String dCFlag, Integer accountLevel,
			boolean canDelete, String higherCode) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(code) && CommUtil.isNotNull(name) && CommUtil.isNotNull(dCFlag)
				&& CommUtil.isNotNull(accountLevel) && CommUtil.isNotNull(canDelete))
		{
			try
			{
				resp = accountService.addAccount(request, code, name, dCFlag, accountLevel, canDelete, higherCode);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "addAccount", "增加" + code + "科目",
						null, resp);
			} catch (Exception e)
			{// 添加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "addAccount", "增加科目" + code + "出错",
						null, e.toString());
				throw new MyException(ERespMessage.AddError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 更新科目
	 * 
	 * @param request
	 * @param id 科目的主键id
	 * @param code 科目代码
	 * @param name 科目名称
	 * @param dCFlag 借贷关系
	 * @param accountLevel 科目级别
	 * @param higherCode 上一级代码
	 * @return ResponseMessage
	 * @throws Exception
	 */
	@RequestMapping(path = "/updateAccountItem")
	public Object updateAccount(HttpServletRequest request, Long id, String code, String name, String dCFlag,
			Integer accountLevel, String higherCode) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{// 缺少id
			try
			{
				resp = accountService.updateAccount(request, id, code, name, dCFlag, accountLevel, higherCode);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "updateAccount",
						"更新科目" + code + "成功", null, resp);
			} catch (Exception e)
			{// 更新报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "updateAccount",
						"更新科目" + code + "出错", null, e.toString());
				throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 删除科目
	 * 
	 * @param request
	 * @param id 科目id Long[] id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/deleteAccountItem")
	public Object deleteAccountBatch(HttpServletRequest request, Long[] id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id) && id.length > 0)
		{// 缺少id
			List<Long> list = java.util.Arrays.asList(id);
			try
			{
				resp = accountService.deleteAccountBatch(request, list);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "deleteAccountItem",
						"删除科目id:" + list.toString() + "成功", null, resp);
			} catch (Exception e)
			{// 删除报错报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "deleteAccountItem",
						"删除科目" + list.toString() + "失败", null, e.toString());
				throw new MyException(ERespMessage.DeleteError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 增加商品的科目
	 * 
	 * @param request
	 * @param systemid 系统号
	 * @param code 代码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/addAccountItemOfCommodity")
	public Object addAccountItemOfCommodity(HttpServletRequest request, String systemid, String code) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(systemid) && CommUtil.isNotNull(code))
		{// 是否缺少参数
			try
			{
				resp = accountService.addAccountOfCommodity(request, systemid, code);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "addAccountItemOfCommodity",
						"增加商品科目" + code + "成功", null, resp);
			} catch (Exception e)
			{// 报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "updateAccount",
						"增加科目" + code + "失败", null, e.toString());
				throw new MyException(ERespMessage.AddError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 增加交易会员科目
	 * 
	 * @param request
	 * @param firmno 会员代码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/addAccountItemOfFirm")
	public Object addAccountItemOfFirm(HttpServletRequest request, String firmno) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(firmno))
		{// 是否缺少参数
			try
			{
				resp = accountService.addAccountItemOfFirm(request, firmno);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "addAccountItemOfFirm",
						"增加交易会员科目" + firmno + "成功", null, resp);
			} catch (Exception e)
			{// 报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "addAccountItemOfFirm",
						"增加交易会员科目" + firmno + "失败", null, e.toString());
				e.printStackTrace();
				throw new MyException(ERespMessage.AddError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 查询科目信息列表
	 * 
	 * @param request
	 * @param code 科目代码
	 * @param name 科目名称
	 * @param dcflag 借贷方向
	 * @param accountlevel 科目级别
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectAccount")
	public Object selectAccount(HttpServletRequest request, String code, String name, String dcflag,
			Integer accountlevel, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = accountService.selectAccount(request, code, name, dcflag, accountlevel, pagereq);
		} catch (Exception e)
		{// 报错
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 根据id获取科目
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月5日 上午10:52:59
	 */
	@RequestMapping(path = "/selectAccountById")
	public Object selectAccountById(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{
			try
			{
				resp = accountService.selectAccountById(request, id);
			} catch (Exception e)
			{// 报错
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
		} else
		{
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 添加用户科目补偿接口
	 * 
	 * @param request
	 * @param id 科目id Long[] id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/addAccountItemOfFirm_compensate")
	public Object addAccountItemOfFirm_compensate(HttpServletRequest request, String requestParameter,
			String reponseParameter) throws Exception
	{
		JSONObject reponseParameterJson = JSONObject.parseObject(reponseParameter);
		JSONObject body = (JSONObject) reponseParameterJson.get("body");
		JSONObject voucher = (JSONObject) body.get("account");
		Long id = voucher.getLong("id");
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{// 缺少id
			List<Long> list = new ArrayList<>();
			list.add(id);
			try
			{
				resp = accountService.deleteAccountBatch(request, list);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "addAccountItemOfFirm_compensate",
						"添加科目补偿接口，删除科目id:" + list.toString() + "成功", null, resp);
			} catch (Exception e)
			{// 删除报错报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "addAccountItemOfFirm_compensate",
						"添加科目补偿接口，删除科目" + list.toString() + "失败", null, e.toString());
				throw new MyException(ERespMessage.DeleteError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

}

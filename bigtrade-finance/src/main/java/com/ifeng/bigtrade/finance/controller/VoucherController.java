package com.ifeng.bigtrade.finance.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.exceptions.MyException;
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.services.VoucherService;
import com.ifeng.bigtrade.finance.tools.CommUtil;

import bigtrade.logger.BigtradeLoggerUtil;


/**
 * 关于凭证的操作Controller
 * 
 * @author shaolin
 *
 */

@RestController
@RequestMapping("/voucher")
public class VoucherController extends BaseController
{
	@Autowired
	private VoucherService voucherService;

	/**
	 * 手动录入凭证的方法
	 * 
	 * @param request
	 * @param voucherNo 凭证号
	 * @param summary_id 摘要id
	 * @param contractNo 合同号（可空）
	 * @param status 状态
	 * @param inputUser 录入人（可空）
	 * @param inputTime 录入时间（可空）
	 * @param note 备注（可空）
	 * @param oneCode 细则一方的科目代码
	 * @param oneName 细则一方的科目名称
	 * @param oneCAmount 细则一方的贷方金额
	 * @param oneDAmount 细则一方的借方金额
	 * @param otherCode 细则另一方的科目代码
	 * @param otherName 细则另一方的科目名称
	 * @param otherCAmount 细则另一方的贷方金额
	 * @param otherDAmount 细则另一方的借方金额
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/enterVoucher")
	public Object enterVoucher(HttpServletRequest request, String voucherNo, Long summary_id, String contractNo,
			String status, String inputUser, String inputTime, String note, String oneCode, String oneName,
			BigDecimal oneCAmount, BigDecimal oneDAmount, String otherCode, String otherName, BigDecimal otherCAmount,
			BigDecimal otherDAmount) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(summary_id) && CommUtil.isNotNull(status) && CommUtil.isNotNull(oneCode)
				&& CommUtil.isNotNull(oneName) && CommUtil.isNotNull(oneCAmount) && CommUtil.isNotNull(oneDAmount)
				&& CommUtil.isNotNull(otherCode) && CommUtil.isNotNull(otherName) && CommUtil.isNotNull(otherDAmount)
				&& CommUtil.isNotNull(otherCAmount))
		{// 缺少参数
			try
			{
				resp = this.voucherService.enterVoucher(request, voucherNo, summary_id, contractNo, status, inputUser,
						inputTime, note, oneCode, oneName, oneCAmount, oneDAmount, otherCode, otherName, otherDAmount,
						otherCAmount);
				// logger.info("手动输入凭证成功,summary_id:" + summary_id + " oneCode:" + oneCode + "
				// otherCode:" + otherCode);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "enterVoucher",
						"手动输入凭证成功,summary_id:" + summary_id + " oneCode:" + oneCode + " otherCode:" + otherCode, null,
						resp);
			} catch (Exception e)
			{// 增加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "enterVoucher",
						"手动输入凭证失败,summary_id:" + summary_id + " oneCode:" + oneCode + " otherCode:" + otherCode, null,
						e.toString());
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
	 * 更新录入的凭证
	 * 
	 * @param request
	 * @param voucherNo 凭证号
	 * @param summary_id 摘要id
	 * @param contractNo 合同号（可空）
	 * @param status 状态
	 * @param inputUser 录入人（可空）
	 * @param inputTime 录入时间（可空）
	 * @param note 备注（可空）
	 * @param oneCode 细则一方的科目代码
	 * @param oneName 细则一方的科目名称
	 * @param oneCAmount 细则一方的贷方金额
	 * @param oneDAmount 细则一方的借方金额
	 * @param otherCode 细则另一方的科目代码
	 * @param otherName 细则另一方的科目名称
	 * @param otherCAmount 细则另一方的贷方金额
	 * @param otherDAmount 细则另一方的借方金额
	 * @param id 凭证id
	 * @return
	 */
	@RequestMapping(path = "/updateVoucherOfEntry")
	public Object updateVoucherOfEntry(HttpServletRequest request, String voucherNo, Long summary_id, String contractNo,
			String status, String note, String oneCode, String oneName, BigDecimal oneCAmount, BigDecimal oneDAmount,
			String otherCode, String otherName, BigDecimal otherCAmount, BigDecimal otherDAmount, Long voucherid,
			Long oneid, Long otherid) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (!(!CommUtil.isNotNull(voucherid) && !CommUtil.isNotNull(oneid) && !CommUtil.isNotNull(otherid)))// 如果三者都为空
		{// 缺少参数
			try
			{
				resp = this.voucherService.updateVoucherOfEnter(request, voucherNo, summary_id, contractNo, status,
						note, oneCode, oneName, oneCAmount, oneDAmount, otherCode, otherName, otherCAmount,
						otherDAmount, voucherid, oneid, otherid);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "updateVoucherOfEntry", "更新凭证成功,vocherid:" + voucherid, null,
						resp);
			} catch (Exception e)
			{// 增加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "updateVoucherOfEntry", "更新凭证失败,vocherid:" + voucherid, null,
						e.toString());
				e.printStackTrace();
				throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 删除凭证接口
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/deleteVoucher")
	public Object deleteVoucher(HttpServletRequest request, Long[] id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id) && id.length > 0)
		{// 缺少参数
			List<Long> list = java.util.Arrays.asList(id);
			try
			{
				resp = this.voucherService.deleteVoucher(request, list);
			} catch (Exception e)
			{// 删除报错
				e.printStackTrace();
				throw new MyException(ERespMessage.DeleteError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 更新凭证状态
	 * 
	 * @param request
	 * @param id 更新的id
	 * @param status 更新的状态
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/updateVoucherStatus")
	public Object updateVoucherStatus(HttpServletRequest request, Long[] id, String status) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id) && id.length > 0 && CommUtil.isNotNull(status))
		{// 缺少参数
			try
			{
				List<Long> list = java.util.Arrays.asList(id);
				resp = this.voucherService.updateVoucherStatus(request, list, status);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "updateVoucherStatus", "更新凭证状态成功", null, resp);
			} catch (Exception e)
			{// 更新报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "updateVoucherStatus", "更新凭证失败", null, e.toString());
				e.printStackTrace();
				throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 批量凭证确认方法
	 * 
	 * @param request
	 * @param id 更新的凭证id
	 * @param operator 操作人
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/checkVoucher")
	public Object checkVoucher(HttpServletRequest request, Long[] id, String operator) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id) && id.length > 0 && CommUtil.isNotNull(operator))
		{// 缺少参数
			List<Long> list = java.util.Arrays.asList(id);
			try
			{
				resp = this.voucherService.checkVoucher(request, list, operator);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "checkVoucher", "批量凭证确认成功,vocherid:" + list.toString(), null,
						resp);
			} catch (Exception e)
			{// 更新报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "checkVoucher", "更新凭证失败,vocherid:" + list.toString(), null,
						e.toString());
				e.printStackTrace();
				throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 查询当前凭证
	 * 
	 * @param request
	 * @param summaryid 摘要id
	 * @param status 状态
	 * @param inputuser 录入员
	 * @param inputtime 录入时间
	 * @param audittime 审核时间
	 * @param auditor 审核人
	 * @param pagereq 分页信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectCurrentVoucher")
	public Object selectCurrentVoucher(HttpServletRequest request, String summaryno, String summaryname, String status,
			String inputuser, String inputtime, String auditor, String audittime, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.voucherService.selectCurrentVoucher(request, summaryno, summaryname, status, inputuser,
					inputtime, auditor, audittime, pagereq);
		} catch (Exception e)
		{// 更新报错
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询历史凭证，即以入账（accounted）的凭证
	 * 
	 * @param request
	 * @param summaryno 摘要号
	 * @param summaryname 摘要名称
	 * @param inputuser 录入员
	 * @param bdate 凭证归属如期
	 * @param pagereq 分页信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectHistoryVoucher")
	public Object selectHistoryVoucher(HttpServletRequest request, String summaryno, String summaryname,
			String inputuser, String bdate, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.voucherService.selectHistoryVoucher(request, summaryno, summaryname, inputuser, bdate, pagereq);
		} catch (Exception e)
		{// 更新报错
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 生成系统的凭证，直接成为audited状态
	 * 
	 * @param request
	 * @param voucherNo 凭证号 （可空）
	 * @param summary_id 摘要id
	 * @param contractNo 合同号 （可空）
	 * @param oneCode 一方的usercode
	 * @param oneCAmount 一方贷方金额
	 * @param oneDAmount 一方借方金额
	 * @param otherCode 另一方的usercode
	 * @param otherCAmount 另一方贷方金额
	 * @param otherDAmount 另一方借方金额
	 * @param fundflow_id 流水id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/createSystemVoucher")
	public Object createSystemVoucher(HttpServletRequest request, String voucherNo, Long summary_id, String contractNo,
			String oneCode, BigDecimal oneCAmount, BigDecimal oneDAmount, String otherCode, BigDecimal otherCAmount,
			BigDecimal otherDAmount, Long fundflow_id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(summary_id) && CommUtil.isNotNull(oneCode) && CommUtil.isNotNull(oneCAmount)
				&& CommUtil.isNotNull(oneDAmount) && CommUtil.isNotNull(otherCode) && CommUtil.isNotNull(otherDAmount)
				&& CommUtil.isNotNull(otherCAmount) && CommUtil.isNotNull(fundflow_id))
		{// 缺少参数
			try
			{
				resp = this.voucherService.createSystemVoucher(request, voucherNo, summary_id, contractNo, oneCode,
						oneCAmount, oneDAmount, otherCode, otherCAmount, otherDAmount, fundflow_id);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "createSystemVoucher",
						"生成系统凭证成功，summary_id" + summary_id + " oneCode" + oneCode + " otherCode" + otherCode, null,
						resp);
			} catch (Exception e)
			{// 增加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "createSystemVoucher",
						"生成系统凭证失败，summary_id" + summary_id + " oneCode" + oneCode + " otherCode" + otherCode, null,
						e.toString());
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
	 * 系统生成凭证补偿接口
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/createSystemVoucher_compensate")
	public Object createSystemVoucher_compensate(HttpServletRequest request, String requestParameter,
			String reponseParameter) throws Exception
	{
		JSONObject reponseParameterJson = JSONObject.parseObject(reponseParameter);
		JSONObject body = (JSONObject) reponseParameterJson.get("body");
		JSONObject voucher = (JSONObject) body.get("voucher");
		Long id = voucher.getLong("id");
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{// 缺少参数
			List<Long> list = new ArrayList<>();
			list.add(id);
			try
			{
				resp = this.voucherService.deleteVoucher(request, list);
			} catch (Exception e)
			{// 删除报错
				e.printStackTrace();
				throw new MyException(ERespMessage.DeleteError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 根据id获取凭证
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月5日 上午10:52:59
	 */
	@RequestMapping(path = "/selectVoucherById")
	public Object selectVoucherById(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{
			try
			{
				resp = voucherService.selectVoucherById(request, id);
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
	 * 将所有编辑状态的凭证提交成待审核状态
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/confirmAllVoucher")
	public Object confirmAllVoucher(HttpServletRequest request) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.voucherService.confirmAllVoucher(request);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "confirmAllVoucher", "将所有编辑状态提交成审核状态成功", null, resp);
		} catch (Exception e)
		{// 更新报错
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "confirmAllVoucher", "将所有编辑状态提交成审核状态失败", null, e.toString());
			e.printStackTrace();
			throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 凭证审核方法
	 * 
	 * @param request
	 * @param id 更新的凭证id
	 * @param operator 操作人
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/auditVoucher")
	public Object auditVoucher(HttpServletRequest request, Long id, String operator) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id) && CommUtil.isNotNull(operator))
		{// 缺少参数
			try
			{
				resp = this.voucherService.auditVoucher(request, id, operator);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "auditVoucher", "审核凭证成功，id为" + id, null, resp);
			} catch (Exception e)
			{// 更新报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "auditVoucher", "审核凭证失败，id为" + id, null, e.toString());
				e.printStackTrace();
				throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 备份
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/backup")
	public Object backup(HttpServletRequest request) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.voucherService.backup(request);
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "backup",
					"备份成功，时间为" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), null, resp);
		} catch (Exception e)
		{// 更新报错
			BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "backup",
					"备份失败，时间为" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), null, e.toString());
			e.printStackTrace();
			throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
		}
		return resp;
	}

}

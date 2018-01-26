package com.ifeng.bigtrade.finance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.exceptions.MyException;
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.services.VoucherModelService;
import com.ifeng.bigtrade.finance.tools.CommUtil;

import bigtrade.logger.BigtradeLoggerUtil;

/**
 * 关于凭证增加模板的操作Controller
 * 
 * @author shaolin
 *
 */

@RestController
@RequestMapping("/vouchermodel")
public class VoucherModelController extends BaseController
{
	@Autowired
	private VoucherModelService voucherModelService;

	/**
	 * 增加模板
	 * 
	 * @param request
	 * @param modelCode 模板代码
	 * @param modelName 模板名称
	 * @param debitCode 借方代码
	 * @param creditCode 贷方代码
	 * @param contractNo 合同号 （可空）
	 * @param summaryid 摘要id
	 * @param note 备注 （可空）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/addVoucherModel")
	public Object addVoucherModel(HttpServletRequest request, String modelCode, String modelName, String debitCode,
			String creditCode, String contractNo, Long summaryid, String note) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(modelCode) && CommUtil.isNotNull(modelName) && CommUtil.isNotNull(debitCode)
				&& CommUtil.isNotNull(creditCode) && CommUtil.isNotNull(summaryid))
		{// 缺少参数
			try
			{
				resp = this.voucherModelService.addVoucherModel(request, modelCode, modelName, debitCode, creditCode,
						contractNo, summaryid, note);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "addVoucherModel", "增加模板成功，modelName：" + modelName, null,
						resp);
			} catch (Exception e)
			{// 增加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "addVoucherModel", "增加模板失败，modelName：" + modelName, null,
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
	 * 更新模板
	 * 
	 * @param request
	 * @param id 主键id
	 * @param modelCode 模板代码
	 * @param modelName 模板名称
	 * @param debitCode 借方代码
	 * @param creditCode 贷方代码
	 * @param contractNo 合同号 （可空）
	 * @param summaryid 摘要id
	 * @param note 备注 （可空）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/updateVoucherModel")
	public Object updateVoucherModel(HttpServletRequest request, Long id, String modelCode, String modelName,
			String debitCode, String creditCode, String contractNo, Long summaryid, String note) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{// 缺少参数
			try
			{
				resp = this.voucherModelService.updateVoucherModel(request, id, modelCode, modelName, debitCode,
						creditCode, contractNo, summaryid, note);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "updateVoucherModel", "更新模板成功，id" + id, null, resp);
			} catch (Exception e)
			{// 更新报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "updateVoucherModel", "更新模板失败，id" + id, null, e.toString());
				e.printStackTrace();
				throw new MyException(ERespMessage.UpdateError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并更新失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 删除模板
	 * 
	 * @param request
	 * @param id 删除的id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/deleteVoucherModel")
	public Object deleteVoucherModel(HttpServletRequest request, Long[] id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{// 缺少参数
			List<Long> list = java.util.Arrays.asList(id);
			try
			{
				resp = this.voucherModelService.deleteVoucherModel(request, list);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "updateAccount", "删除模板成功，id" + list.toString(), null, resp);
			} catch (Exception e)
			{// 删除报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "updateAccount", "删除模板失败，id" + list.toString(), null,
						e.toString());
				e.printStackTrace();
				throw new MyException(ERespMessage.DeleteError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并删除失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 查询模板
	 * 
	 * @param request
	 * @param modelCode
	 * @param pagereq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectVoucherModel")
	public Object selectVoucherModel(HttpServletRequest request, String modelCode, String name, PageReq pagereq)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.voucherModelService.selectVoucherModel(request, modelCode, name, pagereq);
		} catch (Exception e)
		{// 报错
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 查询模板
	 * 
	 * @param request
	 * @param modelCode
	 * @param pagereq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectVoucherModelById")
	public Object selectVoucherModelById(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{
			try
			{
				resp = this.voucherModelService.selectVoucherModelById(request, id);
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
}

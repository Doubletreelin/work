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
import com.ifeng.bigtrade.finance.services.SummaryService;
import com.ifeng.bigtrade.finance.tools.CommUtil;

import bigtrade.logger.BigtradeLoggerUtil;

/**
 * 关于科目的操作Controller
 * 
 * @author shaolin
 *
 */

@RestController
@RequestMapping("/summary")
public class SummaryController extends BaseController
{
	@Autowired
	SummaryService summaryService;
	
	/**
	 * 增加摘要的方法
	 * 
	 * @param request
	 * @param summaryNo 摘要号
	 * @param summary 摘要名称
	 * @param ledgerItemId 归入总账id
	 * @param fundsDCFlag 借贷方向 D为借方 C为贷方 N为不涉及
	 * @param accountCodeOpp 对方科目代码
	 * @param appendAccount 附加账
	 * @param isUserFuds 是否是用户资金相关，如果是，则科目必须以20100开头
	 * @param canDelete 是否能删除
	 * @return ResponseMessage
	 * @throws Exception
	 */
	@RequestMapping(path = "/addSummary")
	public Object addSummary(HttpServletRequest request, String summaryNo, String summary, Long ledgerItemId,
			String fundsDCFlag, String accountCodeOpp, String appendAccount, boolean isUserFunds, boolean canDelete)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(summaryNo) && CommUtil.isNotNull(summary) && CommUtil.isNotNull(ledgerItemId)
				&& CommUtil.isNotNull(fundsDCFlag) && CommUtil.isNotNull(accountCodeOpp)
				&& CommUtil.isNotNull(isUserFunds) && CommUtil.isNotNull(canDelete))
		{// 传递参数不为空
			try
			{
				resp = summaryService.addSummary(request, summaryNo, summary, ledgerItemId, fundsDCFlag, accountCodeOpp,
						appendAccount, isUserFunds, canDelete);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "addSummary", "增加摘要"+summaryNo+" "+summary+"成功", null, resp);
			} catch (Exception e)
			{// 增加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "addSummary", "增加摘要"+summaryNo+" "+summary+"失败", null, e.toString());
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
	 * 更新摘要
	 * 
	 * @param request
	 * @param summaryNo 摘要号
	 * @param summary 摘要名称
	 * @param ledgerItemId 归入总账id
	 * @param dCFlag 借贷方向 D为借方 C为贷方 N为不涉及
	 * @param accountCodeOpp 对方科目代码
	 * @param appendAccount 附加账
	 * @return ResponseMessage
	 */
	@RequestMapping(path = "/updateSummary")
	public Object updateSummary(HttpServletRequest request, Long id, String summaryNo, String summary,
			Long ledgerItemId, String fundsDCFlag, String accountCodeOpp, String appendAccount) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{// 缺少参数
			try
			{
				resp = this.summaryService.updateSummary(request, id, summaryNo, summary, ledgerItemId, fundsDCFlag,
						accountCodeOpp, appendAccount);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "updateSummary", "更新摘要"+summaryNo+" "+summary+"成功", null, resp);
			}catch (Exception e)
			{// 增加报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "updateSummary", "更新摘要"+summaryNo+" "+summary+"失败", null, e.toString());
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
	 * 批量删除摘要
	 * 
	 * @param request
	 * @param id 摘要id Long[] id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/deleteSummary")
	public Object deleteSummary(HttpServletRequest request, Long[] id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id) && id.length > 0)
		{// 缺少id
			List<Long> list = java.util.Arrays.asList(id);
			try
			{
				resp = this.summaryService.deleteSummaryBatch(request, list);
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-finance", "deleteSummary", "删除摘要id:"+list.toString()+"成功", null, resp);
			} catch (Exception e)
			{// 删除报错报错
				BigtradeLoggerUtil.systemLogger.loggerErrorRsp("bigtrade-finance", "deleteSummary", "删除摘要id:"+list.toString()+"失败", null, e.toString());
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
	 * 查询摘要列表
	 * 
	 * @param request
	 * @param systemid 系统id
	 * @param summaryno 摘要号
	 * @param page 分页信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectSummary")
	public Object selectSummary(HttpServletRequest request, String systemid, String summaryno, PageReq page)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.summaryService.selectSummary(request, systemid, summaryno, page);
		} catch (Exception e)
		{// 删除报错报错
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 根据id获取摘要
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectSummaryById")
	public Object selectSummaryById(HttpServletRequest request, Long id) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(id))
		{
			try
			{
				resp = this.summaryService.selectSummaryById(request, id);
			} catch (Exception e)
			{// 删除报错报错
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

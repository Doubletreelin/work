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
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.services.SearchFinanceService;
import com.ifeng.bigtrade.finance.tools.CommUtil;

/**
 * 关于查询财务的方法的Controller
 * 
 * @author shaolin
 *
 */

@RestController
@RequestMapping("/finance")
public class SearchFinanceController
{

	@Autowired
	private SearchFinanceService sfservice;

	/**
	 * 分类账查询
	 * 
	 * @see 与原方法传出参数有差距，但是还未得知传出参数用途，注意！！！
	 * @param request
	 * @param accountCode 科目代码
	 * @param beginDate 开始归属时间
	 * @param endDate 结束归属时间
	 * @param pagereq
	 * @return
	 */
	@RequestMapping(path = "/selectLedger")
	public Object selectLedger(HttpServletRequest request, String accountCode, String beginDate, String endDate,
			PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(accountCode) && CommUtil.isNotNull(beginDate) && CommUtil.isNotNull(endDate))
		{// 条件都不为空
			try
			{
				resp = sfservice.selectLedger(request, accountCode, beginDate, endDate, pagereq);
			} catch (Exception e)
			{// 报错
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 账簿查询
	 * 
	 * @param request
	 * @param creditCode 贷方代码
	 * @param debitCode 借方代码
	 * @param contractNo 合同号
	 * @param beginDate 开始归属如期
	 * @param endDate 结束归属日期
	 * @param voucherNo 凭证号
	 * @param amount 金额
	 * @param summaryNo 摘要号
	 * @param pagereq 分页信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/selectAccountBook")
	public Object selectAccountBook(HttpServletRequest request, String creditCode, String debitCode, String contractNo,
			String beginDate, String endDate, String voucherNo, Integer amount, String summaryNo,String summary, PageReq pagereq)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.sfservice.selectAccountBook(request, creditCode, debitCode, contractNo, beginDate, endDate,
					voucherNo, amount, summaryNo,summary, pagereq);
		} catch (Exception e)
		{// 报错
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 分类账合计
	 * 
	 * @param request
	 * @param accountCode 科目代码
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月1日 下午4:55:31
	 */
	@RequestMapping(path = "/selectLedgerTotal")
	public Object selectLedgerTotal(HttpServletRequest request, String accountCode, String beginDate, String endDate)
			throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(accountCode) && CommUtil.isNotNull(beginDate) && CommUtil.isNotNull(endDate))
		{// 条件都不为空
			try
			{
				resp = this.sfservice.selectLedgerTotal(request, accountCode, beginDate, endDate);
			} catch (Exception e)
			{// 报错
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 结算日报表
	 * 
	 * @param request
	 * @param time 查询时间
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月1日 下午2:30:24
	 */
	@RequestMapping(path = "/selectSettlementDailyReport")
	public Object selectSettlementDailyReport(HttpServletRequest request, String time) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		if (CommUtil.isNotNull(time))
		{// 条件都不为空
			try
			{
				resp = this.sfservice.selectSettlementDailyReport(request, time);
			} catch (Exception e)
			{// 报错
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 结算查询
	 * 
	 * @param request
	 * @param accountCode 科目代码
	 * @param accountLevel 科目级别
	 * @param beginDate 日期开始时间
	 * @param endDate 日期结束时间
	 * @param pagereq PageReq 分页详情
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月1日 上午10:39:04
	 */
	@RequestMapping(path = "/selectSettlement")
	public Object selectSettlement(HttpServletRequest request, String accountCode, String accountLevel,
			String beginDate, String endDate, PageReq pagereq) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.sfservice.selectSettlement(request, accountCode, accountLevel, beginDate, endDate, pagereq);
		} catch (Exception e)
		{// 报错
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 财务已结算余额 000001,00002,00003形式
	 * 
	 * @param request
	 * @param accountCode
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectTodayBalanceStr")
	public Object selectTodayBalanceStr(HttpServletRequest request, String accountCode) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		// 条件都不为空
		if (CommUtil.isNotNull(accountCode))
		{
			try
			{
				String[] accountArr = accountCode.split(",");
				for (int i = 0; i < accountArr.length; i++)
				{
					accountArr[i] = "20100" + accountArr[i];
				}
				resp = this.sfservice.selectTodayBalance(request, accountArr);
			} catch (Exception e)
			{// 报错
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}

	/**
	 * 财务已结算余额
	 * 
	 * @param request
	 * @param accountCode
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/selectTodayBalanceArr")
	public Object selectTodayBalanceArr(HttpServletRequest request, String[] accountCode) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		// 条件都不为空
		if (CommUtil.isNotNull(accountCode))
		{
			try
			{
				for (int i = 0; i < accountCode.length; i++)
				{
					accountCode[i] = "20100" + accountCode[i];
				}
				resp = this.sfservice.selectTodayBalance(request, accountCode);
			} catch (Exception e)
			{// 报错
				e.printStackTrace();
				throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
			}
		} else
		{// 当传递的参数为空提示参数为空，并添加失败
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, ERespMessage.ParaNotEnough));
		}
		return resp;
	}
}

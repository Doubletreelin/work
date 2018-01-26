package com.ifeng.bigtrade.finance.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.finance.entites.FAccountItem;
import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.mapper.FAccountBookMapper;
import com.ifeng.bigtrade.finance.mapper.FAccountItemMapper;
import com.ifeng.bigtrade.finance.mapper.FDailyBalanceMapper;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class SearchFinanceService
{

	@Autowired
	private FAccountBookMapper accountBookMapper;

	@Autowired
	private FAccountItemMapper accountItemMapper;

	@Autowired
	private FDailyBalanceMapper dailybalanceMapper;

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
	public ResponseMessage selectAccountBook(HttpServletRequest request, String creditCode, String debitCode,
			String contractNo, String beginDate, String endDate, String voucherNo, Integer amount, String summaryNo,
			String summary, PageReq pagereq) throws Exception
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		List<HashMap<String, Object>> rlist = this.accountBookMapper.selectAccountBook(creditCode, debitCode,
				contractNo, beginDate, endDate, voucherNo, amount, summaryNo, summary);
		PageInfo<HashMap<String, Object>> page = new PageInfo<>(rlist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 分类账查询
	 * 
	 * @param request
	 * @param accountCode 科目代码
	 * @param beginDate 开始归属时间
	 * @param endDate 结束归属时间
	 * @param pagereq
	 * @return
	 */
	public ResponseMessage selectLedger(HttpServletRequest request, String accountCode, String beginDate,
			String endDate, PageReq pagereq)
	{
		// 分页
		FAccountItem account = this.accountItemMapper.getLeafAccountByCode(accountCode);
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		List<HashMap<String, Object>> rlist = this.accountBookMapper.selectLedger(account, accountCode, beginDate,
				endDate);
		PageInfo<HashMap<String, Object>> page = new PageInfo<>(rlist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
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
	public ResponseMessage selectSettlement(HttpServletRequest request, String accountCode, String accountLevel,
			String beginDate, String endDate, PageReq pagereq) throws Exception
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		List<HashMap<String, Object>> rlist = this.dailybalanceMapper.selectSettlement(accountCode, accountLevel,
				beginDate, endDate);
		PageInfo<HashMap<String, Object>> page = new PageInfo<>(rlist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;

	}

	/**
	 * 结算日报表
	 * 
	 * @param request
	 * @param time 查询的天
	 * @return
	 * @author shaolin
	 * @time 2017年9月1日 下午2:16:51
	 */
	public ResponseMessage selectSettlementDailyReport(HttpServletRequest request, String time) throws Exception
	{
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(time);
		List<HashMap<String, Object>> debitList = this.dailybalanceMapper.selectSettlementDailyReport("D", date);
		List<HashMap<String, Object>> creditList = this.dailybalanceMapper.selectSettlementDailyReport("C", date);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("debitList", debitList);
		rmap.put("creditList", creditList);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 获取分类账合计功能
	 * 
	 * @param request
	 * @param accountCode 科目代码
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月1日 下午3:14:00
	 */
	public ResponseMessage selectLedgerTotal(HttpServletRequest request, String accountCode, String beginDate,
			String endDate) throws Exception
	{
		List<HashMap<String, Object>> ledgerList = this.selectAccountLedgerTotal(accountCode, beginDate, endDate);
		HashMap<String, Object> balanceMap = this.queryAccountBalance(accountCode, beginDate, endDate);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("ledgerList", ledgerList);
		rmap.put("balanceMap", balanceMap);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 获取分类账合计的分类账列表
	 * 
	 * @param accountCode
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @author shaolin
	 * @time 2017年9月1日 下午3:14:23
	 */
	public List<HashMap<String, Object>> selectAccountLedgerTotal(String accountCode, String beginDate, String endDate)
	{
		FAccountItem account = this.accountItemMapper.getLeafAccountByCode(accountCode);
		List<HashMap<String, Object>> rlist = this.accountBookMapper.selectAccountLedgerTotal(account, accountCode, beginDate, endDate);
		return rlist;
	}

	/**
	 * 获取分类账合计的期末期初总和
	 * 
	 * @param accountCode
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @author shaolin
	 * @time 2017年9月1日 下午3:14:40
	 */
	public HashMap<String, Object> queryAccountBalance(String accountCode, String beginDate, String endDate)
	{
		HashMap<String, Object> rmap = this.accountBookMapper.queryAccountBalance(accountCode, beginDate, endDate);
		return rmap;
	}

	/**
	 * 查询财务已结算余额
	 * @param request
	 * @param accountCode
	 * @return
	 * @author shaolin
	 */
	public ResponseMessage selectTodayBalance(HttpServletRequest request, String[] accountCode)
	{
		String accountArr = "";
		for (int i = 0; i < accountCode.length; i++)
		{
			if (i < accountCode.length - 1)
			{
				accountArr = accountArr + "'" + accountCode[i] + "',";
			} else
			{
				accountArr = accountArr + "'" + accountCode[i] + "'";
			}
		}
		List<HashMap<String, Object>> balance = this.dailybalanceMapper.selectTodayBalanceInCode(accountArr);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("result", balance);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		return resp;
	}
}

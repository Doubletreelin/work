package com.ifeng.bigtrade.finance.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifeng.bigtrade.finance.entites.FAccountBookExample;
import com.ifeng.bigtrade.finance.entites.FDailyBalanceExample;
import com.ifeng.bigtrade.finance.entites.FVoucher;
import com.ifeng.bigtrade.finance.entites.FVoucherExample;
import com.ifeng.bigtrade.finance.entites.FVoucherExample.Criteria;
import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.enumf.EVoucherStatus;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.mapper.FAccountBookMapper;
import com.ifeng.bigtrade.finance.mapper.FAccountItemMapper;
import com.ifeng.bigtrade.finance.mapper.FDailyBalanceMapper;
import com.ifeng.bigtrade.finance.mapper.FVoucherMapper;
import com.ifeng.bigtrade.finance.tools.CommUtil;

import bigtrade.logger.BigtradeLoggerUtil;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class SettlementService
{
	@Autowired
	private FDailyBalanceMapper dailyBalanceMapper;

	@Autowired
	private FVoucherMapper fvoucherMapper;

	@Autowired
	private FAccountBookMapper bookMapper;

	@Autowired
	private FAccountItemMapper accountItemMapper;

	/**
	 * 获取最近的一次财务结算的时间
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage selectMaxBdate(HttpServletRequest request) throws Exception
	{
		Date date = this.dailyBalanceMapper.selectMaxBdate();
		HashMap<String, Object> rmap = new HashMap<>();
		if(date !=null) {
			rmap.put("maxbdate", date);
			rmap.put("maxbdatestr", new SimpleDateFormat("yyyy-MM-dd").format(date));
		}else {
			rmap.put("maxbdate", null);
			rmap.put("maxbdatestr", "");
		}
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 获取可以设置的归属时间
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage selectCanSetBdate(HttpServletRequest request) throws Exception
	{
		HashMap<String, Object> rmap = new HashMap<>();
		// 最大的已结算归属时间
		Date maxB_date = this.dailyBalanceMapper.selectMaxBdate();
		// 最小的已审核未结算时间
		Date minAuditTime = this.fvoucherMapper.selectMinAuditTimeWhichBdateNull();
		// 最小的已审核未结算时间字符串形式
		String minAuditTimeStr = "";
		if (CommUtil.isNotNull(minAuditTime))
		{
			minAuditTimeStr = new SimpleDateFormat("yyyy-MM-dd").format(minAuditTime);
		}
		// 查询可设置日期的条件
		String maxDate = "";
		if (maxB_date != null)
		{// 审核通过日期要大于最大的已结算日期
			maxDate = new SimpleDateFormat("yyyy-MM-dd").format(maxB_date) + " 23:59:59";
		} else
		{
			maxDate = "2017-01-01 00:00:00";
		}
		// 查询能设置归属日期的日期
		List<String> datelist = this.fvoucherMapper.selectCanSetBdate(maxDate);
		rmap.put("count", datelist.size());
		if (CommUtil.isNotNull(maxB_date))
		{// 将最大的已结算归属时间加入
			String maxB_dateStr = new SimpleDateFormat("yyyy-MM-dd").format(maxB_date);
			if (!datelist.contains(maxB_dateStr))
			{
				datelist.add(maxB_dateStr);
			}
		}
		String nowDateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if (!datelist.contains(nowDateStr))
		{// 将今天日期加入
			datelist.add(nowDateStr);
		}
		// 归属时间排序
		Collections.sort(datelist, new Comparator<String>()
		{
			public int compare(String arg0, String arg1)
			{
				try
				{
					Date d0 = new SimpleDateFormat("yyyy-MM-dd").parse(arg0);
					Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(arg1);
					if (d0.before(d1))
					{
						return -1;
					} else
					{
						return 1;
					}
				} catch (ParseException e)
				{
					e.printStackTrace();
				}
				return 1;
			}
		});

		rmap.put("minAuditTime", minAuditTimeStr);
		rmap.put("datelist", datelist);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
	}

	/**
	 * 设置凭证的归属时间
	 * 
	 * @param request
	 * @param bdate
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage setBdate(HttpServletRequest request, String bdate, String auditdate) throws Exception
	{
		Date b_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(CommUtil.addHmsForDate(bdate, "00:00:00"));
		FVoucher voucher = new FVoucher();
		voucher.setB_date(b_date);
		FVoucherExample example = new FVoucherExample();
		Criteria c = example.createCriteria();
		// 已审核
		c.andAuditorIsNotNull();
		// 已审核
		c.andStatusEqualTo(EVoucherStatus.audited.getFlag());
		// 没有归属如期
		c.andB_dateIsNull();
		// 审核日期在auditdate那天
		c.andAuditTimeBetween(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(CommUtil.addHmsForDate(auditdate, "00:00:00")),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(CommUtil.addHmsForDate(auditdate, "23:59:59")));
		int count = this.fvoucherMapper.updateByExampleSelective(voucher, example);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		return new ResponseMessage(CommUtil.respByCount(request, count), rmap);
	}

	/**
	 * 设置凭证的归属时间
	 * 
	 * @param request
	 * @param bdate
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage setBdateCompensation(HttpServletRequest request, String auditdate) throws Exception
	{
		int count = this.fvoucherMapper.setBdateCompensation(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(CommUtil.addHmsForDate(auditdate, "00:00:00")),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(CommUtil.addHmsForDate(auditdate, "23:59:59")));
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		return new ResponseMessage(CommUtil.respByCount(request, count), rmap);
	}

	/**
	 * 财务结算
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage settlement(HttpServletRequest request) throws Exception
	{
		String nowStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		BigtradeLoggerUtil.operationLogger.info("时间:"+nowStr+" "+"开始进行结算处理");
		Date lateBdate = this.dailyBalanceMapper.selectMaxBdate();// 最新结算的日期
		if (CommUtil.isNotNull(lateBdate))
		{
			lateBdate = CommUtil.getStartTimeOfDay(lateBdate);
			FVoucherExample example = new FVoucherExample();
			example.createCriteria().andStatusEqualTo(EVoucherStatus.audited.getFlag())
					.andB_dateBetween(CommUtil.getStartTimeOfDay(lateBdate), CommUtil.getEndTimeOfDay(lateBdate));
			long count = this.fvoucherMapper.countByExample(example);// 查询最新结算的那一天是或否还有未入账的凭证
			if (count == 0)
			{// 最近结算日当天没有未入凭证，则天数+1
				Calendar cal = Calendar.getInstance();
				cal.setTime(lateBdate);
				cal.add(Calendar.DATE, 1);
				lateBdate = cal.getTime();
			}
		} else
		{
			lateBdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2000-01-01 00:00:00");
		}
		// 删除掉上面日期之后的accountbook
		FAccountBookExample bookExample = new FAccountBookExample();
		bookExample.createCriteria().andB_dateGreaterThanOrEqualTo(lateBdate);
		this.bookMapper.deleteByExample(bookExample);
		BigtradeLoggerUtil.operationLogger.info("时间:"+nowStr+" "+"已删除掉"+lateBdate+"之后的accountBood表记录");
		// 向账簿表增加数据
		this.bookMapper.insertInSettleBalance(new Date(), lateBdate);
		BigtradeLoggerUtil.operationLogger.info("时间:"+nowStr+" "+"已向accountBood表添加记录");
		// 更新已入账的凭证的状态
		this.fvoucherMapper.updateStatusInSettleBalance(lateBdate);
		BigtradeLoggerUtil.operationLogger.info("时间:"+nowStr+" "+"已将audited的凭证更新成accounted");
		// 删除掉上面日期之后的dailybalance
		FDailyBalanceExample dailyExample = new FDailyBalanceExample();
		dailyExample.createCriteria().andB_dateGreaterThanOrEqualTo(lateBdate);
		this.dailyBalanceMapper.deleteByExample(dailyExample);
		BigtradeLoggerUtil.operationLogger.info("时间:"+nowStr+" "+"已删除dailybalance表的数据");
		BigtradeLoggerUtil.operationLogger.info("时间:"+nowStr+" "+"开始生成dailybalance");
		// 生成dailybalance
		List<Date> calculatelist = this.bookMapper.selectBdateGreatterThanDate(lateBdate);
		Date previousDate = this.dailyBalanceMapper.selectpreviousDate(lateBdate);// 获取结算日期的前一天结算的日期
		if (!CommUtil.isNotNull(previousDate))
		{
			previousDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2000-01-01 00:00:00");
		}
		for (int i = 0; i < calculatelist.size(); i++)
		{
			Date curDate = calculatelist.get(i);
			// 向dailybalance插入空数据
			this.dailyBalanceMapper.insertForSettleBalance(new Date(), curDate, previousDate);
			// 更新借方金额
			List<HashMap<String, Object>> dlist = this.bookMapper.selectDebitcodeAndAmount(curDate);
			for (int j = 0; j < dlist.size(); j++)
			{
				HashMap<String, Object> dmap = dlist.get(j);
				Double damount = Double.parseDouble(dmap.get("amount").toString());
				String dcode = (String) dmap.get("debitCode");
				this.dailyBalanceMapper.updateDebitamountByBdateAndAccountcode(damount, curDate, dcode);
			}
			// 更新贷方金额
			List<HashMap<String, Object>> clist = this.bookMapper.selectCreditcodeAndAmount(curDate);
			for (int j = 0; j < clist.size(); j++)
			{
				HashMap<String, Object> cmap = clist.get(j);
				Double camount = Double.parseDouble(cmap.get("amount").toString());
				String ccode = (String) cmap.get("creditCode");
				this.dailyBalanceMapper.updateCreditamountByBdateAndAccountcode(camount, curDate, ccode);
			}
			int maxlvl = this.accountItemMapper.selectMaxAccountlevel();
			List<HashMap<String, Object>> alist = this.accountItemMapper.selectByAccountLevel(maxlvl);
			for (int j = 0; j < alist.size(); j++)
			{
				HashMap<String, Object> a = (HashMap<String, Object>) alist.get(j);
				int v_cnt2 = this.accountItemMapper.selectCountBycodeAndAccountLevel((String) a.get("code"),
						(Integer) a.get("accountlevel"));
				if (v_cnt2 > 0)
				{
					this.dailyBalanceMapper.updateInbalanceAccount(curDate, (String) a.get("code"),
							(Integer) a.get("accountlevel"));
				}
			}
			// 更新当日结算余额
			this.dailyBalanceMapper.updateTodaybanance(curDate);
			previousDate = curDate;
		}
		BigtradeLoggerUtil.operationLogger.info("时间:"+nowStr+" "+"生成dailybalance结束");
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), null);
		return resp;
	}
}

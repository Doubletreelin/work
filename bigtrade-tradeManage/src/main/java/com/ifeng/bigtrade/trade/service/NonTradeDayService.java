package com.ifeng.bigtrade.trade.service;

import java.util.List;

import com.ifeng.bigtrade.trade.entites.NonTradeDay;

public interface NonTradeDayService
{
	/**
	 * 编辑交易日期
	 * @throws Exception 
	 */
	public Long editTradeDay(NonTradeDay td) throws Exception;

	/**
	 * 分页查询交易日期
	 * @param pageNum
	 * @param pageSize
	 */
	public List<NonTradeDay> getTradeDayWithPage()  throws Exception;
}

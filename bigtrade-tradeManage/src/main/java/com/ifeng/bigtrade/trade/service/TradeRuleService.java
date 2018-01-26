package com.ifeng.bigtrade.trade.service;

import java.util.List;

import com.ifeng.bigtrade.trade.entites.TradeRule;

public interface TradeRuleService
{
	/**
	 * 查询交易规则
	 */
	public List<TradeRule> getRule() throws Exception;

	/**
	 * 修改交易规则
	 */
	public boolean editRule(TradeRule record) throws Exception;
}

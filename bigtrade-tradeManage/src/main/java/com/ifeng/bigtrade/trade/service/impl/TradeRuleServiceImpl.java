package com.ifeng.bigtrade.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifeng.bigtrade.trade.entites.TradeRule;
import com.ifeng.bigtrade.trade.mapper.TradeRuleMapper;
import com.ifeng.bigtrade.trade.service.TradeRuleService;

@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
@Service
public class TradeRuleServiceImpl implements TradeRuleService
{
	@Autowired
	private TradeRuleMapper tradeRuleMapper;

	@Override
	public List<TradeRule> getRule() throws Exception
	{
		return tradeRuleMapper.selectByExample(null);
	}

	@Override
	public boolean editRule(TradeRule record) throws Exception
	{
		if (tradeRuleMapper.updateByPrimaryKeySelective(record) == 1)
		{
			return true;
		}
		return false;
	}

}

package com.ifeng.bigtrade.trade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifeng.bigtrade.trade.entites.NonTradeDay;
import com.ifeng.bigtrade.trade.mapper.NonTradeDayMapper;
import com.ifeng.bigtrade.trade.service.NonTradeDayService;

@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
@Service
public class NonTradeDayServiceImpl implements NonTradeDayService
{
	@Autowired
	private NonTradeDayMapper nonTradeDayMapper;

	@Override
	public Long editTradeDay(NonTradeDay td) throws Exception
	{
		int ins = 0;
		int upd = 0;
		if (td.getId() == null)
		{
			td.setAddTime(new Date());
			ins = nonTradeDayMapper.insert(td);
		} else
		{
			upd = nonTradeDayMapper.updateByPrimaryKeySelective(td);
		}
		if ((ins == 1 && td.getId() != null) || upd == 1)
		{
			return td.getId();
		}
		return null;
	}

	@Override
	public List<NonTradeDay> getTradeDayWithPage() throws Exception
	{
		List<NonTradeDay> list = nonTradeDayMapper.selectByExample(null);
		if (list != null && list.size() > 0)
		{
			return list;
		}
		return null;
	}
}

package com.ifeng.bigtrade.trade.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;

import com.ifeng.bigtrade.trade.entites.ParamNode;
import com.ifeng.bigtrade.trade.entites.ParamNodeExample;
import com.ifeng.bigtrade.trade.entites.TradeParam;
import com.ifeng.bigtrade.trade.entites.TradeParam.tradeStatus;
import com.ifeng.bigtrade.trade.entites.TradeParamExample;
import com.ifeng.bigtrade.trade.mapper.ParamNodeMapper;
import com.ifeng.bigtrade.trade.mapper.TradeParamMapper;
import com.ifeng.bigtrade.trade.service.TradeParamService;

@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
@Service
public class TradeParamServiceImpl implements TradeParamService
{
	@Autowired
	private TradeParamMapper tradeParamMapper;
	@Autowired
	private ParamNodeMapper paramNodeMapper;

	@Override
	public Long initTradeParam(Long cid) throws Exception
	{
		TradeParam tp = new TradeParam();
		tp.setAddTime(new Date());
		tp.setDeleteStatus(false);
		tp.setCommodityId(cid);
		tp.setTradeStatus(tradeStatus.no.getState());
		tp.setClearprice(new BigDecimal(0));
		tp.setTurnover(new BigDecimal(0));
		int ins = tradeParamMapper.insert(tp);
		if (ins == 1)
		{
			return tp.getId();
		} else
		{
			return null;
		}
	}

	@Override
	public boolean editTradeParam(TradeParam tp) throws Exception
	{
		if (tradeParamMapper.updateByPrimaryKeySelective(tp) == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<TradeParam> getParamByCondition(TradeParamExample example) throws Exception
	{
		return tradeParamMapper.selectByExample(example);
	}

	@Override
	public boolean editTradeParamByCid(TradeParam tp) throws Exception
	{
		if (tradeParamMapper.updateByCid(tp) == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<ParamNode> getParamNodeByCondition(ParamNodeExample example) throws Exception
	{
		List<ParamNode> list = paramNodeMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean editParamNode(Long pid, Long[] nids) throws Exception
	{
		int flag = 0;
		// 先删除原数据
		paramNodeMapper.deleteByParamId(pid);
		// 然后重新保存
		ParamNode pn = null;
		Date addTime = new Date();
		for (Long nid : nids)
		{
			pn = new ParamNode(addTime, pid, nid);
			if (paramNodeMapper.insert(pn) == 1)
			{
				flag++;
			}
		}
		if (flag == nids.length)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<TradeParam> getParamByNidOrPid(Long nid, Long pid) throws Exception
	{
		List<TradeParam> list = tradeParamMapper.getParamByNidOrPid(nid, pid);
		return list;
	}

	@Override
	public boolean backup() throws Exception
	{
		try
		{
			tradeParamMapper.backup();
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("=====！！！！！交易参数备份失败！！！！！");
			return false;
		}
	}

}

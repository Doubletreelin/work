package com.ifeng.bigtrade.trade.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifeng.bigtrade.trade.entites.TradeNode;
import com.ifeng.bigtrade.trade.entites.TradeNodeExample;
import com.ifeng.bigtrade.trade.entites.TradeParam;
import com.ifeng.bigtrade.trade.mapper.ParamNodeMapper;
import com.ifeng.bigtrade.trade.mapper.TradeNodeMapper;
import com.ifeng.bigtrade.trade.mapper.TradeParamMapper;
import com.ifeng.bigtrade.trade.service.TradeNodeService;

@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
@Service
public class TradeNodeServiceImpl implements TradeNodeService
{
	@Autowired
	private TradeNodeMapper tradeNodeMapper;
	@Autowired
	private TradeParamMapper tradeParamMapper;
	@Autowired
	private ParamNodeMapper paramNodeMapper;

	@Override
	public Long editTradeNode(TradeNode tn) throws Exception
	{
		int ins = 0;
		int upd = 0;
		tn.setDeleteStatus(false);
		if (tn.getId() == null)
		{
			tn.setAddTime(new Date());
			ins = tradeNodeMapper.insert(tn);
		} else
		{
			upd = tradeNodeMapper.updateByPrimaryKeySelective(tn);
		}
		if ((ins == 1 && tn.getId() != null) || upd == 1)
		{
			return tn.getId();
		} else
		{
			return null;
		}
	}

	@Override
	public boolean delTradeNode(Long nid) throws Exception
	{
		// 断开商品交易参数与交易节的联系
		paramNodeMapper.deleteByNodeId(nid);
		// 删除交易节
		if (tradeNodeMapper.deleteByPrimaryKey(nid) == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<TradeNode> getTradeNodeByContion(TradeNodeExample example) throws Exception
	{
		return tradeNodeMapper.selectByExample(example);
	}

}

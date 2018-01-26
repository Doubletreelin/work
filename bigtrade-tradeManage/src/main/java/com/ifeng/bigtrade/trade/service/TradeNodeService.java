package com.ifeng.bigtrade.trade.service;

import java.util.List;

import com.ifeng.bigtrade.trade.entites.TradeNode;
import com.ifeng.bigtrade.trade.entites.TradeNodeExample;

public interface TradeNodeService
{
	/**
	 * 编辑交易节点
	 * 
	 * @param tp
	 * @return
	 * @throws Exception
	 */
	public Long editTradeNode(TradeNode tn) throws Exception;

	/**
	 * 删除交易节点
	 * 
	 * @param tid
	 * @return
	 */
	public boolean delTradeNode(Long nid) throws Exception;

	/**
	 * 分页查询交易节
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TradeNode> getTradeNodeByContion(TradeNodeExample example) throws Exception;
}

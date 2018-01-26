package com.ifeng.bigtrade.trade.service;

import java.util.List;

import com.ifeng.bigtrade.trade.entites.ParamNode;
import com.ifeng.bigtrade.trade.entites.ParamNodeExample;
import com.ifeng.bigtrade.trade.entites.TradeParam;
import com.ifeng.bigtrade.trade.entites.TradeParamExample;

public interface TradeParamService
{
	/**
	 * 根据商品id，初始化交易参数表
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public Long initTradeParam(Long cid) throws Exception;

	/**
	 * 根据交易参数id，编辑交易参数
	 * 
	 * @param tp
	 * @return
	 */
	public boolean editTradeParam(TradeParam tp) throws Exception;

	/**
	 * 查询商品的交易参数
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public List<TradeParam> getParamByCondition(TradeParamExample example) throws Exception;

	/**
	 * 根据商品id，编辑交易参数
	 * 
	 * @param tp
	 * @return
	 */
	public boolean editTradeParamByCid(TradeParam tp) throws Exception;

	/**
	 * 查询商品的交易节
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ParamNode> getParamNodeByCondition(ParamNodeExample example) throws Exception;

	/**
	 * 编辑商品的交易节
	 * 
	 * @param tp
	 * @return
	 */
	public boolean editParamNode(Long pid, Long[] nids) throws Exception;

	/**
	 * 通过交易节id、参数id查询商品的交易节
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TradeParam> getParamByNidOrPid(Long nid, Long pid) throws Exception;

	/**
	 * 交易参数备份
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public boolean backup() throws Exception;
}

package com.ifeng.bigtrade.trade.service;

import com.ifeng.bigtrade.trade.entites.SpecialParam;

public interface SpecialParamService
{
	/**
	 * 根据商品手续费
	 */
	public SpecialParam getCommodityCharge(Long userId,Long cid) throws Exception;
}

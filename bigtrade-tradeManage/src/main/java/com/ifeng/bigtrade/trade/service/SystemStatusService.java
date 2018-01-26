package com.ifeng.bigtrade.trade.service;

import com.ifeng.bigtrade.trade.entites.SystemStatus;

public interface SystemStatusService
{
	/**
	 * 获取订单交易系统当前状态
	 */
	public SystemStatus getSystemStatus() throws Exception;

}

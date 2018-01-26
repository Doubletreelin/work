package com.ifeng.bigtrade.liquidation.services;

import java.math.BigDecimal;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.ifeng.bigtrade.liquidation.entites.resp.ResponseMessage;

public interface LiquidationService
{

	ResponseMessage liquadition(HttpServletRequest request) throws Exception;

	HashMap<String, HashMap<String, Object>> liquadition();

	ResponseMessage trade(HttpServletRequest request, BigDecimal avg_price, Integer count, String orderNo,
			BigDecimal buyfee, BigDecimal sellfee, Integer buyfeetype, Integer sellfeetype) throws Exception;

	ResponseMessage entrust(HttpServletRequest request, BigDecimal avg_price, Integer count, String orderNo,
			BigDecimal buyfee, Integer buyfeetype) throws Exception;

	ResponseMessage purchasing(HttpServletRequest request, BigDecimal avg_price, Integer count,
			BigDecimal buyfee, Integer buyfeetype) throws Exception;

}
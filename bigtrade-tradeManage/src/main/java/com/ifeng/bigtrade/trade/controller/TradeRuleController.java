package com.ifeng.bigtrade.trade.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigtrade.logger.BigtradeLoggerUtil;

import com.ifeng.bigtrade.trade.entites.TradeRule;
import com.ifeng.bigtrade.trade.entites.TradeRule.SelfTradingState;
import com.ifeng.bigtrade.trade.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.trade.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.trade.enums.RespStatusCode;
import com.ifeng.bigtrade.trade.service.TradeRuleService;

/**
 * @author Zhj
 */
@RestController
@RequestMapping("/traderule")
public class TradeRuleController
{
	@Autowired
	private TradeRuleService tradeRuleService;

	/**
	 * 查询交易规则
	 */
	@RequestMapping("get")
	public Object getTradeDay(HttpServletRequest request, HttpServletResponse response,
			Integer pageNum, Integer pageSize) throws Exception
	{
		List<TradeRule> list = tradeRuleService.getRule();
		if (list != null && list.size() > 0)
		{
			HashMap<String, Object> body = new HashMap<String, Object>();
			body.put("rule", list.get(0));
			return new ResponseMessage(new ResponseHeader(request, RespStatusCode.Succ.getId(),
					RespStatusCode.Succ.getName()), body);
		}
		return new ResponseMessage(new ResponseHeader(request, RespStatusCode.ObjectNull.getId(),
				RespStatusCode.ObjectNull.getName()), null);
	}

	/**
	 * 修改交易规则
	 */
	@RequestMapping("/update/{id}")
	public Object updateTradeRule(HttpServletRequest request, HttpServletResponse response,
			TradeRule rule) throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "updateTradeRule", "修改交易规则", null, rule.getSelfTradingState());
		ResponseHeader header = null;
		boolean flag = false;
		SelfTradingState[] tradingStates = SelfTradingState.values();
		for (SelfTradingState state : tradingStates)
		{
			if (state.getState() == rule.getSelfTradingState())
			{
				flag = true;
				break;
			}
		}
		if (flag)
		{
			if (tradeRuleService.editRule(rule))
			{
				header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
						RespStatusCode.Succ.getName());
				BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "updateTradeRule", "修改交易规则", null,
						header.toString());
				return new ResponseMessage(header, null);
			}
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "updateTradeRule", "修改交易规则", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		header = new ResponseHeader(request, RespStatusCode.ParamError.getId(),
				RespStatusCode.ParamError.getName());
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "updateTradeRule", "修改交易规则", null,
				header.toString());
		return new ResponseMessage(header, null);
	}

}

package com.ifeng.bigtrade.trade.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigtrade.logger.BigtradeLoggerUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.trade.entites.TradeNode;
import com.ifeng.bigtrade.trade.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.trade.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.trade.enums.RespStatusCode;
import com.ifeng.bigtrade.trade.service.TradeNodeService;

/**
 * @author Zhj
 */
@RestController
@RequestMapping("/tradenode")
public class TradeNodeController
{
	@Autowired
	private TradeNodeService tradeNodeService;

	/**
	 * 4、添加交易节
	 */
	@RequestMapping("/edit")
	public Object editTradeNode(HttpServletRequest request, HttpServletResponse response,
			@Validated TradeNode tn) throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "editTradeNode", "添加交易节", null);
		ResponseHeader header = null;
		if (tn.getStartTime().before(tn.getEndTime()))
		{
			List<TradeNode> list = tradeNodeService.getTradeNodeByContion(null);
			for (TradeNode node : list)
			{
				// =======================================
				if ((node.getStartTime().compareTo(tn.getStartTime()) <= 0 && tn.getStartTime()
						.compareTo(node.getEndTime()) < 0)
						|| (node.getStartTime().compareTo(tn.getEndTime()) < 0 && tn.getEndTime()
								.compareTo(node.getEndTime()) <= 0)
						|| (tn.getStartTime().compareTo(node.getStartTime()) <= 0 && node
								.getEndTime().compareTo(tn.getEndTime()) <= 0))
				{
					header = new ResponseHeader(request, RespStatusCode.ParamError.getId(),
							RespStatusCode.ParamError.getName());
					BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "添加交易节", null,
							header.toString());
					return new ResponseMessage(header, null);
				}
				// =======================================
			}
		} else
		{
			header = new ResponseHeader(request, RespStatusCode.ParamError.getId(),
					RespStatusCode.ParamError.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "添加交易节", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		Long nid = tradeNodeService.editTradeNode(tn);
		if (nid == null)
		{
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "添加交易节", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("nid", nid);
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "添加交易节", null,
				header.toString(), body);
		return new ResponseMessage(header, body);
	}

	/**
	 * 5、删除交易节
	 */
	@RequestMapping("/delete/{nid}")
	public Object delTradeNode(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("nid") Long nid) throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "delTradeNode", "删除交易节", null, nid);
		ResponseHeader header = null;
		if (tradeNodeService.delTradeNode(nid))
		{
			header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
					RespStatusCode.Succ.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "delTradeNode", "删除交易节", null,
					header.toString());
			return new ResponseMessage(header, null);
		} else
		{
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "delTradeNode", "删除交易节", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
	}

	/**
	 * 6、修改交易节
	 */
	@RequestMapping("/update")
	public Object updateTradeNode(HttpServletRequest request, HttpServletResponse response,
			@Validated TradeNode tn) throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "updateTradeNode", "修改交易节", null);
		ResponseHeader header = null;
		if (tn.getId() == null)
		{
			header = new ResponseHeader(request, RespStatusCode.ParamNull.getId(),
					RespStatusCode.ParamNull.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateTradeNode", "修改交易节", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		Long nid = tradeNodeService.editTradeNode(tn);
		if (nid == null)
		{
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateTradeNode", "修改交易节", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("nid", nid);
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateTradeNode", "修改交易节", null,
				header.toString(), body);
		return new ResponseMessage(header, body);
	}

	/**
	 * 7、查询交易节列表
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/get")
	public Object getTradeNode(HttpServletRequest request, HttpServletResponse response,
			Integer pageNum, Integer pageSize) throws Exception
	{
		ResponseHeader header = null;
		HashMap<String, Object> body = new HashMap<String, Object>();
		PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
		List<TradeNode> list = tradeNodeService.getTradeNodeByContion(null);
		PageInfo page = new PageInfo<>(list);
		if (list != null && list.size() > 0)
		{
			header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
					RespStatusCode.Succ.getName());
			body.put("page", page);
		} else
		{
			header = new ResponseHeader(request, RespStatusCode.ObjectNull.getId(),
					RespStatusCode.ObjectNull.getName());
		}
		return new ResponseMessage(header, body);
	}

}

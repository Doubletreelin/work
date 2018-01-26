package com.ifeng.bigtrade.trade.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigtrade.logger.BigtradeLoggerUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.trade.entites.SpecialParam;
import com.ifeng.bigtrade.trade.entites.SystemStatus;
import com.ifeng.bigtrade.trade.entites.TradeParam;
import com.ifeng.bigtrade.trade.entites.TradeParam.ChargeAlg;
import com.ifeng.bigtrade.trade.entites.TradeParam.tradeStatus;
import com.ifeng.bigtrade.trade.entites.TradeParamExample;
import com.ifeng.bigtrade.trade.entites.TradeParamExample.Criteria;
import com.ifeng.bigtrade.trade.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.trade.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.trade.enums.RespStatusCode;
import com.ifeng.bigtrade.trade.service.SpecialParamService;
import com.ifeng.bigtrade.trade.service.SystemStatusService;
import com.ifeng.bigtrade.trade.service.TradeParamService;

/**
 * @author Zhj
 */
@RestController
@RequestMapping("/tradeparam")
public class TradeParamController
{
	@Autowired
	private TradeParamService tradeParamService;
	@Autowired
	private SpecialParamService specialParamService;
	@Autowired
	private SystemStatusService systemStatusService;

	/**
	 * 1、添加订单交易模式下商品
	 */
	@RequestMapping("/init")
	public Object initTradeParam(HttpServletRequest request, HttpServletResponse response, Long cid)
			throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "initTradeParam", "初始化商品交易参数", null, "商品ID:"
				+ cid);
		ResponseHeader header = null;
		if (cid == null)
		{
			header = new ResponseHeader(request, RespStatusCode.ParamNull.getId(),
					RespStatusCode.ParamNull.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "initTradeParam", "初始化商品交易参数", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		HashMap<String, Object> body = new HashMap<String, Object>();
		// 商品id为唯一索引,不需要再检验该商品是否已设置交易参数
		Long pid = tradeParamService.initTradeParam(cid);
		if (pid == null)
		{
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "initTradeParam", "初始化商品交易参数", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		body.put("pid", pid);
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "initTradeParam", "初始化商品交易参数", null,
				header.toString(), body);
		return new ResponseMessage(header, body);
	}

	/**
	 * 2、修改商品交易信息
	 */
	@RequestMapping("/update")
	public Object updateTradeParam(HttpServletRequest request, HttpServletResponse response,
			@Validated TradeParam tp, Long[] nids) throws Exception
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("node", tp);
		map.put("nids", nids);
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "updateTradeParam", "修改商品交易信息", null, map);
		ResponseHeader header = null;
		if (tp.getTradeStatus() == tradeStatus.yes.getState() && (nids == null || nids.length <= 0))
		{
			header = new ResponseHeader(request, RespStatusCode.ParamNull.getId(),
					RespStatusCode.ParamNull.getName() + " 商品可交易时，所属交易节不能为空");
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateTradeParam", "修改商品交易信息", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		// 保存商品交易节
		if (!tradeParamService.editParamNode(tp.getId(), nids))
		{
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName() + "保存商品交易节错误");
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateTradeParam", "修改商品交易信息", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		tp.setClearprice(tp.getOpenPrice());
		if (tradeParamService.editTradeParam(tp))
		{
			header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
					RespStatusCode.Succ.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateTradeParam", "修改商品交易信息", null,
					header.toString());
			HashMap<String, Object> body = new HashMap<String, Object>();
			return new ResponseMessage(header, body);
		} else
		{
			return new ResponseMessage(new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName()), null);
		}
	}

	/**
	 * 3、获得订单交易系统内商品的交易参数
	 */
	@RequestMapping("/select/{cids}")
	public Object getParamByCid(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("cids") Long[] cids, Integer status) throws Exception
	{
		TradeParamExample example = new TradeParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andCommodityIdIn(Arrays.asList(cids));
		if (status != null)
		{
			// 交易状态（0：不可交易，1：可交易）
			criteria.andTradeStatusEqualTo(status);
		}
		List<TradeParam> list = tradeParamService.getParamByCondition(example);
		HashMap<String, Object> body = new HashMap<String, Object>();
		if (list != null && list.size() > 0)
		{
			body.put("list", list);
		} else
		{
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ObjectNull.getId(), RespStatusCode.ObjectNull.getName()), body);
		}
		ResponseHeader header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		return new ResponseMessage(header, body);
	}

	/**
	 * 10、计算商品手续费
	 */
	@RequestMapping("/getcharge")
	public Object getCommodityCharge(HttpServletRequest request, HttpServletResponse response,
			Long userId, Long commodityId, BigDecimal price, Integer amount, String flag)
			throws Exception
	{
		if (commodityId == null || price == null || amount == null || StringUtils.isBlank(flag))
		{
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ParamNull.getId(), RespStatusCode.ParamNull.getName()), null);
		}
		BigDecimal money = null;
		SpecialParam specialParam = null;
		if (userId != null)
		{
			specialParam = specialParamService.getCommodityCharge(userId, commodityId);
		}
		TradeParamExample example = new TradeParamExample();
		example.createCriteria().andCommodityIdEqualTo(commodityId);
		TradeParam param = null;
		List<TradeParam> list = tradeParamService.getParamByCondition(example);
		if (list != null && list.size() > 0)
		{
			param = list.get(0);
		} else
		{
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ObjectNull.getId(), RespStatusCode.ObjectNull.getName()), null);
		}
		Double alg = null;
		BigDecimal charge = null;
		Integer chargeAlg = null;
		Integer status = null;
		SystemStatus systemStatus = systemStatusService.getSystemStatus();
		if (systemStatus != null && systemStatus.getNodeId() != null && param.getNodeId() != null
				&& param.getNodeId().contains(systemStatus.getNodeId().toString())
				&& param.getTradeStatus() == tradeStatus.yes.getState())
		{
			status = tradeStatus.yes.getState();
		} else
		{
			status = tradeStatus.no.getState();
		}
		if (specialParam != null)
		{
			if ("buy".equals(flag))
			{
				charge = specialParam.getBuyCharge();
			} else
			{
				charge = specialParam.getSellCharge();
			}
			chargeAlg = specialParam.getChargeAlg();
			alg = ChargeAlg.getDouble(chargeAlg);
			if (specialParam.getChargeAlg() == ChargeAlg.fixed.getId())
			{
				price = new BigDecimal(1);
			}
		} else
		{
			if ("buy".equals(flag))
			{
				charge = param.getBuyCharge();
			} else
			{
				charge = param.getSellCharge();
			}
			chargeAlg = param.getChargeAlg();
			alg = ChargeAlg.getDouble(param.getChargeAlg());
			if (param.getChargeAlg() == ChargeAlg.fixed.getId())
			{
				price = new BigDecimal(1);
			}
		}
		if (chargeAlg == ChargeAlg.fixed.getId())
		{
			money = charge.multiply(BigDecimal.valueOf(amount));
			money.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else
		{
			money = price.multiply(charge).multiply(new BigDecimal(Double.toString(alg)));
			money.setScale(2, BigDecimal.ROUND_HALF_UP);
			money = new BigDecimal(Integer.toString(amount)).multiply(money);
		}
		ResponseHeader header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("money", money);
		body.put("tradeStatus", status);
		body.put("chargeAlg", chargeAlg);
		body.put("charge", charge);
		return new ResponseMessage(header, body);
	}

	/**
	 * 11、获得指定交易节详情
	 */
	@RequestMapping("/get/{nid}")
	public Object getParamByNid(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("nid") Long nid, Integer pageNum, Integer pageSize) throws Exception
	{
		PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
		List<TradeParam> list = tradeParamService.getParamByNidOrPid(nid, null);
		ResponseHeader header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		HashMap<String, Object> body = new HashMap<String, Object>();
		if (list != null && list.size() > 0)
		{
			body.put("page", new PageInfo<>(list));
		} else
		{
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ObjectNull.getId(), RespStatusCode.ObjectNull.getName()), null);
		}
		return new ResponseMessage(header, body);
	}

	/**
	 * 12、修改商品交易参数的流通量
	 */
	@RequestMapping("/turnover/{cid}")
	public Object updateTradeParam(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("cid") Long cid, BigDecimal turnover) throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "updateTradeParam", "修改商品交易参数的流通量", null, cid,
				turnover);
		ResponseHeader header = null;
		TradeParam tp = new TradeParam();
		tp.setCommodityId(cid);
		tp.setTurnover(turnover);
		if (tradeParamService.editTradeParamByCid(tp))
		{
			header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
					RespStatusCode.Succ.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateTradeParam", "修改商品交易参数的流通量", null,
					header.toString());
			return new ResponseMessage(header, null);
		} else
		{
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateTradeParam", "修改商品交易参数的流通量", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
	}

	/**
	 * 13、修改商品交易参数的结算价
	 */
	@RequestMapping("/clearprice/{cid}")
	public Object updateClearprice(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("cid") Long cid, BigDecimal clearprice) throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "updateClearprice", "修改商品交易参数的结算价", null, cid,
				clearprice);
		ResponseHeader header = null;
		TradeParam tp = new TradeParam();
		tp.setCommodityId(cid);
		tp.setClearprice(clearprice);
		if (tradeParamService.editTradeParamByCid(tp))
		{
			header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
					RespStatusCode.Succ.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateClearprice", "修改商品交易参数的结算价", null,
					header.toString());
			return new ResponseMessage(header, null);
		} else
		{
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "updateClearprice", "修改商品交易参数的结算价", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
	}

	/**
	 * 3-1、获得订单交易系统内商品的交易参数
	 */
	@RequestMapping("/selectOne")
	public Object getParamByCid(HttpServletRequest request, HttpServletResponse response, Long cid,
			Integer status) throws Exception
	{
		TradeParamExample example = new TradeParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andCommodityIdEqualTo(cid);
		if (status != null)
		{
			// 交易状态（0：不可交易，1：可交易）
			criteria.andTradeStatusEqualTo(status);
		}
		List<TradeParam> list = tradeParamService.getParamByCondition(example);
		HashMap<String, Object> body = new HashMap<String, Object>();
		if (list != null && list.size() > 0)
		{
			body.put("list", list);
		} else
		{
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ObjectNull.getId(), RespStatusCode.ObjectNull.getName()), null);
		}
		ResponseHeader header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		return new ResponseMessage(header, body);
	}

	/**
	 * 商品的交易参数备份
	 */
	@RequestMapping("/backup")
	public Object backupParam(HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "backupParam", "商品的交易参数备份", null);
		ResponseHeader header = new ResponseHeader(request, RespStatusCode.Error.getId(),
				RespStatusCode.Error.getName());
		if (tradeParamService.backup())
		{
			header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
					RespStatusCode.Succ.getName());
			return new ResponseMessage(header, null);
		}
		return new ResponseMessage(header, null);
	}

	/**
	 * 判断商品能否下单、撤单
	 */
	@RequestMapping("/judge/order")
	public Object judgeOrder(HttpServletRequest request, HttpServletResponse response, Long cid,
			Long nid) throws Exception
	{
		HashMap<String, Object> body = new HashMap<String, Object>();
		if (cid == null || nid == null)
		{
			body.put("tradeStatus", "no");
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ParamNull.getId(), RespStatusCode.ParamNull.getName()), body);
		}
		TradeParamExample example = new TradeParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andCommodityIdEqualTo(cid);
		List<TradeParam> list = tradeParamService.getParamByCondition(example);
		if (list == null || list.size() <= 0)
		{
			body.put("tradeStatus", "no");
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ObjectNull.getId(), "查无次商品（ID" + cid + "）"), body);
		}
		TradeParam param = list.get(0);
		int state = param.getTradeStatus();
		if (state == tradeStatus.yes.getState() && param.getNodeId() != null
				&& param.getNodeId().contains(nid.toString()))
		{
			body.put("tradeStatus", "ok");
		} else
		{
			body.put("tradeStatus", "no");
		}
		return new ResponseMessage(new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName()), body);
	}
}

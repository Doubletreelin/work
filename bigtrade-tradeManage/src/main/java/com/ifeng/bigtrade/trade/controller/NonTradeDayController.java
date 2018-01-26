package com.ifeng.bigtrade.trade.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigtrade.logger.BigtradeLoggerUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.trade.entites.NonTradeDay;
import com.ifeng.bigtrade.trade.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.trade.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.trade.enums.RespStatusCode;
import com.ifeng.bigtrade.trade.service.NonTradeDayService;

/**
 * @author Zhj
 */
@RestController
@RequestMapping("/tradeday")
public class NonTradeDayController
{
	@Autowired
	private NonTradeDayService nonTradeDayService;

	/**
	 * 8、修改交易日期
	 */
	@RequestMapping("/edit")
	public Object editTradeNode(HttpServletRequest request, HttpServletResponse response, Long id,
			Integer[] nonweek, String[] nonday) throws Exception
	{
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-tradeManage", "editTradeNode", "修改交易日期", null, id, nonweek,
				nonday);
		ResponseHeader header = null;
		// 判断非空
		if (id == null || nonday == null || nonweek == null || nonday.length <= 0
				|| nonweek.length <= 0)
		{
			header = new ResponseHeader(request, RespStatusCode.ParamNull.getId(),
					RespStatusCode.ParamNull.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "修改交易日期", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		String nonTradeday = "";
		String nonTradeweek = "";
		// 确保非交易日为yyyy-MM-dd格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			for (String str : nonday)
			{
				nonTradeday += sdf.format(sdf.parse(str)) + ",";
			}
		} catch (ParseException e)
		{
			header = new ResponseHeader(request, RespStatusCode.ParamError.getId(), "非交易日"
					+ RespStatusCode.ParamError.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "修改交易日期", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		for (Integer i : nonweek)
		{
			// 确保非交易周为周日1--7周六的有效周
			if (i >= 1 && i <= 7)
			{
				nonTradeweek += i + ",";
			} else
			{
				header = new ResponseHeader(request, RespStatusCode.ParamError.getId(), "非交易周"
						+ RespStatusCode.ParamError.getName());
				BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "修改交易日期", null,
						header.toString());
				return new ResponseMessage(header, null);
			}
		}
		NonTradeDay td = new NonTradeDay(id, false, nonTradeday, nonTradeweek);
		Long tdid = nonTradeDayService.editTradeDay(td);
		if (tdid == null)
		{
			header = new ResponseHeader(request, RespStatusCode.Error.getId(),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "修改交易日期", null,
					header.toString());
			return new ResponseMessage(header, null);
		}
		header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("tdid", tdid);
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-tradeManage", "editTradeNode", "修改交易日期", null,
				header.toString());
		return new ResponseMessage(header, body);
	}

	/**
	 * 9、 查询交易日期
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("get")
	public Object getTradeDay(HttpServletRequest request, HttpServletResponse response,
			Integer pageNum, Integer pageSize) throws Exception
	{
		PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 1 : pageSize);
		List<NonTradeDay> list = nonTradeDayService.getTradeDayWithPage();
		if (list == null || list.size() <= 0)
		{
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ObjectNull.getId(), RespStatusCode.ObjectNull.getName()), null);
		}
		PageInfo page = new PageInfo<>(list);
		ResponseHeader header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("page", page);
		return new ResponseMessage(header, body);
	}

	/**
	 * 10、 获取下一交易日期
	 */
	@RequestMapping("getNext")
	public Object getNextTradeDay(HttpServletRequest request, HttpServletResponse response,
			Integer pageNum, Integer pageSize) throws Exception
	{
		List<NonTradeDay> list = nonTradeDayService.getTradeDayWithPage();
		if (list == null || list.size() <= 0)
		{
			return new ResponseMessage(new ResponseHeader(request,
					RespStatusCode.ObjectNull.getId(), RespStatusCode.ObjectNull.getName()), null);
		}
		NonTradeDay nonTradeDay = list.get(0);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		int i = 1;
		String nextday = "";
		Integer weekday = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		while (true)
		{
			calendar.set(Calendar.DAY_OF_YEAR, day + i);
			nextday = sdf.format(calendar.getTime());
			weekday = calendar.get(Calendar.DAY_OF_WEEK);
			if ((nonTradeDay.getNonDay() == null || !nonTradeDay.getNonDay().contains(nextday))
					&& (nonTradeDay.getNonWeek() == null || !nonTradeDay.getNonWeek().contains(
							weekday.toString())))
			{
				break;
			} else
			{
				i++;
			}
		}
		ResponseHeader header = new ResponseHeader(request, RespStatusCode.Succ.getId(),
				RespStatusCode.Succ.getName());
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("nextday", nextday);
		return new ResponseMessage(header, body);
	}
}

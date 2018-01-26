package com.ifeng.bigtrade.liquidation.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifeng.bigtrade.liquidation.entites.enumf.ERespCode;
import com.ifeng.bigtrade.liquidation.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.liquidation.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.liquidation.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.liquidation.exceptions.MyException;
import com.ifeng.bigtrade.liquidation.services.LiquidationService;

/**
 * 关于清分的操作Controller
 * 
 * @author shaolin
 *
 */

@RestController
@RequestMapping("/liquidation")
public class LiquidationController
{
	@Autowired
	private LiquidationService liquidationService;

	/**
	 * 计算交易的参数
	 * 
	 * @param request
	 * @param avg_price
	 * @param count
	 * @param orderNo
	 * @param buyfee
	 * @param sellfee
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/trade", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object trade(HttpServletRequest request, BigDecimal avg_price, Integer count, String orderNo,
			BigDecimal buyfee, BigDecimal sellfee, Integer buyfeetype, Integer sellfeetype) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.liquidationService.trade(request, avg_price, count, orderNo, buyfee, sellfee, buyfeetype,
					sellfeetype);
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 计算委托的参数
	 * 
	 * @param request
	 * @param avg_price
	 * @param count
	 * @param orderNo
	 * @param buyfee
	 * @param sellfee
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/entrust", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object entrust(HttpServletRequest request, BigDecimal avg_price, Integer count, String orderNo,
			BigDecimal buyfee, Integer buyfeetype) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.liquidationService.entrust(request, avg_price, count, orderNo, buyfee, buyfeetype);
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

	/**
	 * 计算申购的参数
	 * 
	 * @param request
	 * @param avg_price
	 * @param count
	 * @param orderNo
	 * @param buyfee
	 * @param sellfee
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	@RequestMapping(path = "/purchasing", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object purchasing(HttpServletRequest request, BigDecimal avg_price, Integer count, BigDecimal buyfee,
			Integer buyfeetype) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			resp = this.liquidationService.purchasing(request, avg_price, count, buyfee, buyfeetype);
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}
	
	@RequestMapping(path = "/purchasingAddAll", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public Object purchasingAddAll(HttpServletRequest request, BigDecimal brokerage, BigDecimal totalAmount) throws Exception
	{
		ResponseMessage resp = new ResponseMessage();
		try
		{
			HashMap<String, Object> rmap = new HashMap<>();
			rmap.put("all", brokerage.add(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP));
			resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException(ERespMessage.selectError, ERespCode.MyBatiesError);
		}
		return resp;
	}

}

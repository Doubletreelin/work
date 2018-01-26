package com.ifeng.bigtrade.liquidation.services.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifeng.bigtrade.liquidation.entites.enumf.ERespCode;
import com.ifeng.bigtrade.liquidation.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.liquidation.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.liquidation.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.liquidation.services.LiquidationService;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class LiquidationServiceImpl implements LiquidationService
{

	@Override
	public ResponseMessage liquadition(HttpServletRequest request) throws Exception
	{
		HashMap<String, Object> rmap = new HashMap<>();
		HashMap<String, HashMap<String, Object>> lmap = this.liquadition();
		rmap.put("result", lmap);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	@Override
	public HashMap<String, HashMap<String, Object>> liquadition()
	{
		HashMap<String, HashMap<String, Object>> list = new HashMap<String, HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("summaryId", (long) 19);
		map.put("summaryNo", "706");
		map.put("summary", "付交易商货款");
		list.put("1", map); // 买方交易费

		map = new HashMap<>();
		map.put("summaryId", (long) 25);
		map.put("summaryNo", "701");
		map.put("summary", "收交易手续费");
		list.put("2", map); // 买方手续费

		map = new HashMap<>();
		map.put("summaryId", (long) 18);
		map.put("type", "3");
		map.put("summaryNo", "705");
		map.put("summary", "收交易商货款");
		list.put("3", map); // 卖方交易费

		map = new HashMap<>();
		map.put("summaryId", (long) 25);
		map.put("summaryNo", "701");
		map.put("summary", "收交易手续费");
		list.put("4", map); // 卖方手续费

		map = new HashMap<>();
		map.put("summaryId", (long) 28);
		map.put("summaryNo", "103");
		map.put("summary", "银行入金");
		list.put("5", map); // 银行入金

		map = new HashMap<>();
		map.put("summaryId", (long) 31);
		map.put("summaryNo", "104");
		map.put("summary", "银行出金");
		list.put("6", map); // 银行出金

		map = new HashMap<>();
		map.put("summaryId", (long) 32);
		map.put("summaryNo", "105");
		map.put("summary", "出金手续费");
		list.put("7", map); // 出金手续费
		return list;
	}

	@Override
	public ResponseMessage trade(HttpServletRequest request, BigDecimal avg_price, Integer count, String orderNo,
			BigDecimal buyfee, BigDecimal sellfee, Integer buyfeetype, Integer sellfeetype) throws Exception
	{
		// 单个价格
		avg_price = avg_price.setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方单个手续费
		BigDecimal buy_avg_fee = new BigDecimal(0);
		if (buyfeetype == 0)
		{// 手续费为费率
			buy_avg_fee = avg_price.multiply(buyfee).setScale(2, BigDecimal.ROUND_HALF_UP);
			// 使用费率的时候，如果手续费低于0.01时候，则最低费率为0.01
			buy_avg_fee = judgeForRate(buy_avg_fee);
		} else if (buyfeetype == 1)
		{// 手续费为固定值
			buy_avg_fee = buyfee;
			// 使用固定值的时候，如果手续费小于成交价的时候，则手续费等于成交价
			buy_avg_fee = judgeForFixed(buy_avg_fee, avg_price);
		} else
		{// 卖方手续费参数有误手续费参数
			ResponseMessage resp = new ResponseMessage(
					new ResponseHeader(request, ERespCode.Error, "买方手续费类型参数有误，传入数值为" + buyfeetype), null);
			return resp;
		}
		// 卖方单个手续费
		BigDecimal sell_avg_fee = new BigDecimal(0);
		if (sellfeetype == 0)
		{
			sell_avg_fee = avg_price.multiply(sellfee).setScale(2, BigDecimal.ROUND_HALF_UP);
			// 使用费率的时候，如果手续费低于0.01时候，则最低费率为0.01
			sell_avg_fee = judgeForRate(sell_avg_fee);
		} else if (sellfeetype == 1)
		{
			sell_avg_fee = sellfee;
			// 使用固定值的时候，如果手续费小于成交价的时候，则手续费等于成交价
			sell_avg_fee = judgeForFixed(sell_avg_fee, avg_price);
		} else
		{
			ResponseMessage resp = new ResponseMessage(
					new ResponseHeader(request, ERespCode.Error, "卖方手续费类型参数有误，传入数值为" + sellfeetype), null);
			return resp;
		}
		// 买方单个价格加手续费
		BigDecimal buy_avg_withfee = avg_price.add(buy_avg_fee).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 卖方单个价格加手续费
		BigDecimal sell_avg_withfee = avg_price.add(sell_avg_fee).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 总价格不带手续费
		BigDecimal all_withoutfee = avg_price.multiply(new BigDecimal(count)).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方总手续费
		BigDecimal buy_all_fee = buy_avg_fee.multiply(new BigDecimal(count)).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 卖方总手续费
		BigDecimal sell_all_fee = sell_avg_fee.multiply(new BigDecimal(count)).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方总价格带手续费
		BigDecimal buy_all_withfee = buy_avg_withfee.multiply(new BigDecimal(count)).setScale(2,
				BigDecimal.ROUND_HALF_UP);
		// 卖方总价格带手续费
		BigDecimal sell_all_withfee = sell_avg_withfee.multiply(new BigDecimal(count)).setScale(2,
				BigDecimal.ROUND_HALF_UP);

		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("avg_price", avg_price);
		rmap.put("buy_avg_fee", buy_avg_fee);
		rmap.put("sell_avg_fee", sell_avg_fee);
		rmap.put("buy_avg_withfee", buy_avg_withfee);
		rmap.put("sell_avg_withfee", sell_avg_withfee);
		rmap.put("all_withoutfee", all_withoutfee);
		rmap.put("buy_all_fee", buy_all_fee);
		rmap.put("sell_all_fee", sell_all_fee);
		rmap.put("buy_all_withfee", buy_all_withfee);
		rmap.put("sell_all_withfee", sell_all_withfee);
		rmap.put("orderNo", orderNo);
		rmap.put("count", count);
		rmap.put("buyfee", buyfee);
		rmap.put("sellfee", sellfee);
		rmap.put("buyfeetype", buyfeetype);
		rmap.put("sellfeetype", sellfeetype);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	@Override
	public ResponseMessage entrust(HttpServletRequest request, BigDecimal avg_price, Integer count, String orderNo,
			BigDecimal buyfee, Integer buyfeetype) throws Exception
	{
		// 单个价格
		avg_price = avg_price.setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方单个手续费
		BigDecimal buy_avg_fee = new BigDecimal(0);
		if (buyfeetype == 0)
		{// 手续费为费率
			buy_avg_fee = avg_price.multiply(buyfee).setScale(2, BigDecimal.ROUND_HALF_UP);
			// 使用费率的时候，如果手续费低于0.01时候，则最低费率为0.01
			buy_avg_fee = judgeForRate(buy_avg_fee);
		} else if (buyfeetype == 1)
		{// 手续费为固定值
			buy_avg_fee = buyfee;
			// 使用固定值的时候，如果手续费小于成交价的时候，则手续费等于成交价
			buy_avg_fee = judgeForFixed(buy_avg_fee, avg_price);
		} else
		{// 卖方手续费参数有误手续费参数
			ResponseMessage resp = new ResponseMessage(
					new ResponseHeader(request, ERespCode.Error, "买方手续费类型参数有误，传入数值为" + buyfeetype), null);
			return resp;
		}
		// 买方单个价格加手续费
		BigDecimal buy_avg_withfee = avg_price.add(buy_avg_fee).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 总价格不带手续费
		BigDecimal all_withoutfee = avg_price.multiply(new BigDecimal(count)).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方总手续费
		BigDecimal buy_all_fee = buy_avg_fee.multiply(new BigDecimal(count)).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方总价格带手续费
		BigDecimal buy_all_withfee = buy_avg_withfee.multiply(new BigDecimal(count)).setScale(2,
				BigDecimal.ROUND_HALF_UP);

		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("avg_price", avg_price);
		rmap.put("buy_avg_fee", buy_avg_fee);
		rmap.put("buy_avg_withfee", buy_avg_withfee);
		rmap.put("all_withoutfee", all_withoutfee);
		rmap.put("buy_all_fee", buy_all_fee);
		rmap.put("buy_all_withfee", buy_all_withfee);
		rmap.put("orderNo", orderNo);
		rmap.put("count", count);
		rmap.put("buyfee", buyfee);
		rmap.put("buyfeetype", buyfeetype);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	@Override
	public ResponseMessage purchasing(HttpServletRequest request, BigDecimal avg_price, Integer count,
			BigDecimal buyfee, Integer buyfeetype) throws Exception
	{
		// 单个价格
		avg_price = avg_price.setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方单个手续费
		BigDecimal buy_avg_fee = new BigDecimal(0);
		if (buyfeetype == 0)
		{// 没有手续费
			;
		} else if (buyfeetype == 1)
		{// 手续费为费率
			buy_avg_fee = avg_price.multiply(buyfee).setScale(2, BigDecimal.ROUND_HALF_UP);
			// 使用费率的时候，如果手续费低于0.01时候，则最低费率为0.01
			buy_avg_fee = judgeForRate(buy_avg_fee);
		} else if (buyfeetype == 2)
		{// 手续费为固定值
			buy_avg_fee = buyfee;
			// 使用固定值的时候，如果手续费小于成交价的时候，则手续费等于成交价
			buy_avg_fee = judgeForFixed(buy_avg_fee, avg_price);
		} else
		{
			ResponseMessage resp = new ResponseMessage(
					new ResponseHeader(request, ERespCode.Error, "申购手续费类型参数有误，传入数值为" + buyfeetype), null);
			return resp;
		}
		// 买方单个价格加手续费
		BigDecimal buy_avg_withfee = avg_price.add(buy_avg_fee).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 总价格不带手续费
		BigDecimal all_withoutfee = avg_price.multiply(new BigDecimal(count)).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方总手续费
		BigDecimal buy_all_fee = buy_avg_fee.multiply(new BigDecimal(count)).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 买方总价格带手续费
		BigDecimal buy_all_withfee = buy_avg_withfee.multiply(new BigDecimal(count)).setScale(2,
				BigDecimal.ROUND_HALF_UP);

		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("avg_price", avg_price);
		rmap.put("buy_avg_fee", buy_avg_fee);
		rmap.put("buy_avg_withfee", buy_avg_withfee);
		rmap.put("all_withoutfee", all_withoutfee);
		rmap.put("buy_all_fee", buy_all_fee);
		rmap.put("buy_all_withfee", buy_all_withfee);
		rmap.put("count", count);
		rmap.put("buyfee", buyfee);
		rmap.put("buyfeetype", buyfeetype);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 当手续费类型是百分比时，最低手续费为0.1
	 * 
	 * @param avg_fee
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public BigDecimal judgeForRate(BigDecimal avg_fee) throws Exception
	{
		if (avg_fee.compareTo(new BigDecimal("0.01")) == -1)
		{// 当手续费小于0.01时，则返回0.01作为手续费
			return new BigDecimal("0.01");
		} else
		{// 当手续费大于等于0.01时，则返回手续费的值
			return avg_fee;
		}
	}

	/**
	 * 当手续费类型为固定值时，如果成交价小于手续费，则手续费等于成交价
	 * 
	 * @param avg_fee
	 * @param price
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public BigDecimal judgeForFixed(BigDecimal avg_fee, BigDecimal price) throws Exception
	{
		if (avg_fee.compareTo(price) == -1)
		{// 当手续费小于单价时，返回手续费
			return avg_fee;
		} else
		{// 当手续费大于等于单价时，返回单价作为手续费
			return price;
		}
	}
}

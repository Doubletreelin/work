package com.ifeng.bigtrade.trade.entites;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 交易参数表
 * 
 * @author Administrator
 * 
 */
public class TradeParam
{
	@NotNull(message = "id交易参数id不能为空")
	private Long id;

	private Date addTime;

	private Boolean deleteStatus;
	@NotNull(message = "commodityId商品id不能为空")
	private Long commodityId;
	@NotNull(message = "tradeStatus交易状态不能为空")
	private Integer tradeStatus;// 是否可交易

	/**
	 * 商品交易状态：是、否
	 */
	public enum tradeStatus
	{
		yes(1), no(0);
		private int state;

		tradeStatus(int s)
		{
			this.state = s;
		}

		public int getState()
		{
			return state;
		}
	};

	@NotNull(message = "商品发行价不能为空")
	private BigDecimal issuePrice;// 发行价
	@NotNull(message = "商品指导价不能为空")
	private BigDecimal openPrice;// 开市指导价
	@NotNull(message = "商品上市日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date listingDate;// 上市日期
	@NotNull(message = "商品最后交易日不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastTradeDate;// 最后交易日
	@NotBlank(message = "商品交易单位不能为空")
	private String tradeUnit;// 交易单位
	@NotNull(message = "商品最小变动价位不能为空")
	private BigDecimal minChangePrice;// 最小变动价位
	@NotNull(message = "商品最小变动数量不能为空")
	private Integer minChangeAmount;// 最小变动数量
	@NotNull(message = "商品涨跌停上限不能为空")
	private BigDecimal upperLimitChange;// 涨跌停上限
	@NotNull(message = "商品涨跌停下限不能为空")
	private BigDecimal lowerLlimitChange;// 涨跌停下限
	@NotNull(message = "商品涨跌停算法不能为空")
	private Integer changeLimitAlg;// 涨跌停算法

	private Integer tnDay;// T+N交易天数
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectDate;// 指数生效日期
	@NotNull(message = "商品单笔最大委托量不能为空")
	private Long maxPerEntrust;// 单笔最大委托量
	@NotNull(message = "商品买入手续费不能为空")
	private BigDecimal buyCharge;// 买入手续费
	@NotNull(message = "商品卖出手续费不能为空")
	private BigDecimal sellCharge;// 卖出手续费
	@NotNull(message = "商品手续费算法不能为空")
	private Integer chargeAlg;// 手续费算法

	/**
	 * 手续费算法：（0：百分比手续费，1：固定手续费）
	 */
	public enum ChargeAlg
	{
		percent(0), fixed(1);

		public static Double[] alg =
		{ 0.01d, 1.00d };
		private Integer id;

		ChargeAlg(Integer id)
		{
			this.id = id;
		}

		public static Double getDouble(Integer i)
		{
			return alg[i];
		}

		public Integer getId()
		{
			return id;
		}

		public void setId(Integer id)
		{
			this.id = id;
		}
	};

	private BigDecimal chargeRemainRate;// 手续费市场存留比例(%)

	private BigDecimal dayHostPrice;// 日托管费标准

	private Integer freeHostday;// 免费托管天数
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date hostChargeBegin;// 仓库日租金收取起始日期

	private String settleUnit;// 交割单位
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date deliveryBegin;// 交货起始日期
	private BigDecimal turnover;// 流通量
	private BigDecimal clearprice;// 结算价

	private String nodeId;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getAddTime()
	{
		return addTime;
	}

	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	public Boolean getDeleteStatus()
	{
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus)
	{
		this.deleteStatus = deleteStatus;
	}

	public Long getCommodityId()
	{
		return commodityId;
	}

	public void setCommodityId(Long commodityId)
	{
		this.commodityId = commodityId;
	}

	public Integer getTradeStatus()
	{
		return tradeStatus;
	}

	public void setTradeStatus(Integer tradeStatus)
	{
		this.tradeStatus = tradeStatus;
	}

	public BigDecimal getIssuePrice()
	{
		return issuePrice;
	}

	public void setIssuePrice(BigDecimal issuePrice)
	{
		this.issuePrice = issuePrice;
	}

	public BigDecimal getOpenPrice()
	{
		return openPrice;
	}

	public void setOpenPrice(BigDecimal openPrice)
	{
		this.openPrice = openPrice;
	}

	public BigDecimal getClearprice()
	{
		return clearprice;
	}

	public void setClearprice(BigDecimal clearprice)
	{
		this.clearprice = clearprice;
	}

	public Date getListingDate()
	{
		return listingDate;
	}

	public void setListingDate(Date listingDate)
	{
		this.listingDate = listingDate;
	}

	public Date getLastTradeDate()
	{
		return lastTradeDate;
	}

	public void setLastTradeDate(Date lastTradeDate)
	{
		this.lastTradeDate = lastTradeDate;
	}

	public String getTradeUnit()
	{
		return tradeUnit;
	}

	public void setTradeUnit(String tradeUnit)
	{
		this.tradeUnit = tradeUnit;
	}

	public BigDecimal getMinChangePrice()
	{
		return minChangePrice;
	}

	public void setMinChangePrice(BigDecimal minChangePrice)
	{
		this.minChangePrice = minChangePrice;
	}

	public Integer getMinChangeAmount()
	{
		return minChangeAmount;
	}

	public void setMinChangeAmount(Integer minChangeAmount)
	{
		this.minChangeAmount = minChangeAmount;
	}

	public BigDecimal getUpperLimitChange()
	{
		return upperLimitChange;
	}

	public void setUpperLimitChange(BigDecimal upperLimitChange)
	{
		this.upperLimitChange = upperLimitChange;
	}

	public BigDecimal getLowerLlimitChange()
	{
		return lowerLlimitChange;
	}

	public void setLowerLlimitChange(BigDecimal lowerLlimitChange)
	{
		this.lowerLlimitChange = lowerLlimitChange;
	}

	public Integer getChangeLimitAlg()
	{
		return changeLimitAlg;
	}

	public void setChangeLimitAlg(Integer changeLimitAlg)
	{
		this.changeLimitAlg = changeLimitAlg;
	}

	public Integer getTnDay()
	{
		return tnDay;
	}

	public void setTnDay(Integer tnDay)
	{
		this.tnDay = tnDay;
	}

	public Date getEffectDate()
	{
		return effectDate;
	}

	public void setEffectDate(Date effectDate)
	{
		this.effectDate = effectDate;
	}

	public Long getMaxPerEntrust()
	{
		return maxPerEntrust;
	}

	public void setMaxPerEntrust(Long maxPerEntrust)
	{
		this.maxPerEntrust = maxPerEntrust;
	}

	public BigDecimal getBuyCharge()
	{
		return buyCharge;
	}

	public void setBuyCharge(BigDecimal buyCharge)
	{
		this.buyCharge = buyCharge;
	}

	public BigDecimal getSellCharge()
	{
		return sellCharge;
	}

	public void setSellCharge(BigDecimal sellCharge)
	{
		this.sellCharge = sellCharge;
	}

	public Integer getChargeAlg()
	{
		return chargeAlg;
	}

	public void setChargeAlg(Integer chargeAlg)
	{
		this.chargeAlg = chargeAlg;
	}

	public BigDecimal getChargeRemainRate()
	{
		return chargeRemainRate;
	}

	public void setChargeRemainRate(BigDecimal chargeRemainRate)
	{
		this.chargeRemainRate = chargeRemainRate;
	}

	public BigDecimal getDayHostPrice()
	{
		return dayHostPrice;
	}

	public void setDayHostPrice(BigDecimal dayHostPrice)
	{
		this.dayHostPrice = dayHostPrice;
	}

	public Integer getFreeHostday()
	{
		return freeHostday;
	}

	public void setFreeHostday(Integer freeHostday)
	{
		this.freeHostday = freeHostday;
	}

	public Date getHostChargeBegin()
	{
		return hostChargeBegin;
	}

	public void setHostChargeBegin(Date hostChargeBegin)
	{
		this.hostChargeBegin = hostChargeBegin;
	}

	public String getSettleUnit()
	{
		return settleUnit;
	}

	public void setSettleUnit(String settleUnit)
	{
		this.settleUnit = settleUnit;
	}

	public Date getDeliveryBegin()
	{
		return deliveryBegin;
	}

	public void setDeliveryBegin(Date deliveryBegin)
	{
		this.deliveryBegin = deliveryBegin;
	}

	public BigDecimal getTurnover()
	{
		return turnover;
	}

	public void setTurnover(BigDecimal turnover)
	{
		this.turnover = turnover;
	}

	public String getNodeId()
	{
		return nodeId;
	}

	public void setNodeId(String nodeId)
	{
		this.nodeId = nodeId;
	}

}
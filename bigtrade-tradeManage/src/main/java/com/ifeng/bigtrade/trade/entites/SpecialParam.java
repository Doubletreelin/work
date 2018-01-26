package com.ifeng.bigtrade.trade.entites;

import java.math.BigDecimal;
import java.util.Date;

public class SpecialParam
{
	private Long id;

	private Date addTime;

	private Boolean deleteStatus;

	private Long userId;

	private Long commodityId;

	private BigDecimal buyCharge;

	private BigDecimal sellCharge;

	private Integer chargeAlg;

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

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getCommodityId()
	{
		return commodityId;
	}

	public void setCommodityId(Long commodityId)
	{
		this.commodityId = commodityId;
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
}
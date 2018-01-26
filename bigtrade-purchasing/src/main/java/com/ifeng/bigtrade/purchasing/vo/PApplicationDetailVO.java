package com.ifeng.bigtrade.purchasing.vo;


import java.math.BigDecimal;
import java.util.Date;

import com.ifeng.bigtrade.purchasing.entites.PApplicationDetail;

public class PApplicationDetailVO extends PApplicationDetail {

	private Integer planStatus;
	
	private BigDecimal planUnitPrice;
	
	private Date planLotteryTime;
	
	private Integer planTotalQuantity;
	
	private Integer planMaxSingleWinningCount;
	
	private Date planStartTime;
	
	private Date planEndTime;

	public Integer getPlanStatus()
	{
		return planStatus;
	}

	public void setPlanStatus(Integer planStatus)
	{
		this.planStatus = planStatus;
	}

	public BigDecimal getPlanUnitPrice()
	{
		return planUnitPrice;
	}

	public void setPlanUnitPrice(BigDecimal planUnitPrice)
	{
		this.planUnitPrice = planUnitPrice;
	}

	public Date getPlanLotteryTime()
	{
		return planLotteryTime;
	}

	public void setPlanLotteryTime(Date planLotteryTime)
	{
		this.planLotteryTime = planLotteryTime;
	}

	public Integer getPlanMaxSingleWinningCount()
	{
		return planMaxSingleWinningCount;
	}

	public void setPlanMaxSingleWinningCount(Integer planMaxSingleWinningCount)
	{
		this.planMaxSingleWinningCount = planMaxSingleWinningCount;
	}

	public Date getPlanStartTime()
	{
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime)
	{
		this.planStartTime = planStartTime;
	}

	public Date getPlanEndTime()
	{
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime)
	{
		this.planEndTime = planEndTime;
	}

	public Integer getPlanTotalQuantity()
	{
		return planTotalQuantity;
	}

	public void setPlanTotalQuantity(Integer planTotalQuantity)
	{
		this.planTotalQuantity = planTotalQuantity;
	}

	
}
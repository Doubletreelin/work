package com.ifeng.bigtrade.trade.entites;

import java.util.Date;

public class NonTradeDay
{
	private Long id;

	private Date addTime;

	private Boolean deleteStatus;

	private String nonDay;// 非交易日期

	private String nonWeek;// 非交易星期

	public NonTradeDay()
	{
	}

	public NonTradeDay(Long id, Boolean deleteStatus, String nonDay, String nonWeek)
	{
		this.id = id;
		this.deleteStatus = deleteStatus;
		this.nonDay = nonDay;
		this.nonWeek = nonWeek;
	}

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

	public String getNonDay()
	{
		return nonDay;
	}

	public void setNonDay(String nonDay)
	{
		this.nonDay = nonDay;
	}

	public String getNonWeek()
	{
		return nonWeek;
	}

	public void setNonWeek(String nonWeek)
	{
		this.nonWeek = nonWeek;
	}
}
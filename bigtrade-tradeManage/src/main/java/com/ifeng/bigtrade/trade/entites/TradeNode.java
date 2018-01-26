package com.ifeng.bigtrade.trade.entites;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class TradeNode
{
	private Long id;

	private Date addTime;

	private Boolean deleteStatus;
	@NotNull
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date endTime;
	@NotBlank
	private String name;
	@NotNull
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date startTime;
	@NotNull
	private Integer status;

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

	public Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}
}
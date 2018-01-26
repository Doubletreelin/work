package com.ifeng.bigtrade.trade.entites;

import java.util.Date;

public class ParamNode
{
	private Long id;

	private Date addTime;

	private Long paramId;

	private Long nodeId;

	public ParamNode()
	{
	}

	public ParamNode(Date addTime, Long paramId, Long nodeId)
	{
		super();
		this.addTime = addTime;
		this.paramId = paramId;
		this.nodeId = nodeId;
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

	public Long getParamId()
	{
		return paramId;
	}

	public void setParamId(Long paramId)
	{
		this.paramId = paramId;
	}

	public Long getNodeId()
	{
		return nodeId;
	}

	public void setNodeId(Long nodeId)
	{
		this.nodeId = nodeId;
	}
}
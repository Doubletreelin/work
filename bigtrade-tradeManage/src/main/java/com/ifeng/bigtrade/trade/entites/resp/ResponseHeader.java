package com.ifeng.bigtrade.trade.entites.resp;

import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class ResponseHeader
{
	/**
	 * 请求的服务名称
	 */
	private String serviceName;
	/**
	 * 请求方
	 */
	private String sender;
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	/**
	 * 供应服务商
	 */
	private String provider = "bigtrade-trade";
	/**
	 * 状态码
	 */
	private Integer statusCode;
	/**
	 * 返回结果信息
	 */
	private String message;
	/**
	 * 消息ID
	 */
	private String id;

	public ResponseHeader()
	{
	}

	public ResponseHeader(HttpServletRequest request, Integer code, String message)
	{
		this.serviceName = request.getServletPath();
		this.sender = request.getParameter("sender");
		this.createTime = new Timestamp(System.currentTimeMillis());
		this.statusCode = code;
		this.message = message;
		this.id = UUID.randomUUID().toString();
	}

	public String getServiceName()
	{
		return serviceName;
	}

	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}

	public String getSender()
	{
		return sender;
	}

	public void setSender(String sender)
	{
		this.sender = sender;
	}

	public Timestamp getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public String getProvider()
	{
		return provider;
	}

	public void setProvider(String provider)
	{
		this.provider = provider;
	}

	public Integer getStatusCode()
	{
		return statusCode;
	}

	public void setStatusCode(Integer statusCode)
	{
		this.statusCode = statusCode;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "ResponseHeader [serviceName=" + serviceName + ",sender=" + sender + ",createTime="
				+ createTime + ",provider=" + provider + ",statusCode=" + statusCode + ",message="
				+ message + ",ID="+id+"]";
	}
}
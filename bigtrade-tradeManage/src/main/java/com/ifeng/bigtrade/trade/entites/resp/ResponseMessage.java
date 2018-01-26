package com.ifeng.bigtrade.trade.entites.resp;

import java.util.HashMap;

public class ResponseMessage
{
	/**
	 * 返回消息头
	 */
	private ResponseHeader header;
	/**
	 * 返回消息体
	 */
	private HashMap<String, Object> body;

	public ResponseMessage(ResponseHeader header, HashMap<String, Object> body)
	{
		super();
		this.header = header;
		this.body = body;
	}

	public ResponseHeader getHeader()
	{
		return header;
	}

	public void setHeader(ResponseHeader header)
	{
		this.header = header;
	}

	public HashMap<String, Object> getBody()
	{
		return body;
	}

	public void setBody(HashMap<String, Object> body)
	{
		this.body = body;
	}

}

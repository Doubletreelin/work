package com.ifeng.bigtrade.trade.exception;

/**
 * 自定义通用异常
 * 
 * @author zhj
 * 
 */
public class CommonException extends Exception
{

	private static final long serialVersionUID = 1L;
	private String message;
	private Integer code;

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Integer getCode()
	{
		return code;
	}

	public void setCode(Integer code)
	{
		this.code = code;
	}

	public CommonException(String message, Integer code)
	{
		super();
		this.message = message;
		this.code = code;
	}

	public CommonException()
	{
		super();
	}

}

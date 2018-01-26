package com.ifeng.bigtrade.trade.enums;

/**
 * 消息状态
 */
public enum RespStatusCode
{
	Succ(2000, "操作成功"), Error(3000, "操作异常"), ParamNull(4001, "必填参数为空"),ObjectNull(4002, "请求数据为空"),ParamError(4003, "参数格式错误"), Exception(5000,"访问异常");

	private int id;

	private String name;

	// 普通方法
	public static String getName(int key)
	{
		for (RespStatusCode c : RespStatusCode.values())
		{
			if (c.getId() == key)
			{
				return c.name;
			}
		}
		return null;
	}

	private RespStatusCode(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setKey(int Id)
	{
		this.id = Id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}

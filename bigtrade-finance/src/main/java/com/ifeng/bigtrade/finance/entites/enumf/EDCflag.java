package com.ifeng.bigtrade.finance.entites.enumf;

public enum EDCflag
{
	C("C", "贷方"),
	D("D", "借方");

	private String code;

	private String name;

	// 普通方法
	public static String getName(String code)
	{
		for (EDCflag c : EDCflag.values())
		{
			if (code.equals(c.getCode()))
			{
				return c.name;
			}
		}
		return null;
	}

	private EDCflag(String code, String name)
	{
		this.code = code;
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
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

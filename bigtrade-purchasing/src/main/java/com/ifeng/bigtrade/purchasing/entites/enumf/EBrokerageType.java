package com.ifeng.bigtrade.purchasing.entites.enumf;

public enum EBrokerageType
{
	no(0, "没有手续费"),
	rate(1, "使用费率"), 
	numerical(2, "使用数值");

	private int Id;

	private String name;

	// 普通方法
	public static String getName(int key)
	{
		for (EBrokerageType c : EBrokerageType.values())
		{
			if (c.getId() == key)
			{
				return c.name;
			}
		}
		return null;
	}

	private EBrokerageType(int id, String name)
	{
		this.Id = id;
		this.name = name;
	}

	public int getId()
	{
		return Id;
	}

	public void setKey(int Id)
	{
		this.Id = Id;
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

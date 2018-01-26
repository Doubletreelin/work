package com.ifeng.bigtrade.finance.entites.enumf;

public enum EAccountLevel
{
	Level1(1, "一级"), level2(2, "二级"), level3(3, "三级");

	private int Id;

	private String name;

	// 普通方法
	public static String getName(int key)
	{
		for (EAccountLevel c : EAccountLevel.values())
		{
			if (c.getId() == key)
			{
				return c.name;
			}
		}
		return null;
	}

	private EAccountLevel(int id, String name)
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

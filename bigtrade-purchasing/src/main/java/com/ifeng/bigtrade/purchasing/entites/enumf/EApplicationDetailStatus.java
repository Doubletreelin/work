package com.ifeng.bigtrade.purchasing.entites.enumf;

public enum EApplicationDetailStatus
{
	step1(0, "第一步"),
	step2(1, "第二步"), 
	alreadyPublish(2, "已经发行"),
	cancle(3,"已经撤销"),
	allocated(4,"已经分配号"),
	alreadyLottery(5,"已经摇号")
	;

	private int Id;

	private String name;

	// 普通方法
	public static String getName(int key)
	{
		for (EApplicationDetailStatus c : EApplicationDetailStatus.values())
		{
			if (c.getId() == key)
			{
				return c.name;
			}
		}
		return null;
	}

	private EApplicationDetailStatus(int id, String name)
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

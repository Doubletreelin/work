package com.ifeng.bigtrade.finance.entites.enumf;

public enum EVoucherStatus
{
	editing(1, "编辑中","editing"), 
	auditing(2, "待审核","auditing"),
	audited(3,"已审核","audited"),
	accounted(4, "已入账","accounted");

	private int Id;

	private String name;
	
	private String flag;

	// 普通方法
	public static String getName(int key)
	{
		for (EVoucherStatus c : EVoucherStatus.values())
		{
			if (c.getId() == key)
			{
				return c.name;
			}
		}
		return null;
	}

	private EVoucherStatus(int id, String name,String flag)
	{
		this.Id = id;
		this.name = name;
		this.flag = flag;
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

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public void setId(int id)
	{
		Id = id;
	}
	
}

package com.ifeng.bigtrade.purchasing.entites.enumf;

public enum EIssuanceplanType
{
	normal(0, "正常状态"),
	revoke(1,"撤销状态"),
	allocated(2,"已经分配了号"),
	lottery(3,"已经摇号"),
	failStep1(4,"失败第一步"),
	failStep2(5,"失败第二步"),
	auditSuccess(6,"审核成功"),
	auditFail(7,"审核失败"),
	holdsumChange(8,"持仓划转结束"),
	allEnd(9,"全部结束")
	;

	private int Id;

	private String name;

	// 普通方法
	public static String getName(int key)
	{
		for (EIssuanceplanType c : EIssuanceplanType.values())
		{
			if (c.getId() == key)
			{
				return c.name;
			}
		}
		return null;
	}

	private EIssuanceplanType(int id, String name)
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

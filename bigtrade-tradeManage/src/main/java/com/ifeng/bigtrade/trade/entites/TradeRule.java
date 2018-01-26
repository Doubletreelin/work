package com.ifeng.bigtrade.trade.entites;

public class TradeRule
{
	private Long id;

	private Integer selfTradingState;

	/**
	 * 自我交易状态（0允许，1不允许）
	 */
	public enum SelfTradingState
	{
		yes(0), no(1);
		private int state;

		SelfTradingState(int s)
		{
			this.state = s;
		}

		public int getState()
		{
			return state;
		}
	};

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Integer getSelfTradingState()
	{
		return selfTradingState;
	}

	public void setSelfTradingState(Integer selfTradingState)
	{
		this.selfTradingState = selfTradingState;
	}
}
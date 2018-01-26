package com.ifeng.bigtrade.trade.entites;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TradeParamExample
{

	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public TradeParamExample()
	{
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause)
	{
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause()
	{
		return orderByClause;
	}

	public void setDistinct(boolean distinct)
	{
		this.distinct = distinct;
	}

	public boolean isDistinct()
	{
		return distinct;
	}

	public List<Criteria> getOredCriteria()
	{
		return oredCriteria;
	}

	public void or(Criteria criteria)
	{
		oredCriteria.add(criteria);
	}

	public Criteria or()
	{
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria()
	{
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0)
		{
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal()
	{
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear()
	{
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria
	{
		protected List<Criterion> criteria;

		protected GeneratedCriteria()
		{
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid()
		{
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria()
		{
			return criteria;
		}

		public List<Criterion> getCriteria()
		{
			return criteria;
		}

		protected void addCriterion(String condition)
		{
			if (condition == null)
			{
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property)
		{
			if (value == null)
			{
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property)
		{
			if (value1 == null || value2 == null)
			{
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property)
		{
			if (value == null)
			{
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property)
		{
			if (values == null || values.size() == 0)
			{
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext())
			{
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2,
				String property)
		{
			if (value1 == null || value2 == null)
			{
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()),
					new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull()
		{
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull()
		{
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value)
		{
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value)
		{
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value)
		{
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value)
		{
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value)
		{
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values)
		{
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values)
		{
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2)
		{
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2)
		{
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNull()
		{
			addCriterion("addTime is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull()
		{
			addCriterion("addTime is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value)
		{
			addCriterion("addTime =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value)
		{
			addCriterion("addTime <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value)
		{
			addCriterion("addTime >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("addTime >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value)
		{
			addCriterion("addTime <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("addTime <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values)
		{
			addCriterion("addTime in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values)
		{
			addCriterion("addTime not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2)
		{
			addCriterion("addTime between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("addTime not between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNull()
		{
			addCriterion("deleteStatus is null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNotNull()
		{
			addCriterion("deleteStatus is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusEqualTo(Boolean value)
		{
			addCriterion("deleteStatus =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Boolean value)
		{
			addCriterion("deleteStatus <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Boolean value)
		{
			addCriterion("deleteStatus >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value)
		{
			addCriterion("deleteStatus >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Boolean value)
		{
			addCriterion("deleteStatus <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value)
		{
			addCriterion("deleteStatus <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Boolean> values)
		{
			addCriterion("deleteStatus in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Boolean> values)
		{
			addCriterion("deleteStatus not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2)
		{
			addCriterion("deleteStatus between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2)
		{
			addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andCommodityIdIsNull()
		{
			addCriterion("commodityId is null");
			return (Criteria) this;
		}

		public Criteria andCommodityIdIsNotNull()
		{
			addCriterion("commodityId is not null");
			return (Criteria) this;
		}

		public Criteria andCommodityIdEqualTo(Long value)
		{
			addCriterion("commodityId =", value, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdNotEqualTo(Long value)
		{
			addCriterion("commodityId <>", value, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdGreaterThan(Long value)
		{
			addCriterion("commodityId >", value, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("commodityId >=", value, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdLessThan(Long value)
		{
			addCriterion("commodityId <", value, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdLessThanOrEqualTo(Long value)
		{
			addCriterion("commodityId <=", value, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdIn(List<Long> values)
		{
			addCriterion("commodityId in", values, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdNotIn(List<Long> values)
		{
			addCriterion("commodityId not in", values, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdBetween(Long value1, Long value2)
		{
			addCriterion("commodityId between", value1, value2, "commodityId");
			return (Criteria) this;
		}

		public Criteria andCommodityIdNotBetween(Long value1, Long value2)
		{
			addCriterion("commodityId not between", value1, value2, "commodityId");
			return (Criteria) this;
		}

		public Criteria andTradeStatusIsNull()
		{
			addCriterion("tradeStatus is null");
			return (Criteria) this;
		}

		public Criteria andTradeStatusIsNotNull()
		{
			addCriterion("tradeStatus is not null");
			return (Criteria) this;
		}

		public Criteria andTradeStatusEqualTo(Integer value)
		{
			addCriterion("tradeStatus =", value, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusNotEqualTo(Integer value)
		{
			addCriterion("tradeStatus <>", value, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusGreaterThan(Integer value)
		{
			addCriterion("tradeStatus >", value, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("tradeStatus >=", value, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusLessThan(Integer value)
		{
			addCriterion("tradeStatus <", value, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusLessThanOrEqualTo(Integer value)
		{
			addCriterion("tradeStatus <=", value, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusIn(List<Integer> values)
		{
			addCriterion("tradeStatus in", values, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusNotIn(List<Integer> values)
		{
			addCriterion("tradeStatus not in", values, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusBetween(Integer value1, Integer value2)
		{
			addCriterion("tradeStatus between", value1, value2, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andTradeStatusNotBetween(Integer value1, Integer value2)
		{
			addCriterion("tradeStatus not between", value1, value2, "tradeStatus");
			return (Criteria) this;
		}

		public Criteria andIssuePriceIsNull()
		{
			addCriterion("issuePrice is null");
			return (Criteria) this;
		}

		public Criteria andIssuePriceIsNotNull()
		{
			addCriterion("issuePrice is not null");
			return (Criteria) this;
		}

		public Criteria andIssuePriceEqualTo(BigDecimal value)
		{
			addCriterion("issuePrice =", value, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceNotEqualTo(BigDecimal value)
		{
			addCriterion("issuePrice <>", value, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceGreaterThan(BigDecimal value)
		{
			addCriterion("issuePrice >", value, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("issuePrice >=", value, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceLessThan(BigDecimal value)
		{
			addCriterion("issuePrice <", value, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("issuePrice <=", value, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceIn(List<BigDecimal> values)
		{
			addCriterion("issuePrice in", values, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceNotIn(List<BigDecimal> values)
		{
			addCriterion("issuePrice not in", values, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("issuePrice between", value1, value2, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andIssuePriceNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("issuePrice not between", value1, value2, "issuePrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceIsNull()
		{
			addCriterion("openPrice is null");
			return (Criteria) this;
		}

		public Criteria andOpenPriceIsNotNull()
		{
			addCriterion("openPrice is not null");
			return (Criteria) this;
		}

		public Criteria andOpenPriceEqualTo(BigDecimal value)
		{
			addCriterion("openPrice =", value, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceNotEqualTo(BigDecimal value)
		{
			addCriterion("openPrice <>", value, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceGreaterThan(BigDecimal value)
		{
			addCriterion("openPrice >", value, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("openPrice >=", value, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceLessThan(BigDecimal value)
		{
			addCriterion("openPrice <", value, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("openPrice <=", value, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceIn(List<BigDecimal> values)
		{
			addCriterion("openPrice in", values, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceNotIn(List<BigDecimal> values)
		{
			addCriterion("openPrice not in", values, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("openPrice between", value1, value2, "openPrice");
			return (Criteria) this;
		}

		public Criteria andOpenPriceNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("openPrice not between", value1, value2, "openPrice");
			return (Criteria) this;
		}

		public Criteria andClearpriceIsNull()
		{
			addCriterion("clearprice is null");
			return (Criteria) this;
		}

		public Criteria andClearpriceIsNotNull()
		{
			addCriterion("clearprice is not null");
			return (Criteria) this;
		}

		public Criteria andClearpriceEqualTo(BigDecimal value)
		{
			addCriterion("clearprice =", value, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceNotEqualTo(BigDecimal value)
		{
			addCriterion("clearprice <>", value, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceGreaterThan(BigDecimal value)
		{
			addCriterion("clearprice >", value, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("clearprice >=", value, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceLessThan(BigDecimal value)
		{
			addCriterion("clearprice <", value, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("clearprice <=", value, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceIn(List<BigDecimal> values)
		{
			addCriterion("clearprice in", values, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceNotIn(List<BigDecimal> values)
		{
			addCriterion("clearprice not in", values, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("clearprice between", value1, value2, "clearprice");
			return (Criteria) this;
		}

		public Criteria andClearpriceNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("clearprice not between", value1, value2, "clearprice");
			return (Criteria) this;
		}

		public Criteria andListingDateIsNull()
		{
			addCriterion("listingDate is null");
			return (Criteria) this;
		}

		public Criteria andListingDateIsNotNull()
		{
			addCriterion("listingDate is not null");
			return (Criteria) this;
		}

		public Criteria andListingDateEqualTo(Date value)
		{
			addCriterion("listingDate =", value, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateNotEqualTo(Date value)
		{
			addCriterion("listingDate <>", value, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateGreaterThan(Date value)
		{
			addCriterion("listingDate >", value, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateGreaterThanOrEqualTo(Date value)
		{
			addCriterion("listingDate >=", value, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateLessThan(Date value)
		{
			addCriterion("listingDate <", value, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateLessThanOrEqualTo(Date value)
		{
			addCriterion("listingDate <=", value, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateIn(List<Date> values)
		{
			addCriterion("listingDate in", values, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateNotIn(List<Date> values)
		{
			addCriterion("listingDate not in", values, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateBetween(Date value1, Date value2)
		{
			addCriterion("listingDate between", value1, value2, "listingDate");
			return (Criteria) this;
		}

		public Criteria andListingDateNotBetween(Date value1, Date value2)
		{
			addCriterion("listingDate not between", value1, value2, "listingDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateIsNull()
		{
			addCriterion("lastTradeDate is null");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateIsNotNull()
		{
			addCriterion("lastTradeDate is not null");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateEqualTo(Date value)
		{
			addCriterion("lastTradeDate =", value, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateNotEqualTo(Date value)
		{
			addCriterion("lastTradeDate <>", value, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateGreaterThan(Date value)
		{
			addCriterion("lastTradeDate >", value, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateGreaterThanOrEqualTo(Date value)
		{
			addCriterion("lastTradeDate >=", value, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateLessThan(Date value)
		{
			addCriterion("lastTradeDate <", value, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateLessThanOrEqualTo(Date value)
		{
			addCriterion("lastTradeDate <=", value, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateIn(List<Date> values)
		{
			addCriterion("lastTradeDate in", values, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateNotIn(List<Date> values)
		{
			addCriterion("lastTradeDate not in", values, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateBetween(Date value1, Date value2)
		{
			addCriterion("lastTradeDate between", value1, value2, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andLastTradeDateNotBetween(Date value1, Date value2)
		{
			addCriterion("lastTradeDate not between", value1, value2, "lastTradeDate");
			return (Criteria) this;
		}

		public Criteria andTradeUnitIsNull()
		{
			addCriterion("tradeUnit is null");
			return (Criteria) this;
		}

		public Criteria andTradeUnitIsNotNull()
		{
			addCriterion("tradeUnit is not null");
			return (Criteria) this;
		}

		public Criteria andTradeUnitEqualTo(String value)
		{
			addCriterion("tradeUnit =", value, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitNotEqualTo(String value)
		{
			addCriterion("tradeUnit <>", value, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitGreaterThan(String value)
		{
			addCriterion("tradeUnit >", value, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitGreaterThanOrEqualTo(String value)
		{
			addCriterion("tradeUnit >=", value, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitLessThan(String value)
		{
			addCriterion("tradeUnit <", value, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitLessThanOrEqualTo(String value)
		{
			addCriterion("tradeUnit <=", value, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitLike(String value)
		{
			addCriterion("tradeUnit like", value, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitNotLike(String value)
		{
			addCriterion("tradeUnit not like", value, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitIn(List<String> values)
		{
			addCriterion("tradeUnit in", values, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitNotIn(List<String> values)
		{
			addCriterion("tradeUnit not in", values, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitBetween(String value1, String value2)
		{
			addCriterion("tradeUnit between", value1, value2, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andTradeUnitNotBetween(String value1, String value2)
		{
			addCriterion("tradeUnit not between", value1, value2, "tradeUnit");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceIsNull()
		{
			addCriterion("minChangePrice is null");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceIsNotNull()
		{
			addCriterion("minChangePrice is not null");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceEqualTo(BigDecimal value)
		{
			addCriterion("minChangePrice =", value, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceNotEqualTo(BigDecimal value)
		{
			addCriterion("minChangePrice <>", value, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceGreaterThan(BigDecimal value)
		{
			addCriterion("minChangePrice >", value, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("minChangePrice >=", value, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceLessThan(BigDecimal value)
		{
			addCriterion("minChangePrice <", value, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("minChangePrice <=", value, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceIn(List<BigDecimal> values)
		{
			addCriterion("minChangePrice in", values, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceNotIn(List<BigDecimal> values)
		{
			addCriterion("minChangePrice not in", values, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("minChangePrice between", value1, value2, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangePriceNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("minChangePrice not between", value1, value2, "minChangePrice");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountIsNull()
		{
			addCriterion("minChangeAmount is null");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountIsNotNull()
		{
			addCriterion("minChangeAmount is not null");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountEqualTo(Integer value)
		{
			addCriterion("minChangeAmount =", value, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountNotEqualTo(Integer value)
		{
			addCriterion("minChangeAmount <>", value, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountGreaterThan(Integer value)
		{
			addCriterion("minChangeAmount >", value, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("minChangeAmount >=", value, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountLessThan(Integer value)
		{
			addCriterion("minChangeAmount <", value, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountLessThanOrEqualTo(Integer value)
		{
			addCriterion("minChangeAmount <=", value, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountIn(List<Integer> values)
		{
			addCriterion("minChangeAmount in", values, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountNotIn(List<Integer> values)
		{
			addCriterion("minChangeAmount not in", values, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountBetween(Integer value1, Integer value2)
		{
			addCriterion("minChangeAmount between", value1, value2, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andMinChangeAmountNotBetween(Integer value1, Integer value2)
		{
			addCriterion("minChangeAmount not between", value1, value2, "minChangeAmount");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeIsNull()
		{
			addCriterion("upperLimitChange is null");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeIsNotNull()
		{
			addCriterion("upperLimitChange is not null");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeEqualTo(BigDecimal value)
		{
			addCriterion("upperLimitChange =", value, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeNotEqualTo(BigDecimal value)
		{
			addCriterion("upperLimitChange <>", value, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeGreaterThan(BigDecimal value)
		{
			addCriterion("upperLimitChange >", value, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("upperLimitChange >=", value, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeLessThan(BigDecimal value)
		{
			addCriterion("upperLimitChange <", value, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("upperLimitChange <=", value, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeIn(List<BigDecimal> values)
		{
			addCriterion("upperLimitChange in", values, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeNotIn(List<BigDecimal> values)
		{
			addCriterion("upperLimitChange not in", values, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("upperLimitChange between", value1, value2, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andUpperLimitChangeNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("upperLimitChange not between", value1, value2, "upperLimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeIsNull()
		{
			addCriterion("lowerLlimitChange is null");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeIsNotNull()
		{
			addCriterion("lowerLlimitChange is not null");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeEqualTo(BigDecimal value)
		{
			addCriterion("lowerLlimitChange =", value, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeNotEqualTo(BigDecimal value)
		{
			addCriterion("lowerLlimitChange <>", value, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeGreaterThan(BigDecimal value)
		{
			addCriterion("lowerLlimitChange >", value, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("lowerLlimitChange >=", value, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeLessThan(BigDecimal value)
		{
			addCriterion("lowerLlimitChange <", value, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("lowerLlimitChange <=", value, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeIn(List<BigDecimal> values)
		{
			addCriterion("lowerLlimitChange in", values, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeNotIn(List<BigDecimal> values)
		{
			addCriterion("lowerLlimitChange not in", values, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("lowerLlimitChange between", value1, value2, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andLowerLlimitChangeNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("lowerLlimitChange not between", value1, value2, "lowerLlimitChange");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgIsNull()
		{
			addCriterion("changeLimitAlg is null");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgIsNotNull()
		{
			addCriterion("changeLimitAlg is not null");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgEqualTo(Integer value)
		{
			addCriterion("changeLimitAlg =", value, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgNotEqualTo(Integer value)
		{
			addCriterion("changeLimitAlg <>", value, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgGreaterThan(Integer value)
		{
			addCriterion("changeLimitAlg >", value, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("changeLimitAlg >=", value, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgLessThan(Integer value)
		{
			addCriterion("changeLimitAlg <", value, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgLessThanOrEqualTo(Integer value)
		{
			addCriterion("changeLimitAlg <=", value, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgIn(List<Integer> values)
		{
			addCriterion("changeLimitAlg in", values, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgNotIn(List<Integer> values)
		{
			addCriterion("changeLimitAlg not in", values, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgBetween(Integer value1, Integer value2)
		{
			addCriterion("changeLimitAlg between", value1, value2, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andChangeLimitAlgNotBetween(Integer value1, Integer value2)
		{
			addCriterion("changeLimitAlg not between", value1, value2, "changeLimitAlg");
			return (Criteria) this;
		}

		public Criteria andTnDayIsNull()
		{
			addCriterion("TnDay is null");
			return (Criteria) this;
		}

		public Criteria andTnDayIsNotNull()
		{
			addCriterion("TnDay is not null");
			return (Criteria) this;
		}

		public Criteria andTnDayEqualTo(Integer value)
		{
			addCriterion("TnDay =", value, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayNotEqualTo(Integer value)
		{
			addCriterion("TnDay <>", value, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayGreaterThan(Integer value)
		{
			addCriterion("TnDay >", value, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("TnDay >=", value, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayLessThan(Integer value)
		{
			addCriterion("TnDay <", value, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayLessThanOrEqualTo(Integer value)
		{
			addCriterion("TnDay <=", value, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayIn(List<Integer> values)
		{
			addCriterion("TnDay in", values, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayNotIn(List<Integer> values)
		{
			addCriterion("TnDay not in", values, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayBetween(Integer value1, Integer value2)
		{
			addCriterion("TnDay between", value1, value2, "tnDay");
			return (Criteria) this;
		}

		public Criteria andTnDayNotBetween(Integer value1, Integer value2)
		{
			addCriterion("TnDay not between", value1, value2, "tnDay");
			return (Criteria) this;
		}

		public Criteria andEffectDateIsNull()
		{
			addCriterion("effectDate is null");
			return (Criteria) this;
		}

		public Criteria andEffectDateIsNotNull()
		{
			addCriterion("effectDate is not null");
			return (Criteria) this;
		}

		public Criteria andEffectDateEqualTo(Date value)
		{
			addCriterion("effectDate =", value, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateNotEqualTo(Date value)
		{
			addCriterion("effectDate <>", value, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateGreaterThan(Date value)
		{
			addCriterion("effectDate >", value, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateGreaterThanOrEqualTo(Date value)
		{
			addCriterion("effectDate >=", value, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateLessThan(Date value)
		{
			addCriterion("effectDate <", value, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateLessThanOrEqualTo(Date value)
		{
			addCriterion("effectDate <=", value, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateIn(List<Date> values)
		{
			addCriterion("effectDate in", values, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateNotIn(List<Date> values)
		{
			addCriterion("effectDate not in", values, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateBetween(Date value1, Date value2)
		{
			addCriterion("effectDate between", value1, value2, "effectDate");
			return (Criteria) this;
		}

		public Criteria andEffectDateNotBetween(Date value1, Date value2)
		{
			addCriterion("effectDate not between", value1, value2, "effectDate");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustIsNull()
		{
			addCriterion("maxPerEntrust is null");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustIsNotNull()
		{
			addCriterion("maxPerEntrust is not null");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustEqualTo(Long value)
		{
			addCriterion("maxPerEntrust =", value, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustNotEqualTo(Long value)
		{
			addCriterion("maxPerEntrust <>", value, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustGreaterThan(Long value)
		{
			addCriterion("maxPerEntrust >", value, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustGreaterThanOrEqualTo(Long value)
		{
			addCriterion("maxPerEntrust >=", value, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustLessThan(Long value)
		{
			addCriterion("maxPerEntrust <", value, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustLessThanOrEqualTo(Long value)
		{
			addCriterion("maxPerEntrust <=", value, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustIn(List<Long> values)
		{
			addCriterion("maxPerEntrust in", values, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustNotIn(List<Long> values)
		{
			addCriterion("maxPerEntrust not in", values, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustBetween(Long value1, Long value2)
		{
			addCriterion("maxPerEntrust between", value1, value2, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andMaxPerEntrustNotBetween(Long value1, Long value2)
		{
			addCriterion("maxPerEntrust not between", value1, value2, "maxPerEntrust");
			return (Criteria) this;
		}

		public Criteria andBuyChargeIsNull()
		{
			addCriterion("buyCharge is null");
			return (Criteria) this;
		}

		public Criteria andBuyChargeIsNotNull()
		{
			addCriterion("buyCharge is not null");
			return (Criteria) this;
		}

		public Criteria andBuyChargeEqualTo(BigDecimal value)
		{
			addCriterion("buyCharge =", value, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeNotEqualTo(BigDecimal value)
		{
			addCriterion("buyCharge <>", value, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeGreaterThan(BigDecimal value)
		{
			addCriterion("buyCharge >", value, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("buyCharge >=", value, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeLessThan(BigDecimal value)
		{
			addCriterion("buyCharge <", value, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("buyCharge <=", value, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeIn(List<BigDecimal> values)
		{
			addCriterion("buyCharge in", values, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeNotIn(List<BigDecimal> values)
		{
			addCriterion("buyCharge not in", values, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("buyCharge between", value1, value2, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andBuyChargeNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("buyCharge not between", value1, value2, "buyCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeIsNull()
		{
			addCriterion("sellCharge is null");
			return (Criteria) this;
		}

		public Criteria andSellChargeIsNotNull()
		{
			addCriterion("sellCharge is not null");
			return (Criteria) this;
		}

		public Criteria andSellChargeEqualTo(BigDecimal value)
		{
			addCriterion("sellCharge =", value, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeNotEqualTo(BigDecimal value)
		{
			addCriterion("sellCharge <>", value, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeGreaterThan(BigDecimal value)
		{
			addCriterion("sellCharge >", value, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("sellCharge >=", value, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeLessThan(BigDecimal value)
		{
			addCriterion("sellCharge <", value, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("sellCharge <=", value, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeIn(List<BigDecimal> values)
		{
			addCriterion("sellCharge in", values, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeNotIn(List<BigDecimal> values)
		{
			addCriterion("sellCharge not in", values, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("sellCharge between", value1, value2, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andSellChargeNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("sellCharge not between", value1, value2, "sellCharge");
			return (Criteria) this;
		}

		public Criteria andChargeAlgIsNull()
		{
			addCriterion("chargeAlg is null");
			return (Criteria) this;
		}

		public Criteria andChargeAlgIsNotNull()
		{
			addCriterion("chargeAlg is not null");
			return (Criteria) this;
		}

		public Criteria andChargeAlgEqualTo(Integer value)
		{
			addCriterion("chargeAlg =", value, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgNotEqualTo(Integer value)
		{
			addCriterion("chargeAlg <>", value, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgGreaterThan(Integer value)
		{
			addCriterion("chargeAlg >", value, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("chargeAlg >=", value, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgLessThan(Integer value)
		{
			addCriterion("chargeAlg <", value, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgLessThanOrEqualTo(Integer value)
		{
			addCriterion("chargeAlg <=", value, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgIn(List<Integer> values)
		{
			addCriterion("chargeAlg in", values, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgNotIn(List<Integer> values)
		{
			addCriterion("chargeAlg not in", values, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgBetween(Integer value1, Integer value2)
		{
			addCriterion("chargeAlg between", value1, value2, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeAlgNotBetween(Integer value1, Integer value2)
		{
			addCriterion("chargeAlg not between", value1, value2, "chargeAlg");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateIsNull()
		{
			addCriterion("chargeRemainRate is null");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateIsNotNull()
		{
			addCriterion("chargeRemainRate is not null");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateEqualTo(BigDecimal value)
		{
			addCriterion("chargeRemainRate =", value, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateNotEqualTo(BigDecimal value)
		{
			addCriterion("chargeRemainRate <>", value, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateGreaterThan(BigDecimal value)
		{
			addCriterion("chargeRemainRate >", value, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("chargeRemainRate >=", value, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateLessThan(BigDecimal value)
		{
			addCriterion("chargeRemainRate <", value, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("chargeRemainRate <=", value, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateIn(List<BigDecimal> values)
		{
			addCriterion("chargeRemainRate in", values, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateNotIn(List<BigDecimal> values)
		{
			addCriterion("chargeRemainRate not in", values, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("chargeRemainRate between", value1, value2, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andChargeRemainRateNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("chargeRemainRate not between", value1, value2, "chargeRemainRate");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceIsNull()
		{
			addCriterion("dayHostPrice is null");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceIsNotNull()
		{
			addCriterion("dayHostPrice is not null");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceEqualTo(BigDecimal value)
		{
			addCriterion("dayHostPrice =", value, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceNotEqualTo(BigDecimal value)
		{
			addCriterion("dayHostPrice <>", value, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceGreaterThan(BigDecimal value)
		{
			addCriterion("dayHostPrice >", value, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("dayHostPrice >=", value, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceLessThan(BigDecimal value)
		{
			addCriterion("dayHostPrice <", value, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("dayHostPrice <=", value, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceIn(List<BigDecimal> values)
		{
			addCriterion("dayHostPrice in", values, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceNotIn(List<BigDecimal> values)
		{
			addCriterion("dayHostPrice not in", values, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("dayHostPrice between", value1, value2, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andDayHostPriceNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("dayHostPrice not between", value1, value2, "dayHostPrice");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayIsNull()
		{
			addCriterion("freeHostday is null");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayIsNotNull()
		{
			addCriterion("freeHostday is not null");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayEqualTo(Integer value)
		{
			addCriterion("freeHostday =", value, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayNotEqualTo(Integer value)
		{
			addCriterion("freeHostday <>", value, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayGreaterThan(Integer value)
		{
			addCriterion("freeHostday >", value, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("freeHostday >=", value, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayLessThan(Integer value)
		{
			addCriterion("freeHostday <", value, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayLessThanOrEqualTo(Integer value)
		{
			addCriterion("freeHostday <=", value, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayIn(List<Integer> values)
		{
			addCriterion("freeHostday in", values, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayNotIn(List<Integer> values)
		{
			addCriterion("freeHostday not in", values, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayBetween(Integer value1, Integer value2)
		{
			addCriterion("freeHostday between", value1, value2, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andFreeHostdayNotBetween(Integer value1, Integer value2)
		{
			addCriterion("freeHostday not between", value1, value2, "freeHostday");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginIsNull()
		{
			addCriterion("hostChargeBegin is null");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginIsNotNull()
		{
			addCriterion("hostChargeBegin is not null");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginEqualTo(Date value)
		{
			addCriterionForJDBCDate("hostChargeBegin =", value, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginNotEqualTo(Date value)
		{
			addCriterionForJDBCDate("hostChargeBegin <>", value, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginGreaterThan(Date value)
		{
			addCriterionForJDBCDate("hostChargeBegin >", value, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginGreaterThanOrEqualTo(Date value)
		{
			addCriterionForJDBCDate("hostChargeBegin >=", value, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginLessThan(Date value)
		{
			addCriterionForJDBCDate("hostChargeBegin <", value, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginLessThanOrEqualTo(Date value)
		{
			addCriterionForJDBCDate("hostChargeBegin <=", value, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginIn(List<Date> values)
		{
			addCriterionForJDBCDate("hostChargeBegin in", values, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginNotIn(List<Date> values)
		{
			addCriterionForJDBCDate("hostChargeBegin not in", values, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginBetween(Date value1, Date value2)
		{
			addCriterionForJDBCDate("hostChargeBegin between", value1, value2, "hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andHostChargeBeginNotBetween(Date value1, Date value2)
		{
			addCriterionForJDBCDate("hostChargeBegin not between", value1, value2,
					"hostChargeBegin");
			return (Criteria) this;
		}

		public Criteria andSettleUnitIsNull()
		{
			addCriterion("settleUnit is null");
			return (Criteria) this;
		}

		public Criteria andSettleUnitIsNotNull()
		{
			addCriterion("settleUnit is not null");
			return (Criteria) this;
		}

		public Criteria andSettleUnitEqualTo(String value)
		{
			addCriterion("settleUnit =", value, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitNotEqualTo(String value)
		{
			addCriterion("settleUnit <>", value, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitGreaterThan(String value)
		{
			addCriterion("settleUnit >", value, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitGreaterThanOrEqualTo(String value)
		{
			addCriterion("settleUnit >=", value, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitLessThan(String value)
		{
			addCriterion("settleUnit <", value, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitLessThanOrEqualTo(String value)
		{
			addCriterion("settleUnit <=", value, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitLike(String value)
		{
			addCriterion("settleUnit like", value, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitNotLike(String value)
		{
			addCriterion("settleUnit not like", value, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitIn(List<String> values)
		{
			addCriterion("settleUnit in", values, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitNotIn(List<String> values)
		{
			addCriterion("settleUnit not in", values, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitBetween(String value1, String value2)
		{
			addCriterion("settleUnit between", value1, value2, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andSettleUnitNotBetween(String value1, String value2)
		{
			addCriterion("settleUnit not between", value1, value2, "settleUnit");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginIsNull()
		{
			addCriterion("deliveryBegin is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginIsNotNull()
		{
			addCriterion("deliveryBegin is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginEqualTo(Date value)
		{
			addCriterionForJDBCDate("deliveryBegin =", value, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginNotEqualTo(Date value)
		{
			addCriterionForJDBCDate("deliveryBegin <>", value, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginGreaterThan(Date value)
		{
			addCriterionForJDBCDate("deliveryBegin >", value, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginGreaterThanOrEqualTo(Date value)
		{
			addCriterionForJDBCDate("deliveryBegin >=", value, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginLessThan(Date value)
		{
			addCriterionForJDBCDate("deliveryBegin <", value, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginLessThanOrEqualTo(Date value)
		{
			addCriterionForJDBCDate("deliveryBegin <=", value, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginIn(List<Date> values)
		{
			addCriterionForJDBCDate("deliveryBegin in", values, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginNotIn(List<Date> values)
		{
			addCriterionForJDBCDate("deliveryBegin not in", values, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginBetween(Date value1, Date value2)
		{
			addCriterionForJDBCDate("deliveryBegin between", value1, value2, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andDeliveryBeginNotBetween(Date value1, Date value2)
		{
			addCriterionForJDBCDate("deliveryBegin not between", value1, value2, "deliveryBegin");
			return (Criteria) this;
		}

		public Criteria andTurnoverIsNull()
		{
			addCriterion("turnover is null");
			return (Criteria) this;
		}

		public Criteria andTurnoverIsNotNull()
		{
			addCriterion("turnover is not null");
			return (Criteria) this;
		}

		public Criteria andTurnoverEqualTo(Integer value)
		{
			addCriterion("turnover =", value, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverNotEqualTo(BigDecimal value)
		{
			addCriterion("turnover <>", value, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverGreaterThan(BigDecimal value)
		{
			addCriterion("turnover >", value, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverGreaterThanOrEqualTo(BigDecimal value)
		{
			addCriterion("turnover >=", value, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverLessThan(BigDecimal value)
		{
			addCriterion("turnover <", value, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverLessThanOrEqualTo(BigDecimal value)
		{
			addCriterion("turnover <=", value, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverIn(List<BigDecimal> values)
		{
			addCriterion("turnover in", values, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverNotIn(List<BigDecimal> values)
		{
			addCriterion("turnover not in", values, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("turnover between", value1, value2, "turnover");
			return (Criteria) this;
		}

		public Criteria andTurnoverNotBetween(BigDecimal value1, BigDecimal value2)
		{
			addCriterion("turnover not between", value1, value2, "turnover");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria
	{
		protected Criteria()
		{
			super();
		}
	}

	public static class Criterion
	{
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition()
		{
			return condition;
		}

		public Object getValue()
		{
			return value;
		}

		public Object getSecondValue()
		{
			return secondValue;
		}

		public boolean isNoValue()
		{
			return noValue;
		}

		public boolean isSingleValue()
		{
			return singleValue;
		}

		public boolean isBetweenValue()
		{
			return betweenValue;
		}

		public boolean isListValue()
		{
			return listValue;
		}

		public String getTypeHandler()
		{
			return typeHandler;
		}

		protected Criterion(String condition)
		{
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler)
		{
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>)
			{
				this.listValue = true;
			} else
			{
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value)
		{
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
		{
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue)
		{
			this(condition, value, secondValue, null);
		}
	}
}
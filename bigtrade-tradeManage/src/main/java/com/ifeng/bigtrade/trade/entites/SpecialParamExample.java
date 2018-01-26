package com.ifeng.bigtrade.trade.entites;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecialParamExample
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SpecialParamExample()
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

		public Criteria andUserIdIsNull()
		{
			addCriterion("userId is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull()
		{
			addCriterion("userId is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value)
		{
			addCriterion("userId =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value)
		{
			addCriterion("userId <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value)
		{
			addCriterion("userId >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("userId >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value)
		{
			addCriterion("userId <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value)
		{
			addCriterion("userId <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values)
		{
			addCriterion("userId in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values)
		{
			addCriterion("userId not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2)
		{
			addCriterion("userId between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2)
		{
			addCriterion("userId not between", value1, value2, "userId");
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
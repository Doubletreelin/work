package com.ifeng.bigtrade.trade.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NonTradeDayExample
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public NonTradeDayExample()
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

		public Criteria andNonDayIsNull()
		{
			addCriterion("nonDay is null");
			return (Criteria) this;
		}

		public Criteria andNonDayIsNotNull()
		{
			addCriterion("nonDay is not null");
			return (Criteria) this;
		}

		public Criteria andNonDayEqualTo(String value)
		{
			addCriterion("nonDay =", value, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayNotEqualTo(String value)
		{
			addCriterion("nonDay <>", value, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayGreaterThan(String value)
		{
			addCriterion("nonDay >", value, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayGreaterThanOrEqualTo(String value)
		{
			addCriterion("nonDay >=", value, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayLessThan(String value)
		{
			addCriterion("nonDay <", value, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayLessThanOrEqualTo(String value)
		{
			addCriterion("nonDay <=", value, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayLike(String value)
		{
			addCriterion("nonDay like", value, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayNotLike(String value)
		{
			addCriterion("nonDay not like", value, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayIn(List<String> values)
		{
			addCriterion("nonDay in", values, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayNotIn(List<String> values)
		{
			addCriterion("nonDay not in", values, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayBetween(String value1, String value2)
		{
			addCriterion("nonDay between", value1, value2, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonDayNotBetween(String value1, String value2)
		{
			addCriterion("nonDay not between", value1, value2, "nonDay");
			return (Criteria) this;
		}

		public Criteria andNonWeekIsNull()
		{
			addCriterion("nonWeek is null");
			return (Criteria) this;
		}

		public Criteria andNonWeekIsNotNull()
		{
			addCriterion("nonWeek is not null");
			return (Criteria) this;
		}

		public Criteria andNonWeekEqualTo(String value)
		{
			addCriterion("nonWeek =", value, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekNotEqualTo(String value)
		{
			addCriterion("nonWeek <>", value, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekGreaterThan(String value)
		{
			addCriterion("nonWeek >", value, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekGreaterThanOrEqualTo(String value)
		{
			addCriterion("nonWeek >=", value, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekLessThan(String value)
		{
			addCriterion("nonWeek <", value, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekLessThanOrEqualTo(String value)
		{
			addCriterion("nonWeek <=", value, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekLike(String value)
		{
			addCriterion("nonWeek like", value, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekNotLike(String value)
		{
			addCriterion("nonWeek not like", value, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekIn(List<String> values)
		{
			addCriterion("nonWeek in", values, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekNotIn(List<String> values)
		{
			addCriterion("nonWeek not in", values, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekBetween(String value1, String value2)
		{
			addCriterion("nonWeek between", value1, value2, "nonWeek");
			return (Criteria) this;
		}

		public Criteria andNonWeekNotBetween(String value1, String value2)
		{
			addCriterion("nonWeek not between", value1, value2, "nonWeek");
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
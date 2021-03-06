package com.ifeng.bigtrade.trade.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParamNodeExample
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ParamNodeExample()
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

		public Criteria andParamIdIsNull()
		{
			addCriterion("paramId is null");
			return (Criteria) this;
		}

		public Criteria andParamIdIsNotNull()
		{
			addCriterion("paramId is not null");
			return (Criteria) this;
		}

		public Criteria andParamIdEqualTo(Long value)
		{
			addCriterion("paramId =", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdNotEqualTo(Long value)
		{
			addCriterion("paramId <>", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdGreaterThan(Long value)
		{
			addCriterion("paramId >", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("paramId >=", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdLessThan(Long value)
		{
			addCriterion("paramId <", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdLessThanOrEqualTo(Long value)
		{
			addCriterion("paramId <=", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdIn(List<Long> values)
		{
			addCriterion("paramId in", values, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdNotIn(List<Long> values)
		{
			addCriterion("paramId not in", values, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdBetween(Long value1, Long value2)
		{
			addCriterion("paramId between", value1, value2, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdNotBetween(Long value1, Long value2)
		{
			addCriterion("paramId not between", value1, value2, "paramId");
			return (Criteria) this;
		}

		public Criteria andNodeIdIsNull()
		{
			addCriterion("nodeId is null");
			return (Criteria) this;
		}

		public Criteria andNodeIdIsNotNull()
		{
			addCriterion("nodeId is not null");
			return (Criteria) this;
		}

		public Criteria andNodeIdEqualTo(Long value)
		{
			addCriterion("nodeId =", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotEqualTo(Long value)
		{
			addCriterion("nodeId <>", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdGreaterThan(Long value)
		{
			addCriterion("nodeId >", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("nodeId >=", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdLessThan(Long value)
		{
			addCriterion("nodeId <", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdLessThanOrEqualTo(Long value)
		{
			addCriterion("nodeId <=", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdIn(List<Long> values)
		{
			addCriterion("nodeId in", values, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotIn(List<Long> values)
		{
			addCriterion("nodeId not in", values, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdBetween(Long value1, Long value2)
		{
			addCriterion("nodeId between", value1, value2, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotBetween(Long value1, Long value2)
		{
			addCriterion("nodeId not between", value1, value2, "nodeId");
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
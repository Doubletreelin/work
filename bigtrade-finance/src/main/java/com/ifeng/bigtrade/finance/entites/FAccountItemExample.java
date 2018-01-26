package com.ifeng.bigtrade.finance.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FAccountItemExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public FAccountItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("addTime <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNull() {
            addCriterion("deleteStatus is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("deleteStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Boolean value) {
            addCriterion("deleteStatus =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Boolean value) {
            addCriterion("deleteStatus <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Boolean value) {
            addCriterion("deleteStatus >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleteStatus >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Boolean value) {
            addCriterion("deleteStatus <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("deleteStatus <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Boolean> values) {
            addCriterion("deleteStatus in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Boolean> values) {
            addCriterion("deleteStatus not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("deleteStatus between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andAccountLevelIsNull() {
            addCriterion("accountLevel is null");
            return (Criteria) this;
        }

        public Criteria andAccountLevelIsNotNull() {
            addCriterion("accountLevel is not null");
            return (Criteria) this;
        }

        public Criteria andAccountLevelEqualTo(Integer value) {
            addCriterion("accountLevel =", value, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelNotEqualTo(Integer value) {
            addCriterion("accountLevel <>", value, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelGreaterThan(Integer value) {
            addCriterion("accountLevel >", value, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("accountLevel >=", value, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelLessThan(Integer value) {
            addCriterion("accountLevel <", value, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelLessThanOrEqualTo(Integer value) {
            addCriterion("accountLevel <=", value, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelIn(List<Integer> values) {
            addCriterion("accountLevel in", values, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelNotIn(List<Integer> values) {
            addCriterion("accountLevel not in", values, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelBetween(Integer value1, Integer value2) {
            addCriterion("accountLevel between", value1, value2, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andAccountLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("accountLevel not between", value1, value2, "accountLevel");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDCFlagIsNull() {
            addCriterion("dCFlag is null");
            return (Criteria) this;
        }

        public Criteria andDCFlagIsNotNull() {
            addCriterion("dCFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDCFlagEqualTo(String value) {
            addCriterion("dCFlag =", value, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagNotEqualTo(String value) {
            addCriterion("dCFlag <>", value, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagGreaterThan(String value) {
            addCriterion("dCFlag >", value, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagGreaterThanOrEqualTo(String value) {
            addCriterion("dCFlag >=", value, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagLessThan(String value) {
            addCriterion("dCFlag <", value, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagLessThanOrEqualTo(String value) {
            addCriterion("dCFlag <=", value, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagLike(String value) {
            addCriterion("dCFlag like", value, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagNotLike(String value) {
            addCriterion("dCFlag not like", value, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagIn(List<String> values) {
            addCriterion("dCFlag in", values, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagNotIn(List<String> values) {
            addCriterion("dCFlag not in", values, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagBetween(String value1, String value2) {
            addCriterion("dCFlag between", value1, value2, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andDCFlagNotBetween(String value1, String value2) {
            addCriterion("dCFlag not between", value1, value2, "dCFlag");
            return (Criteria) this;
        }

        public Criteria andHigherCodeIsNull() {
            addCriterion("higherCode is null");
            return (Criteria) this;
        }

        public Criteria andHigherCodeIsNotNull() {
            addCriterion("higherCode is not null");
            return (Criteria) this;
        }

        public Criteria andHigherCodeEqualTo(String value) {
            addCriterion("higherCode =", value, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeNotEqualTo(String value) {
            addCriterion("higherCode <>", value, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeGreaterThan(String value) {
            addCriterion("higherCode >", value, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeGreaterThanOrEqualTo(String value) {
            addCriterion("higherCode >=", value, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeLessThan(String value) {
            addCriterion("higherCode <", value, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeLessThanOrEqualTo(String value) {
            addCriterion("higherCode <=", value, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeLike(String value) {
            addCriterion("higherCode like", value, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeNotLike(String value) {
            addCriterion("higherCode not like", value, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeIn(List<String> values) {
            addCriterion("higherCode in", values, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeNotIn(List<String> values) {
            addCriterion("higherCode not in", values, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeBetween(String value1, String value2) {
            addCriterion("higherCode between", value1, value2, "higherCode");
            return (Criteria) this;
        }

        public Criteria andHigherCodeNotBetween(String value1, String value2) {
            addCriterion("higherCode not between", value1, value2, "higherCode");
            return (Criteria) this;
        }

        public Criteria andCanDeleteIsNull() {
            addCriterion("canDelete is null");
            return (Criteria) this;
        }

        public Criteria andCanDeleteIsNotNull() {
            addCriterion("canDelete is not null");
            return (Criteria) this;
        }

        public Criteria andCanDeleteEqualTo(Boolean value) {
            addCriterion("canDelete =", value, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteNotEqualTo(Boolean value) {
            addCriterion("canDelete <>", value, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteGreaterThan(Boolean value) {
            addCriterion("canDelete >", value, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("canDelete >=", value, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteLessThan(Boolean value) {
            addCriterion("canDelete <", value, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("canDelete <=", value, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteIn(List<Boolean> values) {
            addCriterion("canDelete in", values, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteNotIn(List<Boolean> values) {
            addCriterion("canDelete not in", values, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("canDelete between", value1, value2, "canDelete");
            return (Criteria) this;
        }

        public Criteria andCanDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("canDelete not between", value1, value2, "canDelete");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table f_accountitem
     *
     * @mbg.generated do_not_delete_during_merge Thu Aug 17 14:45:30 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table f_accountitem
     *
     * @mbg.generated Thu Aug 17 14:45:30 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
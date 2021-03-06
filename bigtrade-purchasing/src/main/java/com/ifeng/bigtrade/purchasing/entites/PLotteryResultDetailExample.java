package com.ifeng.bigtrade.purchasing.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PLotteryResultDetailExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public PLotteryResultDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
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
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
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

        public Criteria andIssuanceplan_idIsNull() {
            addCriterion("issuanceplan_id is null");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idIsNotNull() {
            addCriterion("issuanceplan_id is not null");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idEqualTo(Long value) {
            addCriterion("issuanceplan_id =", value, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idNotEqualTo(Long value) {
            addCriterion("issuanceplan_id <>", value, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idGreaterThan(Long value) {
            addCriterion("issuanceplan_id >", value, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idGreaterThanOrEqualTo(Long value) {
            addCriterion("issuanceplan_id >=", value, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idLessThan(Long value) {
            addCriterion("issuanceplan_id <", value, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idLessThanOrEqualTo(Long value) {
            addCriterion("issuanceplan_id <=", value, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idIn(List<Long> values) {
            addCriterion("issuanceplan_id in", values, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idNotIn(List<Long> values) {
            addCriterion("issuanceplan_id not in", values, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idBetween(Long value1, Long value2) {
            addCriterion("issuanceplan_id between", value1, value2, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andIssuanceplan_idNotBetween(Long value1, Long value2) {
            addCriterion("issuanceplan_id not between", value1, value2, "issuanceplan_id");
            return (Criteria) this;
        }

        public Criteria andWinningNoIsNull() {
            addCriterion("winningNo is null");
            return (Criteria) this;
        }

        public Criteria andWinningNoIsNotNull() {
            addCriterion("winningNo is not null");
            return (Criteria) this;
        }

        public Criteria andWinningNoEqualTo(String value) {
            addCriterion("winningNo =", value, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoNotEqualTo(String value) {
            addCriterion("winningNo <>", value, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoGreaterThan(String value) {
            addCriterion("winningNo >", value, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoGreaterThanOrEqualTo(String value) {
            addCriterion("winningNo >=", value, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoLessThan(String value) {
            addCriterion("winningNo <", value, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoLessThanOrEqualTo(String value) {
            addCriterion("winningNo <=", value, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoLike(String value) {
            addCriterion("winningNo like", value, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoNotLike(String value) {
            addCriterion("winningNo not like", value, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoIn(List<String> values) {
            addCriterion("winningNo in", values, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoNotIn(List<String> values) {
            addCriterion("winningNo not in", values, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoBetween(String value1, String value2) {
            addCriterion("winningNo between", value1, value2, "winningNo");
            return (Criteria) this;
        }

        public Criteria andWinningNoNotBetween(String value1, String value2) {
            addCriterion("winningNo not between", value1, value2, "winningNo");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idIsNull() {
            addCriterion("applicationdetail_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idIsNotNull() {
            addCriterion("applicationdetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idEqualTo(Long value) {
            addCriterion("applicationdetail_id =", value, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idNotEqualTo(Long value) {
            addCriterion("applicationdetail_id <>", value, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idGreaterThan(Long value) {
            addCriterion("applicationdetail_id >", value, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idGreaterThanOrEqualTo(Long value) {
            addCriterion("applicationdetail_id >=", value, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idLessThan(Long value) {
            addCriterion("applicationdetail_id <", value, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idLessThanOrEqualTo(Long value) {
            addCriterion("applicationdetail_id <=", value, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idIn(List<Long> values) {
            addCriterion("applicationdetail_id in", values, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idNotIn(List<Long> values) {
            addCriterion("applicationdetail_id not in", values, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idBetween(Long value1, Long value2) {
            addCriterion("applicationdetail_id between", value1, value2, "applicationdetail_id");
            return (Criteria) this;
        }

        public Criteria andApplicationdetail_idNotBetween(Long value1, Long value2) {
            addCriterion("applicationdetail_id not between", value1, value2, "applicationdetail_id");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated do_not_delete_during_merge Tue Sep 12 13:39:42 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table p_lotteryresult_detail
     *
     * @mbg.generated Tue Sep 12 13:39:42 CST 2017
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
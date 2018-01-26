/*      */ package com.ifeng.bigtrade.cms.entites.article;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ 
/*      */ public class ArticleExample
/*      */ {
/*      */   protected String orderByClause;
/*      */   protected boolean distinct;
/*      */   protected List<Criteria> oredCriteria;
/*      */ 
/*      */   public ArticleExample()
/*      */   {
/*   15 */     this.oredCriteria = new ArrayList();
/*      */   }
/*      */ 
/*      */   public void setOrderByClause(String orderByClause) {
/*   19 */     this.orderByClause = orderByClause;
/*      */   }
/*      */ 
/*      */   public String getOrderByClause() {
/*   23 */     return this.orderByClause;
/*      */   }
/*      */ 
/*      */   public void setDistinct(boolean distinct) {
/*   27 */     this.distinct = distinct;
/*      */   }
/*      */ 
/*      */   public boolean isDistinct() {
/*   31 */     return this.distinct;
/*      */   }
/*      */ 
/*      */   public List<Criteria> getOredCriteria() {
/*   35 */     return this.oredCriteria;
/*      */   }
/*      */ 
/*      */   public void or(Criteria criteria) {
/*   39 */     this.oredCriteria.add(criteria);
/*      */   }
/*      */ 
/*      */   public Criteria or() {
/*   43 */     Criteria criteria = createCriteriaInternal();
/*   44 */     this.oredCriteria.add(criteria);
/*   45 */     return criteria;
/*      */   }
/*      */ 
/*      */   public Criteria createCriteria() {
/*   49 */     Criteria criteria = createCriteriaInternal();
/*   50 */     if (this.oredCriteria.size() == 0) {
/*   51 */       this.oredCriteria.add(criteria);
/*      */     }
/*   53 */     return criteria;
/*      */   }
/*      */ 
/*      */   protected Criteria createCriteriaInternal() {
/*   57 */     Criteria criteria = new Criteria();
/*   58 */     return criteria;
/*      */   }
/*      */ 
/*      */   public void clear() {
/*   62 */     this.oredCriteria.clear();
/*   63 */     this.orderByClause = null;
/*   64 */     this.distinct = false;
/*      */   }
/*      */ 
/*      */   public static class Criterion
/*      */   {
/*      */     private String condition;
/*      */     private Object value;
/*      */     private Object secondValue;
/*      */     private boolean noValue;
/*      */     private boolean singleValue;
/*      */     private boolean betweenValue;
/*      */     private boolean listValue;
/*      */     private String typeHandler;
/*      */ 
/*      */     public String getCondition()
/*      */     {
/* 1084 */       return this.condition;
/*      */     }
/*      */ 
/*      */     public Object getValue() {
/* 1088 */       return this.value;
/*      */     }
/*      */ 
/*      */     public Object getSecondValue() {
/* 1092 */       return this.secondValue;
/*      */     }
/*      */ 
/*      */     public boolean isNoValue() {
/* 1096 */       return this.noValue;
/*      */     }
/*      */ 
/*      */     public boolean isSingleValue() {
/* 1100 */       return this.singleValue;
/*      */     }
/*      */ 
/*      */     public boolean isBetweenValue() {
/* 1104 */       return this.betweenValue;
/*      */     }
/*      */ 
/*      */     public boolean isListValue() {
/* 1108 */       return this.listValue;
/*      */     }
/*      */ 
/*      */     public String getTypeHandler() {
/* 1112 */       return this.typeHandler;
/*      */     }
/*      */ 
/*      */     protected Criterion(String condition)
/*      */     {
/* 1117 */       this.condition = condition;
/* 1118 */       this.typeHandler = null;
/* 1119 */       this.noValue = true;
/*      */     }
/*      */ 
/*      */     protected Criterion(String condition, Object value, String typeHandler)
/*      */     {
/* 1124 */       this.condition = condition;
/* 1125 */       this.value = value;
/* 1126 */       this.typeHandler = typeHandler;
/* 1127 */       if ((value instanceof List))
/* 1128 */         this.listValue = true;
/*      */       else
/* 1130 */         this.singleValue = true;
/*      */     }
/*      */ 
/*      */     protected Criterion(String condition, Object value)
/*      */     {
/* 1135 */       this(condition, value, null);
/*      */     }
/*      */ 
/*      */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/*      */     {
/* 1140 */       this.condition = condition;
/* 1141 */       this.value = value;
/* 1142 */       this.secondValue = secondValue;
/* 1143 */       this.typeHandler = typeHandler;
/* 1144 */       this.betweenValue = true;
/*      */     }
/*      */ 
/*      */     protected Criterion(String condition, Object value, Object secondValue) {
/* 1148 */       this(condition, value, secondValue, null);
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Criteria extends ArticleExample.GeneratedCriteria
/*      */   {
/*      */   }
/*      */ 
/*      */   protected static abstract class GeneratedCriteria
/*      */   {
/*      */     protected List<ArticleExample.Criterion> criteria;
/*      */ 
/*      */     protected GeneratedCriteria()
/*      */     {
/*   72 */       this.criteria = new ArrayList();
/*      */     }
/*      */ 
/*      */     public boolean isValid() {
/*   76 */       return this.criteria.size() > 0;
/*      */     }
/*      */ 
/*      */     public List<ArticleExample.Criterion> getAllCriteria() {
/*   80 */       return this.criteria;
/*      */     }
/*      */ 
/*      */     public List<ArticleExample.Criterion> getCriteria() {
/*   84 */       return this.criteria;
/*      */     }
/*      */ 
/*      */     protected void addCriterion(String condition) {
/*   88 */       if (condition == null) {
/*   89 */         throw new RuntimeException("Value for condition cannot be null");
/*      */       }
/*   91 */       this.criteria.add(new ArticleExample.Criterion(condition));
/*      */     }
/*      */ 
/*      */     protected void addCriterion(String condition, Object value, String property) {
/*   95 */       if (value == null) {
/*   96 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*      */       }
/*   98 */       this.criteria.add(new ArticleExample.Criterion(condition, value));
/*      */     }
/*      */ 
/*      */     protected void addCriterion(String condition, Object value1, Object value2, String property) {
/*  102 */       if ((value1 == null) || (value2 == null)) {
/*  103 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*      */       }
/*  105 */       this.criteria.add(new ArticleExample.Criterion(condition, value1, value2));
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdIsNull() {
/*  109 */       addCriterion("id is null");
/*  110 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdIsNotNull() {
/*  114 */       addCriterion("id is not null");
/*  115 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdEqualTo(Long value) {
/*  119 */       addCriterion("id =", value, "id");
/*  120 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdNotEqualTo(Long value) {
/*  124 */       addCriterion("id <>", value, "id");
/*  125 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdGreaterThan(Long value) {
/*  129 */       addCriterion("id >", value, "id");
/*  130 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
/*  134 */       addCriterion("id >=", value, "id");
/*  135 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdLessThan(Long value) {
/*  139 */       addCriterion("id <", value, "id");
/*  140 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdLessThanOrEqualTo(Long value) {
/*  144 */       addCriterion("id <=", value, "id");
/*  145 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdIn(List<Long> values) {
/*  149 */       addCriterion("id in", values, "id");
/*  150 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdNotIn(List<Long> values) {
/*  154 */       addCriterion("id not in", values, "id");
/*  155 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdBetween(Long value1, Long value2) {
/*  159 */       addCriterion("id between", value1, value2, "id");
/*  160 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andIdNotBetween(Long value1, Long value2) {
/*  164 */       addCriterion("id not between", value1, value2, "id");
/*  165 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeIsNull() {
/*  169 */       addCriterion("addTime is null");
/*  170 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeIsNotNull() {
/*  174 */       addCriterion("addTime is not null");
/*  175 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeEqualTo(Date value) {
/*  179 */       addCriterion("addTime =", value, "addTime");
/*  180 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeNotEqualTo(Date value) {
/*  184 */       addCriterion("addTime <>", value, "addTime");
/*  185 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeGreaterThan(Date value) {
/*  189 */       addCriterion("addTime >", value, "addTime");
/*  190 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
/*  194 */       addCriterion("addTime >=", value, "addTime");
/*  195 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeLessThan(Date value) {
/*  199 */       addCriterion("addTime <", value, "addTime");
/*  200 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeLessThanOrEqualTo(Date value) {
/*  204 */       addCriterion("addTime <=", value, "addTime");
/*  205 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeIn(List<Date> values) {
/*  209 */       addCriterion("addTime in", values, "addTime");
/*  210 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeNotIn(List<Date> values) {
/*  214 */       addCriterion("addTime not in", values, "addTime");
/*  215 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeBetween(Date value1, Date value2) {
/*  219 */       addCriterion("addTime between", value1, value2, "addTime");
/*  220 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAddTimeNotBetween(Date value1, Date value2) {
/*  224 */       addCriterion("addTime not between", value1, value2, "addTime");
/*  225 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusIsNull() {
/*  229 */       addCriterion("deleteStatus is null");
/*  230 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusIsNotNull() {
/*  234 */       addCriterion("deleteStatus is not null");
/*  235 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusEqualTo(Boolean value) {
/*  239 */       addCriterion("deleteStatus =", value, "deleteStatus");
/*  240 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusNotEqualTo(Boolean value) {
/*  244 */       addCriterion("deleteStatus <>", value, "deleteStatus");
/*  245 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusGreaterThan(Boolean value) {
/*  249 */       addCriterion("deleteStatus >", value, "deleteStatus");
/*  250 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
/*  254 */       addCriterion("deleteStatus >=", value, "deleteStatus");
/*  255 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusLessThan(Boolean value) {
/*  259 */       addCriterion("deleteStatus <", value, "deleteStatus");
/*  260 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
/*  264 */       addCriterion("deleteStatus <=", value, "deleteStatus");
/*  265 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusIn(List<Boolean> values) {
/*  269 */       addCriterion("deleteStatus in", values, "deleteStatus");
/*  270 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusNotIn(List<Boolean> values) {
/*  274 */       addCriterion("deleteStatus not in", values, "deleteStatus");
/*  275 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
/*  279 */       addCriterion("deleteStatus between", value1, value2, "deleteStatus");
/*  280 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
/*  284 */       addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
/*  285 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleIsNull() {
/*  289 */       addCriterion("title is null");
/*  290 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleIsNotNull() {
/*  294 */       addCriterion("title is not null");
/*  295 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleEqualTo(String value) {
/*  299 */       addCriterion("title =", value, "title");
/*  300 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleNotEqualTo(String value) {
/*  304 */       addCriterion("title <>", value, "title");
/*  305 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleGreaterThan(String value) {
/*  309 */       addCriterion("title >", value, "title");
/*  310 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
/*  314 */       addCriterion("title >=", value, "title");
/*  315 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleLessThan(String value) {
/*  319 */       addCriterion("title <", value, "title");
/*  320 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleLessThanOrEqualTo(String value) {
/*  324 */       addCriterion("title <=", value, "title");
/*  325 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleLike(String value) {
/*  329 */       addCriterion("title like", value, "title");
/*  330 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleNotLike(String value) {
/*  334 */       addCriterion("title not like", value, "title");
/*  335 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleIn(List<String> values) {
/*  339 */       addCriterion("title in", values, "title");
/*  340 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleNotIn(List<String> values) {
/*  344 */       addCriterion("title not in", values, "title");
/*  345 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleBetween(String value1, String value2) {
/*  349 */       addCriterion("title between", value1, value2, "title");
/*  350 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTitleNotBetween(String value1, String value2) {
/*  354 */       addCriterion("title not between", value1, value2, "title");
/*  355 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdIsNull() {
/*  359 */       addCriterion("typeId is null");
/*  360 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdIsNotNull() {
/*  364 */       addCriterion("typeId is not null");
/*  365 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdEqualTo(Long value) {
/*  369 */       addCriterion("typeId =", value, "typeId");
/*  370 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdNotEqualTo(Long value) {
/*  374 */       addCriterion("typeId <>", value, "typeId");
/*  375 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdGreaterThan(Long value) {
/*  379 */       addCriterion("typeId >", value, "typeId");
/*  380 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
/*  384 */       addCriterion("typeId >=", value, "typeId");
/*  385 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdLessThan(Long value) {
/*  389 */       addCriterion("typeId <", value, "typeId");
/*  390 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdLessThanOrEqualTo(Long value) {
/*  394 */       addCriterion("typeId <=", value, "typeId");
/*  395 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdIn(List<Long> values) {
/*  399 */       addCriterion("typeId in", values, "typeId");
/*  400 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdNotIn(List<Long> values) {
/*  404 */       addCriterion("typeId not in", values, "typeId");
/*  405 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdBetween(Long value1, Long value2) {
/*  409 */       addCriterion("typeId between", value1, value2, "typeId");
/*  410 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andTypeIdNotBetween(Long value1, Long value2) {
/*  414 */       addCriterion("typeId not between", value1, value2, "typeId");
/*  415 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorIsNull() {
/*  419 */       addCriterion("author is null");
/*  420 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorIsNotNull() {
/*  424 */       addCriterion("author is not null");
/*  425 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorEqualTo(String value) {
/*  429 */       addCriterion("author =", value, "author");
/*  430 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorNotEqualTo(String value) {
/*  434 */       addCriterion("author <>", value, "author");
/*  435 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorGreaterThan(String value) {
/*  439 */       addCriterion("author >", value, "author");
/*  440 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorGreaterThanOrEqualTo(String value) {
/*  444 */       addCriterion("author >=", value, "author");
/*  445 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorLessThan(String value) {
/*  449 */       addCriterion("author <", value, "author");
/*  450 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorLessThanOrEqualTo(String value) {
/*  454 */       addCriterion("author <=", value, "author");
/*  455 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorLike(String value) {
/*  459 */       addCriterion("author like", value, "author");
/*  460 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorNotLike(String value) {
/*  464 */       addCriterion("author not like", value, "author");
/*  465 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorIn(List<String> values) {
/*  469 */       addCriterion("author in", values, "author");
/*  470 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorNotIn(List<String> values) {
/*  474 */       addCriterion("author not in", values, "author");
/*  475 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorBetween(String value1, String value2) {
/*  479 */       addCriterion("author between", value1, value2, "author");
/*  480 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuthorNotBetween(String value1, String value2) {
/*  484 */       addCriterion("author not between", value1, value2, "author");
/*  485 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterIsNull() {
/*  489 */       addCriterion("submitter is null");
/*  490 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterIsNotNull() {
/*  494 */       addCriterion("submitter is not null");
/*  495 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterEqualTo(String value) {
/*  499 */       addCriterion("submitter =", value, "submitter");
/*  500 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterNotEqualTo(String value) {
/*  504 */       addCriterion("submitter <>", value, "submitter");
/*  505 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterGreaterThan(String value) {
/*  509 */       addCriterion("submitter >", value, "submitter");
/*  510 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterGreaterThanOrEqualTo(String value) {
/*  514 */       addCriterion("submitter >=", value, "submitter");
/*  515 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterLessThan(String value) {
/*  519 */       addCriterion("submitter <", value, "submitter");
/*  520 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterLessThanOrEqualTo(String value) {
/*  524 */       addCriterion("submitter <=", value, "submitter");
/*  525 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterLike(String value) {
/*  529 */       addCriterion("submitter like", value, "submitter");
/*  530 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterNotLike(String value) {
/*  534 */       addCriterion("submitter not like", value, "submitter");
/*  535 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterIn(List<String> values) {
/*  539 */       addCriterion("submitter in", values, "submitter");
/*  540 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterNotIn(List<String> values) {
/*  544 */       addCriterion("submitter not in", values, "submitter");
/*  545 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterBetween(String value1, String value2) {
/*  549 */       addCriterion("submitter between", value1, value2, "submitter");
/*  550 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitterNotBetween(String value1, String value2) {
/*  554 */       addCriterion("submitter not between", value1, value2, "submitter");
/*  555 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeIsNull() {
/*  559 */       addCriterion("submitTime is null");
/*  560 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeIsNotNull() {
/*  564 */       addCriterion("submitTime is not null");
/*  565 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeEqualTo(Date value) {
/*  569 */       addCriterion("submitTime =", value, "submitTime");
/*  570 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeNotEqualTo(Date value) {
/*  574 */       addCriterion("submitTime <>", value, "submitTime");
/*  575 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeGreaterThan(Date value) {
/*  579 */       addCriterion("submitTime >", value, "submitTime");
/*  580 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
/*  584 */       addCriterion("submitTime >=", value, "submitTime");
/*  585 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeLessThan(Date value) {
/*  589 */       addCriterion("submitTime <", value, "submitTime");
/*  590 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
/*  594 */       addCriterion("submitTime <=", value, "submitTime");
/*  595 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeIn(List<Date> values) {
/*  599 */       addCriterion("submitTime in", values, "submitTime");
/*  600 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeNotIn(List<Date> values) {
/*  604 */       addCriterion("submitTime not in", values, "submitTime");
/*  605 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeBetween(Date value1, Date value2) {
/*  609 */       addCriterion("submitTime between", value1, value2, "submitTime");
/*  610 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
/*  614 */       addCriterion("submitTime not between", value1, value2, "submitTime");
/*  615 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeIsNull() {
/*  619 */       addCriterion("publishTime is null");
/*  620 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeIsNotNull() {
/*  624 */       addCriterion("publishTime is not null");
/*  625 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeEqualTo(Date value) {
/*  629 */       addCriterion("publishTime =", value, "publishTime");
/*  630 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeNotEqualTo(Date value) {
/*  634 */       addCriterion("publishTime <>", value, "publishTime");
/*  635 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeGreaterThan(Date value) {
/*  639 */       addCriterion("publishTime >", value, "publishTime");
/*  640 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
/*  644 */       addCriterion("publishTime >=", value, "publishTime");
/*  645 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeLessThan(Date value) {
/*  649 */       addCriterion("publishTime <", value, "publishTime");
/*  650 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeLessThanOrEqualTo(Date value) {
/*  654 */       addCriterion("publishTime <=", value, "publishTime");
/*  655 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeIn(List<Date> values) {
/*  659 */       addCriterion("publishTime in", values, "publishTime");
/*  660 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeNotIn(List<Date> values) {
/*  664 */       addCriterion("publishTime not in", values, "publishTime");
/*  665 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeBetween(Date value1, Date value2) {
/*  669 */       addCriterion("publishTime between", value1, value2, "publishTime");
/*  670 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPublishTimeNotBetween(Date value1, Date value2) {
/*  674 */       addCriterion("publishTime not between", value1, value2, "publishTime");
/*  675 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlIsNull() {
/*  679 */       addCriterion("pictureUrl is null");
/*  680 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlIsNotNull() {
/*  684 */       addCriterion("pictureUrl is not null");
/*  685 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlEqualTo(String value) {
/*  689 */       addCriterion("pictureUrl =", value, "pictureUrl");
/*  690 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlNotEqualTo(String value) {
/*  694 */       addCriterion("pictureUrl <>", value, "pictureUrl");
/*  695 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlGreaterThan(String value) {
/*  699 */       addCriterion("pictureUrl >", value, "pictureUrl");
/*  700 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlGreaterThanOrEqualTo(String value) {
/*  704 */       addCriterion("pictureUrl >=", value, "pictureUrl");
/*  705 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlLessThan(String value) {
/*  709 */       addCriterion("pictureUrl <", value, "pictureUrl");
/*  710 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlLessThanOrEqualTo(String value) {
/*  714 */       addCriterion("pictureUrl <=", value, "pictureUrl");
/*  715 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlLike(String value) {
/*  719 */       addCriterion("pictureUrl like", value, "pictureUrl");
/*  720 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlNotLike(String value) {
/*  724 */       addCriterion("pictureUrl not like", value, "pictureUrl");
/*  725 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlIn(List<String> values) {
/*  729 */       addCriterion("pictureUrl in", values, "pictureUrl");
/*  730 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlNotIn(List<String> values) {
/*  734 */       addCriterion("pictureUrl not in", values, "pictureUrl");
/*  735 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlBetween(String value1, String value2) {
/*  739 */       addCriterion("pictureUrl between", value1, value2, "pictureUrl");
/*  740 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andPictureUrlNotBetween(String value1, String value2) {
/*  744 */       addCriterion("pictureUrl not between", value1, value2, "pictureUrl");
/*  745 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorIsNull() {
/*  749 */       addCriterion("auditor is null");
/*  750 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorIsNotNull() {
/*  754 */       addCriterion("auditor is not null");
/*  755 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorEqualTo(String value) {
/*  759 */       addCriterion("auditor =", value, "auditor");
/*  760 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorNotEqualTo(String value) {
/*  764 */       addCriterion("auditor <>", value, "auditor");
/*  765 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorGreaterThan(String value) {
/*  769 */       addCriterion("auditor >", value, "auditor");
/*  770 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorGreaterThanOrEqualTo(String value) {
/*  774 */       addCriterion("auditor >=", value, "auditor");
/*  775 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorLessThan(String value) {
/*  779 */       addCriterion("auditor <", value, "auditor");
/*  780 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorLessThanOrEqualTo(String value) {
/*  784 */       addCriterion("auditor <=", value, "auditor");
/*  785 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorLike(String value) {
/*  789 */       addCriterion("auditor like", value, "auditor");
/*  790 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorNotLike(String value) {
/*  794 */       addCriterion("auditor not like", value, "auditor");
/*  795 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorIn(List<String> values) {
/*  799 */       addCriterion("auditor in", values, "auditor");
/*  800 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorNotIn(List<String> values) {
/*  804 */       addCriterion("auditor not in", values, "auditor");
/*  805 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorBetween(String value1, String value2) {
/*  809 */       addCriterion("auditor between", value1, value2, "auditor");
/*  810 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditorNotBetween(String value1, String value2) {
/*  814 */       addCriterion("auditor not between", value1, value2, "auditor");
/*  815 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeIsNull() {
/*  819 */       addCriterion("auditTime is null");
/*  820 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeIsNotNull() {
/*  824 */       addCriterion("auditTime is not null");
/*  825 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeEqualTo(Date value) {
/*  829 */       addCriterion("auditTime =", value, "auditTime");
/*  830 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeNotEqualTo(Date value) {
/*  834 */       addCriterion("auditTime <>", value, "auditTime");
/*  835 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeGreaterThan(Date value) {
/*  839 */       addCriterion("auditTime >", value, "auditTime");
/*  840 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
/*  844 */       addCriterion("auditTime >=", value, "auditTime");
/*  845 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeLessThan(Date value) {
/*  849 */       addCriterion("auditTime <", value, "auditTime");
/*  850 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeLessThanOrEqualTo(Date value) {
/*  854 */       addCriterion("auditTime <=", value, "auditTime");
/*  855 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeIn(List<Date> values) {
/*  859 */       addCriterion("auditTime in", values, "auditTime");
/*  860 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeNotIn(List<Date> values) {
/*  864 */       addCriterion("auditTime not in", values, "auditTime");
/*  865 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeBetween(Date value1, Date value2) {
/*  869 */       addCriterion("auditTime between", value1, value2, "auditTime");
/*  870 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditTimeNotBetween(Date value1, Date value2) {
/*  874 */       addCriterion("auditTime not between", value1, value2, "auditTime");
/*  875 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateIsNull() {
/*  879 */       addCriterion("auditState is null");
/*  880 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateIsNotNull() {
/*  884 */       addCriterion("auditState is not null");
/*  885 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateEqualTo(Integer value) {
/*  889 */       addCriterion("auditState =", value, "auditState");
/*  890 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateNotEqualTo(Integer value) {
/*  894 */       addCriterion("auditState <>", value, "auditState");
/*  895 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateGreaterThan(Integer value) {
/*  899 */       addCriterion("auditState >", value, "auditState");
/*  900 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateGreaterThanOrEqualTo(Integer value) {
/*  904 */       addCriterion("auditState >=", value, "auditState");
/*  905 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateLessThan(Integer value) {
/*  909 */       addCriterion("auditState <", value, "auditState");
/*  910 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateLessThanOrEqualTo(Integer value) {
/*  914 */       addCriterion("auditState <=", value, "auditState");
/*  915 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateIn(List<Integer> values) {
/*  919 */       addCriterion("auditState in", values, "auditState");
/*  920 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateNotIn(List<Integer> values) {
/*  924 */       addCriterion("auditState not in", values, "auditState");
/*  925 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateBetween(Integer value1, Integer value2) {
/*  929 */       addCriterion("auditState between", value1, value2, "auditState");
/*  930 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andAuditStateNotBetween(Integer value1, Integer value2) {
/*  934 */       addCriterion("auditState not between", value1, value2, "auditState");
/*  935 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateIsNull() {
/*  939 */       addCriterion("showState is null");
/*  940 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateIsNotNull() {
/*  944 */       addCriterion("showState is not null");
/*  945 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateEqualTo(Integer value) {
/*  949 */       addCriterion("showState =", value, "showState");
/*  950 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateNotEqualTo(Integer value) {
/*  954 */       addCriterion("showState <>", value, "showState");
/*  955 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateGreaterThan(Integer value) {
/*  959 */       addCriterion("showState >", value, "showState");
/*  960 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateGreaterThanOrEqualTo(Integer value) {
/*  964 */       addCriterion("showState >=", value, "showState");
/*  965 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateLessThan(Integer value) {
/*  969 */       addCriterion("showState <", value, "showState");
/*  970 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateLessThanOrEqualTo(Integer value) {
/*  974 */       addCriterion("showState <=", value, "showState");
/*  975 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateIn(List<Integer> values) {
/*  979 */       addCriterion("showState in", values, "showState");
/*  980 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateNotIn(List<Integer> values) {
/*  984 */       addCriterion("showState not in", values, "showState");
/*  985 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateBetween(Integer value1, Integer value2) {
/*  989 */       addCriterion("showState between", value1, value2, "showState");
/*  990 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andShowStateNotBetween(Integer value1, Integer value2) {
/*  994 */       addCriterion("showState not between", value1, value2, "showState");
/*  995 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsIsNull() {
/*  999 */       addCriterion("hits is null");
/* 1000 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsIsNotNull() {
/* 1004 */       addCriterion("hits is not null");
/* 1005 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsEqualTo(Integer value) {
/* 1009 */       addCriterion("hits =", value, "hits");
/* 1010 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsNotEqualTo(Integer value) {
/* 1014 */       addCriterion("hits <>", value, "hits");
/* 1015 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsGreaterThan(Integer value) {
/* 1019 */       addCriterion("hits >", value, "hits");
/* 1020 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsGreaterThanOrEqualTo(Integer value) {
/* 1024 */       addCriterion("hits >=", value, "hits");
/* 1025 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsLessThan(Integer value) {
/* 1029 */       addCriterion("hits <", value, "hits");
/* 1030 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsLessThanOrEqualTo(Integer value) {
/* 1034 */       addCriterion("hits <=", value, "hits");
/* 1035 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsIn(List<Integer> values) {
/* 1039 */       addCriterion("hits in", values, "hits");
/* 1040 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsNotIn(List<Integer> values) {
/* 1044 */       addCriterion("hits not in", values, "hits");
/* 1045 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsBetween(Integer value1, Integer value2) {
/* 1049 */       addCriterion("hits between", value1, value2, "hits");
/* 1050 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */ 
/*      */     public ArticleExample.Criteria andHitsNotBetween(Integer value1, Integer value2) {
/* 1054 */       addCriterion("hits not between", value1, value2, "hits");
/* 1055 */       return (ArticleExample.Criteria)this;
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.article.ArticleExample
 * JD-Core Version:    0.6.2
 */
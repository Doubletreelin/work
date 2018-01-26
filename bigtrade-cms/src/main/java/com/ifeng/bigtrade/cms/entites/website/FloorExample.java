/*     */ package com.ifeng.bigtrade.cms.entites.website;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class FloorExample
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public FloorExample()
/*     */   {
/*  15 */     this.oredCriteria = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void setOrderByClause(String orderByClause) {
/*  19 */     this.orderByClause = orderByClause;
/*     */   }
/*     */ 
/*     */   public String getOrderByClause() {
/*  23 */     return this.orderByClause;
/*     */   }
/*     */ 
/*     */   public void setDistinct(boolean distinct) {
/*  27 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   public boolean isDistinct() {
/*  31 */     return this.distinct;
/*     */   }
/*     */ 
/*     */   public List<Criteria> getOredCriteria() {
/*  35 */     return this.oredCriteria;
/*     */   }
/*     */ 
/*     */   public void or(Criteria criteria) {
/*  39 */     this.oredCriteria.add(criteria);
/*     */   }
/*     */ 
/*     */   public Criteria or() {
/*  43 */     Criteria criteria = createCriteriaInternal();
/*  44 */     this.oredCriteria.add(criteria);
/*  45 */     return criteria;
/*     */   }
/*     */ 
/*     */   public Criteria createCriteria() {
/*  49 */     Criteria criteria = createCriteriaInternal();
/*  50 */     if (this.oredCriteria.size() == 0) {
/*  51 */       this.oredCriteria.add(criteria);
/*     */     }
/*  53 */     return criteria;
/*     */   }
/*     */ 
/*     */   protected Criteria createCriteriaInternal() {
/*  57 */     Criteria criteria = new Criteria();
/*  58 */     return criteria;
/*     */   }
/*     */ 
/*     */   public void clear() {
/*  62 */     this.oredCriteria.clear();
/*  63 */     this.orderByClause = null;
/*  64 */     this.distinct = false;
/*     */   }
/*     */ 
/*     */   public static class Criterion
/*     */   {
/*     */     private String condition;
/*     */     private Object value;
/*     */     private Object secondValue;
/*     */     private boolean noValue;
/*     */     private boolean singleValue;
/*     */     private boolean betweenValue;
/*     */     private boolean listValue;
/*     */     private String typeHandler;
/*     */ 
/*     */     public String getCondition()
/*     */     {
/* 574 */       return this.condition;
/*     */     }
/*     */ 
/*     */     public Object getValue() {
/* 578 */       return this.value;
/*     */     }
/*     */ 
/*     */     public Object getSecondValue() {
/* 582 */       return this.secondValue;
/*     */     }
/*     */ 
/*     */     public boolean isNoValue() {
/* 586 */       return this.noValue;
/*     */     }
/*     */ 
/*     */     public boolean isSingleValue() {
/* 590 */       return this.singleValue;
/*     */     }
/*     */ 
/*     */     public boolean isBetweenValue() {
/* 594 */       return this.betweenValue;
/*     */     }
/*     */ 
/*     */     public boolean isListValue() {
/* 598 */       return this.listValue;
/*     */     }
/*     */ 
/*     */     public String getTypeHandler() {
/* 602 */       return this.typeHandler;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition)
/*     */     {
/* 607 */       this.condition = condition;
/* 608 */       this.typeHandler = null;
/* 609 */       this.noValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, String typeHandler)
/*     */     {
/* 614 */       this.condition = condition;
/* 615 */       this.value = value;
/* 616 */       this.typeHandler = typeHandler;
/* 617 */       if ((value instanceof List))
/* 618 */         this.listValue = true;
/*     */       else
/* 620 */         this.singleValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value)
/*     */     {
/* 625 */       this(condition, value, null);
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/*     */     {
/* 630 */       this.condition = condition;
/* 631 */       this.value = value;
/* 632 */       this.secondValue = secondValue;
/* 633 */       this.typeHandler = typeHandler;
/* 634 */       this.betweenValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue) {
/* 638 */       this(condition, value, secondValue, null);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Criteria extends FloorExample.GeneratedCriteria
/*     */   {
/*     */   }
/*     */ 
/*     */   protected static abstract class GeneratedCriteria
/*     */   {
/*     */     protected List<FloorExample.Criterion> criteria;
/*     */ 
/*     */     protected GeneratedCriteria()
/*     */     {
/*  72 */       this.criteria = new ArrayList();
/*     */     }
/*     */ 
/*     */     public boolean isValid() {
/*  76 */       return this.criteria.size() > 0;
/*     */     }
/*     */ 
/*     */     public List<FloorExample.Criterion> getAllCriteria() {
/*  80 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     public List<FloorExample.Criterion> getCriteria() {
/*  84 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition) {
/*  88 */       if (condition == null) {
/*  89 */         throw new RuntimeException("Value for condition cannot be null");
/*     */       }
/*  91 */       this.criteria.add(new FloorExample.Criterion(condition));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value, String property) {
/*  95 */       if (value == null) {
/*  96 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*     */       }
/*  98 */       this.criteria.add(new FloorExample.Criterion(condition, value));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value1, Object value2, String property) {
/* 102 */       if ((value1 == null) || (value2 == null)) {
/* 103 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*     */       }
/* 105 */       this.criteria.add(new FloorExample.Criterion(condition, value1, value2));
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdIsNull() {
/* 109 */       addCriterion("id is null");
/* 110 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdIsNotNull() {
/* 114 */       addCriterion("id is not null");
/* 115 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdEqualTo(Long value) {
/* 119 */       addCriterion("id =", value, "id");
/* 120 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdNotEqualTo(Long value) {
/* 124 */       addCriterion("id <>", value, "id");
/* 125 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdGreaterThan(Long value) {
/* 129 */       addCriterion("id >", value, "id");
/* 130 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
/* 134 */       addCriterion("id >=", value, "id");
/* 135 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdLessThan(Long value) {
/* 139 */       addCriterion("id <", value, "id");
/* 140 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdLessThanOrEqualTo(Long value) {
/* 144 */       addCriterion("id <=", value, "id");
/* 145 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdIn(List<Long> values) {
/* 149 */       addCriterion("id in", values, "id");
/* 150 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdNotIn(List<Long> values) {
/* 154 */       addCriterion("id not in", values, "id");
/* 155 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdBetween(Long value1, Long value2) {
/* 159 */       addCriterion("id between", value1, value2, "id");
/* 160 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andIdNotBetween(Long value1, Long value2) {
/* 164 */       addCriterion("id not between", value1, value2, "id");
/* 165 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeIsNull() {
/* 169 */       addCriterion("addTime is null");
/* 170 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeIsNotNull() {
/* 174 */       addCriterion("addTime is not null");
/* 175 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeEqualTo(Date value) {
/* 179 */       addCriterion("addTime =", value, "addTime");
/* 180 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeNotEqualTo(Date value) {
/* 184 */       addCriterion("addTime <>", value, "addTime");
/* 185 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeGreaterThan(Date value) {
/* 189 */       addCriterion("addTime >", value, "addTime");
/* 190 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
/* 194 */       addCriterion("addTime >=", value, "addTime");
/* 195 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeLessThan(Date value) {
/* 199 */       addCriterion("addTime <", value, "addTime");
/* 200 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeLessThanOrEqualTo(Date value) {
/* 204 */       addCriterion("addTime <=", value, "addTime");
/* 205 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeIn(List<Date> values) {
/* 209 */       addCriterion("addTime in", values, "addTime");
/* 210 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeNotIn(List<Date> values) {
/* 214 */       addCriterion("addTime not in", values, "addTime");
/* 215 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeBetween(Date value1, Date value2) {
/* 219 */       addCriterion("addTime between", value1, value2, "addTime");
/* 220 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andAddTimeNotBetween(Date value1, Date value2) {
/* 224 */       addCriterion("addTime not between", value1, value2, "addTime");
/* 225 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusIsNull() {
/* 229 */       addCriterion("deleteStatus is null");
/* 230 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusIsNotNull() {
/* 234 */       addCriterion("deleteStatus is not null");
/* 235 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusEqualTo(Boolean value) {
/* 239 */       addCriterion("deleteStatus =", value, "deleteStatus");
/* 240 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusNotEqualTo(Boolean value) {
/* 244 */       addCriterion("deleteStatus <>", value, "deleteStatus");
/* 245 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusGreaterThan(Boolean value) {
/* 249 */       addCriterion("deleteStatus >", value, "deleteStatus");
/* 250 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
/* 254 */       addCriterion("deleteStatus >=", value, "deleteStatus");
/* 255 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusLessThan(Boolean value) {
/* 259 */       addCriterion("deleteStatus <", value, "deleteStatus");
/* 260 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
/* 264 */       addCriterion("deleteStatus <=", value, "deleteStatus");
/* 265 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusIn(List<Boolean> values) {
/* 269 */       addCriterion("deleteStatus in", values, "deleteStatus");
/* 270 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusNotIn(List<Boolean> values) {
/* 274 */       addCriterion("deleteStatus not in", values, "deleteStatus");
/* 275 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
/* 279 */       addCriterion("deleteStatus between", value1, value2, "deleteStatus");
/* 280 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
/* 284 */       addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
/* 285 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleIsNull() {
/* 289 */       addCriterion("title is null");
/* 290 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleIsNotNull() {
/* 294 */       addCriterion("title is not null");
/* 295 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleEqualTo(String value) {
/* 299 */       addCriterion("title =", value, "title");
/* 300 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleNotEqualTo(String value) {
/* 304 */       addCriterion("title <>", value, "title");
/* 305 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleGreaterThan(String value) {
/* 309 */       addCriterion("title >", value, "title");
/* 310 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
/* 314 */       addCriterion("title >=", value, "title");
/* 315 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleLessThan(String value) {
/* 319 */       addCriterion("title <", value, "title");
/* 320 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleLessThanOrEqualTo(String value) {
/* 324 */       addCriterion("title <=", value, "title");
/* 325 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleLike(String value) {
/* 329 */       addCriterion("title like", value, "title");
/* 330 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleNotLike(String value) {
/* 334 */       addCriterion("title not like", value, "title");
/* 335 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleIn(List<String> values) {
/* 339 */       addCriterion("title in", values, "title");
/* 340 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleNotIn(List<String> values) {
/* 344 */       addCriterion("title not in", values, "title");
/* 345 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleBetween(String value1, String value2) {
/* 349 */       addCriterion("title between", value1, value2, "title");
/* 350 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andTitleNotBetween(String value1, String value2) {
/* 354 */       addCriterion("title not between", value1, value2, "title");
/* 355 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionIsNull() {
/* 359 */       addCriterion("description is null");
/* 360 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionIsNotNull() {
/* 364 */       addCriterion("description is not null");
/* 365 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionEqualTo(String value) {
/* 369 */       addCriterion("description =", value, "description");
/* 370 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionNotEqualTo(String value) {
/* 374 */       addCriterion("description <>", value, "description");
/* 375 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionGreaterThan(String value) {
/* 379 */       addCriterion("description >", value, "description");
/* 380 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
/* 384 */       addCriterion("description >=", value, "description");
/* 385 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionLessThan(String value) {
/* 389 */       addCriterion("description <", value, "description");
/* 390 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
/* 394 */       addCriterion("description <=", value, "description");
/* 395 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionLike(String value) {
/* 399 */       addCriterion("description like", value, "description");
/* 400 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionNotLike(String value) {
/* 404 */       addCriterion("description not like", value, "description");
/* 405 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionIn(List<String> values) {
/* 409 */       addCriterion("description in", values, "description");
/* 410 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionNotIn(List<String> values) {
/* 414 */       addCriterion("description not in", values, "description");
/* 415 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionBetween(String value1, String value2) {
/* 419 */       addCriterion("description between", value1, value2, "description");
/* 420 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andDescriptionNotBetween(String value1, String value2) {
/* 424 */       addCriterion("description not between", value1, value2, "description");
/* 425 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateIsNull() {
/* 429 */       addCriterion("showState is null");
/* 430 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateIsNotNull() {
/* 434 */       addCriterion("showState is not null");
/* 435 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateEqualTo(Integer value) {
/* 439 */       addCriterion("showState =", value, "showState");
/* 440 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateNotEqualTo(Integer value) {
/* 444 */       addCriterion("showState <>", value, "showState");
/* 445 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateGreaterThan(Integer value) {
/* 449 */       addCriterion("showState >", value, "showState");
/* 450 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateGreaterThanOrEqualTo(Integer value) {
/* 454 */       addCriterion("showState >=", value, "showState");
/* 455 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateLessThan(Integer value) {
/* 459 */       addCriterion("showState <", value, "showState");
/* 460 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateLessThanOrEqualTo(Integer value) {
/* 464 */       addCriterion("showState <=", value, "showState");
/* 465 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateIn(List<Integer> values) {
/* 469 */       addCriterion("showState in", values, "showState");
/* 470 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateNotIn(List<Integer> values) {
/* 474 */       addCriterion("showState not in", values, "showState");
/* 475 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateBetween(Integer value1, Integer value2) {
/* 479 */       addCriterion("showState between", value1, value2, "showState");
/* 480 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andShowStateNotBetween(Integer value1, Integer value2) {
/* 484 */       addCriterion("showState not between", value1, value2, "showState");
/* 485 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumIsNull() {
/* 489 */       addCriterion("serialNum is null");
/* 490 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumIsNotNull() {
/* 494 */       addCriterion("serialNum is not null");
/* 495 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumEqualTo(Integer value) {
/* 499 */       addCriterion("serialNum =", value, "serialNum");
/* 500 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumNotEqualTo(Integer value) {
/* 504 */       addCriterion("serialNum <>", value, "serialNum");
/* 505 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumGreaterThan(Integer value) {
/* 509 */       addCriterion("serialNum >", value, "serialNum");
/* 510 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumGreaterThanOrEqualTo(Integer value) {
/* 514 */       addCriterion("serialNum >=", value, "serialNum");
/* 515 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumLessThan(Integer value) {
/* 519 */       addCriterion("serialNum <", value, "serialNum");
/* 520 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumLessThanOrEqualTo(Integer value) {
/* 524 */       addCriterion("serialNum <=", value, "serialNum");
/* 525 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumIn(List<Integer> values) {
/* 529 */       addCriterion("serialNum in", values, "serialNum");
/* 530 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumNotIn(List<Integer> values) {
/* 534 */       addCriterion("serialNum not in", values, "serialNum");
/* 535 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumBetween(Integer value1, Integer value2) {
/* 539 */       addCriterion("serialNum between", value1, value2, "serialNum");
/* 540 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorExample.Criteria andSerialNumNotBetween(Integer value1, Integer value2) {
/* 544 */       addCriterion("serialNum not between", value1, value2, "serialNum");
/* 545 */       return (FloorExample.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.website.FloorExample
 * JD-Core Version:    0.6.2
 */
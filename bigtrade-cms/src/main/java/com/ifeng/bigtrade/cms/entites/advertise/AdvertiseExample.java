/*     */ package com.ifeng.bigtrade.cms.entites.advertise;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AdvertiseExample
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public AdvertiseExample()
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
/* 834 */       return this.condition;
/*     */     }
/*     */ 
/*     */     public Object getValue() {
/* 838 */       return this.value;
/*     */     }
/*     */ 
/*     */     public Object getSecondValue() {
/* 842 */       return this.secondValue;
/*     */     }
/*     */ 
/*     */     public boolean isNoValue() {
/* 846 */       return this.noValue;
/*     */     }
/*     */ 
/*     */     public boolean isSingleValue() {
/* 850 */       return this.singleValue;
/*     */     }
/*     */ 
/*     */     public boolean isBetweenValue() {
/* 854 */       return this.betweenValue;
/*     */     }
/*     */ 
/*     */     public boolean isListValue() {
/* 858 */       return this.listValue;
/*     */     }
/*     */ 
/*     */     public String getTypeHandler() {
/* 862 */       return this.typeHandler;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition)
/*     */     {
/* 867 */       this.condition = condition;
/* 868 */       this.typeHandler = null;
/* 869 */       this.noValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, String typeHandler)
/*     */     {
/* 874 */       this.condition = condition;
/* 875 */       this.value = value;
/* 876 */       this.typeHandler = typeHandler;
/* 877 */       if ((value instanceof List))
/* 878 */         this.listValue = true;
/*     */       else
/* 880 */         this.singleValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value)
/*     */     {
/* 885 */       this(condition, value, null);
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/*     */     {
/* 890 */       this.condition = condition;
/* 891 */       this.value = value;
/* 892 */       this.secondValue = secondValue;
/* 893 */       this.typeHandler = typeHandler;
/* 894 */       this.betweenValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue) {
/* 898 */       this(condition, value, secondValue, null);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Criteria extends AdvertiseExample.GeneratedCriteria
/*     */   {
/*     */   }
/*     */ 
/*     */   protected static abstract class GeneratedCriteria
/*     */   {
/*     */     protected List<AdvertiseExample.Criterion> criteria;
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
/*     */     public List<AdvertiseExample.Criterion> getAllCriteria() {
/*  80 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     public List<AdvertiseExample.Criterion> getCriteria() {
/*  84 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition) {
/*  88 */       if (condition == null) {
/*  89 */         throw new RuntimeException("Value for condition cannot be null");
/*     */       }
/*  91 */       this.criteria.add(new AdvertiseExample.Criterion(condition));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value, String property) {
/*  95 */       if (value == null) {
/*  96 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*     */       }
/*  98 */       this.criteria.add(new AdvertiseExample.Criterion(condition, value));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value1, Object value2, String property) {
/* 102 */       if ((value1 == null) || (value2 == null)) {
/* 103 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*     */       }
/* 105 */       this.criteria.add(new AdvertiseExample.Criterion(condition, value1, value2));
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdIsNull() {
/* 109 */       addCriterion("id is null");
/* 110 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdIsNotNull() {
/* 114 */       addCriterion("id is not null");
/* 115 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdEqualTo(Long value) {
/* 119 */       addCriterion("id =", value, "id");
/* 120 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdNotEqualTo(Long value) {
/* 124 */       addCriterion("id <>", value, "id");
/* 125 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdGreaterThan(Long value) {
/* 129 */       addCriterion("id >", value, "id");
/* 130 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
/* 134 */       addCriterion("id >=", value, "id");
/* 135 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdLessThan(Long value) {
/* 139 */       addCriterion("id <", value, "id");
/* 140 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdLessThanOrEqualTo(Long value) {
/* 144 */       addCriterion("id <=", value, "id");
/* 145 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdIn(List<Long> values) {
/* 149 */       addCriterion("id in", values, "id");
/* 150 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdNotIn(List<Long> values) {
/* 154 */       addCriterion("id not in", values, "id");
/* 155 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdBetween(Long value1, Long value2) {
/* 159 */       addCriterion("id between", value1, value2, "id");
/* 160 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andIdNotBetween(Long value1, Long value2) {
/* 164 */       addCriterion("id not between", value1, value2, "id");
/* 165 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeIsNull() {
/* 169 */       addCriterion("addTime is null");
/* 170 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeIsNotNull() {
/* 174 */       addCriterion("addTime is not null");
/* 175 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeEqualTo(Date value) {
/* 179 */       addCriterion("addTime =", value, "addTime");
/* 180 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeNotEqualTo(Date value) {
/* 184 */       addCriterion("addTime <>", value, "addTime");
/* 185 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeGreaterThan(Date value) {
/* 189 */       addCriterion("addTime >", value, "addTime");
/* 190 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
/* 194 */       addCriterion("addTime >=", value, "addTime");
/* 195 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeLessThan(Date value) {
/* 199 */       addCriterion("addTime <", value, "addTime");
/* 200 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeLessThanOrEqualTo(Date value) {
/* 204 */       addCriterion("addTime <=", value, "addTime");
/* 205 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeIn(List<Date> values) {
/* 209 */       addCriterion("addTime in", values, "addTime");
/* 210 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeNotIn(List<Date> values) {
/* 214 */       addCriterion("addTime not in", values, "addTime");
/* 215 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeBetween(Date value1, Date value2) {
/* 219 */       addCriterion("addTime between", value1, value2, "addTime");
/* 220 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andAddTimeNotBetween(Date value1, Date value2) {
/* 224 */       addCriterion("addTime not between", value1, value2, "addTime");
/* 225 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusIsNull() {
/* 229 */       addCriterion("deleteStatus is null");
/* 230 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusIsNotNull() {
/* 234 */       addCriterion("deleteStatus is not null");
/* 235 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusEqualTo(Boolean value) {
/* 239 */       addCriterion("deleteStatus =", value, "deleteStatus");
/* 240 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusNotEqualTo(Boolean value) {
/* 244 */       addCriterion("deleteStatus <>", value, "deleteStatus");
/* 245 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusGreaterThan(Boolean value) {
/* 249 */       addCriterion("deleteStatus >", value, "deleteStatus");
/* 250 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
/* 254 */       addCriterion("deleteStatus >=", value, "deleteStatus");
/* 255 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusLessThan(Boolean value) {
/* 259 */       addCriterion("deleteStatus <", value, "deleteStatus");
/* 260 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
/* 264 */       addCriterion("deleteStatus <=", value, "deleteStatus");
/* 265 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusIn(List<Boolean> values) {
/* 269 */       addCriterion("deleteStatus in", values, "deleteStatus");
/* 270 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusNotIn(List<Boolean> values) {
/* 274 */       addCriterion("deleteStatus not in", values, "deleteStatus");
/* 275 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
/* 279 */       addCriterion("deleteStatus between", value1, value2, "deleteStatus");
/* 280 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
/* 284 */       addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
/* 285 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameIsNull() {
/* 289 */       addCriterion("name is null");
/* 290 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameIsNotNull() {
/* 294 */       addCriterion("name is not null");
/* 295 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameEqualTo(String value) {
/* 299 */       addCriterion("name =", value, "name");
/* 300 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameNotEqualTo(String value) {
/* 304 */       addCriterion("name <>", value, "name");
/* 305 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameGreaterThan(String value) {
/* 309 */       addCriterion("name >", value, "name");
/* 310 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameGreaterThanOrEqualTo(String value) {
/* 314 */       addCriterion("name >=", value, "name");
/* 315 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameLessThan(String value) {
/* 319 */       addCriterion("name <", value, "name");
/* 320 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameLessThanOrEqualTo(String value) {
/* 324 */       addCriterion("name <=", value, "name");
/* 325 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameLike(String value) {
/* 329 */       addCriterion("name like", value, "name");
/* 330 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameNotLike(String value) {
/* 334 */       addCriterion("name not like", value, "name");
/* 335 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameIn(List<String> values) {
/* 339 */       addCriterion("name in", values, "name");
/* 340 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameNotIn(List<String> values) {
/* 344 */       addCriterion("name not in", values, "name");
/* 345 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameBetween(String value1, String value2) {
/* 349 */       addCriterion("name between", value1, value2, "name");
/* 350 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andNameNotBetween(String value1, String value2) {
/* 354 */       addCriterion("name not between", value1, value2, "name");
/* 355 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkIsNull() {
/* 359 */       addCriterion("imgeLink is null");
/* 360 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkIsNotNull() {
/* 364 */       addCriterion("imgeLink is not null");
/* 365 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkEqualTo(String value) {
/* 369 */       addCriterion("imgeLink =", value, "imgeLink");
/* 370 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkNotEqualTo(String value) {
/* 374 */       addCriterion("imgeLink <>", value, "imgeLink");
/* 375 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkGreaterThan(String value) {
/* 379 */       addCriterion("imgeLink >", value, "imgeLink");
/* 380 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkGreaterThanOrEqualTo(String value) {
/* 384 */       addCriterion("imgeLink >=", value, "imgeLink");
/* 385 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkLessThan(String value) {
/* 389 */       addCriterion("imgeLink <", value, "imgeLink");
/* 390 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkLessThanOrEqualTo(String value) {
/* 394 */       addCriterion("imgeLink <=", value, "imgeLink");
/* 395 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkLike(String value) {
/* 399 */       addCriterion("imgeLink like", value, "imgeLink");
/* 400 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkNotLike(String value) {
/* 404 */       addCriterion("imgeLink not like", value, "imgeLink");
/* 405 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkIn(List<String> values) {
/* 409 */       addCriterion("imgeLink in", values, "imgeLink");
/* 410 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkNotIn(List<String> values) {
/* 414 */       addCriterion("imgeLink not in", values, "imgeLink");
/* 415 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkBetween(String value1, String value2) {
/* 419 */       addCriterion("imgeLink between", value1, value2, "imgeLink");
/* 420 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeLinkNotBetween(String value1, String value2) {
/* 424 */       addCriterion("imgeLink not between", value1, value2, "imgeLink");
/* 425 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlIsNull() {
/* 429 */       addCriterion("imgeUrl is null");
/* 430 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlIsNotNull() {
/* 434 */       addCriterion("imgeUrl is not null");
/* 435 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlEqualTo(String value) {
/* 439 */       addCriterion("imgeUrl =", value, "imgeUrl");
/* 440 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlNotEqualTo(String value) {
/* 444 */       addCriterion("imgeUrl <>", value, "imgeUrl");
/* 445 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlGreaterThan(String value) {
/* 449 */       addCriterion("imgeUrl >", value, "imgeUrl");
/* 450 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlGreaterThanOrEqualTo(String value) {
/* 454 */       addCriterion("imgeUrl >=", value, "imgeUrl");
/* 455 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlLessThan(String value) {
/* 459 */       addCriterion("imgeUrl <", value, "imgeUrl");
/* 460 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlLessThanOrEqualTo(String value) {
/* 464 */       addCriterion("imgeUrl <=", value, "imgeUrl");
/* 465 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlLike(String value) {
/* 469 */       addCriterion("imgeUrl like", value, "imgeUrl");
/* 470 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlNotLike(String value) {
/* 474 */       addCriterion("imgeUrl not like", value, "imgeUrl");
/* 475 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlIn(List<String> values) {
/* 479 */       addCriterion("imgeUrl in", values, "imgeUrl");
/* 480 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlNotIn(List<String> values) {
/* 484 */       addCriterion("imgeUrl not in", values, "imgeUrl");
/* 485 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlBetween(String value1, String value2) {
/* 489 */       addCriterion("imgeUrl between", value1, value2, "imgeUrl");
/* 490 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andImgeUrlNotBetween(String value1, String value2) {
/* 494 */       addCriterion("imgeUrl not between", value1, value2, "imgeUrl");
/* 495 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionIsNull() {
/* 499 */       addCriterion("position is null");
/* 500 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionIsNotNull() {
/* 504 */       addCriterion("position is not null");
/* 505 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionEqualTo(Integer value) {
/* 509 */       addCriterion("position =", value, "position");
/* 510 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionNotEqualTo(Integer value) {
/* 514 */       addCriterion("position <>", value, "position");
/* 515 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionGreaterThan(Integer value) {
/* 519 */       addCriterion("position >", value, "position");
/* 520 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionGreaterThanOrEqualTo(Integer value) {
/* 524 */       addCriterion("position >=", value, "position");
/* 525 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionLessThan(Integer value) {
/* 529 */       addCriterion("position <", value, "position");
/* 530 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionLessThanOrEqualTo(Integer value) {
/* 534 */       addCriterion("position <=", value, "position");
/* 535 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionIn(List<Integer> values) {
/* 539 */       addCriterion("position in", values, "position");
/* 540 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionNotIn(List<Integer> values) {
/* 544 */       addCriterion("position not in", values, "position");
/* 545 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionBetween(Integer value1, Integer value2) {
/* 549 */       addCriterion("position between", value1, value2, "position");
/* 550 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPositionNotBetween(Integer value1, Integer value2) {
/* 554 */       addCriterion("position not between", value1, value2, "position");
/* 555 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToIsNull() {
/* 559 */       addCriterion("belongTo is null");
/* 560 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToIsNotNull() {
/* 564 */       addCriterion("belongTo is not null");
/* 565 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToEqualTo(Integer value) {
/* 569 */       addCriterion("belongTo =", value, "belongTo");
/* 570 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToNotEqualTo(Integer value) {
/* 574 */       addCriterion("belongTo <>", value, "belongTo");
/* 575 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToGreaterThan(Integer value) {
/* 579 */       addCriterion("belongTo >", value, "belongTo");
/* 580 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToGreaterThanOrEqualTo(Integer value) {
/* 584 */       addCriterion("belongTo >=", value, "belongTo");
/* 585 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToLessThan(Integer value) {
/* 589 */       addCriterion("belongTo <", value, "belongTo");
/* 590 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToLessThanOrEqualTo(Integer value) {
/* 594 */       addCriterion("belongTo <=", value, "belongTo");
/* 595 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToIn(List<Integer> values) {
/* 599 */       addCriterion("belongTo in", values, "belongTo");
/* 600 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToNotIn(List<Integer> values) {
/* 604 */       addCriterion("belongTo not in", values, "belongTo");
/* 605 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToBetween(Integer value1, Integer value2) {
/* 609 */       addCriterion("belongTo between", value1, value2, "belongTo");
/* 610 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andBelongToNotBetween(Integer value1, Integer value2) {
/* 614 */       addCriterion("belongTo not between", value1, value2, "belongTo");
/* 615 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeIsNull() {
/* 619 */       addCriterion("updateTime is null");
/* 620 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeIsNotNull() {
/* 624 */       addCriterion("updateTime is not null");
/* 625 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeEqualTo(Date value) {
/* 629 */       addCriterion("updateTime =", value, "updateTime");
/* 630 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeNotEqualTo(Date value) {
/* 634 */       addCriterion("updateTime <>", value, "updateTime");
/* 635 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeGreaterThan(Date value) {
/* 639 */       addCriterion("updateTime >", value, "updateTime");
/* 640 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
/* 644 */       addCriterion("updateTime >=", value, "updateTime");
/* 645 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeLessThan(Date value) {
/* 649 */       addCriterion("updateTime <", value, "updateTime");
/* 650 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
/* 654 */       addCriterion("updateTime <=", value, "updateTime");
/* 655 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeIn(List<Date> values) {
/* 659 */       addCriterion("updateTime in", values, "updateTime");
/* 660 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeNotIn(List<Date> values) {
/* 664 */       addCriterion("updateTime not in", values, "updateTime");
/* 665 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
/* 669 */       addCriterion("updateTime between", value1, value2, "updateTime");
/* 670 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
/* 674 */       addCriterion("updateTime not between", value1, value2, "updateTime");
/* 675 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanIsNull() {
/* 679 */       addCriterion("plan is null");
/* 680 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanIsNotNull() {
/* 684 */       addCriterion("plan is not null");
/* 685 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanEqualTo(String value) {
/* 689 */       addCriterion("plan =", value, "plan");
/* 690 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanNotEqualTo(String value) {
/* 694 */       addCriterion("plan <>", value, "plan");
/* 695 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanGreaterThan(String value) {
/* 699 */       addCriterion("plan >", value, "plan");
/* 700 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanGreaterThanOrEqualTo(String value) {
/* 704 */       addCriterion("plan >=", value, "plan");
/* 705 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanLessThan(String value) {
/* 709 */       addCriterion("plan <", value, "plan");
/* 710 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanLessThanOrEqualTo(String value) {
/* 714 */       addCriterion("plan <=", value, "plan");
/* 715 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanLike(String value) {
/* 719 */       addCriterion("plan like", value, "plan");
/* 720 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanNotLike(String value) {
/* 724 */       addCriterion("plan not like", value, "plan");
/* 725 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanIn(List<String> values) {
/* 729 */       addCriterion("plan in", values, "plan");
/* 730 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanNotIn(List<String> values) {
/* 734 */       addCriterion("plan not in", values, "plan");
/* 735 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanBetween(String value1, String value2) {
/* 739 */       addCriterion("plan between", value1, value2, "plan");
/* 740 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andPlanNotBetween(String value1, String value2) {
/* 744 */       addCriterion("plan not between", value1, value2, "plan");
/* 745 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumIsNull() {
/* 749 */       addCriterion("orderNum is null");
/* 750 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumIsNotNull() {
/* 754 */       addCriterion("orderNum is not null");
/* 755 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumEqualTo(Integer value) {
/* 759 */       addCriterion("orderNum =", value, "orderNum");
/* 760 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumNotEqualTo(Integer value) {
/* 764 */       addCriterion("orderNum <>", value, "orderNum");
/* 765 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumGreaterThan(Integer value) {
/* 769 */       addCriterion("orderNum >", value, "orderNum");
/* 770 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
/* 774 */       addCriterion("orderNum >=", value, "orderNum");
/* 775 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumLessThan(Integer value) {
/* 779 */       addCriterion("orderNum <", value, "orderNum");
/* 780 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumLessThanOrEqualTo(Integer value) {
/* 784 */       addCriterion("orderNum <=", value, "orderNum");
/* 785 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumIn(List<Integer> values) {
/* 789 */       addCriterion("orderNum in", values, "orderNum");
/* 790 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumNotIn(List<Integer> values) {
/* 794 */       addCriterion("orderNum not in", values, "orderNum");
/* 795 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumBetween(Integer value1, Integer value2) {
/* 799 */       addCriterion("orderNum between", value1, value2, "orderNum");
/* 800 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public AdvertiseExample.Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
/* 804 */       addCriterion("orderNum not between", value1, value2, "orderNum");
/* 805 */       return (AdvertiseExample.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.advertise.AdvertiseExample
 * JD-Core Version:    0.6.2
 */
/*     */ package com.ifeng.bigtrade.cms.entites.article;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TypeAndModuleExample
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public TypeAndModuleExample()
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
/* 434 */       return this.condition;
/*     */     }
/*     */ 
/*     */     public Object getValue() {
/* 438 */       return this.value;
/*     */     }
/*     */ 
/*     */     public Object getSecondValue() {
/* 442 */       return this.secondValue;
/*     */     }
/*     */ 
/*     */     public boolean isNoValue() {
/* 446 */       return this.noValue;
/*     */     }
/*     */ 
/*     */     public boolean isSingleValue() {
/* 450 */       return this.singleValue;
/*     */     }
/*     */ 
/*     */     public boolean isBetweenValue() {
/* 454 */       return this.betweenValue;
/*     */     }
/*     */ 
/*     */     public boolean isListValue() {
/* 458 */       return this.listValue;
/*     */     }
/*     */ 
/*     */     public String getTypeHandler() {
/* 462 */       return this.typeHandler;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition)
/*     */     {
/* 467 */       this.condition = condition;
/* 468 */       this.typeHandler = null;
/* 469 */       this.noValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, String typeHandler)
/*     */     {
/* 474 */       this.condition = condition;
/* 475 */       this.value = value;
/* 476 */       this.typeHandler = typeHandler;
/* 477 */       if ((value instanceof List))
/* 478 */         this.listValue = true;
/*     */       else
/* 480 */         this.singleValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value)
/*     */     {
/* 485 */       this(condition, value, null);
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/*     */     {
/* 490 */       this.condition = condition;
/* 491 */       this.value = value;
/* 492 */       this.secondValue = secondValue;
/* 493 */       this.typeHandler = typeHandler;
/* 494 */       this.betweenValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue) {
/* 498 */       this(condition, value, secondValue, null);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Criteria extends TypeAndModuleExample.GeneratedCriteria
/*     */   {
/*     */   }
/*     */ 
/*     */   protected static abstract class GeneratedCriteria
/*     */   {
/*     */     protected List<TypeAndModuleExample.Criterion> criteria;
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
/*     */     public List<TypeAndModuleExample.Criterion> getAllCriteria() {
/*  80 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     public List<TypeAndModuleExample.Criterion> getCriteria() {
/*  84 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition) {
/*  88 */       if (condition == null) {
/*  89 */         throw new RuntimeException("Value for condition cannot be null");
/*     */       }
/*  91 */       this.criteria.add(new TypeAndModuleExample.Criterion(condition));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value, String property) {
/*  95 */       if (value == null) {
/*  96 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*     */       }
/*  98 */       this.criteria.add(new TypeAndModuleExample.Criterion(condition, value));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value1, Object value2, String property) {
/* 102 */       if ((value1 == null) || (value2 == null)) {
/* 103 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*     */       }
/* 105 */       this.criteria.add(new TypeAndModuleExample.Criterion(condition, value1, value2));
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdIsNull() {
/* 109 */       addCriterion("id is null");
/* 110 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdIsNotNull() {
/* 114 */       addCriterion("id is not null");
/* 115 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdEqualTo(Long value) {
/* 119 */       addCriterion("id =", value, "id");
/* 120 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdNotEqualTo(Long value) {
/* 124 */       addCriterion("id <>", value, "id");
/* 125 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdGreaterThan(Long value) {
/* 129 */       addCriterion("id >", value, "id");
/* 130 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
/* 134 */       addCriterion("id >=", value, "id");
/* 135 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdLessThan(Long value) {
/* 139 */       addCriterion("id <", value, "id");
/* 140 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdLessThanOrEqualTo(Long value) {
/* 144 */       addCriterion("id <=", value, "id");
/* 145 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdIn(List<Long> values) {
/* 149 */       addCriterion("id in", values, "id");
/* 150 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdNotIn(List<Long> values) {
/* 154 */       addCriterion("id not in", values, "id");
/* 155 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdBetween(Long value1, Long value2) {
/* 159 */       addCriterion("id between", value1, value2, "id");
/* 160 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andIdNotBetween(Long value1, Long value2) {
/* 164 */       addCriterion("id not between", value1, value2, "id");
/* 165 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeIsNull() {
/* 169 */       addCriterion("addTime is null");
/* 170 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeIsNotNull() {
/* 174 */       addCriterion("addTime is not null");
/* 175 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeEqualTo(Date value) {
/* 179 */       addCriterion("addTime =", value, "addTime");
/* 180 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeNotEqualTo(Date value) {
/* 184 */       addCriterion("addTime <>", value, "addTime");
/* 185 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeGreaterThan(Date value) {
/* 189 */       addCriterion("addTime >", value, "addTime");
/* 190 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
/* 194 */       addCriterion("addTime >=", value, "addTime");
/* 195 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeLessThan(Date value) {
/* 199 */       addCriterion("addTime <", value, "addTime");
/* 200 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeLessThanOrEqualTo(Date value) {
/* 204 */       addCriterion("addTime <=", value, "addTime");
/* 205 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeIn(List<Date> values) {
/* 209 */       addCriterion("addTime in", values, "addTime");
/* 210 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeNotIn(List<Date> values) {
/* 214 */       addCriterion("addTime not in", values, "addTime");
/* 215 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeBetween(Date value1, Date value2) {
/* 219 */       addCriterion("addTime between", value1, value2, "addTime");
/* 220 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andAddTimeNotBetween(Date value1, Date value2) {
/* 224 */       addCriterion("addTime not between", value1, value2, "addTime");
/* 225 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusIsNull() {
/* 229 */       addCriterion("deleteStatus is null");
/* 230 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusIsNotNull() {
/* 234 */       addCriterion("deleteStatus is not null");
/* 235 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusEqualTo(Boolean value) {
/* 239 */       addCriterion("deleteStatus =", value, "deleteStatus");
/* 240 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusNotEqualTo(Boolean value) {
/* 244 */       addCriterion("deleteStatus <>", value, "deleteStatus");
/* 245 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusGreaterThan(Boolean value) {
/* 249 */       addCriterion("deleteStatus >", value, "deleteStatus");
/* 250 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
/* 254 */       addCriterion("deleteStatus >=", value, "deleteStatus");
/* 255 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusLessThan(Boolean value) {
/* 259 */       addCriterion("deleteStatus <", value, "deleteStatus");
/* 260 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
/* 264 */       addCriterion("deleteStatus <=", value, "deleteStatus");
/* 265 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusIn(List<Boolean> values) {
/* 269 */       addCriterion("deleteStatus in", values, "deleteStatus");
/* 270 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusNotIn(List<Boolean> values) {
/* 274 */       addCriterion("deleteStatus not in", values, "deleteStatus");
/* 275 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
/* 279 */       addCriterion("deleteStatus between", value1, value2, "deleteStatus");
/* 280 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
/* 284 */       addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
/* 285 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdIsNull() {
/* 289 */       addCriterion("typeId is null");
/* 290 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdIsNotNull() {
/* 294 */       addCriterion("typeId is not null");
/* 295 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdEqualTo(Long value) {
/* 299 */       addCriterion("typeId =", value, "typeId");
/* 300 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdNotEqualTo(Long value) {
/* 304 */       addCriterion("typeId <>", value, "typeId");
/* 305 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdGreaterThan(Long value) {
/* 309 */       addCriterion("typeId >", value, "typeId");
/* 310 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
/* 314 */       addCriterion("typeId >=", value, "typeId");
/* 315 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdLessThan(Long value) {
/* 319 */       addCriterion("typeId <", value, "typeId");
/* 320 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdLessThanOrEqualTo(Long value) {
/* 324 */       addCriterion("typeId <=", value, "typeId");
/* 325 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdIn(List<Long> values) {
/* 329 */       addCriterion("typeId in", values, "typeId");
/* 330 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdNotIn(List<Long> values) {
/* 334 */       addCriterion("typeId not in", values, "typeId");
/* 335 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdBetween(Long value1, Long value2) {
/* 339 */       addCriterion("typeId between", value1, value2, "typeId");
/* 340 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andTypeIdNotBetween(Long value1, Long value2) {
/* 344 */       addCriterion("typeId not between", value1, value2, "typeId");
/* 345 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdIsNull() {
/* 349 */       addCriterion("moduleId is null");
/* 350 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdIsNotNull() {
/* 354 */       addCriterion("moduleId is not null");
/* 355 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdEqualTo(Long value) {
/* 359 */       addCriterion("moduleId =", value, "moduleId");
/* 360 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdNotEqualTo(Long value) {
/* 364 */       addCriterion("moduleId <>", value, "moduleId");
/* 365 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdGreaterThan(Long value) {
/* 369 */       addCriterion("moduleId >", value, "moduleId");
/* 370 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdGreaterThanOrEqualTo(Long value) {
/* 374 */       addCriterion("moduleId >=", value, "moduleId");
/* 375 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdLessThan(Long value) {
/* 379 */       addCriterion("moduleId <", value, "moduleId");
/* 380 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdLessThanOrEqualTo(Long value) {
/* 384 */       addCriterion("moduleId <=", value, "moduleId");
/* 385 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdIn(List<Long> values) {
/* 389 */       addCriterion("moduleId in", values, "moduleId");
/* 390 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdNotIn(List<Long> values) {
/* 394 */       addCriterion("moduleId not in", values, "moduleId");
/* 395 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdBetween(Long value1, Long value2) {
/* 399 */       addCriterion("moduleId between", value1, value2, "moduleId");
/* 400 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public TypeAndModuleExample.Criteria andModuleIdNotBetween(Long value1, Long value2) {
/* 404 */       addCriterion("moduleId not between", value1, value2, "moduleId");
/* 405 */       return (TypeAndModuleExample.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.article.TypeAndModuleExample
 * JD-Core Version:    0.6.2
 */
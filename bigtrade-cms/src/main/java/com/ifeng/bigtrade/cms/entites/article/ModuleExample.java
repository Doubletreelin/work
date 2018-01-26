/*     */ package com.ifeng.bigtrade.cms.entites.article;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ModuleExample
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public ModuleExample()
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
/* 384 */       return this.condition;
/*     */     }
/*     */ 
/*     */     public Object getValue() {
/* 388 */       return this.value;
/*     */     }
/*     */ 
/*     */     public Object getSecondValue() {
/* 392 */       return this.secondValue;
/*     */     }
/*     */ 
/*     */     public boolean isNoValue() {
/* 396 */       return this.noValue;
/*     */     }
/*     */ 
/*     */     public boolean isSingleValue() {
/* 400 */       return this.singleValue;
/*     */     }
/*     */ 
/*     */     public boolean isBetweenValue() {
/* 404 */       return this.betweenValue;
/*     */     }
/*     */ 
/*     */     public boolean isListValue() {
/* 408 */       return this.listValue;
/*     */     }
/*     */ 
/*     */     public String getTypeHandler() {
/* 412 */       return this.typeHandler;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition)
/*     */     {
/* 417 */       this.condition = condition;
/* 418 */       this.typeHandler = null;
/* 419 */       this.noValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, String typeHandler)
/*     */     {
/* 424 */       this.condition = condition;
/* 425 */       this.value = value;
/* 426 */       this.typeHandler = typeHandler;
/* 427 */       if ((value instanceof List))
/* 428 */         this.listValue = true;
/*     */       else
/* 430 */         this.singleValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value)
/*     */     {
/* 435 */       this(condition, value, null);
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/*     */     {
/* 440 */       this.condition = condition;
/* 441 */       this.value = value;
/* 442 */       this.secondValue = secondValue;
/* 443 */       this.typeHandler = typeHandler;
/* 444 */       this.betweenValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue) {
/* 448 */       this(condition, value, secondValue, null);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Criteria extends ModuleExample.GeneratedCriteria
/*     */   {
/*     */   }
/*     */ 
/*     */   protected static abstract class GeneratedCriteria
/*     */   {
/*     */     protected List<ModuleExample.Criterion> criteria;
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
/*     */     public List<ModuleExample.Criterion> getAllCriteria() {
/*  80 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     public List<ModuleExample.Criterion> getCriteria() {
/*  84 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition) {
/*  88 */       if (condition == null) {
/*  89 */         throw new RuntimeException("Value for condition cannot be null");
/*     */       }
/*  91 */       this.criteria.add(new ModuleExample.Criterion(condition));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value, String property) {
/*  95 */       if (value == null) {
/*  96 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*     */       }
/*  98 */       this.criteria.add(new ModuleExample.Criterion(condition, value));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value1, Object value2, String property) {
/* 102 */       if ((value1 == null) || (value2 == null)) {
/* 103 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*     */       }
/* 105 */       this.criteria.add(new ModuleExample.Criterion(condition, value1, value2));
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdIsNull() {
/* 109 */       addCriterion("id is null");
/* 110 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdIsNotNull() {
/* 114 */       addCriterion("id is not null");
/* 115 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdEqualTo(Long value) {
/* 119 */       addCriterion("id =", value, "id");
/* 120 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdNotEqualTo(Long value) {
/* 124 */       addCriterion("id <>", value, "id");
/* 125 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdGreaterThan(Long value) {
/* 129 */       addCriterion("id >", value, "id");
/* 130 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
/* 134 */       addCriterion("id >=", value, "id");
/* 135 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdLessThan(Long value) {
/* 139 */       addCriterion("id <", value, "id");
/* 140 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdLessThanOrEqualTo(Long value) {
/* 144 */       addCriterion("id <=", value, "id");
/* 145 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdIn(List<Long> values) {
/* 149 */       addCriterion("id in", values, "id");
/* 150 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdNotIn(List<Long> values) {
/* 154 */       addCriterion("id not in", values, "id");
/* 155 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdBetween(Long value1, Long value2) {
/* 159 */       addCriterion("id between", value1, value2, "id");
/* 160 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andIdNotBetween(Long value1, Long value2) {
/* 164 */       addCriterion("id not between", value1, value2, "id");
/* 165 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeIsNull() {
/* 169 */       addCriterion("addTime is null");
/* 170 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeIsNotNull() {
/* 174 */       addCriterion("addTime is not null");
/* 175 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeEqualTo(Date value) {
/* 179 */       addCriterion("addTime =", value, "addTime");
/* 180 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeNotEqualTo(Date value) {
/* 184 */       addCriterion("addTime <>", value, "addTime");
/* 185 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeGreaterThan(Date value) {
/* 189 */       addCriterion("addTime >", value, "addTime");
/* 190 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
/* 194 */       addCriterion("addTime >=", value, "addTime");
/* 195 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeLessThan(Date value) {
/* 199 */       addCriterion("addTime <", value, "addTime");
/* 200 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeLessThanOrEqualTo(Date value) {
/* 204 */       addCriterion("addTime <=", value, "addTime");
/* 205 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeIn(List<Date> values) {
/* 209 */       addCriterion("addTime in", values, "addTime");
/* 210 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeNotIn(List<Date> values) {
/* 214 */       addCriterion("addTime not in", values, "addTime");
/* 215 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeBetween(Date value1, Date value2) {
/* 219 */       addCriterion("addTime between", value1, value2, "addTime");
/* 220 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andAddTimeNotBetween(Date value1, Date value2) {
/* 224 */       addCriterion("addTime not between", value1, value2, "addTime");
/* 225 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusIsNull() {
/* 229 */       addCriterion("deleteStatus is null");
/* 230 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusIsNotNull() {
/* 234 */       addCriterion("deleteStatus is not null");
/* 235 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusEqualTo(Boolean value) {
/* 239 */       addCriterion("deleteStatus =", value, "deleteStatus");
/* 240 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusNotEqualTo(Boolean value) {
/* 244 */       addCriterion("deleteStatus <>", value, "deleteStatus");
/* 245 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusGreaterThan(Boolean value) {
/* 249 */       addCriterion("deleteStatus >", value, "deleteStatus");
/* 250 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
/* 254 */       addCriterion("deleteStatus >=", value, "deleteStatus");
/* 255 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusLessThan(Boolean value) {
/* 259 */       addCriterion("deleteStatus <", value, "deleteStatus");
/* 260 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
/* 264 */       addCriterion("deleteStatus <=", value, "deleteStatus");
/* 265 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusIn(List<Boolean> values) {
/* 269 */       addCriterion("deleteStatus in", values, "deleteStatus");
/* 270 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusNotIn(List<Boolean> values) {
/* 274 */       addCriterion("deleteStatus not in", values, "deleteStatus");
/* 275 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
/* 279 */       addCriterion("deleteStatus between", value1, value2, "deleteStatus");
/* 280 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
/* 284 */       addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
/* 285 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameIsNull() {
/* 289 */       addCriterion("name is null");
/* 290 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameIsNotNull() {
/* 294 */       addCriterion("name is not null");
/* 295 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameEqualTo(String value) {
/* 299 */       addCriterion("name =", value, "name");
/* 300 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameNotEqualTo(String value) {
/* 304 */       addCriterion("name <>", value, "name");
/* 305 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameGreaterThan(String value) {
/* 309 */       addCriterion("name >", value, "name");
/* 310 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameGreaterThanOrEqualTo(String value) {
/* 314 */       addCriterion("name >=", value, "name");
/* 315 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameLessThan(String value) {
/* 319 */       addCriterion("name <", value, "name");
/* 320 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameLessThanOrEqualTo(String value) {
/* 324 */       addCriterion("name <=", value, "name");
/* 325 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameLike(String value) {
/* 329 */       addCriterion("name like", value, "name");
/* 330 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameNotLike(String value) {
/* 334 */       addCriterion("name not like", value, "name");
/* 335 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameIn(List<String> values) {
/* 339 */       addCriterion("name in", values, "name");
/* 340 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameNotIn(List<String> values) {
/* 344 */       addCriterion("name not in", values, "name");
/* 345 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameBetween(String value1, String value2) {
/* 349 */       addCriterion("name between", value1, value2, "name");
/* 350 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ModuleExample.Criteria andNameNotBetween(String value1, String value2) {
/* 354 */       addCriterion("name not between", value1, value2, "name");
/* 355 */       return (ModuleExample.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.article.ModuleExample
 * JD-Core Version:    0.6.2
 */
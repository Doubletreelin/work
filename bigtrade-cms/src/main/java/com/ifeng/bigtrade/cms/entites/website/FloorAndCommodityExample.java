/*     */ package com.ifeng.bigtrade.cms.entites.website;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class FloorAndCommodityExample
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public FloorAndCommodityExample()
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
/*     */   public static class Criteria extends FloorAndCommodityExample.GeneratedCriteria
/*     */   {
/*     */   }
/*     */ 
/*     */   protected static abstract class GeneratedCriteria
/*     */   {
/*     */     protected List<FloorAndCommodityExample.Criterion> criteria;
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
/*     */     public List<FloorAndCommodityExample.Criterion> getAllCriteria() {
/*  80 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     public List<FloorAndCommodityExample.Criterion> getCriteria() {
/*  84 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition) {
/*  88 */       if (condition == null) {
/*  89 */         throw new RuntimeException("Value for condition cannot be null");
/*     */       }
/*  91 */       this.criteria.add(new FloorAndCommodityExample.Criterion(condition));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value, String property) {
/*  95 */       if (value == null) {
/*  96 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*     */       }
/*  98 */       this.criteria.add(new FloorAndCommodityExample.Criterion(condition, value));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value1, Object value2, String property) {
/* 102 */       if ((value1 == null) || (value2 == null)) {
/* 103 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*     */       }
/* 105 */       this.criteria.add(new FloorAndCommodityExample.Criterion(condition, value1, value2));
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdIsNull() {
/* 109 */       addCriterion("id is null");
/* 110 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdIsNotNull() {
/* 114 */       addCriterion("id is not null");
/* 115 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdEqualTo(Long value) {
/* 119 */       addCriterion("id =", value, "id");
/* 120 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdNotEqualTo(Long value) {
/* 124 */       addCriterion("id <>", value, "id");
/* 125 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdGreaterThan(Long value) {
/* 129 */       addCriterion("id >", value, "id");
/* 130 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
/* 134 */       addCriterion("id >=", value, "id");
/* 135 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdLessThan(Long value) {
/* 139 */       addCriterion("id <", value, "id");
/* 140 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdLessThanOrEqualTo(Long value) {
/* 144 */       addCriterion("id <=", value, "id");
/* 145 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdIn(List<Long> values) {
/* 149 */       addCriterion("id in", values, "id");
/* 150 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdNotIn(List<Long> values) {
/* 154 */       addCriterion("id not in", values, "id");
/* 155 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdBetween(Long value1, Long value2) {
/* 159 */       addCriterion("id between", value1, value2, "id");
/* 160 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andIdNotBetween(Long value1, Long value2) {
/* 164 */       addCriterion("id not between", value1, value2, "id");
/* 165 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdIsNull() {
/* 169 */       addCriterion("floorId is null");
/* 170 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdIsNotNull() {
/* 174 */       addCriterion("floorId is not null");
/* 175 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdEqualTo(Long value) {
/* 179 */       addCriterion("floorId =", value, "floorId");
/* 180 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdNotEqualTo(Long value) {
/* 184 */       addCriterion("floorId <>", value, "floorId");
/* 185 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdGreaterThan(Long value) {
/* 189 */       addCriterion("floorId >", value, "floorId");
/* 190 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
/* 194 */       addCriterion("floorId >=", value, "floorId");
/* 195 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdLessThan(Long value) {
/* 199 */       addCriterion("floorId <", value, "floorId");
/* 200 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
/* 204 */       addCriterion("floorId <=", value, "floorId");
/* 205 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdIn(List<Long> values) {
/* 209 */       addCriterion("floorId in", values, "floorId");
/* 210 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdNotIn(List<Long> values) {
/* 214 */       addCriterion("floorId not in", values, "floorId");
/* 215 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdBetween(Long value1, Long value2) {
/* 219 */       addCriterion("floorId between", value1, value2, "floorId");
/* 220 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
/* 224 */       addCriterion("floorId not between", value1, value2, "floorId");
/* 225 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdIsNull() {
/* 229 */       addCriterion("commodityId is null");
/* 230 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdIsNotNull() {
/* 234 */       addCriterion("commodityId is not null");
/* 235 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdEqualTo(Long value) {
/* 239 */       addCriterion("commodityId =", value, "commodityId");
/* 240 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdNotEqualTo(Long value) {
/* 244 */       addCriterion("commodityId <>", value, "commodityId");
/* 245 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdGreaterThan(Long value) {
/* 249 */       addCriterion("commodityId >", value, "commodityId");
/* 250 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdGreaterThanOrEqualTo(Long value) {
/* 254 */       addCriterion("commodityId >=", value, "commodityId");
/* 255 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdLessThan(Long value) {
/* 259 */       addCriterion("commodityId <", value, "commodityId");
/* 260 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdLessThanOrEqualTo(Long value) {
/* 264 */       addCriterion("commodityId <=", value, "commodityId");
/* 265 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdIn(List<Long> values) {
/* 269 */       addCriterion("commodityId in", values, "commodityId");
/* 270 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdNotIn(List<Long> values) {
/* 274 */       addCriterion("commodityId not in", values, "commodityId");
/* 275 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdBetween(Long value1, Long value2) {
/* 279 */       addCriterion("commodityId between", value1, value2, "commodityId");
/* 280 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andCommodityIdNotBetween(Long value1, Long value2) {
/* 284 */       addCriterion("commodityId not between", value1, value2, "commodityId");
/* 285 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeIsNull() {
/* 289 */       addCriterion("addTime is null");
/* 290 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeIsNotNull() {
/* 294 */       addCriterion("addTime is not null");
/* 295 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeEqualTo(Date value) {
/* 299 */       addCriterion("addTime =", value, "addTime");
/* 300 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeNotEqualTo(Date value) {
/* 304 */       addCriterion("addTime <>", value, "addTime");
/* 305 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeGreaterThan(Date value) {
/* 309 */       addCriterion("addTime >", value, "addTime");
/* 310 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
/* 314 */       addCriterion("addTime >=", value, "addTime");
/* 315 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeLessThan(Date value) {
/* 319 */       addCriterion("addTime <", value, "addTime");
/* 320 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeLessThanOrEqualTo(Date value) {
/* 324 */       addCriterion("addTime <=", value, "addTime");
/* 325 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeIn(List<Date> values) {
/* 329 */       addCriterion("addTime in", values, "addTime");
/* 330 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeNotIn(List<Date> values) {
/* 334 */       addCriterion("addTime not in", values, "addTime");
/* 335 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeBetween(Date value1, Date value2) {
/* 339 */       addCriterion("addTime between", value1, value2, "addTime");
/* 340 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andAddTimeNotBetween(Date value1, Date value2) {
/* 344 */       addCriterion("addTime not between", value1, value2, "addTime");
/* 345 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusIsNull() {
/* 349 */       addCriterion("deleteStatus is null");
/* 350 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusIsNotNull() {
/* 354 */       addCriterion("deleteStatus is not null");
/* 355 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusEqualTo(Boolean value) {
/* 359 */       addCriterion("deleteStatus =", value, "deleteStatus");
/* 360 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusNotEqualTo(Boolean value) {
/* 364 */       addCriterion("deleteStatus <>", value, "deleteStatus");
/* 365 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusGreaterThan(Boolean value) {
/* 369 */       addCriterion("deleteStatus >", value, "deleteStatus");
/* 370 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
/* 374 */       addCriterion("deleteStatus >=", value, "deleteStatus");
/* 375 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusLessThan(Boolean value) {
/* 379 */       addCriterion("deleteStatus <", value, "deleteStatus");
/* 380 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
/* 384 */       addCriterion("deleteStatus <=", value, "deleteStatus");
/* 385 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusIn(List<Boolean> values) {
/* 389 */       addCriterion("deleteStatus in", values, "deleteStatus");
/* 390 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusNotIn(List<Boolean> values) {
/* 394 */       addCriterion("deleteStatus not in", values, "deleteStatus");
/* 395 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
/* 399 */       addCriterion("deleteStatus between", value1, value2, "deleteStatus");
/* 400 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FloorAndCommodityExample.Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
/* 404 */       addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
/* 405 */       return (FloorAndCommodityExample.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.website.FloorAndCommodityExample
 * JD-Core Version:    0.6.2
 */
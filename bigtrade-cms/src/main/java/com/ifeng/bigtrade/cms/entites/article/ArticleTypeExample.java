/*     */ package com.ifeng.bigtrade.cms.entites.article;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ArticleTypeExample
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public ArticleTypeExample()
/*     */   {
/*  17 */     this.oredCriteria = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void setOrderByClause(String orderByClause)
/*     */   {
/*  22 */     this.orderByClause = orderByClause;
/*     */   }
/*     */ 
/*     */   public String getOrderByClause()
/*     */   {
/*  27 */     return this.orderByClause;
/*     */   }
/*     */ 
/*     */   public void setDistinct(boolean distinct)
/*     */   {
/*  32 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   public boolean isDistinct()
/*     */   {
/*  37 */     return this.distinct;
/*     */   }
/*     */ 
/*     */   public List<Criteria> getOredCriteria()
/*     */   {
/*  42 */     return this.oredCriteria;
/*     */   }
/*     */ 
/*     */   public void or(Criteria criteria)
/*     */   {
/*  47 */     this.oredCriteria.add(criteria);
/*     */   }
/*     */ 
/*     */   public Criteria or()
/*     */   {
/*  52 */     Criteria criteria = createCriteriaInternal();
/*  53 */     this.oredCriteria.add(criteria);
/*  54 */     return criteria;
/*     */   }
/*     */ 
/*     */   public Criteria createCriteria()
/*     */   {
/*  59 */     Criteria criteria = createCriteriaInternal();
/*  60 */     if (this.oredCriteria.size() == 0)
/*     */     {
/*  62 */       this.oredCriteria.add(criteria);
/*     */     }
/*  64 */     return criteria;
/*     */   }
/*     */ 
/*     */   protected Criteria createCriteriaInternal()
/*     */   {
/*  69 */     Criteria criteria = new Criteria();
/*  70 */     return criteria;
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/*  75 */     this.oredCriteria.clear();
/*  76 */     this.orderByClause = null;
/*  77 */     this.distinct = false;
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
/* 606 */       return this.condition;
/*     */     }
/*     */ 
/*     */     public Object getValue()
/*     */     {
/* 611 */       return this.value;
/*     */     }
/*     */ 
/*     */     public Object getSecondValue()
/*     */     {
/* 616 */       return this.secondValue;
/*     */     }
/*     */ 
/*     */     public boolean isNoValue()
/*     */     {
/* 621 */       return this.noValue;
/*     */     }
/*     */ 
/*     */     public boolean isSingleValue()
/*     */     {
/* 626 */       return this.singleValue;
/*     */     }
/*     */ 
/*     */     public boolean isBetweenValue()
/*     */     {
/* 631 */       return this.betweenValue;
/*     */     }
/*     */ 
/*     */     public boolean isListValue()
/*     */     {
/* 636 */       return this.listValue;
/*     */     }
/*     */ 
/*     */     public String getTypeHandler()
/*     */     {
/* 641 */       return this.typeHandler;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition)
/*     */     {
/* 647 */       this.condition = condition;
/* 648 */       this.typeHandler = null;
/* 649 */       this.noValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, String typeHandler)
/*     */     {
/* 655 */       this.condition = condition;
/* 656 */       this.value = value;
/* 657 */       this.typeHandler = typeHandler;
/* 658 */       if ((value instanceof List))
/*     */       {
/* 660 */         this.listValue = true;
/*     */       }
/*     */       else
/* 663 */         this.singleValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value)
/*     */     {
/* 669 */       this(condition, value, null);
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/*     */     {
/* 675 */       this.condition = condition;
/* 676 */       this.value = value;
/* 677 */       this.secondValue = secondValue;
/* 678 */       this.typeHandler = typeHandler;
/* 679 */       this.betweenValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue)
/*     */     {
/* 684 */       this(condition, value, secondValue, null);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Criteria extends ArticleTypeExample.GeneratedCriteria
/*     */   {
/*     */   }
/*     */ 
/*     */   protected static abstract class GeneratedCriteria
/*     */   {
/*     */     protected List<ArticleTypeExample.Criterion> criteria;
/*     */ 
/*     */     protected GeneratedCriteria()
/*     */     {
/*  87 */       this.criteria = new ArrayList();
/*     */     }
/*     */ 
/*     */     public boolean isValid()
/*     */     {
/*  92 */       return this.criteria.size() > 0;
/*     */     }
/*     */ 
/*     */     public List<ArticleTypeExample.Criterion> getAllCriteria()
/*     */     {
/*  97 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     public List<ArticleTypeExample.Criterion> getCriteria()
/*     */     {
/* 102 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition)
/*     */     {
/* 107 */       if (condition == null)
/*     */       {
/* 109 */         throw new RuntimeException("Value for condition cannot be null");
/*     */       }
/* 111 */       this.criteria.add(new ArticleTypeExample.Criterion(condition));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value, String property)
/*     */     {
/* 116 */       if (value == null)
/*     */       {
/* 118 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*     */       }
/* 120 */       this.criteria.add(new ArticleTypeExample.Criterion(condition, value));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value1, Object value2, String property)
/*     */     {
/* 125 */       if ((value1 == null) || (value2 == null))
/*     */       {
/* 127 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*     */       }
/* 129 */       this.criteria.add(new ArticleTypeExample.Criterion(condition, value1, value2));
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdIsNull()
/*     */     {
/* 134 */       addCriterion("id is null");
/* 135 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdIsNotNull()
/*     */     {
/* 140 */       addCriterion("id is not null");
/* 141 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdEqualTo(Long value)
/*     */     {
/* 146 */       addCriterion("id =", value, "id");
/* 147 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdNotEqualTo(Long value)
/*     */     {
/* 152 */       addCriterion("id <>", value, "id");
/* 153 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdGreaterThan(Long value)
/*     */     {
/* 158 */       addCriterion("id >", value, "id");
/* 159 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdGreaterThanOrEqualTo(Long value)
/*     */     {
/* 164 */       addCriterion("id >=", value, "id");
/* 165 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdLessThan(Long value)
/*     */     {
/* 170 */       addCriterion("id <", value, "id");
/* 171 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdLessThanOrEqualTo(Long value)
/*     */     {
/* 176 */       addCriterion("id <=", value, "id");
/* 177 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdIn(List<Long> values)
/*     */     {
/* 182 */       addCriterion("id in", values, "id");
/* 183 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdNotIn(List<Long> values)
/*     */     {
/* 188 */       addCriterion("id not in", values, "id");
/* 189 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdBetween(Long value1, Long value2)
/*     */     {
/* 194 */       addCriterion("id between", value1, value2, "id");
/* 195 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andIdNotBetween(Long value1, Long value2)
/*     */     {
/* 200 */       addCriterion("id not between", value1, value2, "id");
/* 201 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeIsNull()
/*     */     {
/* 206 */       addCriterion("addTime is null");
/* 207 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeIsNotNull()
/*     */     {
/* 212 */       addCriterion("addTime is not null");
/* 213 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeEqualTo(Date value)
/*     */     {
/* 218 */       addCriterion("addTime =", value, "addTime");
/* 219 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeNotEqualTo(Date value)
/*     */     {
/* 224 */       addCriterion("addTime <>", value, "addTime");
/* 225 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeGreaterThan(Date value)
/*     */     {
/* 230 */       addCriterion("addTime >", value, "addTime");
/* 231 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeGreaterThanOrEqualTo(Date value)
/*     */     {
/* 236 */       addCriterion("addTime >=", value, "addTime");
/* 237 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeLessThan(Date value)
/*     */     {
/* 242 */       addCriterion("addTime <", value, "addTime");
/* 243 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeLessThanOrEqualTo(Date value)
/*     */     {
/* 248 */       addCriterion("addTime <=", value, "addTime");
/* 249 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeIn(List<Date> values)
/*     */     {
/* 254 */       addCriterion("addTime in", values, "addTime");
/* 255 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeNotIn(List<Date> values)
/*     */     {
/* 260 */       addCriterion("addTime not in", values, "addTime");
/* 261 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeBetween(Date value1, Date value2)
/*     */     {
/* 266 */       addCriterion("addTime between", value1, value2, "addTime");
/* 267 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andAddTimeNotBetween(Date value1, Date value2)
/*     */     {
/* 272 */       addCriterion("addTime not between", value1, value2, "addTime");
/* 273 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusIsNull()
/*     */     {
/* 278 */       addCriterion("deleteStatus is null");
/* 279 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusIsNotNull()
/*     */     {
/* 284 */       addCriterion("deleteStatus is not null");
/* 285 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusEqualTo(Boolean value)
/*     */     {
/* 290 */       addCriterion("deleteStatus =", value, "deleteStatus");
/* 291 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusNotEqualTo(Boolean value)
/*     */     {
/* 296 */       addCriterion("deleteStatus <>", value, "deleteStatus");
/* 297 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusGreaterThan(Boolean value)
/*     */     {
/* 302 */       addCriterion("deleteStatus >", value, "deleteStatus");
/* 303 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value)
/*     */     {
/* 308 */       addCriterion("deleteStatus >=", value, "deleteStatus");
/* 309 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusLessThan(Boolean value)
/*     */     {
/* 314 */       addCriterion("deleteStatus <", value, "deleteStatus");
/* 315 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusLessThanOrEqualTo(Boolean value)
/*     */     {
/* 320 */       addCriterion("deleteStatus <=", value, "deleteStatus");
/* 321 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusIn(List<Boolean> values)
/*     */     {
/* 326 */       addCriterion("deleteStatus in", values, "deleteStatus");
/* 327 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusNotIn(List<Boolean> values)
/*     */     {
/* 332 */       addCriterion("deleteStatus not in", values, "deleteStatus");
/* 333 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusBetween(Boolean value1, Boolean value2)
/*     */     {
/* 338 */       addCriterion("deleteStatus between", value1, value2, "deleteStatus");
/* 339 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2)
/*     */     {
/* 344 */       addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
/* 345 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameIsNull()
/*     */     {
/* 350 */       addCriterion("name is null");
/* 351 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameIsNotNull()
/*     */     {
/* 356 */       addCriterion("name is not null");
/* 357 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameEqualTo(String value)
/*     */     {
/* 362 */       addCriterion("name =", value, "name");
/* 363 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameNotEqualTo(String value)
/*     */     {
/* 368 */       addCriterion("name <>", value, "name");
/* 369 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameGreaterThan(String value)
/*     */     {
/* 374 */       addCriterion("name >", value, "name");
/* 375 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameGreaterThanOrEqualTo(String value)
/*     */     {
/* 380 */       addCriterion("name >=", value, "name");
/* 381 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameLessThan(String value)
/*     */     {
/* 386 */       addCriterion("name <", value, "name");
/* 387 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameLessThanOrEqualTo(String value)
/*     */     {
/* 392 */       addCriterion("name <=", value, "name");
/* 393 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameLike(String value)
/*     */     {
/* 398 */       addCriterion("name like", value, "name");
/* 399 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameNotLike(String value)
/*     */     {
/* 404 */       addCriterion("name not like", value, "name");
/* 405 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameIn(List<String> values)
/*     */     {
/* 410 */       addCriterion("name in", values, "name");
/* 411 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameNotIn(List<String> values)
/*     */     {
/* 416 */       addCriterion("name not in", values, "name");
/* 417 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameBetween(String value1, String value2)
/*     */     {
/* 422 */       addCriterion("name between", value1, value2, "name");
/* 423 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andNameNotBetween(String value1, String value2)
/*     */     {
/* 428 */       addCriterion("name not between", value1, value2, "name");
/* 429 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdIsNull()
/*     */     {
/* 434 */       addCriterion("parentId is null");
/* 435 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdIsNotNull()
/*     */     {
/* 440 */       addCriterion("parentId is not null");
/* 441 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdEqualTo(Long value)
/*     */     {
/* 446 */       addCriterion("parentId =", value, "parentId");
/* 447 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdNotEqualTo(Long value)
/*     */     {
/* 452 */       addCriterion("parentId <>", value, "parentId");
/* 453 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdGreaterThan(Long value)
/*     */     {
/* 458 */       addCriterion("parentId >", value, "parentId");
/* 459 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdGreaterThanOrEqualTo(Long value)
/*     */     {
/* 464 */       addCriterion("parentId >=", value, "parentId");
/* 465 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdLessThan(Long value)
/*     */     {
/* 470 */       addCriterion("parentId <", value, "parentId");
/* 471 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdLessThanOrEqualTo(Long value)
/*     */     {
/* 476 */       addCriterion("parentId <=", value, "parentId");
/* 477 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdIn(List<Long> values)
/*     */     {
/* 482 */       addCriterion("parentId in", values, "parentId");
/* 483 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdNotIn(List<Long> values)
/*     */     {
/* 488 */       addCriterion("parentId not in", values, "parentId");
/* 489 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdBetween(Long value1, Long value2)
/*     */     {
/* 494 */       addCriterion("parentId between", value1, value2, "parentId");
/* 495 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andParentIdNotBetween(Long value1, Long value2)
/*     */     {
/* 500 */       addCriterion("parentId not between", value1, value2, "parentId");
/* 501 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelIsNull()
/*     */     {
/* 506 */       addCriterion("level is null");
/* 507 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelIsNotNull()
/*     */     {
/* 512 */       addCriterion("level is not null");
/* 513 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelEqualTo(Integer value)
/*     */     {
/* 518 */       addCriterion("level =", value, "level");
/* 519 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelNotEqualTo(Integer value)
/*     */     {
/* 524 */       addCriterion("level <>", value, "level");
/* 525 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelGreaterThan(Integer value)
/*     */     {
/* 530 */       addCriterion("level >", value, "level");
/* 531 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelGreaterThanOrEqualTo(Integer value)
/*     */     {
/* 536 */       addCriterion("level >=", value, "level");
/* 537 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelLessThan(Integer value)
/*     */     {
/* 542 */       addCriterion("level <", value, "level");
/* 543 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelLessThanOrEqualTo(Integer value)
/*     */     {
/* 548 */       addCriterion("level <=", value, "level");
/* 549 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelIn(List<Integer> values)
/*     */     {
/* 554 */       addCriterion("level in", values, "level");
/* 555 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelNotIn(List<Integer> values)
/*     */     {
/* 560 */       addCriterion("level not in", values, "level");
/* 561 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelBetween(Integer value1, Integer value2)
/*     */     {
/* 566 */       addCriterion("level between", value1, value2, "level");
/* 567 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public ArticleTypeExample.Criteria andLevelNotBetween(Integer value1, Integer value2)
/*     */     {
/* 572 */       addCriterion("level not between", value1, value2, "level");
/* 573 */       return (ArticleTypeExample.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.article.ArticleTypeExample
 * JD-Core Version:    0.6.2
 */
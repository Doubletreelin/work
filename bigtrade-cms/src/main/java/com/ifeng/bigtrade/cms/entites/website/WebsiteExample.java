/*     */ package com.ifeng.bigtrade.cms.entites.website;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WebsiteExample
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public WebsiteExample()
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
/* 630 */       return this.condition;
/*     */     }
/*     */ 
/*     */     public Object getValue()
/*     */     {
/* 635 */       return this.value;
/*     */     }
/*     */ 
/*     */     public Object getSecondValue()
/*     */     {
/* 640 */       return this.secondValue;
/*     */     }
/*     */ 
/*     */     public boolean isNoValue()
/*     */     {
/* 645 */       return this.noValue;
/*     */     }
/*     */ 
/*     */     public boolean isSingleValue()
/*     */     {
/* 650 */       return this.singleValue;
/*     */     }
/*     */ 
/*     */     public boolean isBetweenValue()
/*     */     {
/* 655 */       return this.betweenValue;
/*     */     }
/*     */ 
/*     */     public boolean isListValue()
/*     */     {
/* 660 */       return this.listValue;
/*     */     }
/*     */ 
/*     */     public String getTypeHandler()
/*     */     {
/* 665 */       return this.typeHandler;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition)
/*     */     {
/* 671 */       this.condition = condition;
/* 672 */       this.typeHandler = null;
/* 673 */       this.noValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, String typeHandler)
/*     */     {
/* 679 */       this.condition = condition;
/* 680 */       this.value = value;
/* 681 */       this.typeHandler = typeHandler;
/* 682 */       if ((value instanceof List))
/*     */       {
/* 684 */         this.listValue = true;
/*     */       }
/*     */       else
/* 687 */         this.singleValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value)
/*     */     {
/* 693 */       this(condition, value, null);
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/*     */     {
/* 699 */       this.condition = condition;
/* 700 */       this.value = value;
/* 701 */       this.secondValue = secondValue;
/* 702 */       this.typeHandler = typeHandler;
/* 703 */       this.betweenValue = true;
/*     */     }
/*     */ 
/*     */     protected Criterion(String condition, Object value, Object secondValue)
/*     */     {
/* 708 */       this(condition, value, secondValue, null);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Criteria extends WebsiteExample.GeneratedCriteria
/*     */   {
/*     */   }
/*     */ 
/*     */   protected static abstract class GeneratedCriteria
/*     */   {
/*     */     protected List<WebsiteExample.Criterion> criteria;
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
/*     */     public List<WebsiteExample.Criterion> getAllCriteria()
/*     */     {
/*  97 */       return this.criteria;
/*     */     }
/*     */ 
/*     */     public List<WebsiteExample.Criterion> getCriteria()
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
/* 111 */       this.criteria.add(new WebsiteExample.Criterion(condition));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value, String property)
/*     */     {
/* 116 */       if (value == null)
/*     */       {
/* 118 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*     */       }
/* 120 */       this.criteria.add(new WebsiteExample.Criterion(condition, value));
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value1, Object value2, String property)
/*     */     {
/* 125 */       if ((value1 == null) || (value2 == null))
/*     */       {
/* 127 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*     */       }
/* 129 */       this.criteria.add(new WebsiteExample.Criterion(condition, value1, value2));
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdIsNull()
/*     */     {
/* 134 */       addCriterion("id is null");
/* 135 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdIsNotNull()
/*     */     {
/* 140 */       addCriterion("id is not null");
/* 141 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdEqualTo(Long value)
/*     */     {
/* 146 */       addCriterion("id =", value, "id");
/* 147 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdNotEqualTo(Long value)
/*     */     {
/* 152 */       addCriterion("id <>", value, "id");
/* 153 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdGreaterThan(Long value)
/*     */     {
/* 158 */       addCriterion("id >", value, "id");
/* 159 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdGreaterThanOrEqualTo(Long value)
/*     */     {
/* 164 */       addCriterion("id >=", value, "id");
/* 165 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdLessThan(Long value)
/*     */     {
/* 170 */       addCriterion("id <", value, "id");
/* 171 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdLessThanOrEqualTo(Long value)
/*     */     {
/* 176 */       addCriterion("id <=", value, "id");
/* 177 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdIn(List<Long> values)
/*     */     {
/* 182 */       addCriterion("id in", values, "id");
/* 183 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdNotIn(List<Long> values)
/*     */     {
/* 188 */       addCriterion("id not in", values, "id");
/* 189 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdBetween(Long value1, Long value2)
/*     */     {
/* 194 */       addCriterion("id between", value1, value2, "id");
/* 195 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andIdNotBetween(Long value1, Long value2)
/*     */     {
/* 200 */       addCriterion("id not between", value1, value2, "id");
/* 201 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeIsNull()
/*     */     {
/* 206 */       addCriterion("addTime is null");
/* 207 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeIsNotNull()
/*     */     {
/* 212 */       addCriterion("addTime is not null");
/* 213 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeEqualTo(Date value)
/*     */     {
/* 218 */       addCriterion("addTime =", value, "addTime");
/* 219 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeNotEqualTo(Date value)
/*     */     {
/* 224 */       addCriterion("addTime <>", value, "addTime");
/* 225 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeGreaterThan(Date value)
/*     */     {
/* 230 */       addCriterion("addTime >", value, "addTime");
/* 231 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeGreaterThanOrEqualTo(Date value)
/*     */     {
/* 236 */       addCriterion("addTime >=", value, "addTime");
/* 237 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeLessThan(Date value)
/*     */     {
/* 242 */       addCriterion("addTime <", value, "addTime");
/* 243 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeLessThanOrEqualTo(Date value)
/*     */     {
/* 248 */       addCriterion("addTime <=", value, "addTime");
/* 249 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeIn(List<Date> values)
/*     */     {
/* 254 */       addCriterion("addTime in", values, "addTime");
/* 255 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeNotIn(List<Date> values)
/*     */     {
/* 260 */       addCriterion("addTime not in", values, "addTime");
/* 261 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeBetween(Date value1, Date value2)
/*     */     {
/* 266 */       addCriterion("addTime between", value1, value2, "addTime");
/* 267 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andAddTimeNotBetween(Date value1, Date value2)
/*     */     {
/* 272 */       addCriterion("addTime not between", value1, value2, "addTime");
/* 273 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusIsNull()
/*     */     {
/* 278 */       addCriterion("deleteStatus is null");
/* 279 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusIsNotNull()
/*     */     {
/* 284 */       addCriterion("deleteStatus is not null");
/* 285 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusEqualTo(Boolean value)
/*     */     {
/* 290 */       addCriterion("deleteStatus =", value, "deleteStatus");
/* 291 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusNotEqualTo(Boolean value)
/*     */     {
/* 296 */       addCriterion("deleteStatus <>", value, "deleteStatus");
/* 297 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusGreaterThan(Boolean value)
/*     */     {
/* 302 */       addCriterion("deleteStatus >", value, "deleteStatus");
/* 303 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value)
/*     */     {
/* 308 */       addCriterion("deleteStatus >=", value, "deleteStatus");
/* 309 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusLessThan(Boolean value)
/*     */     {
/* 314 */       addCriterion("deleteStatus <", value, "deleteStatus");
/* 315 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusLessThanOrEqualTo(Boolean value)
/*     */     {
/* 320 */       addCriterion("deleteStatus <=", value, "deleteStatus");
/* 321 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusIn(List<Boolean> values)
/*     */     {
/* 326 */       addCriterion("deleteStatus in", values, "deleteStatus");
/* 327 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusNotIn(List<Boolean> values)
/*     */     {
/* 332 */       addCriterion("deleteStatus not in", values, "deleteStatus");
/* 333 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusBetween(Boolean value1, Boolean value2)
/*     */     {
/* 338 */       addCriterion("deleteStatus between", value1, value2, "deleteStatus");
/* 339 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2)
/*     */     {
/* 344 */       addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
/* 345 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyIsNull()
/*     */     {
/* 350 */       addCriterion("pkey is null");
/* 351 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyIsNotNull()
/*     */     {
/* 356 */       addCriterion("pkey is not null");
/* 357 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyEqualTo(String value)
/*     */     {
/* 362 */       addCriterion("pkey =", value, "pkey");
/* 363 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyNotEqualTo(String value)
/*     */     {
/* 368 */       addCriterion("pkey <>", value, "pkey");
/* 369 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyGreaterThan(String value)
/*     */     {
/* 374 */       addCriterion("pkey >", value, "pkey");
/* 375 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyGreaterThanOrEqualTo(String value)
/*     */     {
/* 380 */       addCriterion("pkey >=", value, "pkey");
/* 381 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyLessThan(String value)
/*     */     {
/* 386 */       addCriterion("pkey <", value, "pkey");
/* 387 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyLessThanOrEqualTo(String value)
/*     */     {
/* 392 */       addCriterion("pkey <=", value, "pkey");
/* 393 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyLike(String value)
/*     */     {
/* 398 */       addCriterion("pkey like", value, "pkey");
/* 399 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyNotLike(String value)
/*     */     {
/* 404 */       addCriterion("pkey not like", value, "pkey");
/* 405 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyIn(List<String> values)
/*     */     {
/* 410 */       addCriterion("pkey in", values, "pkey");
/* 411 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyNotIn(List<String> values)
/*     */     {
/* 416 */       addCriterion("pkey not in", values, "pkey");
/* 417 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyBetween(String value1, String value2)
/*     */     {
/* 422 */       addCriterion("pkey between", value1, value2, "pkey");
/* 423 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andPkeyNotBetween(String value1, String value2)
/*     */     {
/* 428 */       addCriterion("pkey not between", value1, value2, "pkey");
/* 429 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeIsNull()
/*     */     {
/* 434 */       addCriterion("notice is null");
/* 435 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeIsNotNull()
/*     */     {
/* 440 */       addCriterion("notice is not null");
/* 441 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeEqualTo(String value)
/*     */     {
/* 446 */       addCriterion("notice =", value, "notice");
/* 447 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeNotEqualTo(String value)
/*     */     {
/* 452 */       addCriterion("notice <>", value, "notice");
/* 453 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeGreaterThan(String value)
/*     */     {
/* 458 */       addCriterion("notice >", value, "notice");
/* 459 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeGreaterThanOrEqualTo(String value)
/*     */     {
/* 464 */       addCriterion("notice >=", value, "notice");
/* 465 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeLessThan(String value)
/*     */     {
/* 470 */       addCriterion("notice <", value, "notice");
/* 471 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeLessThanOrEqualTo(String value)
/*     */     {
/* 476 */       addCriterion("notice <=", value, "notice");
/* 477 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeLike(String value)
/*     */     {
/* 482 */       addCriterion("notice like", value, "notice");
/* 483 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeNotLike(String value)
/*     */     {
/* 488 */       addCriterion("notice not like", value, "notice");
/* 489 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeIn(List<String> values)
/*     */     {
/* 494 */       addCriterion("notice in", values, "notice");
/* 495 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeNotIn(List<String> values)
/*     */     {
/* 500 */       addCriterion("notice not in", values, "notice");
/* 501 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeBetween(String value1, String value2)
/*     */     {
/* 506 */       addCriterion("notice between", value1, value2, "notice");
/* 507 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andNoticeNotBetween(String value1, String value2)
/*     */     {
/* 512 */       addCriterion("notice not between", value1, value2, "notice");
/* 513 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkIsNull()
/*     */     {
/* 518 */       addCriterion("remark is null");
/* 519 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkIsNotNull()
/*     */     {
/* 524 */       addCriterion("remark is not null");
/* 525 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkEqualTo(String value)
/*     */     {
/* 530 */       addCriterion("remark =", value, "remark");
/* 531 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkNotEqualTo(String value)
/*     */     {
/* 536 */       addCriterion("remark <>", value, "remark");
/* 537 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkGreaterThan(String value)
/*     */     {
/* 542 */       addCriterion("remark >", value, "remark");
/* 543 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkGreaterThanOrEqualTo(String value)
/*     */     {
/* 548 */       addCriterion("remark >=", value, "remark");
/* 549 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkLessThan(String value)
/*     */     {
/* 554 */       addCriterion("remark <", value, "remark");
/* 555 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkLessThanOrEqualTo(String value)
/*     */     {
/* 560 */       addCriterion("remark <=", value, "remark");
/* 561 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkLike(String value)
/*     */     {
/* 566 */       addCriterion("remark like", value, "remark");
/* 567 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkNotLike(String value)
/*     */     {
/* 572 */       addCriterion("remark not like", value, "remark");
/* 573 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkIn(List<String> values)
/*     */     {
/* 578 */       addCriterion("remark in", values, "remark");
/* 579 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkNotIn(List<String> values)
/*     */     {
/* 584 */       addCriterion("remark not in", values, "remark");
/* 585 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkBetween(String value1, String value2)
/*     */     {
/* 590 */       addCriterion("remark between", value1, value2, "remark");
/* 591 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */ 
/*     */     public WebsiteExample.Criteria andRemarkNotBetween(String value1, String value2)
/*     */     {
/* 596 */       addCriterion("remark not between", value1, value2, "remark");
/* 597 */       return (WebsiteExample.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.website.WebsiteExample
 * JD-Core Version:    0.6.2
 */
/*     */ package com.ifeng.bigtrade.cms.entites.article;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.validator.constraints.NotBlank;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ 
/*     */ public class Article
/*     */ {
/*     */   private Long id;
/*     */   private Date addTime;
/*     */   private Boolean deleteStatus;
/*     */ 
/*     */   @NotBlank(message="文章题目不能为空")
/*     */   private String title;
/*     */ 
/*     */   @NotNull(message="文章所属类型不能为空")
/*     */   private Long typeId;
/*     */ 
/*     */   @NotBlank(message="文章作者不能为空")
/*     */   private String author;
/*     */ 
/*     */   @NotBlank(message="文章提交人不能为空")
/*     */   private String submitter;
/*     */ 
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd")
/*     */   private Date submitTime;
/*     */ 
/*     */   @NotNull
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
/*     */   private Date publishTime;
/*     */ 
/*     */   @NotBlank(message="文章图片地址不能为空")
/*     */   private String pictureUrl;
/*     */   private String auditor;
/*     */ 
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd")
/*     */   private Date auditTime;
/*     */   private Integer auditState;
/*     */ 
/*     */   @NotNull
/*     */   private Integer showState;
/*     */   private String appUrl;
/*     */   private Integer hits;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 100 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 105 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/* 110 */     return this.addTime;
/*     */   }
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/* 115 */     this.addTime = addTime;
/*     */   }
/*     */ 
/*     */   public Boolean getDeleteStatus()
/*     */   {
/* 120 */     return this.deleteStatus;
/*     */   }
/*     */ 
/*     */   public void setDeleteStatus(Boolean deleteStatus)
/*     */   {
/* 125 */     this.deleteStatus = deleteStatus;
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 130 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/* 135 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public Long getTypeId()
/*     */   {
/* 140 */     return this.typeId;
/*     */   }
/*     */ 
/*     */   public void setTypeId(Long typeId)
/*     */   {
/* 145 */     this.typeId = typeId;
/*     */   }
/*     */ 
/*     */   public String getAuthor()
/*     */   {
/* 150 */     return this.author;
/*     */   }
/*     */ 
/*     */   public void setAuthor(String author)
/*     */   {
/* 155 */     this.author = author;
/*     */   }
/*     */ 
/*     */   public String getSubmitter()
/*     */   {
/* 160 */     return this.submitter;
/*     */   }
/*     */ 
/*     */   public void setSubmitter(String submitter)
/*     */   {
/* 165 */     this.submitter = submitter;
/*     */   }
/*     */ 
/*     */   public Date getSubmitTime()
/*     */   {
/* 170 */     return this.submitTime;
/*     */   }
/*     */ 
/*     */   public void setSubmitTime(Date submitTime)
/*     */   {
/* 175 */     this.submitTime = submitTime;
/*     */   }
/*     */ 
/*     */   public Date getPublishTime()
/*     */   {
/* 180 */     return this.publishTime;
/*     */   }
/*     */ 
/*     */   public void setPublishTime(Date publishTime)
/*     */   {
/* 185 */     this.publishTime = publishTime;
/*     */   }
/*     */ 
/*     */   public String getPictureUrl()
/*     */   {
/* 190 */     return this.pictureUrl;
/*     */   }
/*     */ 
/*     */   public void setPictureUrl(String pictureUrl)
/*     */   {
/* 195 */     this.pictureUrl = pictureUrl;
/*     */   }
/*     */ 
/*     */   public String getAuditor()
/*     */   {
/* 200 */     return this.auditor;
/*     */   }
/*     */ 
/*     */   public void setAuditor(String auditor)
/*     */   {
/* 205 */     this.auditor = auditor;
/*     */   }
/*     */ 
/*     */   public Date getAuditTime()
/*     */   {
/* 210 */     return this.auditTime;
/*     */   }
/*     */ 
/*     */   public void setAuditTime(Date auditTime)
/*     */   {
/* 215 */     this.auditTime = auditTime;
/*     */   }
/*     */ 
/*     */   public Integer getAuditState()
/*     */   {
/* 220 */     return this.auditState;
/*     */   }
/*     */ 
/*     */   public void setAuditState(Integer auditState)
/*     */   {
/* 225 */     this.auditState = auditState;
/*     */   }
/*     */ 
/*     */   public Integer getShowState()
/*     */   {
/* 230 */     return this.showState;
/*     */   }
/*     */ 
/*     */   public void setShowState(Integer showState)
/*     */   {
/* 235 */     this.showState = showState;
/*     */   }
/*     */ 
/*     */   public Integer getHits()
/*     */   {
/* 240 */     return this.hits;
/*     */   }
/*     */ 
/*     */   public void setHits(Integer hits)
/*     */   {
/* 245 */     this.hits = hits;
/*     */   }
/*     */ 
/*     */   public String getAppUrl()
/*     */   {
/* 250 */     return this.appUrl;
/*     */   }
/*     */ 
/*     */   public void setAppUrl(String appUrl)
/*     */   {
/* 255 */     this.appUrl = appUrl;
/*     */   }
/*     */ 
/*     */   public static enum ShowState
/*     */   {
/*  74 */     HIDE(0, "都不显示"), SHOW_ALL(1, "都显示"), SHOW_WEB(2, "仅web显示"), SHOW_APP(3, "仅app显示");
/*     */ 
/*     */     private int state;
/*     */     private String name;
/*     */ 
/*  80 */     private ShowState(int s, String str) { this.state = s;
/*  81 */       this.name = str;
/*     */     }
/*     */ 
/*     */     public int getState()
/*     */     {
/*  86 */       return this.state;
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/*  91 */       return this.name;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static enum AuditState
/*     */   {
/*  55 */     auditing(0), audited(1), reject(2);
/*     */ 
/*     */     private int state;
/*     */ 
/*     */     private AuditState(int s) {
/*  60 */       this.state = s;
/*     */     }
/*     */ 
/*     */     public int getState()
/*     */     {
/*  65 */       return this.state;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.article.Article
 * JD-Core Version:    0.6.2
 */
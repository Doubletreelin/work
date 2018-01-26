/*     */ package com.ifeng.bigtrade.cms.entites.article;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.validator.constraints.NotBlank;
/*     */ 
/*     */ public class ArticleType
/*     */ {
/*     */   private Long id;
/*     */   private Date addTime;
/*     */   private Boolean deleteStatus;
/*     */ 
/*     */   @NotBlank
/*     */   private String name;
/*     */   private Long parentId;
/*     */ 
/*     */   @NotNull
/*     */   private Integer level;
/*     */   private String mainType;
/*     */   private String subType;
/*     */   private List<ArticleType> sublist;
/*     */   private List<ArticleWithBLOBs> articlelist;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  31 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  36 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/*  41 */     return this.addTime;
/*     */   }
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/*  46 */     this.addTime = addTime;
/*     */   }
/*     */ 
/*     */   public Boolean getDeleteStatus()
/*     */   {
/*  51 */     return this.deleteStatus;
/*     */   }
/*     */ 
/*     */   public void setDeleteStatus(Boolean deleteStatus)
/*     */   {
/*  56 */     this.deleteStatus = deleteStatus;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  61 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  66 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Long getParentId()
/*     */   {
/*  71 */     return this.parentId;
/*     */   }
/*     */ 
/*     */   public void setParentId(Long parentId)
/*     */   {
/*  76 */     this.parentId = parentId;
/*     */   }
/*     */ 
/*     */   public Integer getLevel()
/*     */   {
/*  81 */     return this.level;
/*     */   }
/*     */ 
/*     */   public void setLevel(Integer level)
/*     */   {
/*  86 */     this.level = level;
/*     */   }
/*     */ 
/*     */   public String getMainType()
/*     */   {
/*  91 */     return this.mainType;
/*     */   }
/*     */ 
/*     */   public void setMainType(String mainType)
/*     */   {
/*  96 */     this.mainType = mainType;
/*     */   }
/*     */ 
/*     */   public String getSubType()
/*     */   {
/* 101 */     return this.subType;
/*     */   }
/*     */ 
/*     */   public void setSubType(String subType)
/*     */   {
/* 106 */     this.subType = subType;
/*     */   }
/*     */ 
/*     */   public List<ArticleType> getSublist()
/*     */   {
/* 111 */     return this.sublist;
/*     */   }
/*     */ 
/*     */   public void setSublist(List<ArticleType> sublist)
/*     */   {
/* 116 */     this.sublist = sublist;
/*     */   }
/*     */ 
/*     */   public List<ArticleWithBLOBs> getArticlelist()
/*     */   {
/* 121 */     return this.articlelist;
/*     */   }
/*     */ 
/*     */   public void setArticlelist(List<ArticleWithBLOBs> articlelist)
/*     */   {
/* 126 */     this.articlelist = articlelist;
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.article.ArticleType
 * JD-Core Version:    0.6.2
 */
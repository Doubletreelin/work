/*     */ package com.ifeng.bigtrade.cms.entites.article;
/*     */ 
/*     */ import org.hibernate.validator.constraints.NotBlank;
/*     */ 
/*     */ public class ArticleWithBLOBs extends Article
/*     */ {
/*     */ 
/*     */   @NotBlank(message="文章摘要不能为空")
/*     */   private String summary;
/*     */ 
/*     */   @NotBlank(message="文章内容不能为空")
/*     */   private String content;
/*     */   private String remarks;
/*     */   private String mainName;
/*     */   private String subName;
/*     */   private Long mainId;
/*     */   private Long subId;
/*     */   private String pretitle;
/*     */   private Long preId;
/*     */   private String nexttitle;
/*     */   private Long nextid;
/*     */   private String preurl;
/*     */   private String nexturl;
/*     */ 
/*     */   public String getSummary()
/*     */   {
/*  27 */     return this.summary;
/*     */   }
/*     */ 
/*     */   public void setSummary(String summary)
/*     */   {
/*  32 */     this.summary = summary;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/*  37 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/*  42 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getRemarks()
/*     */   {
/*  47 */     return this.remarks;
/*     */   }
/*     */ 
/*     */   public void setRemarks(String remarks)
/*     */   {
/*  52 */     this.remarks = remarks;
/*     */   }
/*     */ 
/*     */   public String getMainName()
/*     */   {
/*  57 */     return this.mainName;
/*     */   }
/*     */ 
/*     */   public void setMainName(String mainName)
/*     */   {
/*  62 */     this.mainName = mainName;
/*     */   }
/*     */ 
/*     */   public String getSubName()
/*     */   {
/*  67 */     return this.subName;
/*     */   }
/*     */ 
/*     */   public void setSubName(String subName)
/*     */   {
/*  72 */     this.subName = subName;
/*     */   }
/*     */ 
/*     */   public Long getMainId()
/*     */   {
/*  77 */     return this.mainId;
/*     */   }
/*     */ 
/*     */   public void setMainId(Long mainId)
/*     */   {
/*  82 */     this.mainId = mainId;
/*     */   }
/*     */ 
/*     */   public Long getSubId()
/*     */   {
/*  87 */     return this.subId;
/*     */   }
/*     */ 
/*     */   public void setSubId(Long subId)
/*     */   {
/*  92 */     this.subId = subId;
/*     */   }
/*     */ 
/*     */   public String getPretitle()
/*     */   {
/*  97 */     return this.pretitle;
/*     */   }
/*     */ 
/*     */   public void setPretitle(String pretitle)
/*     */   {
/* 102 */     this.pretitle = pretitle;
/*     */   }
/*     */ 
/*     */   public String getNexttitle()
/*     */   {
/* 107 */     return this.nexttitle;
/*     */   }
/*     */ 
/*     */   public void setNexttitle(String nexttitle)
/*     */   {
/* 112 */     this.nexttitle = nexttitle;
/*     */   }
/*     */ 
/*     */   public String getPreurl()
/*     */   {
/* 117 */     return this.preurl;
/*     */   }
/*     */ 
/*     */   public void setPreurl(String preurl)
/*     */   {
/* 122 */     this.preurl = preurl;
/*     */   }
/*     */ 
/*     */   public String getNexturl()
/*     */   {
/* 127 */     return this.nexturl;
/*     */   }
/*     */ 
/*     */   public void setNexturl(String nexturl)
/*     */   {
/* 132 */     this.nexturl = nexturl;
/*     */   }
/*     */ 
/*     */   public Long getPreId()
/*     */   {
/* 137 */     return this.preId;
/*     */   }
/*     */ 
/*     */   public void setPreId(Long preId)
/*     */   {
/* 142 */     this.preId = preId;
/*     */   }
/*     */ 
/*     */   public Long getNextid()
/*     */   {
/* 147 */     return this.nextid;
/*     */   }
/*     */ 
/*     */   public void setNextid(Long nextid)
/*     */   {
/* 152 */     this.nextid = nextid;
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.article.ArticleWithBLOBs
 * JD-Core Version:    0.6.2
 */
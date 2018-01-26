/*     */ package com.ifeng.bigtrade.cms.entites.advertise;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.validator.constraints.NotBlank;
/*     */ 
/*     */ public class Advertise
/*     */ {
/*     */   private Long id;
/*     */   private Date addTime;
/*     */   private Boolean deleteStatus;
/*     */ 
/*     */   @NotBlank
/*     */   private String name;
/*     */ 
/*     */   @NotBlank
/*     */   private String imgeLink;
/*     */ 
/*     */   @NotBlank
/*     */   private String imgeUrl;
/*     */ 
/*     */   @NotNull
/*     */   private Integer position;
/*     */ 
/*     */   @NotNull
/*     */   private Integer belongTo;
/*     */   private Date updateTime;
/*     */   private String plan;
/*     */ 
/*     */   @NotNull
/*     */   private Integer orderNum;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  71 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  76 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/*  81 */     return this.addTime;
/*     */   }
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/*  86 */     this.addTime = addTime;
/*     */   }
/*     */ 
/*     */   public Boolean getDeleteStatus()
/*     */   {
/*  91 */     return this.deleteStatus;
/*     */   }
/*     */ 
/*     */   public void setDeleteStatus(Boolean deleteStatus)
/*     */   {
/*  96 */     this.deleteStatus = deleteStatus;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 101 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 106 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getImgeLink()
/*     */   {
/* 111 */     return this.imgeLink;
/*     */   }
/*     */ 
/*     */   public void setImgeLink(String imgeLink)
/*     */   {
/* 116 */     this.imgeLink = imgeLink;
/*     */   }
/*     */ 
/*     */   public String getImgeUrl()
/*     */   {
/* 121 */     return this.imgeUrl;
/*     */   }
/*     */ 
/*     */   public void setImgeUrl(String imgeUrl)
/*     */   {
/* 126 */     this.imgeUrl = imgeUrl;
/*     */   }
/*     */ 
/*     */   public Integer getPosition()
/*     */   {
/* 131 */     return this.position;
/*     */   }
/*     */ 
/*     */   public void setPosition(Integer position)
/*     */   {
/* 136 */     this.position = position;
/*     */   }
/*     */ 
/*     */   public Integer getBelongTo()
/*     */   {
/* 141 */     return this.belongTo;
/*     */   }
/*     */ 
/*     */   public void setBelongTo(Integer belongTo)
/*     */   {
/* 146 */     this.belongTo = belongTo;
/*     */   }
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 151 */     return this.updateTime;
/*     */   }
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 156 */     this.updateTime = updateTime;
/*     */   }
/*     */ 
/*     */   public String getPlan()
/*     */   {
/* 161 */     return this.plan;
/*     */   }
/*     */ 
/*     */   public void setPlan(String plan)
/*     */   {
/* 166 */     this.plan = plan;
/*     */   }
/*     */ 
/*     */   public Integer getOrderNum()
/*     */   {
/* 171 */     return this.orderNum;
/*     */   }
/*     */ 
/*     */   public void setOrderNum(Integer orderNum)
/*     */   {
/* 176 */     this.orderNum = orderNum;
/*     */   }
/*     */ 
/*     */   public static enum belongPage
/*     */   {
/*  39 */     homePage_roll(0, "首页轮播", 1), homePage_fix(0, "首页固定位置", 2), trusteePage_roll(1, "托管轮播", 1), app_article_roll(2, "app文章轮播图", 1);
/*     */ 
/*     */     private int id;
/*     */     private String name;
/*     */     private int position;
/*     */ 
/*  47 */     private belongPage(int i, String str, int p) { this.id = i;
/*  48 */       this.name = str;
/*  49 */       this.position = p;
/*     */     }
/*     */ 
/*     */     public int getId()
/*     */     {
/*  54 */       return this.id;
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/*  59 */       return this.name;
/*     */     }
/*     */ 
/*     */     public int getPosition()
/*     */     {
/*  64 */       return this.position;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.advertise.Advertise
 * JD-Core Version:    0.6.2
 */
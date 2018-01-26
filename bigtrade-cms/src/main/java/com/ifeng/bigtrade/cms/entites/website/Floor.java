/*     */ package com.ifeng.bigtrade.cms.entites.website;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.validator.constraints.NotBlank;
/*     */ 
/*     */ public class Floor
/*     */ {
/*     */   private Long id;
/*     */   private Date addTime;
/*     */   private Boolean deleteStatus;
/*     */ 
/*     */   @NotBlank
/*     */   private String title;
/*     */ 
/*     */   @NotBlank
/*     */   private String description;
/*     */ 
/*     */   @NotNull
/*     */   private Integer showState;
/*     */ 
/*     */   @NotNull
/*     */   private Integer serialNum;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  54 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  59 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Date getAddTime()
/*     */   {
/*  64 */     return this.addTime;
/*     */   }
/*     */ 
/*     */   public void setAddTime(Date addTime)
/*     */   {
/*  69 */     this.addTime = addTime;
/*     */   }
/*     */ 
/*     */   public Boolean getDeleteStatus()
/*     */   {
/*  74 */     return this.deleteStatus;
/*     */   }
/*     */ 
/*     */   public void setDeleteStatus(Boolean deleteStatus)
/*     */   {
/*  79 */     this.deleteStatus = deleteStatus;
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  84 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  89 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getDescription()
/*     */   {
/*  94 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description)
/*     */   {
/*  99 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Integer getShowState()
/*     */   {
/* 104 */     return this.showState;
/*     */   }
/*     */ 
/*     */   public void setShowState(Integer showState)
/*     */   {
/* 109 */     this.showState = showState;
/*     */   }
/*     */ 
/*     */   public Integer getSerialNum()
/*     */   {
/* 114 */     return this.serialNum;
/*     */   }
/*     */ 
/*     */   public void setSerialNum(Integer serialNum)
/*     */   {
/* 119 */     this.serialNum = serialNum;
/*     */   }
/*     */ 
/*     */   public static enum ShowState
/*     */   {
/*  30 */     SHOW(0, "显示"), HIDE(1, "都显示");
/*     */ 
/*     */     private int state;
/*     */     private String name;
/*     */ 
/*  36 */     private ShowState(int s, String str) { this.state = s;
/*  37 */       this.name = str;
/*     */     }
/*     */ 
/*     */     public int getState()
/*     */     {
/*  42 */       return this.state;
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/*  47 */       return this.name;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.website.Floor
 * JD-Core Version:    0.6.2
 */
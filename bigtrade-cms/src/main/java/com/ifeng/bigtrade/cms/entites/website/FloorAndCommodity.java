/*    */ package com.ifeng.bigtrade.cms.entites.website;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class FloorAndCommodity
/*    */ {
/*    */   private Long id;
/*    */   private Long floorId;
/*    */   private Long commodityId;
/*    */   private Date addTime;
/*    */   private Boolean deleteStatus;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 17 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 21 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Long getFloorId() {
/* 25 */     return this.floorId;
/*    */   }
/*    */ 
/*    */   public void setFloorId(Long floorId) {
/* 29 */     this.floorId = floorId;
/*    */   }
/*    */ 
/*    */   public Long getCommodityId() {
/* 33 */     return this.commodityId;
/*    */   }
/*    */ 
/*    */   public void setCommodityId(Long commodityId) {
/* 37 */     this.commodityId = commodityId;
/*    */   }
/*    */ 
/*    */   public Date getAddTime() {
/* 41 */     return this.addTime;
/*    */   }
/*    */ 
/*    */   public void setAddTime(Date addTime) {
/* 45 */     this.addTime = addTime;
/*    */   }
/*    */ 
/*    */   public Boolean getDeleteStatus() {
/* 49 */     return this.deleteStatus;
/*    */   }
/*    */ 
/*    */   public void setDeleteStatus(Boolean deleteStatus) {
/* 53 */     this.deleteStatus = deleteStatus;
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.website.FloorAndCommodity
 * JD-Core Version:    0.6.2
 */
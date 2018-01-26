/*    */ package com.ifeng.bigtrade.cms.services.advertise.impl;
/*    */ 
/*    */ import com.ifeng.bigtrade.cms.entites.advertise.Advertise;
/*    */ import com.ifeng.bigtrade.cms.entites.advertise.AdvertiseExample;
/*    */ import com.ifeng.bigtrade.cms.enums.RespStatusCode;
/*    */ import com.ifeng.bigtrade.cms.exception.CommonException;
/*    */ import com.ifeng.bigtrade.cms.mapper.advertise.AdvertiseMapper;
/*    */ import com.ifeng.bigtrade.cms.services.advertise.AdvertiseService;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Transactional(rollbackFor={Exception.class, RuntimeException.class})
/*    */ @Service
/*    */ public class AdvertiseServiceImpl
/*    */   implements AdvertiseService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AdvertiseMapper advertiseMapper;
/*    */ 
/*    */   public List<Advertise> selectByCondition(AdvertiseExample example)
/*    */     throws Exception
/*    */   {
/* 28 */     return this.advertiseMapper.selectByExample(example);
/*    */   }
/*    */ 
/*    */   public Long editAdvertise(Advertise ad)
/*    */     throws Exception
/*    */   {
/* 34 */     int i = 0;
/* 35 */     if (ad.getId() == null)
/*    */     {
/* 37 */       ad.setAddTime(new Date());
/* 38 */       ad.setDeleteStatus(Boolean.valueOf(false));
/* 39 */       i = this.advertiseMapper.insert(ad);
/*    */     }
/*    */     else {
/* 42 */       ad.setUpdateTime(new Date());
/* 43 */       i = this.advertiseMapper.updateByPrimaryKeySelective(ad);
/*    */     }
/* 45 */     if (i == 1)
/*    */     {
/* 47 */       return ad.getId();
/*    */     }
/*    */ 
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */   public int delAdvertise(Long id)
/*    */     throws Exception
/*    */   {
/* 57 */     return this.advertiseMapper.deleteByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public Advertise getDetail(Long aid)
/*    */     throws Exception
/*    */   {
/* 63 */     Advertise advertise = this.advertiseMapper.selectByPrimaryKey(aid);
/* 64 */     if (advertise != null)
/*    */     {
/* 66 */       return advertise;
/*    */     }
/*    */ 
/* 70 */     throw new CommonException(RespStatusCode.ObjectNull.getName(), 
/* 70 */       Integer.valueOf(RespStatusCode.ObjectNull
/* 70 */       .getId()));
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.advertise.impl.AdvertiseServiceImpl
 * JD-Core Version:    0.6.2
 */
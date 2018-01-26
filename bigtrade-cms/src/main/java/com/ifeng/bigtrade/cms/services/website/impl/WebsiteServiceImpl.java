/*    */ package com.ifeng.bigtrade.cms.services.website.impl;
/*    */ 
/*    */ import com.ifeng.bigtrade.cms.entites.website.Website;
/*    */ import com.ifeng.bigtrade.cms.entites.website.WebsiteExample;
/*    */ import com.ifeng.bigtrade.cms.enums.RespStatusCode;
/*    */ import com.ifeng.bigtrade.cms.exception.CommonException;
/*    */ import com.ifeng.bigtrade.cms.mapper.website.WebsiteMapper;
/*    */ import com.ifeng.bigtrade.cms.services.website.WebsiteService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Transactional(rollbackFor={Exception.class, RuntimeException.class})
/*    */ @Service
/*    */ public class WebsiteServiceImpl
/*    */   implements WebsiteService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private WebsiteMapper websiteMapper;
/*    */ 
/*    */   public List<Website> selectByCondition(WebsiteExample example)
/*    */     throws Exception
/*    */   {
/* 27 */     List list = this.websiteMapper.selectByExampleWithBLOBs(example);
/* 28 */     if ((list != null) && (list.size() > 0))
/*    */     {
/* 30 */       return list;
/*    */     }
/*    */ 
/* 34 */     throw new CommonException(RespStatusCode.ObjectNull.getName(), 
/* 34 */       Integer.valueOf(RespStatusCode.ObjectNull
/* 34 */       .getId()));
/*    */   }
/*    */ 
/*    */   public boolean editWebsite(Website website)
/*    */     throws Exception
/*    */   {
/* 41 */     int i = 0;
/* 42 */     if (website.getId() == null)
/*    */     {
/* 44 */       i = this.websiteMapper.insert(website);
/*    */     }
/*    */     else {
/* 47 */       i = this.websiteMapper.updateByPrimaryKeySelective(website);
/*    */     }
/* 49 */     if (i == 1)
/*    */     {
/* 51 */       return true;
/*    */     }
/*    */ 
/* 54 */     throw new CommonException(RespStatusCode.Error.getName(), Integer.valueOf(RespStatusCode.Error.getId()));
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.website.impl.WebsiteServiceImpl
 * JD-Core Version:    0.6.2
 */
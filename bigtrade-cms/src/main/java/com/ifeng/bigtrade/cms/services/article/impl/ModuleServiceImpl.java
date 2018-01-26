/*    */ package com.ifeng.bigtrade.cms.services.article.impl;
/*    */ 
/*    */ import com.ifeng.bigtrade.cms.entites.article.Module;
/*    */ import com.ifeng.bigtrade.cms.entites.article.TypeAndModule;
/*    */ import com.ifeng.bigtrade.cms.entites.article.TypeAndModuleExample;
/*    */ import com.ifeng.bigtrade.cms.entites.article.TypeAndModuleExample.Criteria;
/*    */ import com.ifeng.bigtrade.cms.enums.RespStatusCode;
/*    */ import com.ifeng.bigtrade.cms.exception.CommonException;
/*    */ import com.ifeng.bigtrade.cms.mapper.article.ModuleMapper;
/*    */ import com.ifeng.bigtrade.cms.mapper.article.TypeAndModuleMapper;
/*    */ import com.ifeng.bigtrade.cms.services.article.ModuleService;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Transactional(rollbackFor={Exception.class, RuntimeException.class})
/*    */ @Service
/*    */ public class ModuleServiceImpl
/*    */   implements ModuleService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ModuleMapper moduleMapper;
/*    */ 
/*    */   @Autowired
/*    */   private TypeAndModuleMapper typeAndModuleMapper;
/*    */ 
/*    */   public List<Module> findAll()
/*    */     throws Exception
/*    */   {
/* 32 */     return this.moduleMapper.findAll();
/*    */   }
/*    */ 
/*    */   public boolean updModule(Long mid, String name, Long[] tids)
/*    */     throws Exception
/*    */   {
/* 38 */     Module module = new Module();
/* 39 */     module.setId(mid);
/* 40 */     module.setName(name);
/* 41 */     module.setAddTime(new Date());
/* 42 */     module.setDeleteStatus(Boolean.valueOf(false));
/* 43 */     TypeAndModuleExample example = new TypeAndModuleExample();
/* 44 */     example.createCriteria().andModuleIdEqualTo(mid);
/*    */ 
/* 46 */     this.typeAndModuleMapper.deleteByExample(example);
/*    */ 
/* 48 */     TypeAndModule tm = new TypeAndModule();
/* 49 */     tm.setModuleId(mid);
/* 50 */     tm.setAddTime(new Date());
/* 51 */     tm.setDeleteStatus(Boolean.valueOf(false));
/* 52 */     for (Long tid : tids)
/*    */     {
/* 54 */       if (tid != null)
/*    */       {
/* 56 */         tm.setTypeId(tid);
/* 57 */         this.typeAndModuleMapper.insertSelective(tm);
/*    */       }
/*    */     }
/*    */ 
/* 61 */     if (this.moduleMapper.updateByPrimaryKey(module) == 1)
/*    */     {
/* 63 */       return true;
/*    */     }
/*    */ 
/* 66 */     throw new CommonException(RespStatusCode.Error.getName(), Integer.valueOf(RespStatusCode.Error.getId()));
/*    */   }
/*    */ 
/*    */   public List<TypeAndModule> getTypeId(Long mid)
/*    */     throws Exception
/*    */   {
/* 73 */     TypeAndModuleExample tm = new TypeAndModuleExample();
/* 74 */     tm.createCriteria().andModuleIdEqualTo(mid);
/* 75 */     List list = this.typeAndModuleMapper.selectByExample(tm);
/* 76 */     return list;
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.article.impl.ModuleServiceImpl
 * JD-Core Version:    0.6.2
 */
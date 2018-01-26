/*    */ package com.ifeng.bigtrade.cms.services.website.impl;
/*    */ 
/*    */ import com.ifeng.bigtrade.cms.entites.website.Floor;
/*    */ import com.ifeng.bigtrade.cms.entites.website.FloorAndCommodity;
/*    */ import com.ifeng.bigtrade.cms.entites.website.FloorAndCommodityExample;
/*    */ import com.ifeng.bigtrade.cms.entites.website.FloorAndCommodityExample.Criteria;
/*    */ import com.ifeng.bigtrade.cms.entites.website.FloorExample;
/*    */ import com.ifeng.bigtrade.cms.enums.RespStatusCode;
/*    */ import com.ifeng.bigtrade.cms.exception.CommonException;
/*    */ import com.ifeng.bigtrade.cms.mapper.website.FloorAndCommodityMapper;
/*    */ import com.ifeng.bigtrade.cms.mapper.website.FloorMapper;
/*    */ import com.ifeng.bigtrade.cms.services.website.FloorService;
/*    */ import java.util.Arrays;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Transactional(rollbackFor={Exception.class, RuntimeException.class})
/*    */ @Service
/*    */ public class FloorServiceImpl
/*    */   implements FloorService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private FloorMapper floorMapper;
/*    */ 
/*    */   @Autowired
/*    */   private FloorAndCommodityMapper fcMapper;
/*    */ 
/*    */   public List<Floor> selectByCondition(FloorExample example)
/*    */     throws Exception
/*    */   {
/* 34 */     List list = this.floorMapper.selectByExample(example);
/* 35 */     if ((list != null) && (list.size() > 0))
/*    */     {
/* 37 */       return list;
/*    */     }
/*    */ 
/* 41 */     throw new CommonException(RespStatusCode.ObjectNull.getName(), 
/* 41 */       Integer.valueOf(RespStatusCode.ObjectNull
/* 41 */       .getId()));
/*    */   }
/*    */ 
/*    */   public Long editFloor(Floor floor, Long[] cids)
/*    */     throws Exception
/*    */   {
/* 48 */     int i = 0;
/* 49 */     floor.setDeleteStatus(Boolean.valueOf(false));
/* 50 */     if (floor.getId() == null)
/*    */     {
/* 53 */       floor.setAddTime(new Date());
/* 54 */       i = this.floorMapper.insert(floor);
/*    */     }
/*    */     else
/*    */     {
/* 58 */       i = this.floorMapper.updateByPrimaryKeySelective(floor);
/*    */     }
/* 60 */     if (i == 1)
/*    */     {
/* 62 */       if ((cids != null) && (cids.length > 0))
/*    */       {
/* 64 */         FloorAndCommodityExample example = new FloorAndCommodityExample();
/* 65 */         example.createCriteria().andFloorIdEqualTo(floor.getId())
/* 66 */           .andCommodityIdIn(Arrays.asList(cids));
/*    */ 
/* 67 */         this.fcMapper.deleteByExample(example);
/* 68 */         FloorAndCommodity fc = new FloorAndCommodity();
/* 69 */         Date date = new Date();
/* 70 */         fc.setAddTime(date);
/* 71 */         fc.setDeleteStatus(Boolean.valueOf(false));
/* 72 */         fc.setFloorId(floor.getId());
/* 73 */         int j = 0;
/* 74 */         for (Long cid : cids)
/*    */         {
/* 76 */           fc.setCommodityId(cid);
/* 77 */           j += this.fcMapper.insert(fc);
/*    */         }
/* 79 */         if (j != cids.length)
/*    */         {
/* 82 */           throw new CommonException("添加/修改楼层" + RespStatusCode.Error.getName(), 
/* 82 */             Integer.valueOf(RespStatusCode.Error
/* 82 */             .getId()));
/*    */         }
/*    */       }
/* 85 */       return floor.getId();
/*    */     }
/*    */ 
/* 89 */     throw new CommonException("添加/修改楼层" + RespStatusCode.Error.getName(), 
/* 89 */       Integer.valueOf(RespStatusCode.Error
/* 89 */       .getId()));
/*    */   }
/*    */ 
/*    */   public int delFloor(Long fid)
/*    */     throws Exception
/*    */   {
/* 96 */     FloorAndCommodityExample example = new FloorAndCommodityExample();
/* 97 */     example.createCriteria().andFloorIdEqualTo(fid);
/* 98 */     this.fcMapper.deleteByExample(example);
/* 99 */     return this.floorMapper.deleteByPrimaryKey(fid);
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.website.impl.FloorServiceImpl
 * JD-Core Version:    0.6.2
 */
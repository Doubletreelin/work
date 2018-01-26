/*     */ package com.ifeng.bigtrade.cms.controller.website;
/*     */ 
/*     */ import com.ifeng.bigtrade.cms.entites.resp.ResponseHeader;
/*     */ import com.ifeng.bigtrade.cms.entites.resp.ResponseMessage;
/*     */ import com.ifeng.bigtrade.cms.entites.website.Floor;
/*     */ import com.ifeng.bigtrade.cms.entites.website.Floor.ShowState;
/*     */ import com.ifeng.bigtrade.cms.entites.website.FloorExample;
/*     */ import com.ifeng.bigtrade.cms.entites.website.FloorExample.Criteria;
/*     */ import com.ifeng.bigtrade.cms.enums.RespStatusCode;
/*     */ import com.ifeng.bigtrade.cms.exception.CommonException;
/*     */ import com.ifeng.bigtrade.cms.services.website.FloorService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.validation.annotation.Validated;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/floor"})
/*     */ public class FloorController
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private FloorService floorService;
/*     */ 
/*     */   @RequestMapping({"/add"})
/*     */   public Object getWebsite(HttpServletRequest request, HttpServletResponse response, @Validated Floor floor, Long[] cids)
/*     */     throws Exception
/*     */   {
/*  43 */     Long fid = this.floorService.editFloor(floor, cids);
/*     */ 
/*  45 */     ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()), RespStatusCode.Succ
/*  45 */       .getName());
/*  46 */     HashMap body = new HashMap();
/*  47 */     body.put("fid", fid);
/*  48 */     return new ResponseMessage(header, body);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/delete/{fid}"})
/*     */   public Object delWebsite(HttpServletRequest request, HttpServletResponse response, @PathVariable("fid") Long fid)
/*     */     throws Exception
/*     */   {
/*  59 */     ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()), RespStatusCode.Succ
/*  59 */       .getName());
/*  60 */     if (this.floorService.delFloor(fid) != 1)
/*     */     {
/*  63 */       header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Error.getId()), RespStatusCode.Error
/*  63 */         .getName());
/*     */     }
/*  65 */     HashMap body = new HashMap();
/*  66 */     body.put("fid", fid);
/*  67 */     return new ResponseMessage(header, body);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/update/{fid}"})
/*     */   public Object updWebsite(HttpServletRequest request, HttpServletResponse response, @Validated Floor floor, @PathVariable("fid") Long fid, Long[] cids)
/*     */     throws Exception
/*     */   {
/*  77 */     floor.setId(fid);
/*  78 */     Long floorId = this.floorService.editFloor(floor, cids);
/*     */ 
/*  80 */     ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()), RespStatusCode.Succ
/*  80 */       .getName());
/*  81 */     HashMap body = new HashMap();
/*  82 */     body.put("fid", floorId);
/*  83 */     return new ResponseMessage(header, body);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/select/{state}"})
/*     */   public Object selWebsite(HttpServletRequest request, HttpServletResponse response, @PathVariable("state") String state)
/*     */     throws Exception
/*     */   {
/*  93 */     FloorExample example = null;
/*  94 */     if ("hide".equals(state))
/*     */     {
/*  96 */       example = new FloorExample();
/*  97 */       example.createCriteria().andShowStateEqualTo(Integer.valueOf(Floor.ShowState.HIDE.getState()));
/*  98 */     } else if ("show".equals(state))
/*     */     {
/* 100 */       example = new FloorExample();
/* 101 */       example.createCriteria().andShowStateEqualTo(Integer.valueOf(Floor.ShowState.SHOW.getState()));
/* 102 */     } else if (!"all".equals(state))
/*     */     {
/* 105 */       throw new CommonException(RespStatusCode.ParamError.getName(), 
/* 105 */         Integer.valueOf(RespStatusCode.ParamError
/* 105 */         .getId()));
/*     */     }
/* 107 */     List list = this.floorService.selectByCondition(example);
/*     */ 
/* 109 */     ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()), RespStatusCode.Succ
/* 109 */       .getName());
/* 110 */     HashMap body = new HashMap();
/* 111 */     body.put("list", list);
/* 112 */     return new ResponseMessage(header, body);
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.controller.website.FloorController
 * JD-Core Version:    0.6.2
 */
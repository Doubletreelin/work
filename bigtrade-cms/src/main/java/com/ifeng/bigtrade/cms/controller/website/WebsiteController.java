/*     */ package com.ifeng.bigtrade.cms.controller.website;
/*     */ 
/*     */ import com.ifeng.bigtrade.cms.entites.resp.ResponseHeader;
/*     */ import com.ifeng.bigtrade.cms.entites.resp.ResponseMessage;
/*     */ import com.ifeng.bigtrade.cms.entites.website.Website;
/*     */ import com.ifeng.bigtrade.cms.entites.website.WebsiteExample;
/*     */ import com.ifeng.bigtrade.cms.entites.website.WebsiteExample.Criteria;
/*     */ import com.ifeng.bigtrade.cms.enums.RespStatusCode;
/*     */ import com.ifeng.bigtrade.cms.exception.CommonException;
/*     */ import com.ifeng.bigtrade.cms.services.website.WebsiteService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/website"})
/*     */ public class WebsiteController
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private WebsiteService websiteService;
/*     */ 
/*     */   @RequestMapping({"/get/{flag}"})
/*     */   public Object getWebsite(HttpServletRequest request, HttpServletResponse response, @PathVariable("flag") String flag)
/*     */     throws Exception
/*     */   {
/*  44 */     String pkey = null;
/*  45 */     if ("basic".equals(flag))
/*     */     {
/*  47 */       pkey = "basicinfo_%";
/*  48 */     } else if ("foot".equals(flag))
/*     */     {
/*  50 */       pkey = "footer_%";
/*  51 */     } else if ("relate".equals(flag))
/*     */     {
/*  53 */       pkey = "related_%";
/*  54 */     } else if ("navigate".equals(flag))
/*     */     {
/*  56 */       pkey = "navigationbar_%";
/*     */     }
/*     */     else
/*     */     {
/*  60 */       throw new CommonException(RespStatusCode.ParamError.getName(), 
/*  60 */         Integer.valueOf(RespStatusCode.ParamError
/*  60 */         .getId()));
/*     */     }
/*  62 */     WebsiteExample example = new WebsiteExample();
/*  63 */     example.createCriteria().andPkeyLike(pkey);
/*  64 */     List list = this.websiteService.selectByCondition(example);
/*     */ 
/*  66 */     ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()), RespStatusCode.Succ
/*  66 */       .getName());
/*  67 */     HashMap body = new HashMap();
/*  68 */     body.put("list", list);
/*  69 */     return new ResponseMessage(header, body);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/update/{flag}/{wid}"})
/*     */   public Object updateWebsite(HttpServletRequest request, HttpServletResponse response, @PathVariable("flag") String flag, @PathVariable("wid") Long wid, String value, String notice)
/*     */     throws Exception
/*     */   {
/*  80 */     String pkey = null;
/*  81 */     if ("basic".equals(flag))
/*     */     {
/*  83 */       pkey = "basicinfo_%";
/*  84 */     } else if ("foot".equals(flag))
/*     */     {
/*  86 */       pkey = "footer_%";
/*  87 */     } else if ("relate".equals(flag))
/*     */     {
/*  89 */       pkey = "related_%";
/*  90 */     } else if ("navigate".equals(flag))
/*     */     {
/*  92 */       pkey = "navigationbar_%";
/*     */     }
/*     */     else
/*     */     {
/*  96 */       throw new CommonException(RespStatusCode.ParamError.getName(), 
/*  96 */         Integer.valueOf(RespStatusCode.ParamError
/*  96 */         .getId()));
/*     */     }
/*  98 */     WebsiteExample example = new WebsiteExample();
/*  99 */     example.createCriteria().andPkeyLike(pkey).andIdEqualTo(wid);
/* 100 */     List list = this.websiteService.selectByCondition(example);
/* 101 */     if ((list != null) && (list.size() > 0))
/*     */     {
/* 103 */       Website website = new Website();
/* 104 */       website.setId(wid);
/* 105 */       website.setPvalue(value);
/* 106 */       website.setNotice(notice);
/* 107 */       this.websiteService.editWebsite(website);
/*     */     }
/*     */ 
/* 110 */     ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()), RespStatusCode.Succ
/* 110 */       .getName());
/* 111 */     return new ResponseMessage(header, null);
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.controller.website.WebsiteController
 * JD-Core Version:    0.6.2
 */
/*     */ package com.ifeng.bigtrade.cms.services.article.impl;
/*     */ 
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifeng.bigtrade.cms.entites.article.Article;
/*     */ import com.ifeng.bigtrade.cms.entites.article.Article.AuditState;
/*     */ import com.ifeng.bigtrade.cms.entites.article.Article.ShowState;
/*     */ import com.ifeng.bigtrade.cms.entites.article.ArticleExample;
/*     */ import com.ifeng.bigtrade.cms.entites.article.ArticleExample.Criteria;
/*     */ import com.ifeng.bigtrade.cms.entites.article.ArticleWithBLOBs;
/*     */ import com.ifeng.bigtrade.cms.enums.RespStatusCode;
/*     */ import com.ifeng.bigtrade.cms.exception.CommonException;
/*     */ import com.ifeng.bigtrade.cms.mapper.article.ArticleMapper;
/*     */ import com.ifeng.bigtrade.cms.services.article.ArticleService;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Transactional(rollbackFor={Exception.class, RuntimeException.class})
/*     */ @Service
/*     */ public class ArticleServiceImpl
/*     */   implements ArticleService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ArticleMapper articleMapper;
/*     */ 
/*     */   public Long editArticle(ArticleWithBLOBs article)
/*     */     throws Exception
/*     */   {
/*  37 */     boolean flag = false;
/*  38 */     Article.ShowState[] show = Article.ShowState.values();
/*  39 */     Integer state = article.getShowState();
/*  40 */     for (Article.ShowState showState : show)
/*     */     {
/*  42 */       if (showState.getState() == state.intValue())
/*     */       {
/*  44 */         flag = true;
/*  45 */         break;
/*     */       }
/*     */     }
/*     */ 
/*  49 */     if ((flag) && (
/*  50 */       ((state
/*  50 */       .intValue() != Article.ShowState.SHOW_APP.getState()) && 
/*  51 */       (state.intValue() != Article.ShowState.SHOW_ALL
/*  51 */       .getState())) || (!StringUtils.isBlank(article.getAppUrl()))))
/*     */     {
/*  54 */       HashMap map = new HashMap();
/*  55 */       map.put("webUrl", article.getPictureUrl());
/*  56 */       map.put("appUrl", article.getAppUrl());
/*  57 */       ObjectMapper objectMapper = new ObjectMapper();
/*  58 */       article.setPictureUrl(objectMapper.writeValueAsString(map));
/*     */ 
/*  60 */       int i = 0;
/*  61 */       article.setDeleteStatus(Boolean.valueOf(false));
/*  62 */       article.setAuditState(Integer.valueOf(Article.AuditState.auditing.getState()));
/*  63 */       article.setAuditor(null);
/*  64 */       article.setAuditTime(null);
/*  65 */       article.setSubmitTime(new Date());
/*  66 */       article.setHits(Integer.valueOf(0));
/*  67 */       article.setRemarks(null);
/*  68 */       if (article.getId() != null)
/*     */       {
/*  71 */         i = this.articleMapper.updateByPrimaryKeySelective(article);
/*     */       }
/*     */       else
/*     */       {
/*  75 */         article.setAddTime(new Date());
/*  76 */         i = this.articleMapper.insert(article);
/*     */       }
/*  78 */       if (i == 1)
/*     */       {
/*  80 */         return article.getId();
/*     */       }
/*     */ 
/*  84 */       throw new CommonException("添加/修改文章" + RespStatusCode.Error.getName(), 
/*  84 */         Integer.valueOf(RespStatusCode.Error
/*  84 */         .getId()));
/*     */     }
/*     */ 
/*  89 */     throw new CommonException(RespStatusCode.ParamError.getName(), 
/*  89 */       Integer.valueOf(RespStatusCode.ParamError
/*  89 */       .getId()));
/*     */   }
/*     */ 
/*     */   public boolean delOneArticle(Long id)
/*     */     throws Exception
/*     */   {
/*  99 */     if (this.articleMapper.deleteByPrimaryKey(id) == 1)
/*     */     {
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delMoreArticle(Long[] ids)
/*     */     throws Exception
/*     */   {
/* 113 */     ArticleExample example = new ArticleExample();
/* 114 */     example.createCriteria().andIdIn(Arrays.asList(ids));
/* 115 */     if (this.articleMapper.deleteByExample(example) == ids.length)
/*     */     {
/* 117 */       return true;
/*     */     }
/*     */ 
/* 120 */     throw new CommonException("传入的文章数与删除的文章条数不等", Integer.valueOf(RespStatusCode.Error.getId()));
/*     */   }
/*     */ 
/*     */   public List<ArticleWithBLOBs> getArticleBycondition(ArticleWithBLOBs articleWithBLOBs)
/*     */     throws Exception
/*     */   {
/* 141 */     List list = this.articleMapper.selectWithType(articleWithBLOBs);
/* 142 */     return list;
/*     */   }
/*     */ 
/*     */   public ArticleWithBLOBs getDetail(Long aid)
/*     */     throws Exception
/*     */   {
/* 148 */     ArticleWithBLOBs articleWithBLOBs = this.articleMapper.selectByPrimaryKey(aid);
/* 149 */     if (articleWithBLOBs != null)
/*     */     {
/* 151 */       return articleWithBLOBs;
/*     */     }
/*     */ 
/* 155 */     throw new CommonException(RespStatusCode.ObjectNull.getName(), 
/* 155 */       Integer.valueOf(RespStatusCode.ObjectNull
/* 155 */       .getId()));
/*     */   }
/*     */ 
/*     */   public boolean auditArticle(Long aid, String remarks, Integer state, String auditor)
/*     */     throws Exception
/*     */   {
/* 163 */     ArticleWithBLOBs article = new ArticleWithBLOBs();
/* 164 */     article.setAuditor(auditor);
/* 165 */     article.setId(aid);
/* 166 */     article.setRemarks(remarks);
/* 167 */     article.setAuditState(state);
/* 168 */     article.setAuditTime(new Date());
/* 169 */     if (this.articleMapper.updateByPrimaryKeySelective(article) == 1)
/*     */     {
/* 171 */       return true;
/*     */     }
/* 173 */     return false;
/*     */   }
/*     */ 
/*     */   public List<ArticleWithBLOBs> selectByType(Long aid, boolean hit, Long mainId, Long subId)
/*     */     throws Exception
/*     */   {
/* 180 */     List list = this.articleMapper.selectByType(aid, hit, mainId, subId);
/* 181 */     return list;
/*     */   }
/*     */ 
/*     */   public boolean updateSelective(ArticleWithBLOBs article)
/*     */     throws Exception
/*     */   {
/* 187 */     if (this.articleMapper.updateByPrimaryKeySelective(article) == 1)
/*     */     {
/* 189 */       return true;
/*     */     }
/* 191 */     return false;
/*     */   }
/*     */ 
/*     */   public List<ArticleWithBLOBs> getArticleByExample(ArticleExample example)
/*     */     throws Exception
/*     */   {
/* 197 */     List list = this.articleMapper.selectByExampleWithBLOBs(example);
/* 198 */     return list;
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.article.impl.ArticleServiceImpl
 * JD-Core Version:    0.6.2
 */
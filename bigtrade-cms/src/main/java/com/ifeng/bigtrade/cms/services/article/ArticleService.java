package com.ifeng.bigtrade.cms.services.article;

import com.ifeng.bigtrade.cms.entites.article.ArticleExample;
import com.ifeng.bigtrade.cms.entites.article.ArticleWithBLOBs;
import java.util.List;

public abstract interface ArticleService
{
  public abstract Long editArticle(ArticleWithBLOBs paramArticleWithBLOBs)
    throws Exception;

  public abstract boolean delOneArticle(Long paramLong)
    throws Exception;

  public abstract boolean delMoreArticle(Long[] paramArrayOfLong)
    throws Exception;

  public abstract List<ArticleWithBLOBs> getArticleBycondition(ArticleWithBLOBs paramArticleWithBLOBs)
    throws Exception;

  public abstract List<ArticleWithBLOBs> selectByType(Long paramLong1, boolean paramBoolean, Long paramLong2, Long paramLong3)
    throws Exception;

  public abstract ArticleWithBLOBs getDetail(Long paramLong)
    throws Exception;

  public abstract boolean auditArticle(Long paramLong, String paramString1, Integer paramInteger, String paramString2)
    throws Exception;

  public abstract boolean updateSelective(ArticleWithBLOBs paramArticleWithBLOBs)
    throws Exception;

  public abstract List<ArticleWithBLOBs> getArticleByExample(ArticleExample paramArticleExample)
    throws Exception;
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.article.ArticleService
 * JD-Core Version:    0.6.2
 */
package com.ifeng.bigtrade.cms.services.article;

import com.ifeng.bigtrade.cms.entites.article.ArticleType;
import java.util.List;

public abstract interface ArticleTypeService
{
  public abstract Long editType(ArticleType paramArticleType)
    throws Exception;

  public abstract boolean delSubType(Long[] paramArrayOfLong)
    throws Exception;

  public abstract boolean delMainType(Long[] paramArrayOfLong)
    throws Exception;

  public abstract List<ArticleType> getTypeBycondition(ArticleType paramArticleType)
    throws Exception;

  public abstract boolean getMainType(Long paramLong)
    throws Exception;

  public abstract List<ArticleType> getSubType(Long paramLong)
    throws Exception;

  public abstract ArticleType getTypeById(Long paramLong)
    throws Exception;

  public abstract List<ArticleType> getMainTypeByMid(Long paramLong)
    throws Exception;

  public abstract ArticleType getWithSubtype(Long paramLong)
    throws Exception;
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.article.ArticleTypeService
 * JD-Core Version:    0.6.2
 */
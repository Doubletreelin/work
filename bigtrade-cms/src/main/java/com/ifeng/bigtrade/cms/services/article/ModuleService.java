package com.ifeng.bigtrade.cms.services.article;

import com.ifeng.bigtrade.cms.entites.article.Module;
import com.ifeng.bigtrade.cms.entites.article.TypeAndModule;
import java.util.List;

public abstract interface ModuleService
{
  public abstract List<Module> findAll()
    throws Exception;

  public abstract boolean updModule(Long paramLong, String paramString, Long[] paramArrayOfLong)
    throws Exception;

  public abstract List<TypeAndModule> getTypeId(Long paramLong)
    throws Exception;
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.article.ModuleService
 * JD-Core Version:    0.6.2
 */
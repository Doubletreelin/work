package com.ifeng.bigtrade.cms.services.website;

import com.ifeng.bigtrade.cms.entites.website.Website;
import com.ifeng.bigtrade.cms.entites.website.WebsiteExample;
import java.util.List;

public abstract interface WebsiteService
{
  public abstract List<Website> selectByCondition(WebsiteExample paramWebsiteExample)
    throws Exception;

  public abstract boolean editWebsite(Website paramWebsite)
    throws Exception;
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.website.WebsiteService
 * JD-Core Version:    0.6.2
 */
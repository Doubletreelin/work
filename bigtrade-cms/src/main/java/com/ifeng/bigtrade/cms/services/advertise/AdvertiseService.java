package com.ifeng.bigtrade.cms.services.advertise;

import com.ifeng.bigtrade.cms.entites.advertise.Advertise;
import com.ifeng.bigtrade.cms.entites.advertise.AdvertiseExample;
import java.util.List;

public abstract interface AdvertiseService
{
  public abstract List<Advertise> selectByCondition(AdvertiseExample paramAdvertiseExample)
    throws Exception;

  public abstract Long editAdvertise(Advertise paramAdvertise)
    throws Exception;

  public abstract Advertise getDetail(Long paramLong)
    throws Exception;

  public abstract int delAdvertise(Long paramLong)
    throws Exception;
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.advertise.AdvertiseService
 * JD-Core Version:    0.6.2
 */
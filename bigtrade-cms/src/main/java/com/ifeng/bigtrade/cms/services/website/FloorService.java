package com.ifeng.bigtrade.cms.services.website;

import com.ifeng.bigtrade.cms.entites.website.Floor;
import com.ifeng.bigtrade.cms.entites.website.FloorExample;
import java.util.List;

public abstract interface FloorService
{
  public abstract List<Floor> selectByCondition(FloorExample paramFloorExample)
    throws Exception;

  public abstract Long editFloor(Floor paramFloor, Long[] paramArrayOfLong)
    throws Exception;

  public abstract int delFloor(Long paramLong)
    throws Exception;
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.services.website.FloorService
 * JD-Core Version:    0.6.2
 */
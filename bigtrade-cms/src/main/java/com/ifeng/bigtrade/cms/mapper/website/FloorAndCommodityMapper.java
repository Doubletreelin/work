package com.ifeng.bigtrade.cms.mapper.website;

import com.ifeng.bigtrade.cms.entites.website.FloorAndCommodity;
import com.ifeng.bigtrade.cms.entites.website.FloorAndCommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

public abstract interface FloorAndCommodityMapper
{
  @DeleteProvider(type=FloorAndCommoditySqlProvider.class, method="deleteByExample")
  public abstract int deleteByExample(FloorAndCommodityExample paramFloorAndCommodityExample);

  @Delete({"delete from cms_floor_commodity", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int deleteByPrimaryKey(Long paramLong);

  @Insert({"insert into cms_floor_commodity (id, floorId, ", "commodityId, addTime, ", "deleteStatus)", "values (#{id,jdbcType=BIGINT}, #{floorId,jdbcType=BIGINT}, ", "#{commodityId,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ", "#{deleteStatus,jdbcType=BIT})"})
  public abstract int insert(FloorAndCommodity paramFloorAndCommodity);

  @InsertProvider(type=FloorAndCommoditySqlProvider.class, method="insertSelective")
  public abstract int insertSelective(FloorAndCommodity paramFloorAndCommodity);

  @SelectProvider(type=FloorAndCommoditySqlProvider.class, method="selectByExample")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="floorId", property="floorId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="commodityId", property="commodityId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT)})
  public abstract List<FloorAndCommodity> selectByExample(FloorAndCommodityExample paramFloorAndCommodityExample);

  @Select({"select", "id, floorId, commodityId, addTime, deleteStatus", "from cms_floor_commodity", "where id = #{id,jdbcType=BIGINT}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="floorId", property="floorId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="commodityId", property="commodityId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT)})
  public abstract FloorAndCommodity selectByPrimaryKey(Long paramLong);

  @UpdateProvider(type=FloorAndCommoditySqlProvider.class, method="updateByPrimaryKeySelective")
  public abstract int updateByPrimaryKeySelective(FloorAndCommodity paramFloorAndCommodity);

  @Update({"update cms_floor_commodity", "set floorId = #{floorId,jdbcType=BIGINT},", "commodityId = #{commodityId,jdbcType=BIGINT},", "addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKey(FloorAndCommodity paramFloorAndCommodity);
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.mapper.website.FloorAndCommodityMapper
 * JD-Core Version:    0.6.2
 */
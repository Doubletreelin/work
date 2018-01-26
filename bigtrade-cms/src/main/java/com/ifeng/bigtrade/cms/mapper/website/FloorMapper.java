package com.ifeng.bigtrade.cms.mapper.website;

import com.ifeng.bigtrade.cms.entites.website.Floor;
import com.ifeng.bigtrade.cms.entites.website.FloorExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

public abstract interface FloorMapper
{
  @DeleteProvider(type=FloorSqlProvider.class, method="deleteByExample")
  public abstract int deleteByExample(FloorExample paramFloorExample);

  @Delete({"delete from cms_floor", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int deleteByPrimaryKey(Long paramLong);

  @Insert({"insert into cms_floor (id, addTime, ", "deleteStatus, title, ", "description, showState, ", "serialNum)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ", "#{deleteStatus,jdbcType=BIT}, #{title,jdbcType=VARCHAR}, ", "#{description,jdbcType=VARCHAR}, #{showState,jdbcType=INTEGER}, ", "#{serialNum,jdbcType=INTEGER})"})
  @Options(keyProperty="id", useGeneratedKeys=true)
  public abstract int insert(Floor paramFloor);

  @InsertProvider(type=FloorSqlProvider.class, method="insertSelective")
  public abstract int insertSelective(Floor paramFloor);

  @SelectProvider(type=FloorSqlProvider.class, method="selectByExample")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="title", property="title", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="description", property="description", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="showState", property="showState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="serialNum", property="serialNum", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract List<Floor> selectByExample(FloorExample paramFloorExample);

  @Select({"select", "id, addTime, deleteStatus, title, description, showState, serialNum", "from cms_floor", "where id = #{id,jdbcType=BIGINT}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="title", property="title", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="description", property="description", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="showState", property="showState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="serialNum", property="serialNum", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract Floor selectByPrimaryKey(Long paramLong);

  @UpdateProvider(type=FloorSqlProvider.class, method="updateByPrimaryKeySelective")
  public abstract int updateByPrimaryKeySelective(Floor paramFloor);

  @Update({"update cms_floor", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "title = #{title,jdbcType=VARCHAR},", "description = #{description,jdbcType=VARCHAR},", "showState = #{showState,jdbcType=INTEGER},", "serialNum = #{serialNum,jdbcType=INTEGER}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKey(Floor paramFloor);
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.mapper.website.FloorMapper
 * JD-Core Version:    0.6.2
 */
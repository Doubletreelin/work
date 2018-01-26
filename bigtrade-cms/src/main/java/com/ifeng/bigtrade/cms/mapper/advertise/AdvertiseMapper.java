package com.ifeng.bigtrade.cms.mapper.advertise;

import com.ifeng.bigtrade.cms.entites.advertise.Advertise;
import com.ifeng.bigtrade.cms.entites.advertise.AdvertiseExample;
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

public abstract interface AdvertiseMapper
{
  @DeleteProvider(type=AdvertiseSqlProvider.class, method="deleteByExample")
  public abstract int deleteByExample(AdvertiseExample paramAdvertiseExample);

  @Delete({"delete from cms_advertise", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int deleteByPrimaryKey(Long paramLong);

  @Insert({"insert into cms_advertise (id, addTime, ", "deleteStatus, name, ", "imgeLink, imgeUrl, ", "position, belongTo, ", "updateTime, plan, ", "orderNum)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ", "#{deleteStatus,jdbcType=BIT}, #{name,jdbcType=VARCHAR}, ", "#{imgeLink,jdbcType=VARCHAR}, #{imgeUrl,jdbcType=VARCHAR}, ", "#{position,jdbcType=INTEGER}, #{belongTo,jdbcType=INTEGER}, ", "#{updateTime,jdbcType=TIMESTAMP}, #{plan,jdbcType=VARCHAR}, ", "#{orderNum,jdbcType=INTEGER})"})
  @Options(useGeneratedKeys=true, keyProperty="id")
  public abstract int insert(Advertise paramAdvertise);

  @InsertProvider(type=AdvertiseSqlProvider.class, method="insertSelective")
  public abstract int insertSelective(Advertise paramAdvertise);

  @SelectProvider(type=AdvertiseSqlProvider.class, method="selectByExample")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="imgeLink", property="imgeLink", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="imgeUrl", property="imgeUrl", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="position", property="position", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="belongTo", property="belongTo", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="updateTime", property="updateTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="plan", property="plan", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="orderNum", property="orderNum", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract List<Advertise> selectByExample(AdvertiseExample paramAdvertiseExample);

  @Select({"select", "id, addTime, deleteStatus, name, imgeLink, imgeUrl, position, belongTo, updateTime, ", "plan, orderNum", "from cms_advertise", "where id = #{id,jdbcType=BIGINT}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="imgeLink", property="imgeLink", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="imgeUrl", property="imgeUrl", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="position", property="position", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="belongTo", property="belongTo", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="updateTime", property="updateTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="plan", property="plan", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="orderNum", property="orderNum", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract Advertise selectByPrimaryKey(Long paramLong);

  @UpdateProvider(type=AdvertiseSqlProvider.class, method="updateByPrimaryKeySelective")
  public abstract int updateByPrimaryKeySelective(Advertise paramAdvertise);

  @Update({"update cms_advertise", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "name = #{name,jdbcType=VARCHAR},", "imgeLink = #{imgeLink,jdbcType=VARCHAR},", "imgeUrl = #{imgeUrl,jdbcType=VARCHAR},", "position = #{position,jdbcType=INTEGER},", "belongTo = #{belongTo,jdbcType=INTEGER},", "updateTime = #{updateTime,jdbcType=TIMESTAMP},", "plan = #{plan,jdbcType=VARCHAR},", "orderNum = #{orderNum,jdbcType=INTEGER}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKey(Advertise paramAdvertise);
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.mapper.advertise.AdvertiseMapper
 * JD-Core Version:    0.6.2
 */
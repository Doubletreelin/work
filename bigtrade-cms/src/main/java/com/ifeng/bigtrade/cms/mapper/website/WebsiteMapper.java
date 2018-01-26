package com.ifeng.bigtrade.cms.mapper.website;

import com.ifeng.bigtrade.cms.entites.website.Website;
import com.ifeng.bigtrade.cms.entites.website.WebsiteExample;
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

public abstract interface WebsiteMapper
{
  @DeleteProvider(type=WebsiteSqlProvider.class, method="deleteByExample")
  public abstract int deleteByExample(WebsiteExample paramWebsiteExample);

  @Delete({"delete from cms_website", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int deleteByPrimaryKey(Long paramLong);

  @Insert({"insert into cms_website (id, addTime, ", "deleteStatus, pkey, ", "notice, remark, ", "pvalue)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ", "#{deleteStatus,jdbcType=BIT}, #{pkey,jdbcType=VARCHAR}, ", "#{notice,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ", "#{pvalue,jdbcType=LONGVARCHAR})"})
  public abstract int insert(Website paramWebsite);

  @InsertProvider(type=WebsiteSqlProvider.class, method="insertSelective")
  public abstract int insertSelective(Website paramWebsite);

  @SelectProvider(type=WebsiteSqlProvider.class, method="selectByExampleWithBLOBs")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="pkey", property="pkey", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="notice", property="notice", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="remark", property="remark", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="pvalue", property="pvalue", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR)})
  public abstract List<Website> selectByExampleWithBLOBs(WebsiteExample paramWebsiteExample);

  @SelectProvider(type=WebsiteSqlProvider.class, method="selectByExample")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="pkey", property="pkey", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="notice", property="notice", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="remark", property="remark", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  public abstract List<Website> selectByExample(WebsiteExample paramWebsiteExample);

  @Select({"select", "id, addTime, deleteStatus, pkey, notice, remark, pvalue", "from cms_website", "where id = #{id,jdbcType=BIGINT}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="pkey", property="pkey", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="notice", property="notice", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="remark", property="remark", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="pvalue", property="pvalue", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR)})
  public abstract Website selectByPrimaryKey(Long paramLong);

  @UpdateProvider(type=WebsiteSqlProvider.class, method="updateByPrimaryKeySelective")
  public abstract int updateByPrimaryKeySelective(Website paramWebsite);

  @Update({"update cms_website", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "pkey = #{pkey,jdbcType=VARCHAR},", "notice = #{notice,jdbcType=VARCHAR},", "remark = #{remark,jdbcType=VARCHAR},", "pvalue = #{pvalue,jdbcType=LONGVARCHAR}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKeyWithBLOBs(Website paramWebsite);

  @Update({"update cms_website", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "pkey = #{pkey,jdbcType=VARCHAR},", "notice = #{notice,jdbcType=VARCHAR},", "remark = #{remark,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKey(Website paramWebsite);
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.mapper.website.WebsiteMapper
 * JD-Core Version:    0.6.2
 */
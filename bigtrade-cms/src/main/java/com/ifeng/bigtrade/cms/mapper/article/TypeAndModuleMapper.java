package com.ifeng.bigtrade.cms.mapper.article;

import com.ifeng.bigtrade.cms.entites.article.TypeAndModule;
import com.ifeng.bigtrade.cms.entites.article.TypeAndModuleExample;
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

public abstract interface TypeAndModuleMapper
{
  @DeleteProvider(type=TypeAndModuleSqlProvider.class, method="deleteByExample")
  public abstract int deleteByExample(TypeAndModuleExample paramTypeAndModuleExample);

  @Delete({"delete from cms_typemodule", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int deleteByPrimaryKey(Long paramLong);

  @Insert({"insert into cms_typemodule (id, addTime, ", "deleteStatus, typeId, ", "moduleId)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ", "#{deleteStatus,jdbcType=BIT}, #{typeId,jdbcType=BIGINT}, ", "#{moduleId,jdbcType=BIGINT})"})
  public abstract int insert(TypeAndModule paramTypeAndModule);

  @InsertProvider(type=TypeAndModuleSqlProvider.class, method="insertSelective")
  public abstract int insertSelective(TypeAndModule paramTypeAndModule);

  @SelectProvider(type=TypeAndModuleSqlProvider.class, method="selectByExample")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="typeId", property="typeId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="moduleId", property="moduleId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT)})
  public abstract List<TypeAndModule> selectByExample(TypeAndModuleExample paramTypeAndModuleExample);

  @Select({"select", "id, addTime, deleteStatus, typeId, moduleId", "from cms_typemodule", "where id = #{id,jdbcType=BIGINT}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="typeId", property="typeId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="moduleId", property="moduleId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT)})
  public abstract TypeAndModule selectByPrimaryKey(Long paramLong);

  @UpdateProvider(type=TypeAndModuleSqlProvider.class, method="updateByPrimaryKeySelective")
  public abstract int updateByPrimaryKeySelective(TypeAndModule paramTypeAndModule);

  @Update({"update cms_typemodule", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "typeId = #{typeId,jdbcType=BIGINT},", "moduleId = #{moduleId,jdbcType=BIGINT}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKey(TypeAndModule paramTypeAndModule);
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.mapper.article.TypeAndModuleMapper
 * JD-Core Version:    0.6.2
 */
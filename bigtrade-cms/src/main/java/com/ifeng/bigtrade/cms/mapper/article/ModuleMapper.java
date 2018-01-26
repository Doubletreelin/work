package com.ifeng.bigtrade.cms.mapper.article;

import com.ifeng.bigtrade.cms.entites.article.Module;
import com.ifeng.bigtrade.cms.entites.article.ModuleExample;
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

public abstract interface ModuleMapper
{
  @DeleteProvider(type=ModuleSqlProvider.class, method="deleteByExample")
  public abstract int deleteByExample(ModuleExample paramModuleExample);

  @Delete({"delete from cms_module", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int deleteByPrimaryKey(Long paramLong);

  @Insert({"insert into cms_module (id, addTime, ", "deleteStatus, name)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ", "#{deleteStatus,jdbcType=BIT}, #{name,jdbcType=VARCHAR})"})
  public abstract int insert(Module paramModule);

  @InsertProvider(type=ModuleSqlProvider.class, method="insertSelective")
  public abstract int insertSelective(Module paramModule);

  @SelectProvider(type=ModuleSqlProvider.class, method="selectByExample")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  public abstract List<Module> selectByExample(ModuleExample paramModuleExample);

  @Select({"select", "id, addTime, deleteStatus, name", "from cms_module", "where id = #{id,jdbcType=BIGINT}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  public abstract Module selectByPrimaryKey(Long paramLong);

  @UpdateProvider(type=ModuleSqlProvider.class, method="updateByPrimaryKeySelective")
  public abstract int updateByPrimaryKeySelective(Module paramModule);

  @Update({"update cms_module", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "name = #{name,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKey(Module paramModule);

  @SelectProvider(type=ModuleSqlProvider.class, method="findAll")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="tnames", property="tnames", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  public abstract List<Module> findAll();
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.mapper.article.ModuleMapper
 * JD-Core Version:    0.6.2
 */
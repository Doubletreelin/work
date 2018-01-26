package com.ifeng.bigtrade.cms.mapper.article;

import com.ifeng.bigtrade.cms.entites.article.ArticleType;
import com.ifeng.bigtrade.cms.entites.article.ArticleTypeExample;
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

public abstract interface ArticleTypeMapper
{
  @DeleteProvider(type=ArticleTypeSqlProvider.class, method="deleteByExample")
  public abstract int deleteByExample(ArticleTypeExample paramArticleTypeExample);

  @Delete({"delete from cms_articletype", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int deleteByPrimaryKey(Long paramLong);

  @Insert({"insert into cms_articletype (id, addTime, ", "deleteStatus, name, ", "parentId, level)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ", "#{deleteStatus,jdbcType=BIT}, #{name,jdbcType=VARCHAR}, ", "#{parentId,jdbcType=BIGINT}, #{level,jdbcType=INTEGER})"})
  @Options(keyProperty="id", useGeneratedKeys=true)
  public abstract int insert(ArticleType paramArticleType);

  @InsertProvider(type=ArticleTypeSqlProvider.class, method="insertSelective")
  public abstract int insertSelective(ArticleType paramArticleType);

  @SelectProvider(type=ArticleTypeSqlProvider.class, method="selectByExample")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="parentId", property="parentId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="level", property="level", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract List<ArticleType> selectByExample(ArticleTypeExample paramArticleTypeExample);

  @Select({"select", "id, addTime, deleteStatus, name, parentId, level", "from cms_articletype", "where id = #{id,jdbcType=BIGINT}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="parentId", property="parentId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="level", property="level", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract ArticleType selectByPrimaryKey(Long paramLong);

  @UpdateProvider(type=ArticleTypeSqlProvider.class, method="updateByPrimaryKeySelective")
  public abstract int updateByPrimaryKeySelective(ArticleType paramArticleType);

  @Update({"update cms_articletype", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "name = #{name,jdbcType=VARCHAR},", "parentId = #{parentId,jdbcType=BIGINT},", "level = #{level,jdbcType=INTEGER}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKey(ArticleType paramArticleType);

  @SelectProvider(type=ArticleTypeSqlProvider.class, method="selectByCondition")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="parentId", property="parentId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="level", property="level", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract List<ArticleType> selectByCondition(ArticleType paramArticleType);

  @SelectProvider(type=ArticleTypeSqlProvider.class, method="selectMaintype")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="name", property="name", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="level", property="level", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract List<ArticleType> selectMaintype(Long paramLong);
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.mapper.article.ArticleTypeMapper
 * JD-Core Version:    0.6.2
 */
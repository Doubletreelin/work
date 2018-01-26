package com.ifeng.bigtrade.cms.mapper.article;

import com.ifeng.bigtrade.cms.entites.article.Article;
import com.ifeng.bigtrade.cms.entites.article.ArticleExample;
import com.ifeng.bigtrade.cms.entites.article.ArticleWithBLOBs;
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

public abstract interface ArticleMapper
{
  @DeleteProvider(type=ArticleSqlProvider.class, method="deleteByExample")
  public abstract int deleteByExample(ArticleExample paramArticleExample);

  @Delete({"delete from cms_article", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int deleteByPrimaryKey(Long paramLong);

  @Insert({"insert into cms_article (id, addTime, ", "deleteStatus, title, ", "typeId, author, submitter, ", "submitTime, publishTime, ", "pictureUrl, auditor, ", "auditTime, auditState, ", "showState, hits, ", "summary, content, ", "remarks)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ", "#{deleteStatus,jdbcType=BIT}, #{title,jdbcType=VARCHAR}, ", "#{typeId,jdbcType=BIGINT}, #{author,jdbcType=VARCHAR}, #{submitter,jdbcType=VARCHAR}, ", "#{submitTime,jdbcType=TIMESTAMP}, #{publishTime,jdbcType=TIMESTAMP}, ", "#{pictureUrl,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, ", "#{auditTime,jdbcType=TIMESTAMP}, #{auditState,jdbcType=INTEGER}, ", "#{showState,jdbcType=INTEGER}, #{hits,jdbcType=INTEGER}, ", "#{summary,jdbcType=LONGVARCHAR}, #{content,jdbcType=LONGVARCHAR}, ", "#{remarks,jdbcType=LONGVARCHAR})"})
  @Options(keyProperty="id", useGeneratedKeys=true)
  public abstract int insert(ArticleWithBLOBs paramArticleWithBLOBs);

  @InsertProvider(type=ArticleSqlProvider.class, method="insertSelective")
  public abstract int insertSelective(ArticleWithBLOBs paramArticleWithBLOBs);

  @SelectProvider(type=ArticleSqlProvider.class, method="selectByExampleWithBLOBs")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="title", property="title", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="typeId", property="typeId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="author", property="author", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitter", property="submitter", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitTime", property="submitTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="publishTime", property="publishTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="pictureUrl", property="pictureUrl", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditor", property="auditor", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditTime", property="auditTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="auditState", property="auditState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="showState", property="showState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="hits", property="hits", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="summary", property="summary", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="content", property="content", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="remarks", property="remarks", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR)})
  public abstract List<ArticleWithBLOBs> selectByExampleWithBLOBs(ArticleExample paramArticleExample);

  @SelectProvider(type=ArticleSqlProvider.class, method="selectByExample")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="title", property="title", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="typeId", property="typeId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="author", property="author", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitter", property="submitter", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitTime", property="submitTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="publishTime", property="publishTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="pictureUrl", property="pictureUrl", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditor", property="auditor", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditTime", property="auditTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="auditState", property="auditState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="showState", property="showState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="hits", property="hits", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER)})
  public abstract List<Article> selectByExample(ArticleExample paramArticleExample);

  @Select({"select", "id, addTime, deleteStatus, title, typeId, author, submitter, submitTime, publishTime, ", "pictureUrl, auditor, auditTime, auditState, showState, hits, summary, content, ", "remarks", "from cms_article", "where id = #{id,jdbcType=BIGINT}"})
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="title", property="title", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="typeId", property="typeId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="author", property="author", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitter", property="submitter", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitTime", property="submitTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="publishTime", property="publishTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="pictureUrl", property="pictureUrl", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditor", property="auditor", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditTime", property="auditTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="auditState", property="auditState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="showState", property="showState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="hits", property="hits", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="summary", property="summary", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="content", property="content", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="remarks", property="remarks", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR)})
  public abstract ArticleWithBLOBs selectByPrimaryKey(Long paramLong);

  @UpdateProvider(type=ArticleSqlProvider.class, method="updateByPrimaryKeySelective")
  public abstract int updateByPrimaryKeySelective(ArticleWithBLOBs paramArticleWithBLOBs);

  @Update({"update cms_article", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "title = #{title,jdbcType=VARCHAR},", "typeId = #{typeId,jdbcType=BIGINT},", "author = #{author,jdbcType=VARCHAR},", "submitter = #{submitter,jdbcType=VARCHAR},", "submitTime = #{submitTime,jdbcType=TIMESTAMP},", "publishTime = #{publishTime,jdbcType=TIMESTAMP},", "pictureUrl = #{pictureUrl,jdbcType=VARCHAR},", "auditor = #{auditor,jdbcType=VARCHAR},", "auditTime = #{auditTime,jdbcType=TIMESTAMP},", "auditState = #{auditState,jdbcType=INTEGER},", "showState = #{showState,jdbcType=INTEGER},", "hits = #{hits,jdbcType=INTEGER},", "summary = #{summary,jdbcType=LONGVARCHAR},", "content = #{content,jdbcType=LONGVARCHAR},", "remarks = #{remarks,jdbcType=LONGVARCHAR}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs paramArticleWithBLOBs);

  @Update({"update cms_article", "set addTime = #{addTime,jdbcType=TIMESTAMP},", "deleteStatus = #{deleteStatus,jdbcType=BIT},", "title = #{title,jdbcType=VARCHAR},", "typeId = #{typeId,jdbcType=BIGINT},", "author = #{author,jdbcType=VARCHAR},", "submitter = #{submitter,jdbcType=VARCHAR},", "submitTime = #{submitTime,jdbcType=TIMESTAMP},", "publishTime = #{publishTime,jdbcType=TIMESTAMP},", "pictureUrl = #{pictureUrl,jdbcType=VARCHAR},", "auditor = #{auditor,jdbcType=VARCHAR},", "auditTime = #{auditTime,jdbcType=TIMESTAMP},", "auditState = #{auditState,jdbcType=INTEGER},", "showState = #{showState,jdbcType=INTEGER},", "hits = #{hits,jdbcType=INTEGER}", "where id = #{id,jdbcType=BIGINT}"})
  public abstract int updateByPrimaryKey(Article paramArticle);

  @SelectProvider(type=ArticleSqlProvider.class, method="selectWithType")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="title", property="title", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="typeId", property="typeId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="author", property="author", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitter", property="submitter", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitTime", property="submitTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="publishTime", property="publishTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="pictureUrl", property="pictureUrl", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditor", property="auditor", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditTime", property="auditTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="auditState", property="auditState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="showState", property="showState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="hits", property="hits", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="summary", property="summary", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="content", property="content", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="remarks", property="remarks", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="mainName", property="mainName", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="subName", property="subName", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="mainId", property="mainId", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR)})
  public abstract List<ArticleWithBLOBs> selectWithType(ArticleWithBLOBs paramArticleWithBLOBs);

  @SelectProvider(type=ArticleSqlProvider.class, method="selectByType")
  @Results({@org.apache.ibatis.annotations.Result(column="id", property="id", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT, id=true), @org.apache.ibatis.annotations.Result(column="addTime", property="addTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="deleteStatus", property="deleteStatus", jdbcType=org.apache.ibatis.type.JdbcType.BIT), @org.apache.ibatis.annotations.Result(column="title", property="title", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="typeId", property="typeId", jdbcType=org.apache.ibatis.type.JdbcType.BIGINT), @org.apache.ibatis.annotations.Result(column="author", property="author", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitter", property="submitter", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="submitTime", property="submitTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="publishTime", property="publishTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="pictureUrl", property="pictureUrl", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditor", property="auditor", jdbcType=org.apache.ibatis.type.JdbcType.VARCHAR), @org.apache.ibatis.annotations.Result(column="auditTime", property="auditTime", jdbcType=org.apache.ibatis.type.JdbcType.TIMESTAMP), @org.apache.ibatis.annotations.Result(column="auditState", property="auditState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="showState", property="showState", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="hits", property="hits", jdbcType=org.apache.ibatis.type.JdbcType.INTEGER), @org.apache.ibatis.annotations.Result(column="summary", property="summary", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="content", property="content", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR), @org.apache.ibatis.annotations.Result(column="remarks", property="remarks", jdbcType=org.apache.ibatis.type.JdbcType.LONGVARCHAR)})
  public abstract List<ArticleWithBLOBs> selectByType(Long paramLong1, boolean paramBoolean, Long paramLong2, Long paramLong3);
}

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.mapper.article.ArticleMapper
 * JD-Core Version:    0.6.2
 */
package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.ParamNode;
import com.ifeng.bigtrade.trade.entites.ParamNodeExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ParamNodeMapper
{
	@Delete(
	{ "delete from tr_paramnode", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	@Insert(
	{ "insert into tr_paramnode (id, addTime, ", "paramId, nodeId)",
			"values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
			"#{paramId,jdbcType=BIGINT}, #{nodeId,jdbcType=BIGINT})" })
	int insert(ParamNode record);

	@InsertProvider(type = ParamNodeSqlProvider.class, method = "insertSelective")
	int insertSelective(ParamNode record);

	@SelectProvider(type = ParamNodeSqlProvider.class, method = "selectByExample")
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "paramId", property = "paramId", jdbcType = JdbcType.BIGINT),
			@Result(column = "nodeId", property = "nodeId", jdbcType = JdbcType.BIGINT) })
	List<ParamNode> selectByExample(ParamNodeExample example);

	@Select(
	{ "select", "id, addTime, paramId, nodeId", "from tr_paramnode",
			"where id = #{id,jdbcType=BIGINT}" })
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "paramId", property = "paramId", jdbcType = JdbcType.BIGINT),
			@Result(column = "nodeId", property = "nodeId", jdbcType = JdbcType.BIGINT) })
	ParamNode selectByPrimaryKey(Long id);

	@UpdateProvider(type = ParamNodeSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(ParamNode record);

	@Update(
	{ "update tr_paramnode", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"paramId = #{paramId,jdbcType=BIGINT},", "nodeId = #{nodeId,jdbcType=BIGINT}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(ParamNode record);

	@Delete(
	{ "delete from tr_paramnode", "where paramId = #{pid,jdbcType=BIGINT}" })
	int deleteByParamId(Long pid);

	@Delete(
	{ "delete from tr_paramnode", "where nodeId = #{nid,jdbcType=BIGINT}" })
	int deleteByNodeId(Long nid);

	@Select(
	{ "select", "GROUP_CONCAT(nodeId)", "from tr_paramnode",
			"where paramId = #{pid,jdbcType=BIGINT}" })
	String getParamNids(Long pid) throws Exception;
}
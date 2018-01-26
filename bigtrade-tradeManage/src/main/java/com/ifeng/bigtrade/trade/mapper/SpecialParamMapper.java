package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.SpecialParam;
import com.ifeng.bigtrade.trade.entites.SpecialParamExample;
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

public interface SpecialParamMapper
{
	@Delete(
	{ "delete from tr_specialparam", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	@Insert(
	{ "insert into tr_specialparam (id, addTime, ", "deleteStatus, userId, ", "commodityId, buyCharge, ",
			"sellCharge, chargeAlg)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
			"#{deleteStatus,jdbcType=BIT}, #{userId,jdbcType=BIGINT}, ",
			"#{commodityId,jdbcType=BIGINT}, #{buyCharge,jdbcType=DECIMAL}, ",
			"#{sellCharge,jdbcType=DECIMAL}, #{chargeAlg,jdbcType=INTEGER})" })
	int insert(SpecialParam record);

	@InsertProvider(type = SpecialParamSqlProvider.class, method = "insertSelective")
	int insertSelective(SpecialParam record);

	@SelectProvider(type = SpecialParamSqlProvider.class, method = "selectByExample")
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "userId", property = "userId", jdbcType = JdbcType.BIGINT),
			@Result(column = "commodityId", property = "commodityId", jdbcType = JdbcType.BIGINT),
			@Result(column = "buyCharge", property = "buyCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "sellCharge", property = "sellCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "chargeAlg", property = "chargeAlg", jdbcType = JdbcType.INTEGER) })
	List<SpecialParam> selectByExample(SpecialParamExample example);

	@Select(
	{ "select", "id, addTime, deleteStatus, userId, commodityId, buyCharge, sellCharge, chargeAlg",
			"from tr_specialparam", "where id = #{id,jdbcType=BIGINT}" })
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "userId", property = "userId", jdbcType = JdbcType.BIGINT),
			@Result(column = "commodityId", property = "commodityId", jdbcType = JdbcType.BIGINT),
			@Result(column = "buyCharge", property = "buyCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "sellCharge", property = "sellCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "chargeAlg", property = "chargeAlg", jdbcType = JdbcType.INTEGER) })
	SpecialParam selectByPrimaryKey(Long id);

	@UpdateProvider(type = SpecialParamSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(SpecialParam record);

	@Update(
	{ "update tr_specialparam", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"deleteStatus = #{deleteStatus,jdbcType=BIT},", "userId = #{userId,jdbcType=BIGINT},",
			"commodityId = #{commodityId,jdbcType=BIGINT},", "buyCharge = #{buyCharge,jdbcType=DECIMAL},",
			"sellCharge = #{sellCharge,jdbcType=DECIMAL},", "chargeAlg = #{chargeAlg,jdbcType=INTEGER}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(SpecialParam record);
}
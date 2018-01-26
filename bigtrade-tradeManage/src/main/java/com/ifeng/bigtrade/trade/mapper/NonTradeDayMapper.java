package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.NonTradeDay;
import com.ifeng.bigtrade.trade.entites.NonTradeDayExample;
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

public interface NonTradeDayMapper
{
	@Delete(
	{ "delete from tr_nontradeday", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	@Insert(
	{ "insert into tr_nontradeday (id, addTime, ", "deleteStatus, nonDay, ", "nonWeek)",
			"values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
			"#{deleteStatus,jdbcType=BIT}, #{nonDay,jdbcType=VARCHAR}, ", "#{nonWeek,jdbcType=VARCHAR})" })
	int insert(NonTradeDay record);

	@InsertProvider(type = NonTradeDaySqlProvider.class, method = "insertSelective")
	int insertSelective(NonTradeDay record);

	@SelectProvider(type = NonTradeDaySqlProvider.class, method = "selectByExample")
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "nonDay", property = "nonDay", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nonWeek", property = "nonWeek", jdbcType = JdbcType.VARCHAR) })
	List<NonTradeDay> selectByExample(NonTradeDayExample example);

	@Select(
	{ "select", "id, addTime, deleteStatus, nonDay, nonWeek", "from tr_nontradeday", "where id = #{id,jdbcType=BIGINT}" })
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "nonDay", property = "nonDay", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nonWeek", property = "nonWeek", jdbcType = JdbcType.VARCHAR) })
	NonTradeDay selectByPrimaryKey(Long id);

	@UpdateProvider(type = NonTradeDaySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(NonTradeDay record);

	@Update(
	{ "update tr_nontradeday", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"deleteStatus = #{deleteStatus,jdbcType=BIT},", "nonDay = #{nonDay,jdbcType=VARCHAR},",
			"nonWeek = #{nonWeek,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(NonTradeDay record);
}
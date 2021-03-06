package com.ifeng.bigtrade.finance.mapper;

import com.ifeng.bigtrade.finance.entites.FLedgerField;
import com.ifeng.bigtrade.finance.entites.FLedgerFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FLedgerFieldMapper
{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@SelectProvider(type = FLedgerFieldSqlProvider.class, method = "countByExample")
	long countByExample(FLedgerFieldExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@DeleteProvider(type = FLedgerFieldSqlProvider.class, method = "deleteByExample")
	int deleteByExample(FLedgerFieldExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@Delete(
	{ "delete from f_ledgerfield", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@Insert(
	{ "insert into f_ledgerfield (id, addTime, ", "deleteStatus, code, ", "name, systemId)",
			"values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
			"#{deleteStatus,jdbcType=BIT}, #{code,jdbcType=VARCHAR}, ",
			"#{name,jdbcType=VARCHAR}, #{systemId,jdbcType=VARCHAR})" })
	int insert(FLedgerField record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@InsertProvider(type = FLedgerFieldSqlProvider.class, method = "insertSelective")
	int insertSelective(FLedgerField record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@SelectProvider(type = FLedgerFieldSqlProvider.class, method = "selectByExample")
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "systemId", property = "systemId", jdbcType = JdbcType.VARCHAR) })
	List<FLedgerField> selectByExample(FLedgerFieldExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@Select(
	{ "select", "id, addTime, deleteStatus, code, name, systemId", "from f_ledgerfield",
			"where id = #{id,jdbcType=BIGINT}" })
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "systemId", property = "systemId", jdbcType = JdbcType.VARCHAR) })
	FLedgerField selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@UpdateProvider(type = FLedgerFieldSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") FLedgerField record, @Param("example") FLedgerFieldExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@UpdateProvider(type = FLedgerFieldSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") FLedgerField record, @Param("example") FLedgerFieldExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@UpdateProvider(type = FLedgerFieldSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(FLedgerField record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_ledgerfield
	 *
	 * @mbg.generated Wed Aug 16 16:25:47 CST 2017
	 */
	@Update(
	{ "update f_ledgerfield", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"deleteStatus = #{deleteStatus,jdbcType=BIT},", "code = #{code,jdbcType=VARCHAR},",
			"name = #{name,jdbcType=VARCHAR},", "systemId = #{systemId,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(FLedgerField record);
}
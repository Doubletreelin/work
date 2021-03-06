package com.ifeng.bigtrade.finance.mapper;

import com.ifeng.bigtrade.finance.entites.FVoucherModel;
import com.ifeng.bigtrade.finance.entites.FVoucherModelExample;
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

public interface FVoucherModelMapper
{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@SelectProvider(type = FVoucherModelSqlProvider.class, method = "countByExample")
	long countByExample(FVoucherModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@DeleteProvider(type = FVoucherModelSqlProvider.class, method = "deleteByExample")
	int deleteByExample(FVoucherModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@Delete(
	{ "delete from f_vouchermodel", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@Insert(
	{ "insert into f_vouchermodel (id, addTime, ", "deleteStatus, modelCode, ", "modelName, creditCode, ",
			"debitCode, contractNo, ", "summary_id, note)",
			"values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
			"#{deleteStatus,jdbcType=BIT}, #{modelCode,jdbcType=VARCHAR}, ",
			"#{modelName,jdbcType=VARCHAR}, #{creditCode,jdbcType=VARCHAR}, ",
			"#{debitCode,jdbcType=VARCHAR}, #{contractNo,jdbcType=VARCHAR}, ",
			"#{summary_id,jdbcType=BIGINT}, #{note,jdbcType=LONGVARCHAR})" })
	int insert(FVoucherModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@InsertProvider(type = FVoucherModelSqlProvider.class, method = "insertSelective")
	int insertSelective(FVoucherModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@SelectProvider(type = FVoucherModelSqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "modelCode", property = "modelCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "modelName", property = "modelName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "creditCode", property = "creditCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "debitCode", property = "debitCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "contractNo", property = "contractNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "summary_id", property = "summary_id", jdbcType = JdbcType.BIGINT),
			@Result(column = "note", property = "note", jdbcType = JdbcType.LONGVARCHAR) })
	List<FVoucherModel> selectByExampleWithBLOBs(FVoucherModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@SelectProvider(type = FVoucherModelSqlProvider.class, method = "selectByExample")
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "modelCode", property = "modelCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "modelName", property = "modelName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "creditCode", property = "creditCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "debitCode", property = "debitCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "contractNo", property = "contractNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "summary_id", property = "summary_id", jdbcType = JdbcType.BIGINT) })
	List<FVoucherModel> selectByExample(FVoucherModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@Select(
	{ "select", "id, addTime, deleteStatus, modelCode, modelName, creditCode, debitCode, contractNo, ",
			"summary_id, note", "from f_vouchermodel", "where id = #{id,jdbcType=BIGINT}" })
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "modelCode", property = "modelCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "modelName", property = "modelName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "creditCode", property = "creditCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "debitCode", property = "debitCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "contractNo", property = "contractNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "summary_id", property = "summary_id", jdbcType = JdbcType.BIGINT),
			@Result(column = "note", property = "note", jdbcType = JdbcType.LONGVARCHAR) })
	FVoucherModel selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@UpdateProvider(type = FVoucherModelSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") FVoucherModel record, @Param("example") FVoucherModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@UpdateProvider(type = FVoucherModelSqlProvider.class, method = "updateByExampleWithBLOBs")
	int updateByExampleWithBLOBs(@Param("record") FVoucherModel record, @Param("example") FVoucherModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@UpdateProvider(type = FVoucherModelSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") FVoucherModel record, @Param("example") FVoucherModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@UpdateProvider(type = FVoucherModelSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(FVoucherModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@Update(
	{ "update f_vouchermodel", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"deleteStatus = #{deleteStatus,jdbcType=BIT},", "modelCode = #{modelCode,jdbcType=VARCHAR},",
			"modelName = #{modelName,jdbcType=VARCHAR},", "creditCode = #{creditCode,jdbcType=VARCHAR},",
			"debitCode = #{debitCode,jdbcType=VARCHAR},", "contractNo = #{contractNo,jdbcType=VARCHAR},",
			"summary_id = #{summary_id,jdbcType=BIGINT},", "note = #{note,jdbcType=LONGVARCHAR}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKeyWithBLOBs(FVoucherModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	@Update(
	{ "update f_vouchermodel", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"deleteStatus = #{deleteStatus,jdbcType=BIT},", "modelCode = #{modelCode,jdbcType=VARCHAR},",
			"modelName = #{modelName,jdbcType=VARCHAR},", "creditCode = #{creditCode,jdbcType=VARCHAR},",
			"debitCode = #{debitCode,jdbcType=VARCHAR},", "contractNo = #{contractNo,jdbcType=VARCHAR},",
			"summary_id = #{summary_id,jdbcType=BIGINT}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(FVoucherModel record);
}
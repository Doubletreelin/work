package com.ifeng.bigtrade.finance.mapper;

import com.ifeng.bigtrade.finance.entites.FVoucherEntry;
import com.ifeng.bigtrade.finance.entites.FVoucherEntryExample;
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

public interface FVoucherEntryMapper
{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@SelectProvider(type = FVoucherEntrySqlProvider.class, method = "countByExample")
	long countByExample(FVoucherEntryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@DeleteProvider(type = FVoucherEntrySqlProvider.class, method = "deleteByExample")
	int deleteByExample(FVoucherEntryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@Delete(
	{ "delete from f_voucherentry", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@Insert(
	{ "insert into f_voucherentry (id, addTime, ", "deleteStatus, accountCode, ", "accountName, creditAmount, ",
			"debitAmount, voucher_id)", "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
			"#{deleteStatus,jdbcType=BIT}, #{accountCode,jdbcType=VARCHAR}, ",
			"#{accountName,jdbcType=VARCHAR}, #{creditAmount,jdbcType=DECIMAL}, ",
			"#{debitAmount,jdbcType=DECIMAL}, #{voucher_id,jdbcType=BIGINT})" })
	int insert(FVoucherEntry record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@InsertProvider(type = FVoucherEntrySqlProvider.class, method = "insertSelective")
	int insertSelective(FVoucherEntry record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@SelectProvider(type = FVoucherEntrySqlProvider.class, method = "selectByExample")
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "accountCode", property = "accountCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "accountName", property = "accountName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "creditAmount", property = "creditAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "debitAmount", property = "debitAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "voucher_id", property = "voucher_id", jdbcType = JdbcType.BIGINT) })
	List<FVoucherEntry> selectByExample(FVoucherEntryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@Select(
	{ "select", "id, addTime, deleteStatus, accountCode, accountName, creditAmount, debitAmount, ", "voucher_id",
			"from f_voucherentry", "where id = #{id,jdbcType=BIGINT}" })
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "accountCode", property = "accountCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "accountName", property = "accountName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "creditAmount", property = "creditAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "debitAmount", property = "debitAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "voucher_id", property = "voucher_id", jdbcType = JdbcType.BIGINT) })
	FVoucherEntry selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@UpdateProvider(type = FVoucherEntrySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") FVoucherEntry record, @Param("example") FVoucherEntryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@UpdateProvider(type = FVoucherEntrySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") FVoucherEntry record, @Param("example") FVoucherEntryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@UpdateProvider(type = FVoucherEntrySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(FVoucherEntry record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_voucherentry
	 *
	 * @mbg.generated Wed Aug 16 13:55:19 CST 2017
	 */
	@Update(
	{ "update f_voucherentry", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"deleteStatus = #{deleteStatus,jdbcType=BIT},", "accountCode = #{accountCode,jdbcType=VARCHAR},",
			"accountName = #{accountName,jdbcType=VARCHAR},", "creditAmount = #{creditAmount,jdbcType=DECIMAL},",
			"debitAmount = #{debitAmount,jdbcType=DECIMAL},", "voucher_id = #{voucher_id,jdbcType=BIGINT}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(FVoucherEntry record);
}
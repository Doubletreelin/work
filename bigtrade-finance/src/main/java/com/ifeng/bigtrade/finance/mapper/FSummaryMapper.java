package com.ifeng.bigtrade.finance.mapper;

import com.ifeng.bigtrade.finance.entites.FSummary;
import com.ifeng.bigtrade.finance.entites.FSummaryExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

/**
 * @author ifeng
 *
 */
public interface FSummaryMapper
{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@SelectProvider(type = FSummarySqlProvider.class, method = "countByExample")
	long countByExample(FSummaryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@DeleteProvider(type = FSummarySqlProvider.class, method = "deleteByExample")
	int deleteByExample(FSummaryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@Delete(
	{ "delete from f_summary", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@Options(keyProperty = "id", useGeneratedKeys = true)
	@Insert(
	{ "insert into f_summary (id, addTime, ", "deleteStatus, canDelete, ", "isUserFunds, summary, ",
			"summaryNo, ledger_id, ", "fundDCFlag, appendAccount, ", "accountCodeOpp)",
			"values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
			"#{deleteStatus,jdbcType=BIT}, #{canDelete,jdbcType=BIT}, ",
			"#{isUserFunds,jdbcType=BIT}, #{summary,jdbcType=VARCHAR}, ",
			"#{summaryNo,jdbcType=VARCHAR}, #{ledger_id,jdbcType=BIGINT}, ",
			"#{fundDCFlag,jdbcType=VARCHAR}, #{appendAccount,jdbcType=VARCHAR}, ",
			"#{accountCodeOpp,jdbcType=VARCHAR})" })
	int insert(FSummary record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@Options(keyProperty = "id", useGeneratedKeys = true)
	@InsertProvider(type = FSummarySqlProvider.class, method = "insertSelective")
	int insertSelective(FSummary record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@SelectProvider(type = FSummarySqlProvider.class, method = "selectByExample")
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "canDelete", property = "canDelete", jdbcType = JdbcType.BIT),
			@Result(column = "isUserFunds", property = "isUserFunds", jdbcType = JdbcType.BIT),
			@Result(column = "summary", property = "summary", jdbcType = JdbcType.VARCHAR),
			@Result(column = "summaryNo", property = "summaryNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ledger_id", property = "ledger_id", jdbcType = JdbcType.BIGINT),
			@Result(column = "fundDCFlag", property = "fundDCFlag", jdbcType = JdbcType.VARCHAR),
			@Result(column = "appendAccount", property = "appendAccount", jdbcType = JdbcType.VARCHAR),
			@Result(column = "accountCodeOpp", property = "accountCodeOpp", jdbcType = JdbcType.VARCHAR) })
	List<FSummary> selectByExample(FSummaryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@Select(
	{ "select", "id, addTime, deleteStatus, canDelete, isUserFunds, summary, summaryNo, ledger_id, ",
			"fundDCFlag, appendAccount, accountCodeOpp", "from f_summary", "where id = #{id,jdbcType=BIGINT}" })
	@Results(
	{ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "canDelete", property = "canDelete", jdbcType = JdbcType.BIT),
			@Result(column = "isUserFunds", property = "isUserFunds", jdbcType = JdbcType.BIT),
			@Result(column = "summary", property = "summary", jdbcType = JdbcType.VARCHAR),
			@Result(column = "summaryNo", property = "summaryNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ledger_id", property = "ledger_id", jdbcType = JdbcType.BIGINT),
			@Result(column = "fundDCFlag", property = "fundDCFlag", jdbcType = JdbcType.VARCHAR),
			@Result(column = "appendAccount", property = "appendAccount", jdbcType = JdbcType.VARCHAR),
			@Result(column = "accountCodeOpp", property = "accountCodeOpp", jdbcType = JdbcType.VARCHAR) })
	FSummary selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@UpdateProvider(type = FSummarySqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") FSummary record, @Param("example") FSummaryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@UpdateProvider(type = FSummarySqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") FSummary record, @Param("example") FSummaryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@UpdateProvider(type = FSummarySqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(FSummary record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_summary
	 *
	 * @mbg.generated Wed Aug 16 13:55:51 CST 2017
	 */
	@Update(
	{ "update f_summary", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"deleteStatus = #{deleteStatus,jdbcType=BIT},", "canDelete = #{canDelete,jdbcType=BIT},",
			"isUserFunds = #{isUserFunds,jdbcType=BIT},", "summary = #{summary,jdbcType=VARCHAR},",
			"summaryNo = #{summaryNo,jdbcType=VARCHAR},", "ledger_id = #{ledger_id,jdbcType=BIGINT},",
			"fundDCFlag = #{fundDCFlag,jdbcType=VARCHAR},", "appendAccount = #{appendAccount,jdbcType=VARCHAR},",
			"accountCodeOpp = #{accountCodeOpp,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(FSummary record);

	/************************** next new add *********************************/

	/**
	 * 查询摘要列表
	 * 
	 * @param systemid 关联到ledgerfield的系统号
	 * @param summaryno 摘要号
	 * @param order 排序字段
	 * @return
	 */
	@SelectProvider(type = FSummarySqlProvider.class, method = "selectSummary")
	@ResultType(HashMap.class)
	List<HashMap<String, Object>> selectSummary(String systemid, String summaryno);

}
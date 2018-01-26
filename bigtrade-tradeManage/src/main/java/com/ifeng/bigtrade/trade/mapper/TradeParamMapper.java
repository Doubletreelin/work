package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.TradeParam;
import com.ifeng.bigtrade.trade.entites.TradeParamExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TradeParamMapper
{
	@Delete(
	{ "delete from tr_tradeparam", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	@Insert(
	{ "insert into tr_tradeparam (id, addTime, ", "deleteStatus, commodityId, ",
			"tradeStatus, issuePrice, ", "openPrice, clearprice, ", "listingDate, lastTradeDate, ",
			"tradeUnit, minChangePrice, ", "minChangeAmount, upperLimitChange, ",
			"lowerLlimitChange, changeLimitAlg, ", "TnDay, effectDate, ",
			"maxPerEntrust, buyCharge, ", "sellCharge, chargeAlg, ",
			"chargeRemainRate, dayHostPrice, ", "freeHostday, hostChargeBegin, ",
			"settleUnit, deliveryBegin, ", "turnover)",
			"values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
			"#{deleteStatus,jdbcType=BIT}, #{commodityId,jdbcType=BIGINT}, ",
			"#{tradeStatus,jdbcType=INTEGER}, #{issuePrice,jdbcType=DECIMAL}, ",
			"#{openPrice,jdbcType=DECIMAL}, #{clearprice,jdbcType=DECIMAL}, ",
			"#{listingDate,jdbcType=TIMESTAMP}, #{lastTradeDate,jdbcType=TIMESTAMP}, ",
			"#{tradeUnit,jdbcType=VARCHAR}, #{minChangePrice,jdbcType=DECIMAL}, ",
			"#{minChangeAmount,jdbcType=INTEGER}, #{upperLimitChange,jdbcType=DECIMAL}, ",
			"#{lowerLlimitChange,jdbcType=DECIMAL}, #{changeLimitAlg,jdbcType=INTEGER}, ",
			"#{tnDay,jdbcType=INTEGER}, #{effectDate,jdbcType=TIMESTAMP}, ",
			"#{maxPerEntrust,jdbcType=BIGINT}, #{buyCharge,jdbcType=DECIMAL}, ",
			"#{sellCharge,jdbcType=DECIMAL}, #{chargeAlg,jdbcType=INTEGER}, ",
			"#{chargeRemainRate,jdbcType=DECIMAL}, #{dayHostPrice,jdbcType=DECIMAL}, ",
			"#{freeHostday,jdbcType=INTEGER}, #{hostChargeBegin,jdbcType=DATE}, ",
			"#{settleUnit,jdbcType=VARCHAR}, #{deliveryBegin,jdbcType=DATE}, ",
			"#{turnover,jdbcType=DECIMAL})" })
	@Options(keyProperty = "id", useGeneratedKeys = true)
	int insert(TradeParam record);

	@InsertProvider(type = TradeParamSqlProvider.class, method = "insertSelective")
	int insertSelective(TradeParam record);

	@SelectProvider(type = TradeParamSqlProvider.class, method = "selectByExample")
	@Results(
	{
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "commodityId", property = "commodityId", jdbcType = JdbcType.BIGINT),
			@Result(column = "tradeStatus", property = "tradeStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "issuePrice", property = "issuePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "openPrice", property = "openPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "clearprice", property = "clearprice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "listingDate", property = "listingDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "lastTradeDate", property = "lastTradeDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "tradeUnit", property = "tradeUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "minChangePrice", property = "minChangePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "minChangeAmount", property = "minChangeAmount", jdbcType = JdbcType.INTEGER),
			@Result(column = "upperLimitChange", property = "upperLimitChange", jdbcType = JdbcType.DECIMAL),
			@Result(column = "lowerLlimitChange", property = "lowerLlimitChange", jdbcType = JdbcType.DECIMAL),
			@Result(column = "changeLimitAlg", property = "changeLimitAlg", jdbcType = JdbcType.INTEGER),
			@Result(column = "TnDay", property = "tnDay", jdbcType = JdbcType.INTEGER),
			@Result(column = "effectDate", property = "effectDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "maxPerEntrust", property = "maxPerEntrust", jdbcType = JdbcType.BIGINT),
			@Result(column = "buyCharge", property = "buyCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "sellCharge", property = "sellCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "chargeAlg", property = "chargeAlg", jdbcType = JdbcType.INTEGER),
			@Result(column = "chargeRemainRate", property = "chargeRemainRate", jdbcType = JdbcType.DECIMAL),
			@Result(column = "dayHostPrice", property = "dayHostPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "freeHostday", property = "freeHostday", jdbcType = JdbcType.INTEGER),
			@Result(column = "hostChargeBegin", property = "hostChargeBegin", jdbcType = JdbcType.DATE),
			@Result(column = "settleUnit", property = "settleUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "deliveryBegin", property = "deliveryBegin", jdbcType = JdbcType.DATE),
			@Result(column = "turnover", property = "turnover", jdbcType = JdbcType.DECIMAL),
			@Result(column = "id", property = "nodeId", one = @One(select = "com.ifeng.bigtrade.trade.mapper.ParamNodeMapper.getParamNids")) })
	List<TradeParam> selectByExample(TradeParamExample example);

	@Select(
	{
			"select",
			"id, addTime, deleteStatus, commodityId, tradeStatus, issuePrice, openPrice, ",
			"clearprice, listingDate, lastTradeDate, tradeUnit, minChangePrice, minChangeAmount, ",
			"upperLimitChange, lowerLlimitChange, changeLimitAlg, TnDay, effectDate, maxPerEntrust, ",
			"buyCharge, sellCharge, chargeAlg, chargeRemainRate, dayHostPrice, freeHostday, ",
			"hostChargeBegin, settleUnit, deliveryBegin, turnover", "from tr_tradeparam",
			"where id = #{id,jdbcType=BIGINT}" })
	@Results(
	{
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "commodityId", property = "commodityId", jdbcType = JdbcType.BIGINT),
			@Result(column = "tradeStatus", property = "tradeStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "issuePrice", property = "issuePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "openPrice", property = "openPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "clearprice", property = "clearprice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "listingDate", property = "listingDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "lastTradeDate", property = "lastTradeDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "tradeUnit", property = "tradeUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "minChangePrice", property = "minChangePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "minChangeAmount", property = "minChangeAmount", jdbcType = JdbcType.INTEGER),
			@Result(column = "upperLimitChange", property = "upperLimitChange", jdbcType = JdbcType.DECIMAL),
			@Result(column = "lowerLlimitChange", property = "lowerLlimitChange", jdbcType = JdbcType.DECIMAL),
			@Result(column = "changeLimitAlg", property = "changeLimitAlg", jdbcType = JdbcType.INTEGER),
			@Result(column = "TnDay", property = "tnDay", jdbcType = JdbcType.INTEGER),
			@Result(column = "effectDate", property = "effectDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "maxPerEntrust", property = "maxPerEntrust", jdbcType = JdbcType.BIGINT),
			@Result(column = "buyCharge", property = "buyCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "sellCharge", property = "sellCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "chargeAlg", property = "chargeAlg", jdbcType = JdbcType.INTEGER),
			@Result(column = "chargeRemainRate", property = "chargeRemainRate", jdbcType = JdbcType.DECIMAL),
			@Result(column = "dayHostPrice", property = "dayHostPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "freeHostday", property = "freeHostday", jdbcType = JdbcType.INTEGER),
			@Result(column = "hostChargeBegin", property = "hostChargeBegin", jdbcType = JdbcType.DATE),
			@Result(column = "settleUnit", property = "settleUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "deliveryBegin", property = "deliveryBegin", jdbcType = JdbcType.DATE),
			@Result(column = "turnover", property = "turnover", jdbcType = JdbcType.DECIMAL) })
	TradeParam selectByPrimaryKey(Long id);

	@UpdateProvider(type = TradeParamSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(TradeParam record);

	@Update(
	{ "update tr_tradeparam", "set addTime = #{addTime,jdbcType=TIMESTAMP},",
			"deleteStatus = #{deleteStatus,jdbcType=BIT},",
			"commodityId = #{commodityId,jdbcType=BIGINT},",
			"tradeStatus = #{tradeStatus,jdbcType=INTEGER},",
			"issuePrice = #{issuePrice,jdbcType=DECIMAL},",
			"openPrice = #{openPrice,jdbcType=DECIMAL},",
			"clearprice = #{clearprice,jdbcType=DECIMAL},",
			"listingDate = #{listingDate,jdbcType=TIMESTAMP},",
			"lastTradeDate = #{lastTradeDate,jdbcType=TIMESTAMP},",
			"tradeUnit = #{tradeUnit,jdbcType=VARCHAR},",
			"minChangePrice = #{minChangePrice,jdbcType=DECIMAL},",
			"minChangeAmount = #{minChangeAmount,jdbcType=INTEGER},",
			"upperLimitChange = #{upperLimitChange,jdbcType=DECIMAL},",
			"lowerLlimitChange = #{lowerLlimitChange,jdbcType=DECIMAL},",
			"changeLimitAlg = #{changeLimitAlg,jdbcType=INTEGER},",
			"TnDay = #{tnDay,jdbcType=INTEGER},", "effectDate = #{effectDate,jdbcType=TIMESTAMP},",
			"maxPerEntrust = #{maxPerEntrust,jdbcType=BIGINT},",
			"buyCharge = #{buyCharge,jdbcType=DECIMAL},",
			"sellCharge = #{sellCharge,jdbcType=DECIMAL},",
			"chargeAlg = #{chargeAlg,jdbcType=INTEGER},",
			"chargeRemainRate = #{chargeRemainRate,jdbcType=DECIMAL},",
			"dayHostPrice = #{dayHostPrice,jdbcType=DECIMAL},",
			"freeHostday = #{freeHostday,jdbcType=INTEGER},",
			"hostChargeBegin = #{hostChargeBegin,jdbcType=DATE},",
			"settleUnit = #{settleUnit,jdbcType=VARCHAR},",
			"deliveryBegin = #{deliveryBegin,jdbcType=DATE},",
			"turnover = #{turnover,jdbcType=DECIMAL}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(TradeParam record);

	@Update(
	{ "update tr_tradeparam", "set nodeId = null", "where nodeId = #{nid,jdbcType=BIGINT}" })
	int updateNodeIdToNull(Long nid);

	@UpdateProvider(type = TradeParamSqlProvider.class, method = "updateByCommodityId")
	int updateByCid(TradeParam record);

	@SelectProvider(type = TradeParamSqlProvider.class, method = "getParamByNidOrPid")
	@Results(
	{
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "addTime", property = "addTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleteStatus", property = "deleteStatus", jdbcType = JdbcType.BIT),
			@Result(column = "commodityId", property = "commodityId", jdbcType = JdbcType.BIGINT),
			@Result(column = "tradeStatus", property = "tradeStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "issuePrice", property = "issuePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "openPrice", property = "openPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "clearprice", property = "clearprice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "listingDate", property = "listingDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "lastTradeDate", property = "lastTradeDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "tradeUnit", property = "tradeUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "minChangePrice", property = "minChangePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "minChangeAmount", property = "minChangeAmount", jdbcType = JdbcType.INTEGER),
			@Result(column = "upperLimitChange", property = "upperLimitChange", jdbcType = JdbcType.DECIMAL),
			@Result(column = "lowerLlimitChange", property = "lowerLlimitChange", jdbcType = JdbcType.DECIMAL),
			@Result(column = "changeLimitAlg", property = "changeLimitAlg", jdbcType = JdbcType.INTEGER),
			@Result(column = "TnDay", property = "tnDay", jdbcType = JdbcType.INTEGER),
			@Result(column = "effectDate", property = "effectDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "maxPerEntrust", property = "maxPerEntrust", jdbcType = JdbcType.BIGINT),
			@Result(column = "buyCharge", property = "buyCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "sellCharge", property = "sellCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "chargeAlg", property = "chargeAlg", jdbcType = JdbcType.INTEGER),
			@Result(column = "chargeRemainRate", property = "chargeRemainRate", jdbcType = JdbcType.DECIMAL),
			@Result(column = "dayHostPrice", property = "dayHostPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "freeHostday", property = "freeHostday", jdbcType = JdbcType.INTEGER),
			@Result(column = "hostChargeBegin", property = "hostChargeBegin", jdbcType = JdbcType.DATE),
			@Result(column = "settleUnit", property = "settleUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "deliveryBegin", property = "deliveryBegin", jdbcType = JdbcType.DATE),
			@Result(column = "turnover", property = "turnover", jdbcType = JdbcType.DECIMAL),
			@Result(column = "id", property = "nodeId", one = @One(select = "com.ifeng.bigtrade.trade.mapper.ParamNodeMapper.getParamNids")) })
	List<TradeParam> getParamByNidOrPid(Long nid, Long pid);

	@Update("CALL tradeparam_backup")
	int backup();
}
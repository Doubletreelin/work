package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.TradeRule;
import com.ifeng.bigtrade.trade.entites.TradeRuleExample;
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

public interface TradeRuleMapper {
    @Delete({
        "delete from tr_traderule",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tr_traderule (id, selfTradingState)",
        "values (#{id,jdbcType=BIGINT}, #{selfTradingState,jdbcType=INTEGER})"
    })
    int insert(TradeRule record);

    @InsertProvider(type=TradeRuleSqlProvider.class, method="insertSelective")
    int insertSelective(TradeRule record);

    @SelectProvider(type=TradeRuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="selfTradingState", property="selfTradingState", jdbcType=JdbcType.INTEGER)
    })
    List<TradeRule> selectByExample(TradeRuleExample example);

    @Select({
        "select",
        "id, selfTradingState",
        "from tr_traderule",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="selfTradingState", property="selfTradingState", jdbcType=JdbcType.INTEGER)
    })
    TradeRule selectByPrimaryKey(Long id);

    @UpdateProvider(type=TradeRuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TradeRule record);

    @Update({
        "update tr_traderule",
        "set selfTradingState = #{selfTradingState,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TradeRule record);
}
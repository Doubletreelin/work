package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.TradeNode;
import com.ifeng.bigtrade.trade.entites.TradeNodeExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TradeNodeMapper {
    @Delete({
        "delete from tr_tradenode",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tr_tradenode (id, addTime, ",
        "deleteStatus, endTime, ",
        "name, startTime, status)",
        "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
        "#{deleteStatus,jdbcType=BIT}, #{endTime,jdbcType=TIME}, ",
        "#{name,jdbcType=VARCHAR}, #{startTime,jdbcType=TIME}, #{status,jdbcType=INTEGER})"
    })
    @Options(keyProperty = "id", useGeneratedKeys = true)
    int insert(TradeNode record);

    @InsertProvider(type=TradeNodeSqlProvider.class, method="insertSelective")
    int insertSelective(TradeNode record);

    @SelectProvider(type=TradeNodeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteStatus", property="deleteStatus", jdbcType=JdbcType.BIT),
        @Result(column="endTime", property="endTime", jdbcType=JdbcType.TIME),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIME),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<TradeNode> selectByExample(TradeNodeExample example);

    @Select({
        "select",
        "id, addTime, deleteStatus, endTime, name, startTime, status",
        "from tr_tradenode",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteStatus", property="deleteStatus", jdbcType=JdbcType.BIT),
        @Result(column="endTime", property="endTime", jdbcType=JdbcType.TIME),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIME),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    TradeNode selectByPrimaryKey(Long id);

    @UpdateProvider(type=TradeNodeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TradeNode record);

    @Update({
        "update tr_tradenode",
        "set addTime = #{addTime,jdbcType=TIMESTAMP},",
          "deleteStatus = #{deleteStatus,jdbcType=BIT},",
          "endTime = #{endTime,jdbcType=TIME},",
          "name = #{name,jdbcType=VARCHAR},",
          "startTime = #{startTime,jdbcType=TIME},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TradeNode record);
}
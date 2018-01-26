package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.SystemStatus;
import com.ifeng.bigtrade.trade.entites.SystemStatusExample;
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

public interface SystemStatusMapper {
    @Delete({
        "delete from tr_systemstatus",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tr_systemstatus (id, addTime, ",
        "deleteStatus, note, ",
        "recoverTime, nodeId, ",
        "states, lastTradeDate)",
        "values (#{id,jdbcType=BIGINT}, #{addTime,jdbcType=TIMESTAMP}, ",
        "#{deleteStatus,jdbcType=BIT}, #{note,jdbcType=VARCHAR}, ",
        "#{recoverTime,jdbcType=TIMESTAMP}, #{nodeId,jdbcType=BIGINT}, ",
        "#{states,jdbcType=INTEGER}, #{lastTradeDate,jdbcType=TIMESTAMP})"
    })
    int insert(SystemStatus record);

    @InsertProvider(type=SystemStatusSqlProvider.class, method="insertSelective")
    int insertSelective(SystemStatus record);

    @SelectProvider(type=SystemStatusSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteStatus", property="deleteStatus", jdbcType=JdbcType.BIT),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="recoverTime", property="recoverTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nodeId", property="nodeId", jdbcType=JdbcType.BIGINT),
        @Result(column="states", property="states", jdbcType=JdbcType.INTEGER),
        @Result(column="lastTradeDate", property="lastTradeDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemStatus> selectByExample(SystemStatusExample example);

    @Select({
        "select",
        "id, addTime, deleteStatus, note, recoverTime, nodeId, states, lastTradeDate",
        "from tr_systemstatus",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteStatus", property="deleteStatus", jdbcType=JdbcType.BIT),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="recoverTime", property="recoverTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nodeId", property="nodeId", jdbcType=JdbcType.BIGINT),
        @Result(column="states", property="states", jdbcType=JdbcType.INTEGER),
        @Result(column="lastTradeDate", property="lastTradeDate", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemStatus selectByPrimaryKey(Long id);

    @UpdateProvider(type=SystemStatusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemStatus record);

    @Update({
        "update tr_systemstatus",
        "set addTime = #{addTime,jdbcType=TIMESTAMP},",
          "deleteStatus = #{deleteStatus,jdbcType=BIT},",
          "note = #{note,jdbcType=VARCHAR},",
          "recoverTime = #{recoverTime,jdbcType=TIMESTAMP},",
          "nodeId = #{nodeId,jdbcType=BIGINT},",
          "states = #{states,jdbcType=INTEGER},",
          "lastTradeDate = #{lastTradeDate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SystemStatus record);
}
package com.ifeng.bigtrade.cms.mapper.advertise;

import com.ifeng.bigtrade.cms.entites.advertise.Advertise;
import com.ifeng.bigtrade.cms.entites.advertise.AdvertiseExample;
import com.ifeng.bigtrade.cms.entites.advertise.AdvertiseExample.Criteria;
import com.ifeng.bigtrade.cms.entites.advertise.AdvertiseExample.Criterion;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class AdvertiseSqlProvider
{
  public String deleteByExample(AdvertiseExample example)
  {
    SQL sql = new SQL();
    sql.DELETE_FROM("cms_advertise");
    applyWhere(sql, example, false);
    return sql.toString();
  }

  public String insertSelective(Advertise record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("cms_advertise");

    if (record.getId() != null) {
      sql.VALUES("id", "#{id,jdbcType=BIGINT}");
    }

    if (record.getAddTime() != null) {
      sql.VALUES("addTime", "#{addTime,jdbcType=TIMESTAMP}");
    }

    if (record.getDeleteStatus() != null) {
      sql.VALUES("deleteStatus", "#{deleteStatus,jdbcType=BIT}");
    }

    if (record.getName() != null) {
      sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
    }

    if (record.getImgeLink() != null) {
      sql.VALUES("imgeLink", "#{imgeLink,jdbcType=VARCHAR}");
    }

    if (record.getImgeUrl() != null) {
      sql.VALUES("imgeUrl", "#{imgeUrl,jdbcType=VARCHAR}");
    }

    if (record.getPosition() != null) {
      sql.VALUES("position", "#{position,jdbcType=INTEGER}");
    }

    if (record.getBelongTo() != null) {
      sql.VALUES("belongTo", "#{belongTo,jdbcType=INTEGER}");
    }

    if (record.getUpdateTime() != null) {
      sql.VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
    }

    if (record.getPlan() != null) {
      sql.VALUES("plan", "#{plan,jdbcType=VARCHAR}");
    }

    if (record.getOrderNum() != null) {
      sql.VALUES("orderNum", "#{orderNum,jdbcType=INTEGER}");
    }

    return sql.toString();
  }

  public String selectByExample(AdvertiseExample example) {
    SQL sql = new SQL();
    if ((example != null) && (example.isDistinct()))
      sql.SELECT_DISTINCT("id");
    else {
      sql.SELECT("id");
    }
    sql.SELECT("addTime");
    sql.SELECT("deleteStatus");
    sql.SELECT("name");
    sql.SELECT("imgeLink");
    sql.SELECT("imgeUrl");
    sql.SELECT("position");
    sql.SELECT("belongTo");
    sql.SELECT("updateTime");
    sql.SELECT("plan");
    sql.SELECT("orderNum");
    sql.FROM("cms_advertise");
    applyWhere(sql, example, false);

    if ((example != null) && (example.getOrderByClause() != null)) {
      sql.ORDER_BY(example.getOrderByClause());
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Advertise record) {
    SQL sql = new SQL();
    sql.UPDATE("cms_advertise");

    if (record.getAddTime() != null) {
      sql.SET("addTime = #{addTime,jdbcType=TIMESTAMP}");
    }

    if (record.getDeleteStatus() != null) {
      sql.SET("deleteStatus = #{deleteStatus,jdbcType=BIT}");
    }

    if (record.getName() != null) {
      sql.SET("name = #{name,jdbcType=VARCHAR}");
    }

    if (record.getImgeLink() != null) {
      sql.SET("imgeLink = #{imgeLink,jdbcType=VARCHAR}");
    }

    if (record.getImgeUrl() != null) {
      sql.SET("imgeUrl = #{imgeUrl,jdbcType=VARCHAR}");
    }

    if (record.getPosition() != null) {
      sql.SET("position = #{position,jdbcType=INTEGER}");
    }

    if (record.getBelongTo() != null) {
      sql.SET("belongTo = #{belongTo,jdbcType=INTEGER}");
    }

    if (record.getUpdateTime() != null) {
      sql.SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
    }

    if (record.getPlan() != null) {
      sql.SET("plan = #{plan,jdbcType=VARCHAR}");
    }

    if (record.getOrderNum() != null) {
      sql.SET("orderNum = #{orderNum,jdbcType=INTEGER}");
    }

    sql.WHERE("id = #{id,jdbcType=BIGINT}");

    return sql.toString();
  }

  protected void applyWhere(SQL sql, AdvertiseExample example, boolean includeExamplePhrase) {
    if (example == null)
      return;
    String parmPhrase3_th;
    String parmPhrase1;
    String parmPhrase1_th;
    String parmPhrase2;
    String parmPhrase2_th;
    String parmPhrase3;
    if (includeExamplePhrase) {
      parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
      parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
      parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
      parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
      parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
      parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
    } else {
      parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
      parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
      parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
      parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
      parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
      parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
    }

    StringBuilder sb = new StringBuilder();
    List oredCriteria = example.getOredCriteria();
    boolean firstCriteria = true;
    for (int i = 0; i < oredCriteria.size(); i++) {
      AdvertiseExample.Criteria criteria = (AdvertiseExample.Criteria)oredCriteria.get(i);
      if (criteria.isValid()) {
        if (firstCriteria)
          firstCriteria = false;
        else {
          sb.append(" or ");
        }

        sb.append('(');
        List criterions = criteria.getAllCriteria();
        boolean firstCriterion = true;
        for (int j = 0; j < criterions.size(); j++) {
          AdvertiseExample.Criterion criterion = (AdvertiseExample.Criterion)criterions.get(j);
          if (firstCriterion)
            firstCriterion = false;
          else {
            sb.append(" and ");
          }

          if (criterion.isNoValue()) {
            sb.append(criterion.getCondition());
          } else if (criterion.isSingleValue()) {
            if (criterion.getTypeHandler() == null)
              sb.append(String.format(parmPhrase1, new Object[] { criterion.getCondition(), Integer.valueOf(i), Integer.valueOf(j) }));
            else
              sb.append(String.format(parmPhrase1_th, new Object[] { criterion.getCondition(), Integer.valueOf(i), Integer.valueOf(j), criterion.getTypeHandler() }));
          }
          else if (criterion.isBetweenValue()) {
            if (criterion.getTypeHandler() == null)
              sb.append(String.format(parmPhrase2, new Object[] { criterion.getCondition(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(j) }));
            else
              sb.append(String.format(parmPhrase2_th, new Object[] { criterion.getCondition(), Integer.valueOf(i), Integer.valueOf(j), criterion.getTypeHandler(), Integer.valueOf(i), Integer.valueOf(j), criterion.getTypeHandler() }));
          }
          else if (criterion.isListValue()) {
            sb.append(criterion.getCondition());
            sb.append(" (");
            List listItems = (List)criterion.getValue();
            boolean comma = false;
            for (int k = 0; k < listItems.size(); k++) {
              if (comma)
                sb.append(", ");
              else {
                comma = true;
              }
              if (criterion.getTypeHandler() == null)
                sb.append(String.format(parmPhrase3, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
              else {
                sb.append(String.format(parmPhrase3_th, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), criterion.getTypeHandler() }));
              }
            }
            sb.append(')');
          }
        }
        sb.append(')');
      }
    }

    if (sb.length() > 0)
      sql.WHERE(sb.toString());
  }
}
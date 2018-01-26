package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.SpecialParam;
import com.ifeng.bigtrade.trade.entites.SpecialParamExample.Criteria;
import com.ifeng.bigtrade.trade.entites.SpecialParamExample.Criterion;
import com.ifeng.bigtrade.trade.entites.SpecialParamExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class SpecialParamSqlProvider
{

	public String insertSelective(SpecialParam record)
	{
		SQL sql = new SQL();
		sql.INSERT_INTO("tr_specialparam");

		if (record.getId() != null)
		{
			sql.VALUES("id", "#{id,jdbcType=BIGINT}");
		}

		if (record.getAddTime() != null)
		{
			sql.VALUES("addTime", "#{addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null)
		{
			sql.VALUES("deleteStatus", "#{deleteStatus,jdbcType=BIT}");
		}

		if (record.getUserId() != null)
		{
			sql.VALUES("userId", "#{userId,jdbcType=BIGINT}");
		}

		if (record.getCommodityId() != null)
		{
			sql.VALUES("commodityId", "#{commodityId,jdbcType=BIGINT}");
		}

		if (record.getBuyCharge() != null)
		{
			sql.VALUES("buyCharge", "#{buyCharge,jdbcType=DECIMAL}");
		}

		if (record.getSellCharge() != null)
		{
			sql.VALUES("sellCharge", "#{sellCharge,jdbcType=DECIMAL}");
		}

		if (record.getChargeAlg() != null)
		{
			sql.VALUES("chargeAlg", "#{chargeAlg,jdbcType=INTEGER}");
		}

		return sql.toString();
	}

	public String selectByExample(SpecialParamExample example)
	{
		SQL sql = new SQL();
		if (example != null && example.isDistinct())
		{
			sql.SELECT_DISTINCT("id");
		} else
		{
			sql.SELECT("id");
		}
		sql.SELECT("addTime");
		sql.SELECT("deleteStatus");
		sql.SELECT("userId");
		sql.SELECT("commodityId");
		sql.SELECT("buyCharge");
		sql.SELECT("sellCharge");
		sql.SELECT("chargeAlg");
		sql.FROM("tr_specialparam");
		applyWhere(sql, example, false);

		if (example != null && example.getOrderByClause() != null)
		{
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	public String updateByPrimaryKeySelective(SpecialParam record)
	{
		SQL sql = new SQL();
		sql.UPDATE("tr_specialparam");

		if (record.getAddTime() != null)
		{
			sql.SET("addTime = #{addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null)
		{
			sql.SET("deleteStatus = #{deleteStatus,jdbcType=BIT}");
		}

		if (record.getUserId() != null)
		{
			sql.SET("userId = #{userId,jdbcType=BIGINT}");
		}

		if (record.getCommodityId() != null)
		{
			sql.SET("commodityId = #{commodityId,jdbcType=BIGINT}");
		}

		if (record.getBuyCharge() != null)
		{
			sql.SET("buyCharge = #{buyCharge,jdbcType=DECIMAL}");
		}

		if (record.getSellCharge() != null)
		{
			sql.SET("sellCharge = #{sellCharge,jdbcType=DECIMAL}");
		}

		if (record.getChargeAlg() != null)
		{
			sql.SET("chargeAlg = #{chargeAlg,jdbcType=INTEGER}");
		}

		sql.WHERE("id = #{id,jdbcType=BIGINT}");

		return sql.toString();
	}

	protected void applyWhere(SQL sql, SpecialParamExample example, boolean includeExamplePhrase)
	{
		if (example == null)
		{
			return;
		}

		String parmPhrase1;
		String parmPhrase1_th;
		String parmPhrase2;
		String parmPhrase2_th;
		String parmPhrase3;
		String parmPhrase3_th;
		if (includeExamplePhrase)
		{
			parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		} else
		{
			parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		}

		StringBuilder sb = new StringBuilder();
		List<Criteria> oredCriteria = example.getOredCriteria();
		boolean firstCriteria = true;
		for (int i = 0; i < oredCriteria.size(); i++)
		{
			Criteria criteria = oredCriteria.get(i);
			if (criteria.isValid())
			{
				if (firstCriteria)
				{
					firstCriteria = false;
				} else
				{
					sb.append(" or ");
				}

				sb.append('(');
				List<Criterion> criterions = criteria.getAllCriteria();
				boolean firstCriterion = true;
				for (int j = 0; j < criterions.size(); j++)
				{
					Criterion criterion = criterions.get(j);
					if (firstCriterion)
					{
						firstCriterion = false;
					} else
					{
						sb.append(" and ");
					}

					if (criterion.isNoValue())
					{
						sb.append(criterion.getCondition());
					} else if (criterion.isSingleValue())
					{
						if (criterion.getTypeHandler() == null)
						{
							sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
						} else
						{
							sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isBetweenValue())
					{
						if (criterion.getTypeHandler() == null)
						{
							sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
						} else
						{
							sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j,
									criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
						}
					} else if (criterion.isListValue())
					{
						sb.append(criterion.getCondition());
						sb.append(" (");
						List<?> listItems = (List<?>) criterion.getValue();
						boolean comma = false;
						for (int k = 0; k < listItems.size(); k++)
						{
							if (comma)
							{
								sb.append(", ");
							} else
							{
								comma = true;
							}
							if (criterion.getTypeHandler() == null)
							{
								sb.append(String.format(parmPhrase3, i, j, k));
							} else
							{
								sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
							}
						}
						sb.append(')');
					}
				}
				sb.append(')');
			}
		}

		if (sb.length() > 0)
		{
			sql.WHERE(sb.toString());
		}
	}
}
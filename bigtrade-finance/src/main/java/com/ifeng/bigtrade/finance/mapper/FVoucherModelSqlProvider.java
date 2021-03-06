package com.ifeng.bigtrade.finance.mapper;

import com.ifeng.bigtrade.finance.entites.FVoucherModel;
import com.ifeng.bigtrade.finance.entites.FVoucherModelExample.Criteria;
import com.ifeng.bigtrade.finance.entites.FVoucherModelExample.Criterion;
import com.ifeng.bigtrade.finance.entites.FVoucherModelExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class FVoucherModelSqlProvider
{

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String countByExample(FVoucherModelExample example)
	{
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("f_vouchermodel");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String deleteByExample(FVoucherModelExample example)
	{
		SQL sql = new SQL();
		sql.DELETE_FROM("f_vouchermodel");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String insertSelective(FVoucherModel record)
	{
		SQL sql = new SQL();
		sql.INSERT_INTO("f_vouchermodel");

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

		if (record.getModelCode() != null)
		{
			sql.VALUES("modelCode", "#{modelCode,jdbcType=VARCHAR}");
		}

		if (record.getModelName() != null)
		{
			sql.VALUES("modelName", "#{modelName,jdbcType=VARCHAR}");
		}

		if (record.getCreditCode() != null)
		{
			sql.VALUES("creditCode", "#{creditCode,jdbcType=VARCHAR}");
		}

		if (record.getDebitCode() != null)
		{
			sql.VALUES("debitCode", "#{debitCode,jdbcType=VARCHAR}");
		}

		if (record.getContractNo() != null)
		{
			sql.VALUES("contractNo", "#{contractNo,jdbcType=VARCHAR}");
		}

		if (record.getSummary_id() != null)
		{
			sql.VALUES("summary_id", "#{summary_id,jdbcType=BIGINT}");
		}

		if (record.getNote() != null)
		{
			sql.VALUES("note", "#{note,jdbcType=LONGVARCHAR}");
		}

		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String selectByExampleWithBLOBs(FVoucherModelExample example)
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
		sql.SELECT("modelCode");
		sql.SELECT("modelName");
		sql.SELECT("creditCode");
		sql.SELECT("debitCode");
		sql.SELECT("contractNo");
		sql.SELECT("summary_id");
		sql.SELECT("note");
		sql.FROM("f_vouchermodel");
		applyWhere(sql, example, false);

		if (example != null && example.getOrderByClause() != null)
		{
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String selectByExample(FVoucherModelExample example)
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
		sql.SELECT("modelCode");
		sql.SELECT("modelName");
		sql.SELECT("creditCode");
		sql.SELECT("debitCode");
		sql.SELECT("contractNo");
		sql.SELECT("summary_id");
		sql.FROM("f_vouchermodel");
		applyWhere(sql, example, false);

		if (example != null && example.getOrderByClause() != null)
		{
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String updateByExampleSelective(Map<String, Object> parameter)
	{
		FVoucherModel record = (FVoucherModel) parameter.get("record");
		FVoucherModelExample example = (FVoucherModelExample) parameter.get("example");

		SQL sql = new SQL();
		sql.UPDATE("f_vouchermodel");

		if (record.getId() != null)
		{
			sql.SET("id = #{record.id,jdbcType=BIGINT}");
		}

		if (record.getAddTime() != null)
		{
			sql.SET("addTime = #{record.addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null)
		{
			sql.SET("deleteStatus = #{record.deleteStatus,jdbcType=BIT}");
		}

		if (record.getModelCode() != null)
		{
			sql.SET("modelCode = #{record.modelCode,jdbcType=VARCHAR}");
		}

		if (record.getModelName() != null)
		{
			sql.SET("modelName = #{record.modelName,jdbcType=VARCHAR}");
		}

		if (record.getCreditCode() != null)
		{
			sql.SET("creditCode = #{record.creditCode,jdbcType=VARCHAR}");
		}

		if (record.getDebitCode() != null)
		{
			sql.SET("debitCode = #{record.debitCode,jdbcType=VARCHAR}");
		}

		if (record.getContractNo() != null)
		{
			sql.SET("contractNo = #{record.contractNo,jdbcType=VARCHAR}");
		}

		if (record.getSummary_id() != null)
		{
			sql.SET("summary_id = #{record.summary_id,jdbcType=BIGINT}");
		}

		if (record.getNote() != null)
		{
			sql.SET("note = #{record.note,jdbcType=LONGVARCHAR}");
		}

		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String updateByExampleWithBLOBs(Map<String, Object> parameter)
	{
		SQL sql = new SQL();
		sql.UPDATE("f_vouchermodel");

		sql.SET("id = #{record.id,jdbcType=BIGINT}");
		sql.SET("addTime = #{record.addTime,jdbcType=TIMESTAMP}");
		sql.SET("deleteStatus = #{record.deleteStatus,jdbcType=BIT}");
		sql.SET("modelCode = #{record.modelCode,jdbcType=VARCHAR}");
		sql.SET("modelName = #{record.modelName,jdbcType=VARCHAR}");
		sql.SET("creditCode = #{record.creditCode,jdbcType=VARCHAR}");
		sql.SET("debitCode = #{record.debitCode,jdbcType=VARCHAR}");
		sql.SET("contractNo = #{record.contractNo,jdbcType=VARCHAR}");
		sql.SET("summary_id = #{record.summary_id,jdbcType=BIGINT}");
		sql.SET("note = #{record.note,jdbcType=LONGVARCHAR}");

		FVoucherModelExample example = (FVoucherModelExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String updateByExample(Map<String, Object> parameter)
	{
		SQL sql = new SQL();
		sql.UPDATE("f_vouchermodel");

		sql.SET("id = #{record.id,jdbcType=BIGINT}");
		sql.SET("addTime = #{record.addTime,jdbcType=TIMESTAMP}");
		sql.SET("deleteStatus = #{record.deleteStatus,jdbcType=BIT}");
		sql.SET("modelCode = #{record.modelCode,jdbcType=VARCHAR}");
		sql.SET("modelName = #{record.modelName,jdbcType=VARCHAR}");
		sql.SET("creditCode = #{record.creditCode,jdbcType=VARCHAR}");
		sql.SET("debitCode = #{record.debitCode,jdbcType=VARCHAR}");
		sql.SET("contractNo = #{record.contractNo,jdbcType=VARCHAR}");
		sql.SET("summary_id = #{record.summary_id,jdbcType=BIGINT}");

		FVoucherModelExample example = (FVoucherModelExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	public String updateByPrimaryKeySelective(FVoucherModel record)
	{
		SQL sql = new SQL();
		sql.UPDATE("f_vouchermodel");

		if (record.getAddTime() != null)
		{
			sql.SET("addTime = #{addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null)
		{
			sql.SET("deleteStatus = #{deleteStatus,jdbcType=BIT}");
		}

		if (record.getModelCode() != null)
		{
			sql.SET("modelCode = #{modelCode,jdbcType=VARCHAR}");
		}

		if (record.getModelName() != null)
		{
			sql.SET("modelName = #{modelName,jdbcType=VARCHAR}");
		}

		if (record.getCreditCode() != null)
		{
			sql.SET("creditCode = #{creditCode,jdbcType=VARCHAR}");
		}

		if (record.getDebitCode() != null)
		{
			sql.SET("debitCode = #{debitCode,jdbcType=VARCHAR}");
		}

		if (record.getContractNo() != null)
		{
			sql.SET("contractNo = #{contractNo,jdbcType=VARCHAR}");
		}

		if (record.getSummary_id() != null)
		{
			sql.SET("summary_id = #{summary_id,jdbcType=BIGINT}");
		}

		if (record.getNote() != null)
		{
			sql.SET("note = #{note,jdbcType=LONGVARCHAR}");
		}

		sql.WHERE("id = #{id,jdbcType=BIGINT}");

		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_vouchermodel
	 *
	 * @mbg.generated Thu Aug 17 16:54:54 CST 2017
	 */
	protected void applyWhere(SQL sql, FVoucherModelExample example, boolean includeExamplePhrase)
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
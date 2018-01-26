package com.ifeng.bigtrade.finance.mapper;

import com.ifeng.bigtrade.finance.entites.FAccountBook;
import com.ifeng.bigtrade.finance.entites.FAccountBookExample.Criteria;
import com.ifeng.bigtrade.finance.entites.FAccountBookExample.Criterion;
import com.ifeng.bigtrade.finance.tools.CommUtil;
import com.ifeng.bigtrade.finance.entites.FAccountBookExample;
import com.ifeng.bigtrade.finance.entites.FAccountItem;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class FAccountBookSqlProvider
{

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_accountbook
	 *
	 * @mbg.generated Wed Aug 23 18:05:52 CST 2017
	 */
	public String countByExample(FAccountBookExample example)
	{
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("f_accountbook");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_accountbook
	 *
	 * @mbg.generated Wed Aug 23 18:05:52 CST 2017
	 */
	public String deleteByExample(FAccountBookExample example)
	{
		SQL sql = new SQL();
		sql.DELETE_FROM("f_accountbook");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_accountbook
	 *
	 * @mbg.generated Wed Aug 23 18:05:52 CST 2017
	 */
	public String insertSelective(FAccountBook record)
	{
		SQL sql = new SQL();
		sql.INSERT_INTO("f_accountbook");

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

		if (record.getAmount() != null)
		{
			sql.VALUES("amount", "#{amount,jdbcType=DECIMAL}");
		}

		if (record.getB_date() != null)
		{
			sql.VALUES("b_date", "#{b_date,jdbcType=TIMESTAMP}");
		}

		if (record.getContractNo() != null)
		{
			sql.VALUES("contractNo", "#{contractNo,jdbcType=VARCHAR}");
		}

		if (record.getCreditCode() != null)
		{
			sql.VALUES("creditCode", "#{creditCode,jdbcType=VARCHAR}");
		}

		if (record.getDebitCode() != null)
		{
			sql.VALUES("debitCode", "#{debitCode,jdbcType=VARCHAR}");
		}

		if (record.getSummary() != null)
		{
			sql.VALUES("summary", "#{summary,jdbcType=VARCHAR}");
		}

		if (record.getSummaryNo() != null)
		{
			sql.VALUES("summaryNo", "#{summaryNo,jdbcType=VARCHAR}");
		}

		if (record.getVoucher_id() != null)
		{
			sql.VALUES("voucher_id", "#{voucher_id,jdbcType=BIGINT}");
		}

		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_accountbook
	 *
	 * @mbg.generated Wed Aug 23 18:05:52 CST 2017
	 */
	public String selectByExample(FAccountBookExample example)
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
		sql.SELECT("amount");
		sql.SELECT("b_date");
		sql.SELECT("contractNo");
		sql.SELECT("creditCode");
		sql.SELECT("debitCode");
		sql.SELECT("summary");
		sql.SELECT("summaryNo");
		sql.SELECT("voucher_id");
		sql.FROM("f_accountbook");
		applyWhere(sql, example, false);

		if (example != null && example.getOrderByClause() != null)
		{
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_accountbook
	 *
	 * @mbg.generated Wed Aug 23 18:05:52 CST 2017
	 */
	public String updateByExampleSelective(Map<String, Object> parameter)
	{
		FAccountBook record = (FAccountBook) parameter.get("record");
		FAccountBookExample example = (FAccountBookExample) parameter.get("example");

		SQL sql = new SQL();
		sql.UPDATE("f_accountbook");

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

		if (record.getAmount() != null)
		{
			sql.SET("amount = #{record.amount,jdbcType=DECIMAL}");
		}

		if (record.getB_date() != null)
		{
			sql.SET("b_date = #{record.b_date,jdbcType=TIMESTAMP}");
		}

		if (record.getContractNo() != null)
		{
			sql.SET("contractNo = #{record.contractNo,jdbcType=VARCHAR}");
		}

		if (record.getCreditCode() != null)
		{
			sql.SET("creditCode = #{record.creditCode,jdbcType=VARCHAR}");
		}

		if (record.getDebitCode() != null)
		{
			sql.SET("debitCode = #{record.debitCode,jdbcType=VARCHAR}");
		}

		if (record.getSummary() != null)
		{
			sql.SET("summary = #{record.summary,jdbcType=VARCHAR}");
		}

		if (record.getSummaryNo() != null)
		{
			sql.SET("summaryNo = #{record.summaryNo,jdbcType=VARCHAR}");
		}

		if (record.getVoucher_id() != null)
		{
			sql.SET("voucher_id = #{record.voucher_id,jdbcType=BIGINT}");
		}

		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_accountbook
	 *
	 * @mbg.generated Wed Aug 23 18:05:52 CST 2017
	 */
	public String updateByExample(Map<String, Object> parameter)
	{
		SQL sql = new SQL();
		sql.UPDATE("f_accountbook");

		sql.SET("id = #{record.id,jdbcType=BIGINT}");
		sql.SET("addTime = #{record.addTime,jdbcType=TIMESTAMP}");
		sql.SET("deleteStatus = #{record.deleteStatus,jdbcType=BIT}");
		sql.SET("amount = #{record.amount,jdbcType=DECIMAL}");
		sql.SET("b_date = #{record.b_date,jdbcType=TIMESTAMP}");
		sql.SET("contractNo = #{record.contractNo,jdbcType=VARCHAR}");
		sql.SET("creditCode = #{record.creditCode,jdbcType=VARCHAR}");
		sql.SET("debitCode = #{record.debitCode,jdbcType=VARCHAR}");
		sql.SET("summary = #{record.summary,jdbcType=VARCHAR}");
		sql.SET("summaryNo = #{record.summaryNo,jdbcType=VARCHAR}");
		sql.SET("voucher_id = #{record.voucher_id,jdbcType=BIGINT}");

		FAccountBookExample example = (FAccountBookExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_accountbook
	 *
	 * @mbg.generated Wed Aug 23 18:05:52 CST 2017
	 */
	public String updateByPrimaryKeySelective(FAccountBook record)
	{
		SQL sql = new SQL();
		sql.UPDATE("f_accountbook");

		if (record.getAddTime() != null)
		{
			sql.SET("addTime = #{addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null)
		{
			sql.SET("deleteStatus = #{deleteStatus,jdbcType=BIT}");
		}

		if (record.getAmount() != null)
		{
			sql.SET("amount = #{amount,jdbcType=DECIMAL}");
		}

		if (record.getB_date() != null)
		{
			sql.SET("b_date = #{b_date,jdbcType=TIMESTAMP}");
		}

		if (record.getContractNo() != null)
		{
			sql.SET("contractNo = #{contractNo,jdbcType=VARCHAR}");
		}

		if (record.getCreditCode() != null)
		{
			sql.SET("creditCode = #{creditCode,jdbcType=VARCHAR}");
		}

		if (record.getDebitCode() != null)
		{
			sql.SET("debitCode = #{debitCode,jdbcType=VARCHAR}");
		}

		if (record.getSummary() != null)
		{
			sql.SET("summary = #{summary,jdbcType=VARCHAR}");
		}

		if (record.getSummaryNo() != null)
		{
			sql.SET("summaryNo = #{summaryNo,jdbcType=VARCHAR}");
		}

		if (record.getVoucher_id() != null)
		{
			sql.SET("voucher_id = #{voucher_id,jdbcType=BIGINT}");
		}

		sql.WHERE("id = #{id,jdbcType=BIGINT}");

		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table f_accountbook
	 *
	 * @mbg.generated Wed Aug 23 18:05:52 CST 2017
	 */
	protected void applyWhere(SQL sql, FAccountBookExample example, boolean includeExamplePhrase)
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

	/******************** next new add ***********************/
	public String selectAccountBook(String creditCode, String debitCode, String contractNo, String beginDate,
			String endDate, String voucherNo, Integer amount, String summaryNo, String summary)
	{
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select t.*,(select name from f_accountitem where code=t.debitcode) debitname,(select name from f_accountitem where code=t.creditcode) creditname ,v.b_date,t.voucher_id");
		sql.append(" from f_accountbook t left join f_voucher v on t.voucher_id=v.id where 1=1 ");
		if (CommUtil.isNotNull(debitCode))
		{
			sql.append(" and t.debitcode like '%" + debitCode + "%'");
		}
		if (CommUtil.isNotNull(creditCode))
		{
			sql.append(" and t.creditCode like '%" + creditCode + "%'");
		}
		if (CommUtil.isNotNull(contractNo))
		{
			sql.append(" and t.contractNo = '" + contractNo + "'");
		}
		if (CommUtil.isNotNull(beginDate))
		{
			sql.append(" and t.b_date >= '" + beginDate + "'");
		}
		if (CommUtil.isNotNull(endDate))
		{
			sql.append(" and t.b_date <= '" + endDate + "'");
		}
		if (CommUtil.isNotNull(voucherNo))
		{
			sql.append(" and v.voucher_id = '" + voucherNo + "'");
		}
		if (CommUtil.isNotNull(amount))
		{
			sql.append(" and t.amount = '" + amount + "'");
		}
		if (CommUtil.isNotNull(summaryNo))
		{
			sql.append(" and t.summaryNo = '" + summaryNo + "'");
		}
		if (CommUtil.isNotNull(summary))
		{
			sql.append(" and t.summary = '" + summary + "'");
		}
		return sql.toString();
	}

	public String selectLedger(FAccountItem account, String accountCode, String beginDate, String endDate)
	{
		StringBuffer sql = new StringBuffer();
		String filter = "";
		if (account != null)
		{
			filter = "='" + accountCode + "' ";
		} else
		{
			filter = " in (select a.code from f_accountitem a where a.accountlevel>(select t.accountlevel from f_accountitem t where t.code='"
					+ accountCode + "') and a.code like '" + accountCode + "%')";
		}
		sql.append("select * from "
				+ "(select b_date voucherDate,voucher_id,summary,a.creditcode accountCode,(select name from f_accountitem where code=a.creditcode) accountName,amount debitAmount,0 creditAmount,contractNo "
				+ "from f_accountbook a  where DebitCode " + filter + " and b_date>='" + beginDate + "' and b_date<='"
				+ endDate
				+ "' union  select b_date voucherDate,voucher_id,summary,b.debitcode accountCode,(select name from f_accountitem where code=b.debitcode) accountName,0 debitAmount,amount creditAmount,contractNo from f_accountbook b where CreditCode "
				+ filter + " and b_date>='" + beginDate + "' and b_date<='" + endDate + "') queryView");
		return sql.toString();
	}

	public String selectAccountLedgerTotal(FAccountItem account, String accountCode, String beginDate, String endDate)
	{
		StringBuffer sql = new StringBuffer();
		String filter = "";
		if (account != null)
		{
			// 如果有具体的科目，那么直接查此科目
			filter = "='" + accountCode + "' ";
		} else
		{
			// 如果未查到具体的科目，那么查的是这个代码下（accountlevel高，且code like ' a%'）的科目
			filter = " in (select a.code from f_accountitem a where a.accountlevel>(select t.accountlevel from f_accountitem t where t.code='"
					+ accountCode + "') and a.code like '" + accountCode + "%')";
		}
		sql.append(
				"select b3.summaryNo,(select s.summary from f_summary s where s.summaryNo=b3.summaryNo) as summary,ifnull(b1.dAmount,0) as dAmount,ifnull(b2.cAmount,0) as cAmount "
						+ "from " + "(select distinct(a3.summaryNo) from f_accountbook a3 where (a3.debitcode " + filter
						+ " or a3.creditcode " + filter + " )" + " and b_date>='" + beginDate + "' and b_date<='"
						+ endDate + "' " + " order by a3.summaryNo) b3 "
						+ "left join (select a1.summaryNo,sum(a1.amount) as dAmount from f_accountbook a1 where a1.debitcode "
						+ filter + "" + " and b_date>='" + beginDate + "' and b_date<='" + endDate + "' "
						+ " group by a1.summaryNo) b1 on b3.summaryNo=b1.summaryNo "
						+ "left join (select a1.summaryNo,sum(a1.amount) as cAmount from f_accountbook a1 where a1.creditcode "
						+ filter + "" + " and b_date>='" + beginDate + "' and b_date<='" + endDate + "' "
						+ " group by a1.summaryNo) b2 on b3.summaryNo=b2.summaryNo ");
		return sql.toString();
	}

}
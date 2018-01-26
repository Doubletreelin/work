package com.ifeng.bigtrade.cms.mapper.website;

import com.ifeng.bigtrade.cms.entites.website.Website;
import com.ifeng.bigtrade.cms.entites.website.WebsiteExample;
import com.ifeng.bigtrade.cms.entites.website.WebsiteExample.Criteria;
import com.ifeng.bigtrade.cms.entites.website.WebsiteExample.Criterion;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class WebsiteSqlProvider {
	public String deleteByExample(WebsiteExample example) {
		SQL sql = new SQL();
		sql.DELETE_FROM("cms_website");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	public String insertSelective(Website record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("cms_website");

		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=BIGINT}");
		}

		if (record.getAddTime() != null) {
			sql.VALUES("addTime", "#{addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null) {
			sql.VALUES("deleteStatus", "#{deleteStatus,jdbcType=BIT}");
		}

		if (record.getPkey() != null) {
			sql.VALUES("pkey", "#{pkey,jdbcType=VARCHAR}");
		}

		if (record.getNotice() != null) {
			sql.VALUES("notice", "#{notice,jdbcType=VARCHAR}");
		}

		if (record.getRemark() != null) {
			sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
		}

		if (record.getPvalue() != null) {
			sql.VALUES("pvalue", "#{pvalue,jdbcType=LONGVARCHAR}");
		}

		return sql.toString();
	}

	public String selectByExampleWithBLOBs(WebsiteExample example) {
		SQL sql = new SQL();
		if ((example != null) && (example.isDistinct()))
			sql.SELECT_DISTINCT("id");
		else {
			sql.SELECT("id");
		}
		sql.SELECT("addTime");
		sql.SELECT("deleteStatus");
		sql.SELECT("pkey");
		sql.SELECT("notice");
		sql.SELECT("remark");
		sql.SELECT("pvalue");
		sql.FROM("cms_website");
		applyWhere(sql, example, false);

		if ((example != null) && (example.getOrderByClause() != null)) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	public String selectByExample(WebsiteExample example) {
		SQL sql = new SQL();
		if ((example != null) && (example.isDistinct()))
			sql.SELECT_DISTINCT("id");
		else {
			sql.SELECT("id");
		}
		sql.SELECT("addTime");
		sql.SELECT("deleteStatus");
		sql.SELECT("pkey");
		sql.SELECT("notice");
		sql.SELECT("remark");
		sql.FROM("cms_website");
		applyWhere(sql, example, false);

		if ((example != null) && (example.getOrderByClause() != null)) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	public String updateByPrimaryKeySelective(Website record) {
		SQL sql = new SQL();
		sql.UPDATE("cms_website");

		if (record.getAddTime() != null) {
			sql.SET("addTime = #{addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null) {
			sql.SET("deleteStatus = #{deleteStatus,jdbcType=BIT}");
		}

		if (record.getPkey() != null) {
			sql.SET("pkey = #{pkey,jdbcType=VARCHAR}");
		}

		if (record.getNotice() != null) {
			sql.SET("notice = #{notice,jdbcType=VARCHAR}");
		}

		if (record.getRemark() != null) {
			sql.SET("remark = #{remark,jdbcType=VARCHAR}");
		}

		if (record.getPvalue() != null) {
			sql.SET("pvalue = #{pvalue,jdbcType=LONGVARCHAR}");
		}

		sql.WHERE("id = #{id,jdbcType=BIGINT}");

		return sql.toString();
	}

	protected void applyWhere(SQL sql, WebsiteExample example, boolean includeExamplePhrase) {
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
			WebsiteExample.Criteria criteria = (WebsiteExample.Criteria) oredCriteria.get(i);
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
					WebsiteExample.Criterion criterion = (WebsiteExample.Criterion) criterions.get(j);
					if (firstCriterion)
						firstCriterion = false;
					else {
						sb.append(" and ");
					}

					if (criterion.isNoValue()) {
						sb.append(criterion.getCondition());
					} else if (criterion.isSingleValue()) {
						if (criterion.getTypeHandler() == null)
							sb.append(String.format(parmPhrase1,
									new Object[] { criterion.getCondition(), Integer.valueOf(i), Integer.valueOf(j) }));
						else
							sb.append(String.format(parmPhrase1_th, new Object[] { criterion.getCondition(),
									Integer.valueOf(i), Integer.valueOf(j), criterion.getTypeHandler() }));
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null)
							sb.append(String.format(parmPhrase2, new Object[] { criterion.getCondition(),
									Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(j) }));
						else
							sb.append(String.format(parmPhrase2_th,
									new Object[] { criterion.getCondition(), Integer.valueOf(i), Integer.valueOf(j),
											criterion.getTypeHandler(), Integer.valueOf(i), Integer.valueOf(j),
											criterion.getTypeHandler() }));
					} else if (criterion.isListValue()) {
						sb.append(criterion.getCondition());
						sb.append(" (");
						List listItems = (List) criterion.getValue();
						boolean comma = false;
						for (int k = 0; k < listItems.size(); k++) {
							if (comma)
								sb.append(", ");
							else {
								comma = true;
							}
							if (criterion.getTypeHandler() == null)
								sb.append(String.format(parmPhrase3,
										new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
							else {
								sb.append(String.format(parmPhrase3_th, new Object[] { Integer.valueOf(i),
										Integer.valueOf(j), Integer.valueOf(k), criterion.getTypeHandler() }));
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
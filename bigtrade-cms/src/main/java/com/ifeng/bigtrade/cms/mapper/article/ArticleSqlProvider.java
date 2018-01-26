package com.ifeng.bigtrade.cms.mapper.article;

import com.ifeng.bigtrade.cms.entites.article.Article;
import com.ifeng.bigtrade.cms.entites.article.Article.AuditState;
import com.ifeng.bigtrade.cms.entites.article.Article.ShowState;
import com.ifeng.bigtrade.cms.entites.article.ArticleExample;
import com.ifeng.bigtrade.cms.entites.article.ArticleExample.Criteria;
import com.ifeng.bigtrade.cms.entites.article.ArticleExample.Criterion;
import com.ifeng.bigtrade.cms.entites.article.ArticleWithBLOBs;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class ArticleSqlProvider {
	public String deleteByExample(ArticleExample example) {
		SQL sql = new SQL();
		sql.DELETE_FROM("cms_article");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	public String insertSelective(ArticleWithBLOBs record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("cms_article");

		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=BIGINT}");
		}

		if (record.getAddTime() != null) {
			sql.VALUES("addTime", "#{addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null) {
			sql.VALUES("deleteStatus", "#{deleteStatus,jdbcType=BIT}");
		}

		if (record.getTitle() != null) {
			sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
		}

		if (record.getTypeId() != null) {
			sql.VALUES("typeId", "#{typeId,jdbcType=BIGINT}");
		}

		if (record.getAuthor() != null) {
			sql.VALUES("author", "#{author,jdbcType=VARCHAR}");
		}

		if (record.getSubmitter() != null) {
			sql.VALUES("submitter", "#{submitter,jdbcType=VARCHAR}");
		}

		if (record.getSubmitTime() != null) {
			sql.VALUES("submitTime", "#{submitTime,jdbcType=TIMESTAMP}");
		}

		if (record.getPublishTime() != null) {
			sql.VALUES("publishTime", "#{publishTime,jdbcType=TIMESTAMP}");
		}

		if (record.getPictureUrl() != null) {
			sql.VALUES("pictureUrl", "#{pictureUrl,jdbcType=VARCHAR}");
		}

		if (record.getAuditor() != null) {
			sql.VALUES("auditor", "#{auditor,jdbcType=VARCHAR}");
		}

		if (record.getAuditTime() != null) {
			sql.VALUES("auditTime", "#{auditTime,jdbcType=TIMESTAMP}");
		}

		if (record.getAuditState() != null) {
			sql.VALUES("auditState", "#{auditState,jdbcType=INTEGER}");
		}

		if (record.getShowState() != null) {
			sql.VALUES("showState", "#{showState,jdbcType=INTEGER}");
		}

		if (record.getHits() != null) {
			sql.VALUES("hits", "#{hits,jdbcType=INTEGER}");
		}

		if (record.getSummary() != null) {
			sql.VALUES("summary", "#{summary,jdbcType=LONGVARCHAR}");
		}

		if (record.getContent() != null) {
			sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
		}

		if (record.getRemarks() != null) {
			sql.VALUES("remarks", "#{remarks,jdbcType=LONGVARCHAR}");
		}

		return sql.toString();
	}

	public String selectByExampleWithBLOBs(ArticleExample example) {
		SQL sql = new SQL();
		if ((example != null) && (example.isDistinct())) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("addTime");
		sql.SELECT("deleteStatus");
		sql.SELECT("title");
		sql.SELECT("typeId");
		sql.SELECT("author");
		sql.SELECT("submitter");
		sql.SELECT("submitTime");
		sql.SELECT("publishTime");
		sql.SELECT("pictureUrl");
		sql.SELECT("auditor");
		sql.SELECT("auditTime");
		sql.SELECT("auditState");
		sql.SELECT("showState");
		sql.SELECT("hits");
		sql.SELECT("summary");
		sql.SELECT("content");
		sql.SELECT("remarks");
		sql.FROM("cms_article");
		applyWhere(sql, example, false);

		if ((example != null) && (example.getOrderByClause() != null)) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	public String selectByExample(ArticleExample example) {
		SQL sql = new SQL();
		if ((example != null) && (example.isDistinct())) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("addTime");
		sql.SELECT("deleteStatus");
		sql.SELECT("title");
		sql.SELECT("typeId");
		sql.SELECT("author");
		sql.SELECT("submitter");
		sql.SELECT("submitTime");
		sql.SELECT("publishTime");
		sql.SELECT("pictureUrl");
		sql.SELECT("auditor");
		sql.SELECT("auditTime");
		sql.SELECT("auditState");
		sql.SELECT("showState");
		sql.SELECT("hits");
		sql.FROM("cms_article");
		applyWhere(sql, example, false);

		if ((example != null) && (example.getOrderByClause() != null)) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	public String updateByPrimaryKeySelective(ArticleWithBLOBs record) {
		SQL sql = new SQL();
		sql.UPDATE("cms_article");

		if (record.getAddTime() != null) {
			sql.SET("addTime = #{addTime,jdbcType=TIMESTAMP}");
		}

		if (record.getDeleteStatus() != null) {
			sql.SET("deleteStatus = #{deleteStatus,jdbcType=BIT}");
		}

		if (record.getTitle() != null) {
			sql.SET("title = #{title,jdbcType=VARCHAR}");
		}

		if (record.getTypeId() != null) {
			sql.SET("typeId = #{typeId,jdbcType=BIGINT}");
		}

		if (record.getAuthor() != null) {
			sql.SET("author = #{author,jdbcType=VARCHAR}");
		}

		if (record.getSubmitter() != null) {
			sql.SET("submitter = #{submitter,jdbcType=VARCHAR}");
		}

		if (record.getSubmitTime() != null) {
			sql.SET("submitTime = #{submitTime,jdbcType=TIMESTAMP}");
		}

		if (record.getPublishTime() != null) {
			sql.SET("publishTime = #{publishTime,jdbcType=TIMESTAMP}");
		}

		if (record.getPictureUrl() != null) {
			sql.SET("pictureUrl = #{pictureUrl,jdbcType=VARCHAR}");
		}

		if (record.getAuditor() != null) {
			sql.SET("auditor = #{auditor,jdbcType=VARCHAR}");
		}

		if (record.getAuditTime() != null) {
			sql.SET("auditTime = #{auditTime,jdbcType=TIMESTAMP}");
		}

		if (record.getAuditState() != null) {
			sql.SET("auditState = #{auditState,jdbcType=INTEGER}");
		}

		if (record.getShowState() != null) {
			sql.SET("showState = #{showState,jdbcType=INTEGER}");
		}

		if (record.getHits() != null) {
			sql.SET("hits = #{hits,jdbcType=INTEGER}");
		}

		if (record.getSummary() != null) {
			sql.SET("summary = #{summary,jdbcType=LONGVARCHAR}");
		}

		if (record.getContent() != null) {
			sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
		}

		if (record.getRemarks() != null) {
			sql.SET("remarks = #{remarks,jdbcType=LONGVARCHAR}");
		}

		sql.WHERE("id = #{id,jdbcType=BIGINT}");

		return sql.toString();
	}

	protected void applyWhere(SQL sql, ArticleExample example, boolean includeExamplePhrase) {
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
			ArticleExample.Criteria criteria = (ArticleExample.Criteria) oredCriteria.get(i);
			if (criteria.isValid()) {
				if (firstCriteria) {
					firstCriteria = false;
				} else {
					sb.append(" or ");
				}

				sb.append('(');
				List criterions = criteria.getAllCriteria();
				boolean firstCriterion = true;
				for (int j = 0; j < criterions.size(); j++) {
					ArticleExample.Criterion criterion = (ArticleExample.Criterion) criterions.get(j);
					if (firstCriterion) {
						firstCriterion = false;
					} else {
						sb.append(" and ");
					}

					if (criterion.isNoValue()) {
						sb.append(criterion.getCondition());
					} else if (criterion.isSingleValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase1,
									new Object[] { criterion.getCondition(), Integer.valueOf(i), Integer.valueOf(j) }));
						} else
							sb.append(String.format(parmPhrase1_th, new Object[] { criterion.getCondition(),
									Integer.valueOf(i), Integer.valueOf(j), criterion.getTypeHandler() }));
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase2, new Object[] { criterion.getCondition(),
									Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(j) }));
						} else {
							sb.append(String.format(parmPhrase2_th,
									new Object[] { criterion.getCondition(), Integer.valueOf(i), Integer.valueOf(j),
											criterion.getTypeHandler(), Integer.valueOf(i), Integer.valueOf(j),
											criterion.getTypeHandler() }));
						}
					} else if (criterion.isListValue()) {
						sb.append(criterion.getCondition());
						sb.append(" (");
						List listItems = (List) criterion.getValue();
						boolean comma = false;
						for (int k = 0; k < listItems.size(); k++) {
							if (comma) {
								sb.append(", ");
							} else {
								comma = true;
							}
							if (criterion.getTypeHandler() == null) {
								sb.append(String.format(parmPhrase3,
										new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
							} else {
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

		if (sb.length() > 0) {
			sql.WHERE(sb.toString());
		}
	}

	public String selectWithType(ArticleWithBLOBs record) {
		SQL sql = new SQL();
		sql.SELECT("a.id");
		sql.SELECT("a.title");
		sql.SELECT("a.typeId");
		sql.SELECT("a.auditor");
		sql.SELECT("a.author");
		sql.SELECT("a.submitter");
		sql.SELECT("a.submitTime");
		sql.SELECT("a.publishTime");
		sql.SELECT("a.summary");
		sql.SELECT("a.content");
		sql.SELECT("a.pictureUrl");
		sql.SELECT("a.auditTime");
		sql.SELECT("a.auditState");
		sql.SELECT("a.showState");
		sql.SELECT("a.remarks");
		sql.SELECT("a.hits");
		sql.SELECT("t.mainName");
		sql.SELECT("t.subName");
		sql.SELECT("t.mainId");
		sql.FROM("cms_article a");
		sql.LEFT_OUTER_JOIN(
				"(select a1.id mainId,a2.id, a1.name mainName,a2.name subName,a1.`level` from cms_articletype a1 join cms_articletype a2 on a1.id=a2.parentId) t on t.id=a.typeId ");
		if (record.getId() != null) {
			sql.WHERE("a.id =  #{id,jdbcType=BIGINT}");
		}

		if (StringUtils.isNotBlank(record.getTitle())) {
			sql.WHERE("a.title LIKE CONCAT(CONCAT('%',#{title,jdbcType=VARCHAR}),'%')");
		}

		if (record.getTypeId() != null) {
			sql.WHERE("t.id = #{typeId,jdbcType=BIGINT}");
		}

		if (StringUtils.isNotBlank(record.getAuthor())) {
			sql.WHERE("a.author LIKE CONCAT(CONCAT('%',#{author,jdbcType=VARCHAR}),'%')");
		}

		if (record.getSubmitter() != null) {
			sql.WHERE("a.submitter LIKE CONCAT(CONCAT('%',#{submitter,jdbcType=VARCHAR}),'%')");
		}

		if (record.getSubmitTime() != null) {
			sql.WHERE("CONVERT(a.submitTime,DATE)= #{submitTime,jdbcType=TIMESTAMP}");
		}

		if (record.getPublishTime() != null) {
			sql.WHERE("CONVERT(a.publishTime,DATE)= #{publishTime,jdbcType=TIMESTAMP}");
		}

		if (StringUtils.isNotBlank(record.getAuditor())) {
			sql.WHERE("a.auditor LIKE CONCAT(CONCAT('%',#{auditor,jdbcType=VARCHAR}),'%')");
		}

		if (record.getAuditTime() != null) {
			sql.WHERE("CONVERT(a.auditTime,DATE)= #{auditTime,jdbcType=TIMESTAMP}");
		}

		if (record.getAuditState() != null) {
			sql.WHERE("a.auditState = #{auditState,jdbcType=INTEGER}");
		}

		if (record.getShowState() != null) {
			sql.WHERE("a.showState = #{showState,jdbcType=INTEGER}");
		}

		if (record.getSummary() != null) {
			sql.WHERE("a.summary LIKE CONCAT(CONCAT('%',#{summary,jdbcType=VARCHAR}),'%')");
		}

		if (record.getContent() != null) {
			sql.WHERE("a.content LIKE CONCAT(CONCAT('%',#{content,jdbcType=VARCHAR}),'%')");
		}

		return sql.toString();
	}

	public String selectByType(Long aid, boolean hit, Long mainId, Long subId) {
		SQL sql = new SQL();
		sql.SELECT("id");
		sql.SELECT("addTime");
		sql.SELECT("deleteStatus");
		sql.SELECT("title");
		sql.SELECT("typeId");
		sql.SELECT("author");
		sql.SELECT("submitter");
		sql.SELECT("submitTime");
		sql.SELECT("publishTime");
		sql.SELECT("pictureUrl");
		sql.SELECT("auditor");
		sql.SELECT("auditTime");
		sql.SELECT("auditState");
		sql.SELECT("showState");
		sql.SELECT("hits");
		sql.SELECT("summary");
		sql.SELECT("content");
		sql.SELECT("remarks");
		sql.FROM("cms_article");
		sql.WHERE(new String[] {
				new StringBuilder().append("auditState = ").append(Article.AuditState.audited.getState()).toString(),
				"deleteStatus=0",
				new StringBuilder().append("(showState=").append(Article.ShowState.SHOW_WEB.getState())
						.append(" or showState =").append(Article.ShowState.SHOW_ALL.getState()).append(")").toString(),
				"publishTime <= now()" });

		if (aid != null) {
			sql.WHERE(new StringBuilder().append("id = ").append(aid).toString());
		}
		if (mainId != null) {
			sql.WHERE(new StringBuilder().append("typeId IN (SELECT id FROM cms_articletype WHERE parentId = ")
					.append(mainId).append(")").toString());
		} else if (subId != null) {
			sql.WHERE(new StringBuilder().append("typeId = ").append(subId).toString());
		}
		if (hit) {
			sql.ORDER_BY("hits DESC");
		}
		sql.ORDER_BY("publishTime DESC");
		return sql.toString();
	}
}
package com.ifeng.bigtrade.trade.mapper;

import com.ifeng.bigtrade.trade.entites.TradeParam;
import com.ifeng.bigtrade.trade.entites.TradeParamExample.Criteria;
import com.ifeng.bigtrade.trade.entites.TradeParamExample.Criterion;
import com.ifeng.bigtrade.trade.entites.TradeParamExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class TradeParamSqlProvider
{

	public String insertSelective(TradeParam record)
	{
		SQL sql = new SQL();
		sql.INSERT_INTO("tr_tradeparam");
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
		if (record.getCommodityId() != null)
		{
			sql.VALUES("commodityId", "#{commodityId,jdbcType=BIGINT}");
		}
		if (record.getTradeStatus() != null)
		{
			sql.VALUES("tradeStatus", "#{tradeStatus,jdbcType=INTEGER}");
		}
		if (record.getIssuePrice() != null)
		{
			sql.VALUES("issuePrice", "#{issuePrice,jdbcType=DECIMAL}");
		}
		if (record.getOpenPrice() != null)
		{
			sql.VALUES("openPrice", "#{openPrice,jdbcType=DECIMAL}");
		}
		if (record.getClearprice() != null)
		{
			sql.VALUES("clearprice", "#{clearprice,jdbcType=DECIMAL}");
		}
		if (record.getListingDate() != null)
		{
			sql.VALUES("listingDate", "#{listingDate,jdbcType=TIMESTAMP}");
		}
		if (record.getLastTradeDate() != null)
		{
			sql.VALUES("lastTradeDate", "#{lastTradeDate,jdbcType=TIMESTAMP}");
		}
		if (record.getTradeUnit() != null)
		{
			sql.VALUES("tradeUnit", "#{tradeUnit,jdbcType=VARCHAR}");
		}
		if (record.getMinChangePrice() != null)
		{
			sql.VALUES("minChangePrice", "#{minChangePrice,jdbcType=DECIMAL}");
		}
		if (record.getMinChangeAmount() != null)
		{
			sql.VALUES("minChangeAmount", "#{minChangeAmount,jdbcType=INTEGER}");
		}
		if (record.getUpperLimitChange() != null)
		{
			sql.VALUES("upperLimitChange", "#{upperLimitChange,jdbcType=DECIMAL}");
		}
		if (record.getLowerLlimitChange() != null)
		{
			sql.VALUES("lowerLlimitChange", "#{lowerLlimitChange,jdbcType=DECIMAL}");
		}
		if (record.getChangeLimitAlg() != null)
		{
			sql.VALUES("changeLimitAlg", "#{changeLimitAlg,jdbcType=INTEGER}");
		}
		if (record.getTnDay() != null)
		{
			sql.VALUES("TnDay", "#{tnDay,jdbcType=INTEGER}");
		}
		if (record.getEffectDate() != null)
		{
			sql.VALUES("effectDate", "#{effectDate,jdbcType=TIMESTAMP}");
		}
		if (record.getMaxPerEntrust() != null)
		{
			sql.VALUES("maxPerEntrust", "#{maxPerEntrust,jdbcType=BIGINT}");
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
		if (record.getChargeRemainRate() != null)
		{
			sql.VALUES("chargeRemainRate", "#{chargeRemainRate,jdbcType=DECIMAL}");
		}
		if (record.getDayHostPrice() != null)
		{
			sql.VALUES("dayHostPrice", "#{dayHostPrice,jdbcType=DECIMAL}");
		}
		if (record.getFreeHostday() != null)
		{
			sql.VALUES("freeHostday", "#{freeHostday,jdbcType=INTEGER}");
		}
		if (record.getHostChargeBegin() != null)
		{
			sql.VALUES("hostChargeBegin", "#{hostChargeBegin,jdbcType=DATE}");
		}
		if (record.getSettleUnit() != null)
		{
			sql.VALUES("settleUnit", "#{settleUnit,jdbcType=VARCHAR}");
		}
		if (record.getDeliveryBegin() != null)
		{
			sql.VALUES("deliveryBegin", "#{deliveryBegin,jdbcType=DATE}");
		}
		if (record.getTurnover() != null)
		{
			sql.VALUES("turnover", "#{turnover,jdbcType=DECIMAL}");
		}
		return sql.toString();
	}

	public String selectByExample(TradeParamExample example)
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
		sql.SELECT("commodityId");
		sql.SELECT("tradeStatus");
		sql.SELECT("issuePrice");
		sql.SELECT("openPrice");
		sql.SELECT("clearprice");
		sql.SELECT("listingDate");
		sql.SELECT("lastTradeDate");
		sql.SELECT("tradeUnit");
		sql.SELECT("minChangePrice");
		sql.SELECT("minChangeAmount");
		sql.SELECT("upperLimitChange");
		sql.SELECT("lowerLlimitChange");
		sql.SELECT("changeLimitAlg");
		sql.SELECT("TnDay");
		sql.SELECT("effectDate");
		sql.SELECT("maxPerEntrust");
		sql.SELECT("buyCharge");
		sql.SELECT("sellCharge");
		sql.SELECT("chargeAlg");
		sql.SELECT("chargeRemainRate");
		sql.SELECT("dayHostPrice");
		sql.SELECT("freeHostday");
		sql.SELECT("hostChargeBegin");
		sql.SELECT("settleUnit");
		sql.SELECT("deliveryBegin");
		sql.SELECT("turnover");
		sql.FROM("tr_tradeparam");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null)
		{
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	public String updateByPrimaryKeySelective(TradeParam record)
	{
		SQL sql = new SQL();
		sql.UPDATE("tr_tradeparam");
		if (record.getAddTime() != null)
		{
			sql.SET("addTime = #{addTime,jdbcType=TIMESTAMP}");
		}
		if (record.getDeleteStatus() != null)
		{
			sql.SET("deleteStatus = #{deleteStatus,jdbcType=BIT}");
		}
		if (record.getCommodityId() != null)
		{
			sql.SET("commodityId = #{commodityId,jdbcType=BIGINT}");
		}
		if (record.getTradeStatus() != null)
		{
			sql.SET("tradeStatus = #{tradeStatus,jdbcType=INTEGER}");
		}
		if (record.getIssuePrice() != null)
		{
			sql.SET("issuePrice = #{issuePrice,jdbcType=DECIMAL}");
		}
		if (record.getOpenPrice() != null)
		{
			sql.SET("openPrice = #{openPrice,jdbcType=DECIMAL}");
		}
		if (record.getClearprice() != null)
		{
			sql.SET("clearprice = #{clearprice,jdbcType=DECIMAL}");
		}
		if (record.getListingDate() != null)
		{
			sql.SET("listingDate = #{listingDate,jdbcType=TIMESTAMP}");
		}
		if (record.getLastTradeDate() != null)
		{
			sql.SET("lastTradeDate = #{lastTradeDate,jdbcType=TIMESTAMP}");
		}
		if (record.getTradeUnit() != null)
		{
			sql.SET("tradeUnit = #{tradeUnit,jdbcType=VARCHAR}");
		}
		if (record.getMinChangePrice() != null)
		{
			sql.SET("minChangePrice = #{minChangePrice,jdbcType=DECIMAL}");
		}
		if (record.getMinChangeAmount() != null)
		{
			sql.SET("minChangeAmount = #{minChangeAmount,jdbcType=INTEGER}");
		}
		if (record.getUpperLimitChange() != null)
		{
			sql.SET("upperLimitChange = #{upperLimitChange,jdbcType=DECIMAL}");
		}
		if (record.getLowerLlimitChange() != null)
		{
			sql.SET("lowerLlimitChange = #{lowerLlimitChange,jdbcType=DECIMAL}");
		}
		if (record.getChangeLimitAlg() != null)
		{
			sql.SET("changeLimitAlg = #{changeLimitAlg,jdbcType=INTEGER}");
		}
		if (record.getTnDay() != null)
		{
			sql.SET("TnDay = #{tnDay,jdbcType=INTEGER}");
		}
		if (record.getEffectDate() != null)
		{
			sql.SET("effectDate = #{effectDate,jdbcType=TIMESTAMP}");
		}
		if (record.getMaxPerEntrust() != null)
		{
			sql.SET("maxPerEntrust = #{maxPerEntrust,jdbcType=BIGINT}");
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
		if (record.getChargeRemainRate() != null)
		{
			sql.SET("chargeRemainRate = #{chargeRemainRate,jdbcType=DECIMAL}");
		}
		if (record.getDayHostPrice() != null)
		{
			sql.SET("dayHostPrice = #{dayHostPrice,jdbcType=DECIMAL}");
		}
		if (record.getFreeHostday() != null)
		{
			sql.SET("freeHostday = #{freeHostday,jdbcType=INTEGER}");
		}
		if (record.getHostChargeBegin() != null)
		{
			sql.SET("hostChargeBegin = #{hostChargeBegin,jdbcType=DATE}");
		}
		if (record.getSettleUnit() != null)
		{
			sql.SET("settleUnit = #{settleUnit,jdbcType=VARCHAR}");
		}
		if (record.getDeliveryBegin() != null)
		{
			sql.SET("deliveryBegin = #{deliveryBegin,jdbcType=DATE}");
		}
		if (record.getTurnover() != null)
		{
			sql.SET("turnover = #{turnover,jdbcType=DECIMAL}");
		}
		sql.WHERE("id = #{id,jdbcType=BIGINT}");
		return sql.toString();
	}

	public String updateByCommodityId(TradeParam record)
	{
		SQL sql = new SQL();
		sql.UPDATE("tr_tradeparam");
		if (record.getAddTime() != null)
		{
			sql.SET("addTime = #{addTime,jdbcType=TIMESTAMP}");
		}
		if (record.getDeleteStatus() != null)
		{
			sql.SET("deleteStatus = #{deleteStatus,jdbcType=BIT}");
		}
		if (record.getCommodityId() != null)
		{
			sql.SET("commodityId = #{commodityId,jdbcType=BIGINT}");
		}
		if (record.getTradeStatus() != null)
		{
			sql.SET("tradeStatus = #{tradeStatus,jdbcType=INTEGER}");
		}
		if (record.getIssuePrice() != null)
		{
			sql.SET("issuePrice = #{issuePrice,jdbcType=DECIMAL}");
		}
		if (record.getOpenPrice() != null)
		{
			sql.SET("openPrice = #{openPrice,jdbcType=DECIMAL}");
		}
		if (record.getClearprice() != null)
		{
			sql.SET("clearprice = #{clearprice,jdbcType=DECIMAL}");
		}
		if (record.getListingDate() != null)
		{
			sql.SET("listingDate = #{listingDate,jdbcType=TIMESTAMP}");
		}
		if (record.getLastTradeDate() != null)
		{
			sql.SET("lastTradeDate = #{lastTradeDate,jdbcType=TIMESTAMP}");
		}
		if (record.getTradeUnit() != null)
		{
			sql.SET("tradeUnit = #{tradeUnit,jdbcType=VARCHAR}");
		}
		if (record.getMinChangePrice() != null)
		{
			sql.SET("minChangePrice = #{minChangePrice,jdbcType=DECIMAL}");
		}
		if (record.getMinChangeAmount() != null)
		{
			sql.SET("minChangeAmount = #{minChangeAmount,jdbcType=INTEGER}");
		}
		if (record.getUpperLimitChange() != null)
		{
			sql.SET("upperLimitChange = #{upperLimitChange,jdbcType=DECIMAL}");
		}
		if (record.getLowerLlimitChange() != null)
		{
			sql.SET("lowerLlimitChange = #{lowerLlimitChange,jdbcType=DECIMAL}");
		}
		if (record.getChangeLimitAlg() != null)
		{
			sql.SET("changeLimitAlg = #{changeLimitAlg,jdbcType=INTEGER}");
		}
		if (record.getTnDay() != null)
		{
			sql.SET("TnDay = #{tnDay,jdbcType=INTEGER}");
		}
		if (record.getEffectDate() != null)
		{
			sql.SET("effectDate = #{effectDate,jdbcType=TIMESTAMP}");
		}
		if (record.getMaxPerEntrust() != null)
		{
			sql.SET("maxPerEntrust = #{maxPerEntrust,jdbcType=BIGINT}");
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
		if (record.getChargeRemainRate() != null)
		{
			sql.SET("chargeRemainRate = #{chargeRemainRate,jdbcType=DECIMAL}");
		}
		if (record.getDayHostPrice() != null)
		{
			sql.SET("dayHostPrice = #{dayHostPrice,jdbcType=DECIMAL}");
		}
		if (record.getFreeHostday() != null)
		{
			sql.SET("freeHostday = #{freeHostday,jdbcType=INTEGER}");
		}
		if (record.getHostChargeBegin() != null)
		{
			sql.SET("hostChargeBegin = #{hostChargeBegin,jdbcType=DATE}");
		}
		if (record.getSettleUnit() != null)
		{
			sql.SET("settleUnit = #{settleUnit,jdbcType=VARCHAR}");
		}
		if (record.getDeliveryBegin() != null)
		{
			sql.SET("deliveryBegin = #{deliveryBegin,jdbcType=DATE}");
		}
		if (record.getTurnover() != null)
		{
			sql.SET("turnover = #{turnover,jdbcType=DECIMAL}");
		}
		sql.WHERE("commodityId = #{commodityId,jdbcType=BIGINT}");
		return sql.toString();
	}

	protected void applyWhere(SQL sql, TradeParamExample example, boolean includeExamplePhrase)
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
							sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i,
									j));
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
								sb.append(String.format(parmPhrase3_th, i, j, k,
										criterion.getTypeHandler()));
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

	public String getParamByNidOrPid(Long nid,Long pid)
	{
		SQL sql = new SQL();
		sql.SELECT("p.*");
		sql.FROM("tr_tradeparam p");
		sql.LEFT_OUTER_JOIN("tr_paramnode pn ON pn.paramId=p.id");
		if (nid != null)
		{
			sql.WHERE("pn.nodeId=" + nid);
		}
		if (pid!=null)
		{
			sql.WHERE("pn.paramId=" + pid);
		}
		return sql.toString();
	}
}
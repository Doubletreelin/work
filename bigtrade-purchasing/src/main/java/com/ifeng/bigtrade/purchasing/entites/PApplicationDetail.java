package com.ifeng.bigtrade.purchasing.entites;

import java.math.BigDecimal;
import java.util.Date;

public class PApplicationDetail {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.id
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.addTime
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Date addTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.deleteStatus
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Boolean deleteStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.commodityId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Long commodityId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.firmId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Long firmId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.issuanceplan_id
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Long issuanceplan_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.count
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Integer count;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.totalAmount
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private BigDecimal totalAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.brokerage
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private BigDecimal brokerage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.status
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.financeAccountId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Long financeAccountId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.startNo
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private String startNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.endNo
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private String endNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_applicationdetail.winCount
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	private Integer winCount;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.id
	 * @return  the value of p_applicationdetail.id
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.id
	 * @param id  the value for p_applicationdetail.id
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.addTime
	 * @return  the value of p_applicationdetail.addTime
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Date getAddTime()
	{
		return addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.addTime
	 * @param addTime  the value for p_applicationdetail.addTime
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.deleteStatus
	 * @return  the value of p_applicationdetail.deleteStatus
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Boolean getDeleteStatus()
	{
		return deleteStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.deleteStatus
	 * @param deleteStatus  the value for p_applicationdetail.deleteStatus
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setDeleteStatus(Boolean deleteStatus)
	{
		this.deleteStatus = deleteStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.commodityId
	 * @return  the value of p_applicationdetail.commodityId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Long getCommodityId()
	{
		return commodityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.commodityId
	 * @param commodityId  the value for p_applicationdetail.commodityId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setCommodityId(Long commodityId)
	{
		this.commodityId = commodityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.firmId
	 * @return  the value of p_applicationdetail.firmId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Long getFirmId()
	{
		return firmId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.firmId
	 * @param firmId  the value for p_applicationdetail.firmId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setFirmId(Long firmId)
	{
		this.firmId = firmId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.issuanceplan_id
	 * @return  the value of p_applicationdetail.issuanceplan_id
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Long getIssuanceplan_id()
	{
		return issuanceplan_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.issuanceplan_id
	 * @param issuanceplan_id  the value for p_applicationdetail.issuanceplan_id
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setIssuanceplan_id(Long issuanceplan_id)
	{
		this.issuanceplan_id = issuanceplan_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.count
	 * @return  the value of p_applicationdetail.count
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Integer getCount()
	{
		return count;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.count
	 * @param count  the value for p_applicationdetail.count
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setCount(Integer count)
	{
		this.count = count;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.totalAmount
	 * @return  the value of p_applicationdetail.totalAmount
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public BigDecimal getTotalAmount()
	{
		return totalAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.totalAmount
	 * @param totalAmount  the value for p_applicationdetail.totalAmount
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setTotalAmount(BigDecimal totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.brokerage
	 * @return  the value of p_applicationdetail.brokerage
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public BigDecimal getBrokerage()
	{
		return brokerage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.brokerage
	 * @param brokerage  the value for p_applicationdetail.brokerage
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setBrokerage(BigDecimal brokerage)
	{
		this.brokerage = brokerage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.status
	 * @return  the value of p_applicationdetail.status
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Integer getStatus()
	{
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.status
	 * @param status  the value for p_applicationdetail.status
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setStatus(Integer status)
	{
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.financeAccountId
	 * @return  the value of p_applicationdetail.financeAccountId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Long getFinanceAccountId()
	{
		return financeAccountId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.financeAccountId
	 * @param financeAccountId  the value for p_applicationdetail.financeAccountId
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setFinanceAccountId(Long financeAccountId)
	{
		this.financeAccountId = financeAccountId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.startNo
	 * @return  the value of p_applicationdetail.startNo
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public String getStartNo()
	{
		return startNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.startNo
	 * @param startNo  the value for p_applicationdetail.startNo
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setStartNo(String startNo)
	{
		this.startNo = startNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.endNo
	 * @return  the value of p_applicationdetail.endNo
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public String getEndNo()
	{
		return endNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.endNo
	 * @param endNo  the value for p_applicationdetail.endNo
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setEndNo(String endNo)
	{
		this.endNo = endNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_applicationdetail.winCount
	 * @return  the value of p_applicationdetail.winCount
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public Integer getWinCount()
	{
		return winCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_applicationdetail.winCount
	 * @param winCount  the value for p_applicationdetail.winCount
	 * @mbg.generated  Wed Nov 01 18:57:40 CST 2017
	 */
	public void setWinCount(Integer winCount)
	{
		this.winCount = winCount;
	}
}
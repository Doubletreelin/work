package com.ifeng.bigtrade.purchasing.entites;

import java.math.BigDecimal;
import java.util.Date;

public class PIssuancePlan {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.id
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.addTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Date addTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.deleteStatus
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Boolean deleteStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.commodityId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Long commodityId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.commodityName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private String commodityName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.planStartTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Date planStartTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.planEndTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Date planEndTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.publicityStartTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Date publicityStartTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.status
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.totalQuantity
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Integer totalQuantity;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.maxSingleWinningCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Integer maxSingleWinningCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.unitPrice
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private BigDecimal unitPrice;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.publisherId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Long publisherId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.brokerageType
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Integer brokerageType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.brokerage
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private BigDecimal brokerage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.operatorId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Long operatorId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.operatorName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private String operatorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.operatorIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private String operatorIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.applicationCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Integer applicationCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.allocateUserId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Long allocateUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.allocateUserName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private String allocateUserName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.allocateUserIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private String allocateUserIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.maxApplicationCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Integer maxApplicationCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.auditorId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Long auditorId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.auditorName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private String auditorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.auditorIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private String auditorIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.lotteryTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Date lotteryTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.publicityEndTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private Date publicityEndTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column p_issuanceplan.notes
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	private String notes;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.id
	 * @return  the value of p_issuanceplan.id
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.id
	 * @param id  the value for p_issuanceplan.id
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.addTime
	 * @return  the value of p_issuanceplan.addTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Date getAddTime()
	{
		return addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.addTime
	 * @param addTime  the value for p_issuanceplan.addTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.deleteStatus
	 * @return  the value of p_issuanceplan.deleteStatus
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Boolean getDeleteStatus()
	{
		return deleteStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.deleteStatus
	 * @param deleteStatus  the value for p_issuanceplan.deleteStatus
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setDeleteStatus(Boolean deleteStatus)
	{
		this.deleteStatus = deleteStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.commodityId
	 * @return  the value of p_issuanceplan.commodityId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Long getCommodityId()
	{
		return commodityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.commodityId
	 * @param commodityId  the value for p_issuanceplan.commodityId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setCommodityId(Long commodityId)
	{
		this.commodityId = commodityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.commodityName
	 * @return  the value of p_issuanceplan.commodityName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public String getCommodityName()
	{
		return commodityName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.commodityName
	 * @param commodityName  the value for p_issuanceplan.commodityName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setCommodityName(String commodityName)
	{
		this.commodityName = commodityName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.planStartTime
	 * @return  the value of p_issuanceplan.planStartTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Date getPlanStartTime()
	{
		return planStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.planStartTime
	 * @param planStartTime  the value for p_issuanceplan.planStartTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setPlanStartTime(Date planStartTime)
	{
		this.planStartTime = planStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.planEndTime
	 * @return  the value of p_issuanceplan.planEndTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Date getPlanEndTime()
	{
		return planEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.planEndTime
	 * @param planEndTime  the value for p_issuanceplan.planEndTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setPlanEndTime(Date planEndTime)
	{
		this.planEndTime = planEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.publicityStartTime
	 * @return  the value of p_issuanceplan.publicityStartTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Date getPublicityStartTime()
	{
		return publicityStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.publicityStartTime
	 * @param publicityStartTime  the value for p_issuanceplan.publicityStartTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setPublicityStartTime(Date publicityStartTime)
	{
		this.publicityStartTime = publicityStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.status
	 * @return  the value of p_issuanceplan.status
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Integer getStatus()
	{
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.status
	 * @param status  the value for p_issuanceplan.status
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setStatus(Integer status)
	{
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.totalQuantity
	 * @return  the value of p_issuanceplan.totalQuantity
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Integer getTotalQuantity()
	{
		return totalQuantity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.totalQuantity
	 * @param totalQuantity  the value for p_issuanceplan.totalQuantity
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setTotalQuantity(Integer totalQuantity)
	{
		this.totalQuantity = totalQuantity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.maxSingleWinningCount
	 * @return  the value of p_issuanceplan.maxSingleWinningCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Integer getMaxSingleWinningCount()
	{
		return maxSingleWinningCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.maxSingleWinningCount
	 * @param maxSingleWinningCount  the value for p_issuanceplan.maxSingleWinningCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setMaxSingleWinningCount(Integer maxSingleWinningCount)
	{
		this.maxSingleWinningCount = maxSingleWinningCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.unitPrice
	 * @return  the value of p_issuanceplan.unitPrice
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public BigDecimal getUnitPrice()
	{
		return unitPrice;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.unitPrice
	 * @param unitPrice  the value for p_issuanceplan.unitPrice
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setUnitPrice(BigDecimal unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.publisherId
	 * @return  the value of p_issuanceplan.publisherId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Long getPublisherId()
	{
		return publisherId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.publisherId
	 * @param publisherId  the value for p_issuanceplan.publisherId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setPublisherId(Long publisherId)
	{
		this.publisherId = publisherId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.brokerageType
	 * @return  the value of p_issuanceplan.brokerageType
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Integer getBrokerageType()
	{
		return brokerageType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.brokerageType
	 * @param brokerageType  the value for p_issuanceplan.brokerageType
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setBrokerageType(Integer brokerageType)
	{
		this.brokerageType = brokerageType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.brokerage
	 * @return  the value of p_issuanceplan.brokerage
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public BigDecimal getBrokerage()
	{
		return brokerage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.brokerage
	 * @param brokerage  the value for p_issuanceplan.brokerage
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setBrokerage(BigDecimal brokerage)
	{
		this.brokerage = brokerage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.operatorId
	 * @return  the value of p_issuanceplan.operatorId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Long getOperatorId()
	{
		return operatorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.operatorId
	 * @param operatorId  the value for p_issuanceplan.operatorId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setOperatorId(Long operatorId)
	{
		this.operatorId = operatorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.operatorName
	 * @return  the value of p_issuanceplan.operatorName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public String getOperatorName()
	{
		return operatorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.operatorName
	 * @param operatorName  the value for p_issuanceplan.operatorName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setOperatorName(String operatorName)
	{
		this.operatorName = operatorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.operatorIp
	 * @return  the value of p_issuanceplan.operatorIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public String getOperatorIp()
	{
		return operatorIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.operatorIp
	 * @param operatorIp  the value for p_issuanceplan.operatorIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setOperatorIp(String operatorIp)
	{
		this.operatorIp = operatorIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.applicationCount
	 * @return  the value of p_issuanceplan.applicationCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Integer getApplicationCount()
	{
		return applicationCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.applicationCount
	 * @param applicationCount  the value for p_issuanceplan.applicationCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setApplicationCount(Integer applicationCount)
	{
		this.applicationCount = applicationCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.allocateUserId
	 * @return  the value of p_issuanceplan.allocateUserId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Long getAllocateUserId()
	{
		return allocateUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.allocateUserId
	 * @param allocateUserId  the value for p_issuanceplan.allocateUserId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setAllocateUserId(Long allocateUserId)
	{
		this.allocateUserId = allocateUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.allocateUserName
	 * @return  the value of p_issuanceplan.allocateUserName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public String getAllocateUserName()
	{
		return allocateUserName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.allocateUserName
	 * @param allocateUserName  the value for p_issuanceplan.allocateUserName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setAllocateUserName(String allocateUserName)
	{
		this.allocateUserName = allocateUserName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.allocateUserIp
	 * @return  the value of p_issuanceplan.allocateUserIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public String getAllocateUserIp()
	{
		return allocateUserIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.allocateUserIp
	 * @param allocateUserIp  the value for p_issuanceplan.allocateUserIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setAllocateUserIp(String allocateUserIp)
	{
		this.allocateUserIp = allocateUserIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.maxApplicationCount
	 * @return  the value of p_issuanceplan.maxApplicationCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Integer getMaxApplicationCount()
	{
		return maxApplicationCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.maxApplicationCount
	 * @param maxApplicationCount  the value for p_issuanceplan.maxApplicationCount
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setMaxApplicationCount(Integer maxApplicationCount)
	{
		this.maxApplicationCount = maxApplicationCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.auditorId
	 * @return  the value of p_issuanceplan.auditorId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Long getAuditorId()
	{
		return auditorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.auditorId
	 * @param auditorId  the value for p_issuanceplan.auditorId
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setAuditorId(Long auditorId)
	{
		this.auditorId = auditorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.auditorName
	 * @return  the value of p_issuanceplan.auditorName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public String getAuditorName()
	{
		return auditorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.auditorName
	 * @param auditorName  the value for p_issuanceplan.auditorName
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setAuditorName(String auditorName)
	{
		this.auditorName = auditorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.auditorIp
	 * @return  the value of p_issuanceplan.auditorIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public String getAuditorIp()
	{
		return auditorIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.auditorIp
	 * @param auditorIp  the value for p_issuanceplan.auditorIp
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setAuditorIp(String auditorIp)
	{
		this.auditorIp = auditorIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.lotteryTime
	 * @return  the value of p_issuanceplan.lotteryTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Date getLotteryTime()
	{
		return lotteryTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.lotteryTime
	 * @param lotteryTime  the value for p_issuanceplan.lotteryTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setLotteryTime(Date lotteryTime)
	{
		this.lotteryTime = lotteryTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.publicityEndTime
	 * @return  the value of p_issuanceplan.publicityEndTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public Date getPublicityEndTime()
	{
		return publicityEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.publicityEndTime
	 * @param publicityEndTime  the value for p_issuanceplan.publicityEndTime
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setPublicityEndTime(Date publicityEndTime)
	{
		this.publicityEndTime = publicityEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column p_issuanceplan.notes
	 * @return  the value of p_issuanceplan.notes
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column p_issuanceplan.notes
	 * @param notes  the value for p_issuanceplan.notes
	 * @mbg.generated  Fri Nov 03 10:04:46 CST 2017
	 */
	public void setNotes(String notes)
	{
		this.notes = notes;
	}
}
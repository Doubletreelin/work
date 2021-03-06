package com.ifeng.bigtrade.finance.entites;

import java.math.BigDecimal;
import java.util.Date;

public class FDailyBalance {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.id
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.addTime
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private Date addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.deleteStatus
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private Boolean deleteStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.accountCode
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private String accountCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.b_date
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private Date b_date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.creditAmount
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private BigDecimal creditAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.debitAmount
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private BigDecimal debitAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.lastdayBalance
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private BigDecimal lastdayBalance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_dailybalance.todayBalance
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    private BigDecimal todayBalance;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.id
     *
     * @return the value of f_dailybalance.id
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.id
     *
     * @param id the value for f_dailybalance.id
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.addTime
     *
     * @return the value of f_dailybalance.addTime
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.addTime
     *
     * @param addTime the value for f_dailybalance.addTime
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.deleteStatus
     *
     * @return the value of f_dailybalance.deleteStatus
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.deleteStatus
     *
     * @param deleteStatus the value for f_dailybalance.deleteStatus
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.accountCode
     *
     * @return the value of f_dailybalance.accountCode
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.accountCode
     *
     * @param accountCode the value for f_dailybalance.accountCode
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.b_date
     *
     * @return the value of f_dailybalance.b_date
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public Date getB_date() {
        return b_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.b_date
     *
     * @param b_date the value for f_dailybalance.b_date
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.creditAmount
     *
     * @return the value of f_dailybalance.creditAmount
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.creditAmount
     *
     * @param creditAmount the value for f_dailybalance.creditAmount
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.debitAmount
     *
     * @return the value of f_dailybalance.debitAmount
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.debitAmount
     *
     * @param debitAmount the value for f_dailybalance.debitAmount
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.lastdayBalance
     *
     * @return the value of f_dailybalance.lastdayBalance
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public BigDecimal getLastdayBalance() {
        return lastdayBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.lastdayBalance
     *
     * @param lastdayBalance the value for f_dailybalance.lastdayBalance
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setLastdayBalance(BigDecimal lastdayBalance) {
        this.lastdayBalance = lastdayBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_dailybalance.todayBalance
     *
     * @return the value of f_dailybalance.todayBalance
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public BigDecimal getTodayBalance() {
        return todayBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_dailybalance.todayBalance
     *
     * @param todayBalance the value for f_dailybalance.todayBalance
     *
     * @mbg.generated Wed Aug 23 18:06:10 CST 2017
     */
    public void setTodayBalance(BigDecimal todayBalance) {
        this.todayBalance = todayBalance;
    }
}
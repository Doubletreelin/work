package com.ifeng.bigtrade.finance.entites;

import java.math.BigDecimal;
import java.util.Date;

public class FVoucherEntry {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_voucherentry.id
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_voucherentry.addTime
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    private Date addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_voucherentry.deleteStatus
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    private Boolean deleteStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_voucherentry.accountCode
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    private String accountCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_voucherentry.accountName
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    private String accountName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_voucherentry.creditAmount
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    private BigDecimal creditAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_voucherentry.debitAmount
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    private BigDecimal debitAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column f_voucherentry.voucher_id
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    private Long voucher_id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_voucherentry.id
     *
     * @return the value of f_voucherentry.id
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_voucherentry.id
     *
     * @param id the value for f_voucherentry.id
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_voucherentry.addTime
     *
     * @return the value of f_voucherentry.addTime
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_voucherentry.addTime
     *
     * @param addTime the value for f_voucherentry.addTime
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_voucherentry.deleteStatus
     *
     * @return the value of f_voucherentry.deleteStatus
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_voucherentry.deleteStatus
     *
     * @param deleteStatus the value for f_voucherentry.deleteStatus
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_voucherentry.accountCode
     *
     * @return the value of f_voucherentry.accountCode
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_voucherentry.accountCode
     *
     * @param accountCode the value for f_voucherentry.accountCode
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_voucherentry.accountName
     *
     * @return the value of f_voucherentry.accountName
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_voucherentry.accountName
     *
     * @param accountName the value for f_voucherentry.accountName
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_voucherentry.creditAmount
     *
     * @return the value of f_voucherentry.creditAmount
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_voucherentry.creditAmount
     *
     * @param creditAmount the value for f_voucherentry.creditAmount
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_voucherentry.debitAmount
     *
     * @return the value of f_voucherentry.debitAmount
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_voucherentry.debitAmount
     *
     * @param debitAmount the value for f_voucherentry.debitAmount
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column f_voucherentry.voucher_id
     *
     * @return the value of f_voucherentry.voucher_id
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public Long getVoucher_id() {
        return voucher_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column f_voucherentry.voucher_id
     *
     * @param voucher_id the value for f_voucherentry.voucher_id
     *
     * @mbg.generated Wed Aug 16 13:55:19 CST 2017
     */
    public void setVoucher_id(Long voucher_id) {
        this.voucher_id = voucher_id;
    }
}
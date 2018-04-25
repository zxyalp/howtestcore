package com.demo;

import java.util.Date;

/***
 * cust
 * @author yang.zhou
 * @date 2018/4/24
 */

public class CustBuyBook {

    private String id;
    private String custNo;
    private String idNo;
    private String custName;
    private String scenario;
    private String fundCode;
    private String appAmt;
    private String bankIndex;
    private String appType;
    private String appDate;
    private String result;
    private Date ts;

    public CustBuyBook(){

    }

    public CustBuyBook(String id, String custNo, String idNo, String custName, String scenario, String fundCode,
                       String appAmt, String bankIndex, String appType, String appDate, String result, Date ts) {
        this.id = id;
        this.custNo = custNo;
        this.idNo = idNo;
        this.custName = custName;
        this.scenario = scenario;
        this.fundCode = fundCode;
        this.appAmt = appAmt;
        this.bankIndex = bankIndex;
        this.appType = appType;
        this.appDate = appDate;
        this.result = result;
        this.ts = ts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getAppAmt() {
        return appAmt;
    }

    public void setAppAmt(String appAmt) {
        this.appAmt = appAmt;
    }

    public String getBankIndex() {
        return bankIndex;
    }

    public void setBankIndex(String bankIndex) {
        this.bankIndex = bankIndex;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

}

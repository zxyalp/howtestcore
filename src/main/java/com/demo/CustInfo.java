package com.demo;

/***
 * cust
 * @author yang.zhou
 * @date 2018/4/24
 */

public class CustInfo {

    private String id;
    private String custNo;
    private String idNo;
    private String custName;
    private String mobile;
    private String hboneNo;
    private String bankAcct;
    private String testScenario;
    private String fundCode;
    private String appAmt;
    private String bankIndex;
    private String appType;
    private String appDate;
    private String testResult;

    public CustInfo(String id, String custNo, String idNo, String custName, String mobile, String hboneNo, String bankAcct, String testScenario, String fundCode, String appAmt, String bankIndex, String appType, String appDate) {
        this.id = id;
        this.custNo = custNo;
        this.idNo = idNo;
        this.custName = custName;
        this.mobile = mobile;
        this.hboneNo = hboneNo;
        this.bankAcct = bankAcct;
        this.testScenario = testScenario;
        this.fundCode = fundCode;
        this.appAmt = appAmt;
        this.bankIndex = bankIndex;
        this.appType = appType;
        this.appDate = appDate;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHboneNo() {
        return hboneNo;
    }

    public void setHboneNo(String hboneNo) {
        this.hboneNo = hboneNo;
    }

    public String getBankAcct() {
        return bankAcct;
    }

    public void setBankAcct(String bankAcct) {
        this.bankAcct = bankAcct;
    }

    public String getTestScenario() {
        return testScenario;
    }

    public void setTestScenario(String testScenario) {
        this.testScenario = testScenario;
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

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

}

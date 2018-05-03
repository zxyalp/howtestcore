package com.howbuy.demo;

import com.howbuy.excelhelp.meta.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/28
 */
public class CustInfo {

    @ExcelField(index = 0)
    private String id;

    @ExcelField(index = 1)
    private String custNo;

    @ExcelField(index = 2)
    private String idNo;

    @ExcelField(index = 3)
    private String custName;

    @ExcelField(index = 4)
    private String mobile;

    @ExcelField(index = 5)
    private String hboneNo;

    @ExcelField(index = 6)
    private String bankAcct;

    @ExcelField(index = 7)
    private String scenario;

    @ExcelField(index = 8)
    private String fundCode;

    @ExcelField(index = 9)
    private String appAmt;

    @ExcelField(index = 10)
    private String bankIndex;

    @ExcelField(index = 11)
    private String appType;

    @ExcelField(index = 12)
    private String appDate;

    @ExcelField(index = 13, isResult = true)
    private String result;

    @ExcelField(index = 14, isResult = true)
    private String result01;

    @ExcelField(index = 15, type = ExcelField.ExcelFieldType.Date)
    private String result02;


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

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
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

    public String isResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getResult01() {
        return result01;
    }

    public String getResult02() {
        return result02;
    }

    public void setResult02(String result02) {
        this.result02 = result02;
    }

    public void setResult01(String result01) {
        this.result01 = result01;
    }

    public static List<String> getHeader(){

        List<String> headers = new ArrayList<>();

        headers.add("ID");
        headers.add("CUST_NO");
        headers.add("ID_NO");
        headers.add("CUST_NAME");
        headers.add("MOBILE");
        headers.add("HBONE_NO");
        headers.add("BANK_ACCT");
        headers.add("SCENARIO");
        headers.add("FUND_CODE");
        headers.add("APP_AMT");
        headers.add("BANK_INDEX");
        headers.add("APP_TYPE");
        headers.add("APP_DATE");
        headers.add("TEST_RESULT");
        headers.add("TEST_RESULT2");
        headers.add("TEST_RESULT3");
        return headers;
    }

    @Override
    public String toString() {
        return id+"::"+idNo+"::"+custNo+"::"+custName+"::"
                +mobile+"::"+hboneNo+"::"+bankAcct+"::"+scenario+"::"+fundCode;
    }
}

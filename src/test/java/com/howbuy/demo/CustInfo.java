package com.howbuy.demo;

import com.demo.excelhelper.ExcelFiled;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/28
 */
public class CustInfo {

    @ExcelFiled(index = 0)
    private String id;

    @ExcelFiled(index = 1)
    private String custNo;

    @ExcelFiled(index = 2)
    private String idNo;

    @ExcelFiled(index = 3)
    private String custName;

    @ExcelFiled(index = 4)
    private String mobole;

    @ExcelFiled(index = 5)
    private String hboneNo;

    @ExcelFiled(index = 6)
    private String bankAcct;

    @ExcelFiled(index = 7)
    private String scenario;

    @ExcelFiled(index = 8)
    private String fundCode;

    @ExcelFiled(index = 9)
    private String appAmt;

    @ExcelFiled(index = 10)
    private String bankIndex;

    @ExcelFiled(index = 11)
    private String appType;

    @ExcelFiled(index = 12)
    private String appDate;

    @ExcelFiled(index = 13)
    private boolean result;

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

    public String getMobole() {
        return mobole;
    }

    public void setMobole(String mobole) {
        this.mobole = mobole;
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

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public static List<String> getHeader(){

        List<String> headers = new ArrayList<>();
        return null;
    }

    @Override
    public String toString() {
        return id+"::"+idNo+"::"+custNo+"::"+custName+"::"
                +mobole+"::"+hboneNo+"::"+bankAcct+"::"+scenario+"::"+fundCode;
    }
}

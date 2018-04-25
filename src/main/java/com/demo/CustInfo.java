package com.demo;

import java.util.Date;

/***
 * cust
 * @author yang.zhou
 * @date 2018/4/24
 */

public class CustInfo {

    private String custNo;
    private String idNo;
    private String custName;

    public CustInfo(){

    }

    public CustInfo(String custNo, String idNo, String custName) {

        this.custNo = custNo;
        this.idNo = idNo;
        this.custName = custName;
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

    @Override
    public String toString() {
        return "CustName:"+custName+"; custNo:"+custNo+"; idNo:"+idNo;
    }
}

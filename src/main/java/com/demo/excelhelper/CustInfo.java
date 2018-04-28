package com.demo.excelhelper;

import com.demo.excelhelper.ExcelFiled;

/***
 * cust
 * @author yang.zhou
 * @date 2018/4/24
 */

public class CustInfo {

    @ExcelFiled(index = 1)
    private String custNo;

    @ExcelFiled(index = 2)
    private String idNo;

    @ExcelFiled(index = 3)
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

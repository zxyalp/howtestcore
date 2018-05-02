package com.howbuy.demo;

import com.howbuy.excelhelp.meta.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/28
 */
public class CustAppInfo {


    @ExcelField(index = 1)
    private String custNo;

    @ExcelField(index = 3)
    private String custName;

    @ExcelField(index = 8)
    private String fundCode;

    public static List<String> getHeader(){

        List<String> headers = new ArrayList<>();
        headers.add("CUST_NO");
        headers.add("CUST_NAME");
        return headers;
    }


    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }



    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return custNo+"::"+custName+"::"+fundCode;
    }
}

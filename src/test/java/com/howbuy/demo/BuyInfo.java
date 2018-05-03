package com.howbuy.demo;

import com.howbuy.excelhelp.meta.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/28
 */
public class BuyInfo {

    @ExcelField(index = 0)
    private String id;

    @ExcelField(index = 1)
    private String custNo;

    @ExcelField(index = 2)
    private String idNo;

    @ExcelField(index = 3, isResult = true)
    private String custName;

    public static List<String> getHeader(){

        List<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("客户号");
        headers.add("身份证号码");
        headers.add("客户姓名");
        return headers;
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

    @Override
    public String toString() {
        return id+"::"+idNo+"::"+custNo+"::"+custName;
    }
}

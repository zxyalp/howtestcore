package com.demo.excelhelper;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/26
 */
public class ExcelTest {

    public static void main(String[] args) throws Exception{

        ExcelParseHandler<CustBuyBook> parseHandler = new ExcelParseHandler<>();

        List<CustBuyBook> custInfoList =  parseHandler.doParse(new FileInputStream("test.xlsx"), CustBuyBook.class);



       for (CustBuyBook cust:custInfoList){
            cust.setResult(false);
       }

       parseHandler.doWriteBook("demo00.xlsx", custInfoList);
    }
}

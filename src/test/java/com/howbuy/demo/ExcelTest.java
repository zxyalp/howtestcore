package com.howbuy.demo;

import com.howbuy.excelhelp.IExcelParser;
import com.howbuy.excelhelp.IParseParam;
import com.howbuy.excelhelp.param.DefaultParseParam;
import com.howbuy.excelhelp.paraser.ExcelDomParser;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/28
 */
public class ExcelTest {

    @Test
    public void testParseDom() throws Exception{

        IExcelParser<CustAppInfo> excelParser = new ExcelDomParser<>();

        IParseParam parseParam = DefaultParseParam.builder()
                .excelInputStream(new FileInputStream("test.xlsx"))
                .columnSize(14)
                .sheetNum(IParseParam.FIRST_SHEET_NAME)
                .targetClass(CustAppInfo.class)
//                .header(BuyInfo.getHeader())
                .build();

        List<CustAppInfo> custInfoList = excelParser.parse(parseParam);

        for (CustAppInfo custInfo : custInfoList){
            System.out.println(custInfo);
        }


    }
}

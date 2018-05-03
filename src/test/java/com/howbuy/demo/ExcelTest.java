package com.howbuy.demo;

import com.howbuy.common.DateUtils;
import com.howbuy.excelhelp.IExcelParser;
import com.howbuy.excelhelp.IParseParam;
import com.howbuy.excelhelp.param.DefaultParseParam;
import com.howbuy.excelhelp.paraser.ExcelDomParser;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/28
 */
public class ExcelTest {

    @Test
    public void testParseDom() throws Exception{

        IExcelParser<CustInfo> excelParser = new ExcelDomParser<>();

        IParseParam parseParam = DefaultParseParam.builder()
                .excelInputStream(new FileInputStream("test.xlsx"))
                .excelOutputStream(new FileOutputStream("result001.xlsx"))
                .columnSize(16)
                .sheetNum(IParseParam.FIRST_SHEET_NAME)
                .targetClass(CustInfo.class)
                .header(CustInfo.getHeader())
                .build();

        List<CustInfo> custInfoList = excelParser.parse(parseParam);

        for (CustInfo custInfo : custInfoList){
            System.out.println(custInfo);
            custInfo.setResult("success");
            custInfo.setResult01("fail");
            custInfo.setResult02(DateUtils.getNowDate());
        }

        excelParser.write(parseParam, custInfoList);

    }

    @Test
    public void testWriteDom01() throws Exception{

        IExcelParser<CustAppInfo> excelParser = new ExcelDomParser<>();

        IParseParam parseParam = DefaultParseParam.builder()
                .excelInputStream(new FileInputStream("test.xlsx"))
                .excelOutputStream(new FileOutputStream("result001.xlsx"))
                .columnSize(16)
                .sheetNum(IParseParam.FIRST_SHEET_NAME)
                .targetClass(CustAppInfo.class)
                .header(CustAppInfo.getHeader())
                .build();

        List<CustAppInfo> custInfoList = excelParser.parse(parseParam);

        for (CustAppInfo custInfo : custInfoList){
            System.out.println(custInfo);
        }

        excelParser.write(parseParam, custInfoList);

    }


    @Test
    public void testWriteDom02() throws Exception{

        IExcelParser<BuyInfo> excelParser = new ExcelDomParser<>();

        IParseParam parseParam = DefaultParseParam.builder()
                .excelOutputStream(new FileOutputStream(new File(".","result004.xlsx")))
                .sheetNum(IParseParam.FIRST_SHEET_NAME)
                .header(BuyInfo.getHeader())
                .build();

        BuyInfo buyInfo = new BuyInfo();
        buyInfo.setId("100");
        buyInfo.setCustName("张三");
        buyInfo.setCustNo("1182882782782");
        buyInfo.setIdNo("12828928292");


        List<BuyInfo> custInfoList = new ArrayList<>();
        custInfoList.add(buyInfo);

        excelParser.write(parseParam, custInfoList);

    }
}

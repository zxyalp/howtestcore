package com.howbuy.demo;

import com.howbuy.excelhelp.IExcelParser;
import com.howbuy.excelhelp.IParseParam;
import com.howbuy.excelhelp.param.DefaultParseParam;
import com.howbuy.excelhelp.paraser.ExcelDomParser;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
            custInfo.setResult02("201de");
        }

        excelParser.write(parseParam, custInfoList);

    }
}

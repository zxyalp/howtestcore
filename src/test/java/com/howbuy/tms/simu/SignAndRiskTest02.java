package com.howbuy.tms.simu;

import com.howbuy.common.DateUtils;
import com.howbuy.common.SimpleExcelUtils;
import com.howbuy.databeans.CustInfo;
import com.howbuy.excelhelp.IExcelParser;
import com.howbuy.excelhelp.IParseParam;
import com.howbuy.excelhelp.param.DefaultParseParam;
import com.howbuy.excelhelp.paraser.ExcelDomParser;
import com.howbuy.simu.OnlineTradePage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by yang.zhou on 2017/11/7.
 */
public class SignAndRiskTest02 extends BaseTestCase {


    @Test(enabled = true)
    public void signAndRisk01Test() throws Exception {

        IExcelParser<CustInfo> excelParser = new ExcelDomParser<>();

        IParseParam parseParam = DefaultParseParam.builder()
                .excelInputStream(new FileInputStream("CustListRisk.xlsx"))
                .excelOutputStream(new FileOutputStream("RiskResult.xlsx"))
                .columnSize(16)
                .sheetNum(IParseParam.FIRST_SHEET_NAME)
                .targetClass(CustInfo.class)
                .header(CustInfo.getHeader())
                .build();
        List<CustInfo> custInfoList = excelParser.parse(parseParam);

        for (CustInfo custInfo: custInfoList){

            try {
                OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
                tradePage.signAndRiskValuation(custInfo.getIdNo());
                custInfo.setResult("true");
                custInfo.setResult02(DateUtils.getNowTime());
            }catch (Exception e){
                custInfo.setResult("fail");
                custInfo.setResult02(DateUtils.getNowTime());
            }

        }

        excelParser.write(parseParam, custInfoList);
    }



    @Test(enabled = true, dataProvider = "ExcelDataProvider")
    public void signAndRiskTest(CustInfo ...dat) throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(dat[0].getIdNo());
    }

    @DataProvider(name="ExcelDataProvider")
    public Object[][] SimpleDataProvider() throws Exception{

        IExcelParser<CustInfo> excelParser = new ExcelDomParser<>();

        IParseParam parseParam = DefaultParseParam.builder()
                .excelInputStream(new FileInputStream("CustListRisk.xlsx"))
                .excelOutputStream(new FileOutputStream("RiskResult.xlsx"))
                .columnSize(16)
                .sheetNum(IParseParam.FIRST_SHEET_NAME)
                .targetClass(CustInfo.class)
                .header(CustInfo.getHeader())
                .build();
        List<CustInfo> custInfoList = excelParser.parse(parseParam);

        CustInfo[][] arrayCust = new CustInfo[custInfoList.size()][1];

        for (int i=0; i< custInfoList.size();i++){
           CustInfo cust = custInfoList.get(i);
            arrayCust[i][0]=cust;
        }
        return arrayCust;
    }


    @Test
    public void excelTest() throws Exception{
        IExcelParser<CustInfo> excelParser = new ExcelDomParser<>();

        IParseParam parseParam = DefaultParseParam.builder()
                .excelInputStream(new FileInputStream("CustListRisk.xlsx"))
                .excelOutputStream(new FileOutputStream("RiskResult.xlsx"))
                .columnSize(16)
                .sheetNum(IParseParam.FIRST_SHEET_NAME)
                .targetClass(CustInfo.class)
                .header(CustInfo.getHeader())
                .build();
        List<CustInfo> custInfoList = excelParser.parse(parseParam);

        CustInfo[][] arrayObject = new CustInfo[custInfoList.size()][1];

        for (int i=0; i< custInfoList.size();i++){
            CustInfo cust = custInfoList.get(i);
            arrayObject[i][0]=cust;
        }
        for (CustInfo[] custInfoArry:arrayObject){
            System.out.println(custInfoArry[0]);
        }
    }
}

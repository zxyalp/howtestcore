package com.howbuy.tms.simu;

import com.demo.excelhelper.CustBuyBook;
import com.demo.excelhelper.ExcelParseHandler;
import com.demo.excelhelper.SimpleExcelUtils;
import com.howbuy.tms.BaseTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/24
 */
public class ReadExcel02Test extends BaseTestCase {

    @Test(enabled = false, dataProvider = "readExcelCustId")
    public void signAndRiskTest(String... strList) throws Exception {
        for (String str:strList){
            System.out.println(str);
        }

    }

    @Test(enabled = true)
    public void readBookTest() throws Exception {

//        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);

    }

    @DataProvider(name = "readExcelCustId")
    public Object[][] readExcel() throws Exception{

        InputStream stream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("test.xlsx");
        return SimpleExcelUtils.list2Array(SimpleExcelUtils.readBook(stream));
    }


}

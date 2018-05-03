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
public class ReadExcelTest extends BaseTestCase {

    @Test(enabled = false, dataProvider = "readExcelCustId")
    public void signAndRiskTest(String... strList) throws Exception {
        for (String str:strList){
            System.out.println(str);
        }

    }

    @Test(enabled = true)
    public void readBookTest() throws Exception {

//        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);

        ExcelParseHandler<CustBuyBook> parseHandler = new ExcelParseHandler<>();

        List<CustBuyBook> custBuyBookList = parseHandler.doParse(new FileInputStream("test02.xlsx"), CustBuyBook.class);

        for (CustBuyBook book:custBuyBookList){
            book.setResult(true);
        }

        parseHandler.doWriteBook("results.xlsx", custBuyBookList);

    }

    @DataProvider(name = "readExcelCustId")
    public Object[][] readExcel() throws Exception{

        InputStream stream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("test.xlsx");
        return SimpleExcelUtils.list2Array(SimpleExcelUtils.readBook(stream));
    }


}

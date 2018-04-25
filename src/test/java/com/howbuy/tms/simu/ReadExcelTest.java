package com.howbuy.tms.simu;

import com.demo.SimpleExcelUtils;
import com.howbuy.simu.OnlineTradePageSimu;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

        List<List<String>> books = SimpleExcelUtils.readBook("CustBuyInfo.xlsx");

        for (List<String> rowList:books){
           for (String cell:rowList)
               System.out.println(cell);
        }

    }

    @DataProvider(name = "readExcelCustId")
    public Object[][] readExcel() throws Exception{

        InputStream stream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("test.xlsx");
        return SimpleExcelUtils.list2Array(SimpleExcelUtils.readBook(stream));
    }


}

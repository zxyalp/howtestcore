package com.howbuy.tms.simu;

import com.demo.SimpleExcelUtils;
import com.howbuy.simu.OnlineTradePageSimu;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author yang.zhou
 * @date 2018/4/24
 */
public class ReadExcelTest extends BaseTestCase {

    @Test(enabled = true, dataProvider = "readExcelCustId")
    public void signAndRiskTest(String... strList) throws Exception {
        for (String str:strList){
            System.out.println(str);
        }

    }

    @DataProvider(name = "readExcelCustId")
    public Object[][] readExcel() throws Exception{
        return SimpleExcelUtils.list4Array(SimpleExcelUtils.readExcel());
    }


}

package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.InvestorSignPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class SimuWebTest extends BaseTestCase{

    private static final Log logger = LogFactory.getLog(SimuWebTest.class);


    @Test(enabled = true)
    public void loginSimuUser01() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320101198801018159", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CF8801", "2800000");
//        highEndBuyPage.buyHighFund("P11601", "2900000");
//        highEndBuyPage.buyHighFund("S21582", "3900000");
//        highEndBuyPage.buyHighFund("S28646", "3800000");
//        highEndBuyPage.buyHighFund("S29089", "1200000");

    }

}

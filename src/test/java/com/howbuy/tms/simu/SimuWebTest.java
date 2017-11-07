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

    private String simuUrl = "http://192.168.221.216:15080/trade/login/login.htm";

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320101199001016619", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("QY0001", "2800000");
        highEndBuyPage.buyHighFund("QY0002", "2900000");
        highEndBuyPage.buyHighFund("QY0003", "3900000");
        highEndBuyPage.buyHighFund("QY0004", "3800000");
        highEndBuyPage.buyHighFund("QY0005", "1200000");

    }

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320101197701018165", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("QY0001", "2800000");
        highEndBuyPage.buyHighFund("QY0002", "2900000", 2);
        highEndBuyPage.buyHighFund("QY0003", "3900000",1);
        highEndBuyPage.buyHighFund("QY0004", "3800000");
        highEndBuyPage.buyHighFund("QY0005", "1200000", 2);

    }

}

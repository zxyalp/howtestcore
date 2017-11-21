package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/** 购买私募产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuySimuFund01Test extends BaseTestCase{

    private static final Log logger = LogFactory.getLog(BuySimuFund01Test.class);

    private String simuUrl = "http://192.168.221.216:15080/trade/login/login.htm";

    /**
     * 开放日最后一天预约自划款 S29493 S29837
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320101197301011503", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S29493", "5500000");
        highEndBuyPage.buyHighFund("S29493", "5600000");


    }

    /**
     * 开放日最后一天预约自划款 S29493 S29837
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("32010119980101278X", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S29493", "6600000");
        highEndBuyPage.buyHighFund("S29493", "6700000");

    }


    /**
     * 开放日前一天预约自划款S29494
     */

    @Test(enabled = true)
    public void loginSimuUser15() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320101197601016066", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S29494", "3100000");
        highEndBuyPage.buyHighFund("S29494", "3500000");
        highEndBuyPage.buyHighFund("S29494", "3500000");

    }

    /**
     * 开放日前一天预约自划款S29494
     */

    @Test(enabled = true)
    public void loginSimuUser16() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("32010119980101286X", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("S29494", "5100000");
//        highEndBuyPage.buyHighFund("S29494", "5500000");
//        highEndBuyPage.buyHighFund("S29494", "6500000");

    }


}

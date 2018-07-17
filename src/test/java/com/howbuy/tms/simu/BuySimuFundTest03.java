package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 购买私募产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuySimuFundTest03 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest03.class);


    /**
     * CS0501
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330521197101011305", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
    }


    /**
     * CS0501
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330521199401012990", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
    }

}

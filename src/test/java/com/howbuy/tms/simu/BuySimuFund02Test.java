package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPageSimu;
import com.howbuy.simu.LoginWebPageSimu;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 购买私募产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuySimuFund02Test extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFund02Test.class);


    /**
     * 开放日最后一天预约自划款 S29493 S29837
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101198801017156", "qq1111");

        HighEndBuyPageSimu highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPageSimu.class);
        highEndBuyPage.buyHighFund("S21582", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S21955", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P11601", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P12596", randomMillAmount(1, 3));
    }

    /**
     * 开放日最后一天预约自划款 S29493 S29837
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101199101017782", "qq1111");

        HighEndBuyPageSimu highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPageSimu.class);
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S37842", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S38010", randomMillAmount(1, 3));


    }

}

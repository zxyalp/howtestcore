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
public class BuySimuFundTest06 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest06.class);


    /**
     * 代扣
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101197601014677", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P12596", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P12596", randomMillAmount(1, 3));
    }

    /**
     * 代扣
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser04() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("32010119980101286X", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P12596", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P12596", randomMillAmount(1, 3));
    }

    /**
     * 代扣
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("320101198701012817", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S29837", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29837", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S38010", randomMillAmount(1, 3));
    }

    /**
     * 储蓄罐
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser03() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330100198501015306", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyPiggyPay("S29837", randomMillAmount(1, 3));
        highEndBuyPage.buyPiggyPay("S29837", randomMillAmount(1, 3));
        highEndBuyPage.buyPiggyPay("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyPiggyPay("S36248", randomMillAmount(1, 3));
        highEndBuyPage.buyPiggyPay("S38010", randomMillAmount(1, 3));
    }


}

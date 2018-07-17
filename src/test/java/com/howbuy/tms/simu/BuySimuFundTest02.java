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
public class BuySimuFundTest02 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest02.class);


    /**
     * CS0501
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330521199601018481", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyBankLinePay("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("CS0504", randomMillAmount(1, 3));

    }

    /**
     * CS0501
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330521197501017925", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
  }


    /**
     * CS0501
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser03() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330521198501015836", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyBankLinePay("CS0305", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("CS0306", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("CS0307", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("CS0508", randomMillAmount(1, 3));
    }


    /**
     * CS0501
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser04() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("330521198901017435", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0305", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0306", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0307", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0508", randomMillAmount(1, 3));      }

}

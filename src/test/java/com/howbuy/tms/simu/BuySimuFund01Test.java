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
public class BuySimuFund01Test extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFund01Test.class);


    /**
     * 预约认购P09553，P11601，代扣下单
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void loginSimuUser01() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101198501015914", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("P09553", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P09553", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P11601", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("P11601", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("PE0146", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("PE0146", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S21582", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S21582", randomMillAmount(1, 3));
    }


    /**
     * 预约认购P09553，P11601，自化款下单
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void loginSimuUser011() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197001019025", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyBankLinePay("P09553", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("P09553", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("P11601", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("P11601", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("PE0146", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("PE0146", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S21582", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S21582", randomMillAmount(1, 3));
    }


    /**
     * S28646、S29089，代扣
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101198901015091", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("S62866", randomMillAmount(1, 3));
    }



    /**
     * S28646、S29089，自化款
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser021() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101199601019802", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyBankLinePay("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S62866", randomMillAmount(1, 3));
    }


    /**
     * S28646、S29089，自化款
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser03() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197901014772", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyBankLinePay("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S28646", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S29089", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S33873", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S62866", randomMillAmount(1, 3));
        highEndBuyPage.buyBankLinePay("S62866", randomMillAmount(1, 3));
    }

}

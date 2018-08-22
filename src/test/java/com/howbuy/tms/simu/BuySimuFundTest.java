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
public class BuySimuFundTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest.class);


    /**
     * CS0501
     *
     * @throws Exception
     */

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197901019362", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
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
    public void loginSimuUser02() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197901012021", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
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
        login.login("440101199101017421", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
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
    public void loginSimuUser04() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101198401016063", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
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
    public void loginSimuUser05() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197501011505", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
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
    public void loginSimuUser06() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197401014426", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
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
    public void loginSimuUser07() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101199201019838", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
    }


    @Test(enabled = true)
    public void loginSimuUser08() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101198401014324", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void loginSimuUser09() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101198401014084", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0503", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0504", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void loginSimuUser10() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197301011623", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("CS0501", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("CS0502", randomMillAmount(1, 3));
    }

}

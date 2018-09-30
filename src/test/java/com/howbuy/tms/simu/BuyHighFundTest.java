package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 购买专户产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuyHighFundTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuyHighFundTest.class);


    /**
     * 单卡认购	认购028050，028051，代扣2笔、储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest001() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197001019025", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("028050", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028050", randomMillAmount(1, 3));

    }


    /**
     * 单卡申购	申购246010，246020，代扣2笔，储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest002() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101199901013728", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("028051", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028051", randomMillAmount(1, 3));

    }


    /**
     * 专户代扣支付
     */
    @Test(enabled = true)
    public void buyHighFundTest003() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101197901014772", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("028050", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028050", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028051", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028051", randomMillAmount(1, 3));

    }


    /**
     * 储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest004() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("440101198001017964", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        highEndBuyPage.buyHighFund("028050", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028050", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028051", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028051", randomMillAmount(1, 3));
    }

}

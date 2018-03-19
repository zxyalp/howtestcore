package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPageSimu;
import com.howbuy.simu.LoginWebPageSimu;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 购买专户产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuyHighFund01Test extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuyHighFund01Test.class);


    /**
     * 单卡认购	认购028050，028051，代扣2笔、储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest001() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101199301018931", "qq1111");
        HighEndBuyPageSimu highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPageSimu.class);

        highEndBuyPage.buyHighFund("028050", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("028051", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("060330", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("060628", randomMillAmount(1, 3));

    }


    /**
     * 单卡申购	申购246010，246020，代扣2笔，储蓄罐2笔
     */
    @Test(enabled = true)
    public void buyHighFundTest003() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101198401016971", "qq1111");
        HighEndBuyPageSimu highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPageSimu.class);

        highEndBuyPage.buyHighFund("246010", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("246010", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("246020", randomMillAmount(1, 3));
        highEndBuyPage.buyHighFund("246020", randomMillAmount(1, 3));
    }



    /**
     * 多卡认购	认购028050，028051，代扣2笔、储蓄罐2笔
     */
    @Test(enabled = false)
    public void buyHighFundTest005() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101198501013276", "qq1111");
        HighEndBuyPageSimu highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPageSimu.class);

        highEndBuyPage.buyHighFund("246010", "800000");
        highEndBuyPage.buyHighFund("246010", "2200000", 2);

        highEndBuyPage.buyHighFund("371021", "500000");
        highEndBuyPage.buyHighFund("371021", "2800000", 2);
    }



}

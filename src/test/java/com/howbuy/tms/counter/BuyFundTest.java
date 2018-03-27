package com.howbuy.tms.counter;


import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


/**
 * Created by yang.zhou on 2017/9/11.
 */
public class BuyFundTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuyFundTest.class);

    @Test(enabled = false)
    public void buyHighFundTest() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("330100198101013416", "246010", randomMillAmount(1, 3), 2);
        buyPage.buyByIdNo("330100198101013416", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("330100198101013416", "246020", randomMillAmount(1, 3), 2);
        buyPage.buyByIdNo("330100198101013416", "246020", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void buyHighFund01Test() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320497513643114", "机构", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246010", randomMillAmount(1, 3));

        buyPage.buyByIdNo("320497513643114", "机构", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246020", randomMillAmount(1, 3));

        buyPage.buyByIdNo("320497513643114", "机构", "275052", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "275807", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void buyHighFund02Test() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320497513643114", "机构", "S21582", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "S21582", randomMillAmount(1, 3));

        buyPage.buyByIdNo("320497513643114", "机构", "S22275", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "S22275", randomMillAmount(1, 3));

        buyPage.buyByIdNo("320497513643114", "机构", "S36248", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "S36248", randomMillAmount(1, 3));

        buyPage.buyByIdNo("320497513643114", "机构", "S38010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "S38010", randomMillAmount(1, 3));
    }

}

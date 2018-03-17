package com.howbuy.tms.smwap;

import com.howbuy.common.PaymentType;
import com.howbuy.smwap.BuyFundPageWap;
import com.howbuy.smwap.LoginWapPageWap;
import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/12/27.
 */
public class BuyFundTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuyFundTest.class);

    @Test(enabled = true)
    public void loginWap01() throws Exception {
        LoginWapPageWap wapPage = PageFactory.initElements(driver, LoginWapPageWap.class);
        wapPage.loginWap("32010119980101286X");

        BuyFundPageWap buyFundPage = PageFactory.initElements(driver, BuyFundPageWap.class);
        buyFundPage.buy("S33873", "1200000", 2, PaymentType.DEFAULT_PAY);
        buyFundPage.buy("S33873", "1200000", 2, PaymentType.CXG_PAY);
        buyFundPage.buy("S33873", "1200000", 2, PaymentType.BANK_LINE_PAY);
        buyFundPage.buy("S33873", "1200000", 2, PaymentType.BANK_CARD_PAY);

    }

}

package com.howbuy.tms.simu;

import com.howbuy.simu.OnlineTradePageSimu;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/11/7.
 */
public class SignAndRiskTest06 extends BaseTestCase {

    @Test(enabled = true)
    public void signAndRiskTest1() throws Exception {
        OnlineTradePageSimu tradePage = PageFactory.initElements(driver, OnlineTradePageSimu.class);
        tradePage.signAndRiskValuation("330100198501015306");
    }


    @Test(enabled = true)
    public void signAndRiskTest2() throws Exception {
        OnlineTradePageSimu tradePage = PageFactory.initElements(driver, OnlineTradePageSimu.class);
        tradePage.signAndRiskValuation("330100198101013176");
    }

    @Test(enabled = true)
    public void signAndRiskTest3() throws Exception {
        OnlineTradePageSimu tradePage = PageFactory.initElements(driver, OnlineTradePageSimu.class);
        tradePage.signAndRiskValuation("330100198801016386");
    }

}

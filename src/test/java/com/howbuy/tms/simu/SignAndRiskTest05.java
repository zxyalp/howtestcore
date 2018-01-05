package com.howbuy.tms.simu;

import com.howbuy.simu.OnlineTradePage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/11/7.
 */
public class SignAndRiskTest05 extends BaseTestCase{
    @Test(enabled = true)
    public void signAndRiskTest1() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl, "330100197001015778");
    }

    @Test(enabled = true)
    public void signAndRiskTest2() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl, "330100198701011609");
    }


    @Test(enabled = true)
    public void signAndRiskTest3() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl, "33010019720101784X");
    }

}

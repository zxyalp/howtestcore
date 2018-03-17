package com.howbuy.tms.simu;

import com.howbuy.simu.OnlineTradePageSimu;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/11/7.
 */
public class SignAndRiskTest03 extends BaseTestCase {
    @Test(enabled = true)
    public void signAndRiskTest1() throws Exception {
        OnlineTradePageSimu tradePage = PageFactory.initElements(driver, OnlineTradePageSimu.class);
        tradePage.signAndRiskValuation("110101198701011997");
    }

    @Test(enabled = true)
    public void signAndRiskTest2() throws Exception {
        OnlineTradePageSimu tradePage = PageFactory.initElements(driver, OnlineTradePageSimu.class);
        tradePage.signAndRiskValuation("11010119870101205X");
    }


    @Test(enabled = true)
    public void signAndRiskTest3() throws Exception {
        OnlineTradePageSimu tradePage = PageFactory.initElements(driver, OnlineTradePageSimu.class);
        tradePage.signAndRiskValuation("110101198701012076");
    }


    @Test(enabled = true)
    public void signAndRiskTest4() throws Exception {
        OnlineTradePageSimu tradePage = PageFactory.initElements(driver, OnlineTradePageSimu.class);
        tradePage.signAndRiskValuation("110101198701012092");
    }

}

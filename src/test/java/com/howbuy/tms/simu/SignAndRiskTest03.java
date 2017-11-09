package com.howbuy.tms.simu;

import com.howbuy.simu.OnlineTradePage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/11/7.
 */
public class SignAndRiskTest03 extends BaseTestCase{

    private String simuUrl = "http://192.168.221.216:15080/trade/login/login.htm";

    @Test(enabled = true)
    public void signAndRiskTest() throws Exception{
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"32010119850101165X");

    }

    @Test(enabled = false)
    public void signAndRiskTest01() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"320101197601016066");
    }

    @Test(enabled = false)
    public void signAndRiskTest02() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"320101198501014332");
    }

    @Test(enabled = false)
    public void signAndRiskTest03() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"32010119980101286X");
    }


    @Test(enabled = false)
    public void signAndRiskTest04() throws Exception{
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"320101199001017849");

    }

    @Test(enabled = false)
    public void signAndRiskTest05() throws Exception{
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"320101199101019323");
    }

    @Test(enabled = true)
    public void signAndRiskTest06() throws Exception{
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"320101198801018159");
    }

    @Test(enabled = true)
    public void signAndRiskTest07() throws Exception{
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"320101199501012550");
    }

    @Test(enabled = true)
    public void signAndRiskTest08() throws Exception{
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"320101197901013684");
    }

    @Test(enabled = true)
    public void signAndRiskTest09() throws Exception{
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation(simuUrl,"320101198901018228");
    }
}

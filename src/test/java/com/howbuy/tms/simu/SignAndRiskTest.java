package com.howbuy.tms.simu;

import com.howbuy.simu.OnlineTradePage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * 风险测评
 * Created by yang.zhou on 2017/11/6.
 */
public class SignAndRiskTest extends BaseTestCase {

//
//    @Test
//    public void signAndRiskTest() throws Exception {
//        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
//        tradePage.signAndRiskValuation("440101197101014686");
//    }

//    @Test
//    public void signAndRiskTest01() throws Exception {
//        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
//        tradePage.signAndRiskValuation("440101198001017964");
//    }

    @Test
    public void signAndRiskTest02() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("44010119800101259X");
    }

    @Test
    public void signAndRiskTest03() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("440101198501015914");
    }

    @Test
    public void signAndRiskTest04() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("440101197001019025");
    }

    @Test
    public void signAndRiskTest05() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("440101198901015091");
    }

    @Test
    public void signAndRiskTest06() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("440101199601019802");
    }

    @Test
    public void signAndRiskTest07() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("440101199901013728");
    }


    @Test
    public void signAndRiskTest08() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("440101198801014657");
    }

    @Test
    public void signAndRiskTest09() throws Exception {
        OnlineTradePage tradePage = PageFactory.initElements(driver, OnlineTradePage.class);
        tradePage.signAndRiskValuation("440101197901014772");
    }


}
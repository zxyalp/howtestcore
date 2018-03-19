package com.howbuy.tms.counter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


/**
 * Created by yang.zhou on 2017/9/11.
 */
public class BuyFundTest extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(BuyFundTest.class);

//    @Test(priority = 1)
//    public void buyProductTest() throws Exception {
//        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
//        buyPage.buy("246020", "1200000", "093000");
//        buyPage.buy("028051", "1300000", "100000");
//    }


//    @Test(priority = 3)
//    public void checkOrderTest() throws Exception {
//        OrderCheckPage checkPage = PageFactory.initElements(driver, OrderCheckPage.class);
//        checkPage.get(tmsCounterUrl, "s002");
//        for (; checkPage.size() > 0; ) {
//            if (checkPage.isSameOperator())
//                checkPage.get(tmsCounterUrl, checkPage.getOtherOperator());
//            checkPage.checkFirstOrder();
//            checkPage.approvedByOrder();
//        }
//    }


}

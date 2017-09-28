package com.tms.counter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.List;


/**
 * Created by yang.zhou on 2017/9/11.
 */
public class BuyTest {

    private WebDriver driver;

    private static final Log logger = LogFactory.getLog(BuyTest.class);

    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.31\\chromedriver.exe");
        logger.info("========开始执行========");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();

    }

    @Test
    public void buyProductTest() throws Exception {
        TradeHomePage tradeHomePage = PageFactory.initElements(driver, TradeHomePage.class);
        tradeHomePage.openCounter("http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html", "s001");
        tradeHomePage.queryCustName("1100875618");
        tradeHomePage.buy("246020", "1200000", "090000");
        tradeHomePage.buy("246020", "1300000", "100000");
        tradeHomePage.buy("371021", "1400000", "090000");
        tradeHomePage.buy("028050", "1500000", "090000");

    }

    @Test
    public void CheckOrderTest() throws Exception {
        OrderCheckPage checkPage = PageFactory.initElements(driver, OrderCheckPage.class);
        checkPage.openCheckPage("http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html", "s001");
        for (; checkPage.size() > 0; ) {
            checkPage.checkFirstOrder();
            checkPage.approvedByOrder();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        logger.info("==========测试结束==========");
    }

}

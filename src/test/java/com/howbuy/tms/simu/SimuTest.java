package com.howbuy.tms.simu;

import com.howbuy.simu.BuyHighPage;
import com.howbuy.simu.LoginPage;
import com.howbuy.simu.OnlineTradingPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class SimuTest {

    private WebDriver driver;

    private String tmsCounterUrl = "http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html";

    private static final Log logger = LogFactory.getLog(SimuTest.class);

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
    public void loginSimuUser01() throws Exception{
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.get("http://192.168.221.55:15080/trade/login/login.htm?targeturl=http://192.168.221.55:4085/newpcsm/buylist.html");
        login.login("320101199101016667", "qq1111");

        BuyHighPage buyHighPage = PageFactory.initElements(driver, BuyHighPage.class);
        buyHighPage.setBuyListPage("http://192.168.221.55:4085/newpcsm/buylist.html");

        buyHighPage.buyHighFund("QY0001", "1200000", "121212");
        buyHighPage.buyHighFund("QY0002", "1300000", "121212");
        buyHighPage.buyHighFund("QY0003", "1400000", "121212");
        buyHighPage.buyHighFund("QY0004", "1500000", "121212");

        Assert.assertTrue(buyHighPage.isBuySuccess());
    }

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception{
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.get("http://192.168.221.55:15080/trade/login/login.htm?targeturl=http://192.168.221.55:4085/newpcsm/buylist.html");
        login.login("320901198001014372", "qq1111");

        BuyHighPage buyHighPage = PageFactory.initElements(driver, BuyHighPage.class);
        buyHighPage.setBuyListPage("http://192.168.221.55:4085/newpcsm/buylist.html");

        buyHighPage.buyHighFund("QY0001", "2200000", "121212");
        buyHighPage.buyHighFund("QY0002", "2300000", "121212");
        buyHighPage.buyHighFund("QY0003", "2400000", "121212");
        buyHighPage.buyHighFund("QY0004", "3500000", "121212");

        Assert.assertTrue(buyHighPage.isBuySuccess());
    }

    @AfterMethod
    public void tearDown() throws Exception{
        logger.info("关闭浏览器.");
//        driver.quit();
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        logger.info("==========测试结束==========");
    }
}

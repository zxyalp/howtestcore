package com.howbuy.tms.simu;

import com.howbuy.simu.BuyHighPage;
import com.howbuy.simu.InvestorSignPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.simu.RiskeValuationPage;
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

    private String simuUrl = "http://192.168.221.55:15080/trade/login/login.htm";

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

    @Test(enabled = false)
    public void loginSimuUser01() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320901198001014372", "qq1111");

        BuyHighPage buyHighPage = PageFactory.initElements(driver, BuyHighPage.class);
        buyHighPage.buyHighFund("QY0001", "32000000", "121212");
        buyHighPage.buyHighFund("QY0002", "33000000", "121212");
        buyHighPage.buyHighFund("QY0003", "34000000", "121212");
        buyHighPage.buyHighFund("QY0004", "35000000", "121212");
        buyHighPage.buyHighFund("QY0005", "36000000", "121212");


//        Assert.assertTrue(buyHighPage.isBuySuccess());
    }

    @Test(enabled = true)
    public void signInvestorTest() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get("http://192.168.221.55:15080/trade/login/login.htm?targeturl=http://192.168.221.55:4085/newpcsm/buylist.html");
        login.login("320101199701017874", "qq1111");

        InvestorSignPage signPage = PageFactory.initElements(driver, InvestorSignPage.class);
        signPage.confirmOfInvestors();
    }

    @Test(enabled = true)
    public void riskevaluationTest() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get("http://192.168.221.55:15080/trade/login/login.htm?targeturl=http://192.168.221.55:4085/newpcsm/buylist.html");
        login.login("320101199701017874", "qq1111");

        RiskeValuationPage signPage = PageFactory.initElements(driver, RiskeValuationPage.class);
        signPage.getAnswerList();
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

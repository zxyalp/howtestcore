package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.InvestorSignPage;
import com.howbuy.simu.LoginWebPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class SimuWebTest {

    private WebDriver driver;

    private String simuUrl = "http://192.168.221.55:15080/trade/login/login.htm";

    private static final Log logger = LogFactory.getLog(SimuWebTest.class);

    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.31\\chromedriver.exe");
        logger.info("========开始执行========");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test(enabled = true)
    public void loginSimuUser01() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320101199001016619", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("QY0001", "2800000");
        highEndBuyPage.buyHighFund("QY0002", "2900000");
        highEndBuyPage.buyHighFund("QY0003", "3900000");
        highEndBuyPage.buyHighFund("QY0004", "3800000");
        highEndBuyPage.buyHighFund("QY0005", "1200000");

    }

    @Test(enabled = true)
    public void loginSimuUser02() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320101197701018165", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("QY0001", "2800000");
        highEndBuyPage.buyHighFund("QY0002", "2900000", 2);
        highEndBuyPage.buyHighFund("QY0003", "3900000",1);
        highEndBuyPage.buyHighFund("QY0004", "3800000");
        highEndBuyPage.buyHighFund("QY0005", "1200000", 2);

//        Assert.assertTrue(highEndBuyPage.isBuySuccess());
    }

    @Test(enabled = true)
    public void loginSimuUser03() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("320101197301011415", "qq1111");

        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        highEndBuyPage.buyHighFund("QY0001", "2800000");
        highEndBuyPage.buyHighFund("QY0002", "2900000");
        highEndBuyPage.buyHighFund("QY0003", "3900000");


//        Assert.assertTrue(highEndBuyPage.isBuySuccess());
    }


    @Test(enabled = true)
    public void signInvestorTest() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get("http://192.168.221.55:15080/trade/login/login.htm?targeturl=http://192.168.221.55:4085/newpcsm/buylist.html");
        login.login("320101197701018165", "qq1111");

        InvestorSignPage signPage = PageFactory.initElements(driver, InvestorSignPage.class);
        signPage.confirmOfInvestors();
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

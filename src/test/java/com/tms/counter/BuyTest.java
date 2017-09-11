package com.tms.counter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import com.tms.counter.TradePage;
import sun.reflect.annotation.ExceptionProxy;


/**
 * Created by yang.zhou on 2017/9/11.
 */
public class BuyTest {

    private WebDriver driver;

    private static final Log logger = LogFactory.getLog(BuyTest.class.getName());

    @BeforeClass
    public void setDriverClass() throws Exception{
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.31\\chromedriver.exe");
        logger.info("========开始执行========");

    }

    @BeforeMethod
    public void setUp() throws Exception{
        driver = new ChromeDriver();

    }

    @Test
    public void buyProductTest() throws Exception{
        TradePage tradePage = PageFactory.initElements(driver, TradePage.class);
        tradePage.openCounter("http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html?operatorNo=s001&operName=s001");
        tradePage.buyProduct("1100876504");
    }

    @AfterClass
    public void tearDown() throws Exception{
        logger.info("==========测试结束==========");
    }

}

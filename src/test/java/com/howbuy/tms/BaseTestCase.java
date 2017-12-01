package com.howbuy.tms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**TestCase
 * Created by yang.zhou on 2017/11/6.
 */
public class BaseTestCase {
    private static final Log logger = LogFactory.getLog(BaseTestCase.class);

    protected WebDriver driver;

    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.31\\chromedriver.exe");
        logger.info("========开始执行========");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
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

package com.howbuy.tms;

import com.howbuy.common.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * TestBaseCase
 * Created by yang.zhou on 2017/11/6.
 */
public class BaseTestCase {
    private final Logger logger = LoggerFactory.getLogger(BaseTestCase.class);

    protected WebDriver driver;

    public static int getRandom(int min, int max) {
        return (int) (min + Math.random() * (Math.abs(max - min) + 1));
    }

    /**
     * 生成随机的百万金额
     *
     * @param minAmount 最小金额，单位：百万
     * @param maxAmount 最大金额，单位：百万
     * @return
     */
    public static String randomMillAmount(int minAmount, int maxAmount) {
        return String.valueOf(getRandom(minAmount * 100, maxAmount * 100) * 10000);
    }

    public static String randomAmount(int minAmount, int maxAmount) {
        return String.valueOf(getRandom(minAmount, maxAmount) * 10000);
    }

    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", TestContext.CHROME_DRIVER_PATH);
        logger.info(">>>Begin testing...");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        logger.info(">>>init chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        logger.info(">>>init complete.");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        logger.info(">>>Quit Browser.");
        driver.quit();
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        logger.info(">>>Test End.");
    }

}

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

//    @Test
    public void buyProductTest() throws Exception{
        TradePage tradePage = PageFactory.initElements(driver, TradePage.class);
        tradePage.openCounter("http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html?operatorNo=s001&operName=s001");
        tradePage.queryCust("1100876504");
        tradePage.entryOrder( "246020", "1200000", "090000");
    }

    @Test
    public void CheckOrderTest() throws Exception{
        TradePage tradePage = PageFactory.initElements(driver, TradePage.class);
        tradePage.openCheckPage("http://192.168.221.216:20380/tms-counter-console/tmscounter/html/index.html?operatorNo=s001&operName=s001");
        List<WebElement> webElements = tradePage.getOrderDetail();
        System.out.println(webElements.size());

        for (WebElement element:webElements){
            System.out.println(element.getText());
        }

        List<WebElement> orderlist = tradePage.getOrderList();

        System.out.println(orderlist.size());
        for (WebElement element: orderlist){
            System.out.println(element.getText());
        }
    }

    @AfterClass
    public void tearDown() throws Exception{
        logger.info("==========测试结束==========");
    }

}

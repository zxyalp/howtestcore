package com.autoit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * 百度search
 * @author summe
 * @date 2017/12/17
 */
public class BaiduTest {

    private WebDriver driver;


    @BeforeClass
    public void setDriverClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_2.34\\chromedriver.exe");
        System.out.println("==============START==============");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void baiduSearchTest(){
        driver.get("https://www.baidu.com/index.php");
        driver.findElement(By.id("kw")).sendKeys("北京时间");
        driver.findElement(By.id("su")).click();
        sleep3s();
        screenshort(driver, "result.png");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("==============END==============");
    }

    private static void sleep3s() {
        sleep3s(3000);
    }

    private static void sleep1s() {
        sleep3s(1000);
    }

    public static void sleep3s(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void screenshort(WebDriver driver, String fileName){
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void scrollTo(WebDriver driver, int ypos) {
        scrollTo(driver, 0, ypos);
    }

    public static void scrollTo(WebDriver driver, int xpos, int ypos) {
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(%s, %s)", xpos, ypos));
    }
}

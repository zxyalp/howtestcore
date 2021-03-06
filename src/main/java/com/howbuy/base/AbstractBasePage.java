package com.howbuy.base;

import com.howbuy.common.TestContext;
import com.howbuy.common.TestUtils;
import com.howbuy.common.UrlBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * 基础页面
 *
 * @author yang.zhou
 * @date 2017/1/15
 */
public abstract class AbstractBasePage {


    private final Logger logger = LoggerFactory.getLogger(AbstractBasePage.class.getName());

    public int timeOutInSeconds = 8;

    public WebDriver driver;

    public Wait<WebDriver> wait;


    public void get(String url, Dimension dimension) {
        logger.info("访问URL地址：{}", url);
        driver.get(url);
        if (dimension != null) {
            driver.manage().window().setSize(dimension);
        }
        driver.manage().window().maximize();
    }

    public void get(String url) {
        get(url, null);
    }

    public void open(String host, int port, String path, String query) {
        UrlBuilder builder = new UrlBuilder().create(host);
        builder.setPort(port);
        builder.setPath(path);
        if (query != null) {
            builder.setCustomQuery(query);
        }
        get(builder.toString());
    }

    public void open(String host, int port, String path) {
        open(host, port, path, null);
    }

    public void open(int port, String path) {
        open(TestContext.TMS_HOST, port, path, null);
    }

    public void open(int port, String path, String query) {
        open(TestContext.TMS_HOST, port, path, query);
    }


    public void open() {

    }

    public Boolean isElementExist(WebDriver driver, WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void addStyle(WebElement element) {
        String originalStyle = element.getAttribute("style");
        String redStyle = "border: 2px solid red; border-style: dashed;";
        String setAttr = "arguments[0].setAttribute(arguments[1], arguments[2])";
        ((JavascriptExecutor) driver).executeScript(setAttr, element, "style", redStyle);
        TestUtils.sleep1s();
        ((JavascriptExecutor) driver).executeScript(setAttr, element, "style", originalStyle);

    }
}

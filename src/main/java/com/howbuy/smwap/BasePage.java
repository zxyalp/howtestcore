package com.howbuy.smwap;

import com.howbuy.simu.UrlParse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * base page
 * @author yang.zhou
 * @date 2017/12/20
 */
public class BasePage {

    private static final Log logger = LogFactory.getLog(com.howbuy.simu.BasePage.class);

    private UrlParse urlParse = UrlParse.getInstance();

    public URL url;

    private static String loginWap = "/wap/account/login/login.htm";

    private static String indexSm = "/smtradewap/indexsm.html";

    WebDriver driver;

    Wait<WebDriver> wait;

    public void openBuyListPage(){
        try {
            url = new URL("http", urlParse.getUrl().getHost(),4081, loginWap);
            driver.get(url.toString());
        }catch (MalformedURLException m){
            logger.error(m);
            throw new RuntimeException(m);
        }
    }

    public Boolean elementIsExist(WebDriver driver, WebElement element, int time){
        try {
            new WebDriverWait(driver, time).until(visibilityOf(element));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

}

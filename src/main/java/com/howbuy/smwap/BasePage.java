package com.howbuy.smwap;

import com.howbuy.simu.UrlParse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Dimension;
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

    private static String LOGIN_WAP_URL = "/wap/account/login/login.htm?targeturl=";

    private static String INDEX_SM_URL = "/smtradewap/indexsm.html";

    public static String BUY_LIST_URL = "/smtradewap/buylist.html";

    WebDriver driver;

    Wait<WebDriver> wait;


    public URL loginWapUrl(){
        return urlParse.urlSpec(4081,LOGIN_WAP_URL);
    }

    public URL homeUrl(){
        return urlParse.urlSpec(1508, INDEX_SM_URL);
    }

    public URL buyListUrl(){
        return urlParse.urlSpec(1508, BUY_LIST_URL);
    }

    public void getHomePage(){
        get(homeUrl());
    }

    public void openBuyListPage(){
        get(buyListUrl());

    }

    public void get(URL url) {
        urlParse.setUrl(url);
        driver.get(url.toString());
        driver.manage().window().setSize(new Dimension(620,725));
    }


    public void get(String url){
        try {
            get(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
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

    public static void main(String[] args) throws MalformedURLException {
        UrlParse.getInstance().setUrl(new URL("http://192.168.221.123"));
        BasePage basePage = new BasePage();
        String u = basePage.loginWapUrl().toString();
        System.out.println(u);
    }

}

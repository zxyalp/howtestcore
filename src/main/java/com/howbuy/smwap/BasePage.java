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

    private String loginWapPath = "/wap/account/login/login.htm?targeturl=";

    private String indexSmPath = "/smtradewap/indexsm.html";

    public  String buyListPath = "/smtradewap/buylist.html";

    WebDriver driver;

    Wait<WebDriver> wait;


    public URL loginWapUrl(String path){
        return urlParse.urlSpec(4081, path);
    }


    public URL loginHomeUrl(){
        return loginWapUrl(loginWapPath+homeUrl().toString());
    }

    public URL loginBuyListUrl(){
        return loginWapUrl(loginWapPath+buyListUrl().toString());
    }

    public URL homeUrl(){
        return urlParse.urlSpec(15080, indexSmPath);
    }

    public URL buyListUrl(){
        return urlParse.urlSpec(15080, buyListPath);
    }


    public void setBaseUrl(URL url){
        urlParse.setUrl(url);
    }

    public void setBaseUrl(String url){
        try {
            setBaseUrl(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void get(String url) {
        driver.get(url);
        driver.manage().window().setSize(new Dimension(620,725));
    }


    public void get(URL url){
        get(url.toString());
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
        String url = "http://192.168.221.123:4081/wap/account/login/login.htm";
        BasePage basePage = new BasePage();
        basePage.setBaseUrl(url);
    }

}

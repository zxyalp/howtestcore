package com.howbuy.simu;

import com.howbuy.common.UrlParse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;

/**基础页面
 *
 * @author yang.zhou
 * @date 2017/9/29
 */
public class BasePage {


    private static final Log logger = LogFactory.getLog(BasePage.class);

    private UrlParse urlParse = UrlParse.getInstance();

    public URL url;

    private String buyListUrl = "/newpcsm/buylist.html";
    private String piggyUrl = "/newpc/pcfund/module/pcfund/view/piggyIndex.html";

    WebDriver driver;
    Wait<WebDriver> wait;


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

    public void get(URL url) {
        get(url.toString());
    }

    public void get(String url){

        if (urlParse.getUrl() == null){
            setBaseUrl(url);
        }

        driver.get(url);
        driver.manage().window().maximize();
    }

    public void openBuyListPage(){
            get(urlParse.urlSpec(4085, buyListUrl));
    }

    public void openPiggyPage(){
            get(urlParse.urlSpec(4085, piggyUrl));

    }
}

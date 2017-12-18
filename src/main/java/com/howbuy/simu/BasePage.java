package com.howbuy.simu;

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

    private static String buyListPath = "/newpcsm/buylist.html";
    private static String piggyPath = "/newpc/pcfund/module/pcfund/view/piggyIndex.html";

    WebDriver driver;
    Wait<WebDriver> wait;

    public void openBuyListPage(){
        try {
            url = new URL("http", urlParse.getUrl().getHost(),4085, buyListPath);
            driver.get(url.toString());
        }catch (MalformedURLException m){
            logger.error(m);
            throw new RuntimeException(m);
        }
    }

    public void openPiggyPage(){
        try {
            url = new  URL("http", urlParse.getUrl().getHost(),4085, piggyPath);
            driver.get(url.toString());
        }catch (MalformedURLException m){
            logger.error(m);
            throw new RuntimeException(m);
        }

    }
}

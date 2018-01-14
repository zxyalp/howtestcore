package com.howbuy.simu;

import com.howbuy.common.UrlBuilder;
import com.howbuy.common.UrlParse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;

/**基础页面
 *
 * @author yang.zhou
 * @date 2017/9/29
 */
public abstract class BasePage {


    private static final Log logger = LogFactory.getLog(BasePage.class);

    public int timeOutInSeconds = 10;

    WebDriver driver;

    Wait<WebDriver> wait;


    public void get(String url, Dimension dimension){
        driver.get(url);
        if (dimension == null) {
            driver.manage().window().maximize();
        }
    }

    public void get(String url){
        get(url,null);
    }

    public  void open(int port, String path){
        UrlBuilder builder = new UrlBuilder().create();
        builder.setPort(port);
        builder.setPath(path);
        get(builder.toString());
    }

    public void open(){}
}

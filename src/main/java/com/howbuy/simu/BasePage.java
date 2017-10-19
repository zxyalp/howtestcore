package com.howbuy.simu;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**基础页面
 *
 * @author yang.zhou
 * @date 2017/9/29
 */
public class BasePage {


    private static final Log logger = LogFactory.getLog(BasePage.class);

    private TestContext testContext = TestContext.getInstance();

    WebDriver driver;
    Wait<WebDriver> wait;

    public void reopen(){
        URL url;
        try {
            url = new URL("http",testContext.getUrl().getHost(),4085, "/newpcsm/buylist.html");
            driver.get(url.toString());
        }catch (MalformedURLException m){
            logger.error("打开在线购买列页面表异常："+m);
        }
    }
}

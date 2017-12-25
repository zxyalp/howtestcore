package com.howbuy.smwap;

import com.howbuy.common.TestUtils;
import com.howbuy.simu.UrlParse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *  login smwap
 * @author yang.zhou
 * @date 2017/12/20
 */
public class LoginWapPage extends BasePage {

    private static final Log logger = LogFactory.getLog(LoginWapPage.class);

    private UrlParse urlParse = UrlParse.getInstance();

    /**
     * 登录身份证号码
     */
    @FindBy(id = "displayIdNo")
    private WebElement loginId;

    /**
     * 登录密码
     */
    @FindBy(id = "loginPwd")
    private WebElement loginPwd;

    @FindBy(id = "loginButton")
    private WebElement loginBtn;

    @FindBy(linkText = "免费开户")
    private WebElement freeOpening;


    public LoginWapPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void loginWap(String idNo, String password){
        TestUtils.sleep1s();
        loginId = wait.until(ExpectedConditions.visibilityOf(loginId));
        loginId.clear();
        loginId.sendKeys();
        TestUtils.sleep1s();
        loginPwd.sendKeys(password);
        loginBtn.click();
    }


    public void loginWap(String idNo){
        loginWap(idNo, "qq1111");
    }

}

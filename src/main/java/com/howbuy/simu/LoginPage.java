package com.howbuy.simu;

import com.howbuy.tms.counter.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class LoginPage {

    private static final Log logger = LogFactory.getLog(LoginPage.class);

    private WebDriver driver;
    private Wait<WebDriver> wait;

    // 交易账号
    @FindBy(id = "idNo")
    @CacheLookup
    private WebElement idNoText;

    // 登录密码
    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordText;

    // 登录按钮
    @FindBy(css = "[value='登录']")
    @CacheLookup
    private WebElement loginBtn;

    // 免费开户
    @FindBy(linkText = "免费开户")
    private WebElement registerLink;

    // 用户激活
    @FindBy(linkText = "用户激活")
    private WebElement activateacctLink;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void get(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void login(String idNo, String passwd){
        TestUtils.sleep1s();
        idNoText = wait.until(visibilityOf(idNoText));
        idNoText.clear();
        idNoText.sendKeys(idNo);
        TestUtils.sleep1s();
        passwordText.clear();
        passwordText.sendKeys(passwd);
        passwordText.submit();
    }
}

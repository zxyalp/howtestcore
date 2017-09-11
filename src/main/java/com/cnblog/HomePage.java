package com.cnblog;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * Created by summe on 2017/5/29.
 */
public class HomePage {
    Wait<WebDriver> wait;
    WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "登录")
    WebElement loginLink;

    @FindBy(how = How.LINK_TEXT, using = "退出")
    WebElement logoutLink;

    private static  final Log logger = LogFactory.getLog(HomePage.class.getName());


    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void openBlog(String url){
        driver.get(url);
    }

    public void login(String userName, String passWord) {
        loginLink = wait.until(visibilityOf(loginLink));
        loginLink.click();

        logger.info("start login cnblog...");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginBlog(userName, passWord);
    }

    public void logout(){
        logoutLink = wait.until(visibilityOf(logoutLink));
        logger.info("logout cnblog...");
        logoutLink.click();
        LogoutPage logoutPage = PageFactory.initElements(driver, LogoutPage.class);
        logoutPage.logout();

    }

}

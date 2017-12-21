package com.howbuy.smwap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by yang.zhou on 2017/12/20.
 */
public class MyHomePage extends BasePage {

    private static final Log logger = LogFactory.getLog(MyHomePage.class);

    @FindBy(id = "loading")
    private WebElement loading;

    @FindBy(id = "dialogMain")
    private WebElement dialog;

    @FindBy(linkText = "买私募")
    private WebElement buyListLink;

    @FindBy(linkText = "卖私募")
    private WebElement sellListLnk;

    @FindBy(linkText = "我的预约")
    private WebElement orderLink;

    @FindBy(linkText = "交易记录")
    private WebElement recordListLink;




    public MyHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


}

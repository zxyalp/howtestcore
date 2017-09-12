package com.tms.counter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by yang.zhou on 2017/9/11.
 */
public class ApplyOrderPage {

    private WebDriver driver;

    private Wait<WebDriver> wait;

    @FindBy(id = "fundCode")
    private WebElement fundCodeElement;

    @FindBy(id = "fundName")
    private WebElement fundNameElement;

    @FindBy(className = "searchIcon")
    private WebElement searchIcon;

    @FindBy(id = "applyAmount")
    private WebElement applyAmountElement;

    @FindBy(id = "appTm")
    private WebElement appTmElement;

    @FindBy(id = "confimBuyBtn")
    private WebElement buyBtn;


    @FindBy(css = ".layui-layer-btn0")
    private WebElement okBtn;


    public ApplyOrderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void  orderInfo(String fundCode, String applyAmount, String appTm){
        fundCodeElement = wait.until(visibilityOf(fundCodeElement));
        fundCodeElement.sendKeys(fundCode);
        searchIcon.click();
        TestUtils.sleep3s(1000);
        applyAmountElement.sendKeys(applyAmount);
        TestUtils.sleep3s(1000);
        appTmElement.sendKeys(appTm);
        TestUtils.sleep3s(1000);
        buyBtn.click();
        okBtn = wait.until(visibilityOf(okBtn));
        okBtn.click();
    }

    public void  orderInfo(String fundCode, String applyAmount){
        orderInfo(fundCode, applyAmount, "090000");
    }

}

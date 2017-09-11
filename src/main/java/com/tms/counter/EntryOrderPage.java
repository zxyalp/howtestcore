package com.tms.counter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by yang.zhou on 2017/9/11.
 */
public class EntryOrderPage {

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


    public EntryOrderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void  buyFund(String fundCode, String applyAmount, String appTm){
        fundCodeElement.sendKeys(fundCode);
        searchIcon.click();

    }

}

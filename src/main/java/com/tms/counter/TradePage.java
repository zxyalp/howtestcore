package com.tms.counter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by yang.zhou on 2017/9/11.
 */
public class TradePage {

    private WebDriver driver;

    private Wait<WebDriver> wait;

    @FindBy(xpath = "//dt[contains(text(), '交易下单')]")
    private WebElement tradeOrderMenu;

    @FindBy(how = How.LINK_TEXT, using = "认申购")
    private WebElement buyMenu;

    @FindBy(how = How.CSS, using = "iframe[src$='buy.html']")
    private WebElement buyFrame;

    @FindBy(how = How.CSS, using = "iframe[src$='sell.html']")
    private WebElement sellFrame;

    private static final Log loger = LogFactory.getLog(TradePage.class.getName());

    public TradePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void openCounter(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void buyProduct(String custNo){
        (wait.until(visibilityOf(tradeOrderMenu))).click();
        (wait.until(visibilityOf(buyMenu))).click();
        buyFrame = wait.until(visibilityOf(buyFrame));
        driver.switchTo().frame(buyFrame);
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.queryCustNo(custNo);
    }



}

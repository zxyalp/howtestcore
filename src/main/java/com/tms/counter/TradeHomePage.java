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
public class TradeHomePage {

    private WebDriver driver;

    private Wait<WebDriver> wait;

    @FindBy(xpath = "//dt[contains(text(), '交易下单')]")
    private WebElement tradeOrderMenu;

    @FindBy(how = How.LINK_TEXT, using = "认申购")
    private WebElement buyMenu;

    @FindBy(how = How.CSS, using = "iframe[src*='buy.html']")
    private WebElement buyFrame;

    @FindBy(how = How.CSS, using = "iframe[src*='sell.html']")
    private WebElement sellFrame;

    private static final Log logger = LogFactory.getLog(TradeHomePage.class.getName());

    public TradeHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void openCounter(String url, String operatorNo){
        driver.get(url + "?operatorNo=" + operatorNo);
        driver.manage().window().maximize();
    }

    public void queryCustName(String custNo){
        (wait.until(visibilityOf(tradeOrderMenu))).click();
        (wait.until(visibilityOf(buyMenu))).click();
        buyFrame = wait.until(visibilityOf(buyFrame));
        driver.switchTo().frame(buyFrame);
        QueryUserPage queryUserPage = PageFactory.initElements(driver, QueryUserPage.class);
        queryUserPage.queryCustNo(custNo);
    }

    public void buy(String fundCode, String applyAmount, String appTm){
        TestUtils.scrollTo(driver, 10000);
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyOrderForm(fundCode, applyAmount, appTm);
    }

}

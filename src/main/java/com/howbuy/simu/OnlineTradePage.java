package com.howbuy.simu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class OnlineTradePage extends BasePage{


    public OnlineTradePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void get(String url){
        driver.get(url);
    }

    public void buyHighFund(String fundCode, String buyAmount, String txPassword){
        BuyHighPage buyPage = PageFactory.initElements(driver, BuyHighPage.class);
        buyPage.queryFund(fundCode);
        buyPage.fillInOrder(buyAmount);
        buyPage.confirmPurchase(txPassword);
    }

}

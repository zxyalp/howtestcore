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
public class BuyFundPage extends BasePage{

    private static final Log logger = LogFactory.getLog(BuyFundPage.class);




    public BuyFundPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public void payment(){

    }


}

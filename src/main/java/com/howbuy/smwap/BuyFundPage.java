package com.howbuy.smwap;

import com.howbuy.common.PaymentType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 购买下单
 * @author yang.zhou
 * @date 2017/12/20
 */
public class BuyFundPage extends BasePage{

    private static final Log logger = LogFactory.getLog(BuyFundPage.class);


    public BuyFundPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public void payment(){

    }

    public void buy(String fundCode, String amount, PaymentType paymentType, int index){


        SearchFundPage searchFundPage = PageFactory.initElements(driver, SearchFundPage.class);
        searchFundPage.seachFund(fundCode);

        PayInfoPage payInfoPage = PageFactory.initElements(driver, PayInfoPage.class);
        payInfoPage.pay(amount, paymentType, index);

    }


}

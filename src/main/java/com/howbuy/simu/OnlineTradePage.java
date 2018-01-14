package com.howbuy.simu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class OnlineTradePage extends BasePage{


    public OnlineTradePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    public void buyHighFund(String fundCode, String buyAmount, String txPassword){
        HighEndBuyPage buyPage = PageFactory.initElements(driver, HighEndBuyPage.class);
        buyPage.buyHighFund(fundCode, buyAmount, txPassword);
    }

    public void signAndRiskValuation (String idNo, String passwd) throws MalformedURLException {
        LoginWebPage loginWebPage = PageFactory.initElements(driver, LoginWebPage.class);
        loginWebPage.open();
        loginWebPage.login(idNo, passwd);
        InvestorSignPage signPage = PageFactory.initElements(driver,InvestorSignPage.class);
        signPage.open();
        signPage.confirmOfInvestors();
    }

    public void signAndRiskValuation (String idNo) throws MalformedURLException {
        signAndRiskValuation(idNo, "qq1111");
    }

}

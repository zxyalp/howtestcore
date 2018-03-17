package com.howbuy.simu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yang.zhou
 * @date 2017/9/29
 */
public class OnlineTradePageSimu extends SimuBasePage {

    private final Logger logger = LoggerFactory.getLogger(OnlineTradePageSimu.class.getName());

    public OnlineTradePageSimu(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    public void buyHighFund(String fundCode, String buyAmount, String txPassword) {
        HighEndBuyPageSimu buyPage = PageFactory.initElements(driver, HighEndBuyPageSimu.class);
        buyPage.buyHighFund(fundCode, buyAmount, txPassword);
    }

    public void signAndRiskValuation(String idNo, String password) {
        LoginWebPageSimu loginWebPage = PageFactory.initElements(driver, LoginWebPageSimu.class);
        loginWebPage.login(idNo, password);
        InvestorSignPageSimu signPage = PageFactory.initElements(driver, InvestorSignPageSimu.class);
        signPage.confirmOfInvestors();
    }

    public void signAndRiskValuation(String idNo) {
        signAndRiskValuation(idNo, "qq1111");
    }

}

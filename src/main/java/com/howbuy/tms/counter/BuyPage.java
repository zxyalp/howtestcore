package com.howbuy.tms.counter;

import jdk.internal.dynalink.linker.LinkerServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**1、购买页面
 * Created by yang.zhou on 2017/9/11.
 */
public class BuyPage {

    private static final Log logger = LogFactory.getLog(BuyPage.class);

    private WebDriver driver;

    private Wait<WebDriver> wait;

    // 基金代码
    @FindBy(id = "fundCode")
    @CacheLookup
    private WebElement fundCodeText;

    // 基金名称
    @FindBy(id = "fundName")
    @CacheLookup
    private WebElement fundNameText;

    // 基金代码搜索按钮
    @FindBy(className = "searchIcon")
    @CacheLookup
    private WebElement searchIcon;

    @FindBy(id = "applyAmount")
    @CacheLookup
    private WebElement applyAmountElement;

    // 获取银行卡
    @FindBy(css = "#selectBank > option")
    private List<WebElement> selectBankValues;

    // 银行卡
    @FindBy(css = "#selectBank")
    private WebElement selectBank;


    @FindBy(id = "appTm")
    @CacheLookup
    private WebElement appTmElement;

    @FindBy(id = "confimBuyBtn")
    @CacheLookup
    private WebElement confimBuyBtn;

    @FindBy(css = ".layui-layer-btn0")
    private WebElement okBtn;

    public BuyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void buyOrderForm(String fundCode, String applyAmount, String appTm){
        buyOrderForm(fundCode, applyAmount, appTm, 1);
    }

    public void  buyOrderForm(String fundCode, String applyAmount, String appTm, int index){
        TestUtils.sleep3s();
        fundCodeText = wait.until(visibilityOf(fundCodeText));
        fundCodeText.clear();
        fundCodeText.sendKeys(fundCode);
        TestUtils.sleep1s();
        searchIcon.click();
        TestUtils.sleep1s();
        applyAmountElement.clear();
        applyAmountElement.sendKeys(applyAmount);
        TestUtils.sleep1s();
        selectBank(index);
        TestUtils.sleep1s();
        appTmElement.clear();
        appTmElement.sendKeys(appTm);
        TestUtils.sleep1s();
        submit();
    }

    private void submit(){
        confimBuyBtn.click();
        wait.until(visibilityOf(okBtn)).click();
    }

    private void selectBank(int i){
        if (selectBankValues.size() > 1){
            selectBank.click();
            selectBankValues.get(i-1).click();
        }
    }

    public void  orderInfo(String fundCode, String applyAmount){
        buyOrderForm(fundCode, applyAmount, "090000");
    }

}

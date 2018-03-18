package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * 1、购买页面
 *
 * @author yang.zhou
 * @date 2017/9/11
 */
public class BuyPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(BuyPage.class.getName());


    /**
     * 购买订单FORM
     */
    @FindBy(css = "#buyConfirmForm")
    private WebElement buyConfirmForm;

    /**
     * 基金代码
     */
    @FindBy(id = "fundCode")
    private WebElement fundCodeInput;

    /**
     * 基金名称
     */
    @FindBy(id = "fundName")
    @CacheLookup
    private WebElement fundNameText;

    /**
     * 基金代码搜索放大镜
     */
    @FindBy(className = "searchIcon")
    private WebElement searchIcon;

    /**
     * 申请金额
     */
    @FindBy(id = "applyAmount")
    private WebElement applyAmountInput;


    /**
     * 用户银行卡列表
     */
    @FindBy(id = "selectBank")
    private WebElement selectBankId;


    /**
     * 申请折扣率
     */
    @FindBy(css = "#discountRate")
    private WebElement discountRate;

    /**
     * 申请时间
     */
    @FindBy(id = "appTm")
    private WebElement appTmInput;

    /**
     * 提交按钮
     */
    @FindBy(id = "confimBuyBtn")
    private WebElement confimBuyBtn;


    @FindBy(css = ".layui-layer-btn0")
    private List<WebElement> okBtnList;


    public BuyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void buyOrderForm(String fundCode, String applyAmount, String appTm) {
        buyOrderForm(fundCode, applyAmount, appTm, 1);
    }

    public void buyOrderForm(String fundCode, String applyAmount, String appTm, int bankIndex){

        logger.info("开始填写购买订单信息，产品：%s,申请金额：%s,申请时间：%s,使用第%s张银行卡.",fundCode,applyAmount,appTm,bankIndex);
        TestUtils.sleep2s();
        TestUtils.scrollTo(driver,fundCodeInput.getLocation().getY());
        if (StringUtils.isEmpty(fundCode)) {
            fundCodeInput.clear();
            fundCodeInput.sendKeys(fundCode);
            TestUtils.sleep1s();
            searchIcon.click();
            TestUtils.sleep1s();
        }

        Select selectBanks = new Select(selectBankId);

        List<WebElement> bankOptions = selectBanks.getOptions();

        int size = bankOptions.size();

        if (size==0){
            throw new NoSuchElementException("未找到客户银行卡信息, 客户持有银行卡:"+size+"张");
        }

        if (size > 1 && bankIndex < size) {
            WebElement bankOption = bankOptions.get(bankIndex - 1);
            bankOption.click();
            logger.info("选择%s张银行卡.银行卡号：%s.",bankIndex,bankOption.getText());
        }

        TestUtils.sleep1s();

        applyAmountInput.clear();
        applyAmountInput.sendKeys(applyAmount);
        logger.info("购买净购买金额：%s",applyAmount);

        TestUtils.sleep1s();
        appTmInput.clear();
        appTmInput.sendKeys(appTm);

        logger.info("下单时间：%s",appTm);

        TestUtils.sleep1s();

        submit();
    }

    private void submit() {

        confimBuyBtn.click();
        TestUtils.sleep2s();

        for (WebElement okBtn: okBtnList){
            okBtn.click();
            logger.info(okBtn.getText());
        }
    }


    private  void buy(){

    }

    public void orderInfo(String fundCode, String applyAmount) {
        buyOrderForm(fundCode, applyAmount, "090000");
    }

}

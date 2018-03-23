package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(css = ".layui-layer-content")
    private WebElement tips;


    public BuyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    private void buyOrderForm(String fundCode, String applyAmount, String appTm, int bankIndex) {

        logger.info(String.format("开始填写购买订单信息，产品：%s,申请金额：%s,申请时间：%s,使用第%s张银行卡.", fundCode, applyAmount, appTm, bankIndex));
        TestUtils.sleep2s();
        TestUtils.scrollTo(driver, fundCodeInput.getLocation().getY()-50);
        if (StringUtils.isNotEmpty(fundCode)) {
            logger.info("查询基金代码:"+fundCode);
            fundCodeInput.clear();
            fundCodeInput.sendKeys(fundCode);
            TestUtils.sleep1s();
            searchIcon.click();
            TestUtils.sleep1s();
        }

        Select selectBanks = new Select(selectBankId);

        List<WebElement> bankOptions = selectBanks.getOptions();

        int size = bankOptions.size();

        if (size == 0) {
            throw new NoSuchElementException("未找到客户银行卡信息, 客户持有银行为空.");
        }

        if (bankIndex >1 && size > 1 && bankIndex < size) {
            WebElement bankOption = bankOptions.get(bankIndex - 1);
            bankOption.click();
            logger.info(String.format("选择第%s张银行卡,银行卡号：%s.", bankIndex, bankOption.getText()));
        }

        TestUtils.sleep1s();

        applyAmountInput.clear();
        applyAmountInput.sendKeys(applyAmount);
        logger.info("购买净购买金额：" + applyAmount);

        TestUtils.sleep1s();
        appTmInput.clear();
        appTmInput.sendKeys(appTm);

        logger.info("下单时间：" + appTm);
        TestUtils.scrollTo(driver, appTmInput.getLocation().getY()-30);

        TestUtils.sleep1s();

        submit();
    }

    private void submit() {

        confimBuyBtn.click();
        TestUtils.sleep2s();

        while (okBtnList.size()>0){
            for (WebElement okBtn : okBtnList) {
                logger.info("弹出框内容："+tips.getText());
                okBtn.click();
            }
            TestUtils.sleep1s();
        }
    }

    public void buy(String custNo, String idNo, String fundCode, String applyAmount, String appTm, int bankIndex) {
        CounterHomePage homePage = PageFactory.initElements(driver, CounterHomePage.class);
        homePage.openBuyPage("s001");
        QueryUserPage queryUserPage = PageFactory.initElements(driver, QueryUserPage.class);
        queryUserPage.queryCustInfo(custNo, idNo);
        buyOrderForm(fundCode, applyAmount, appTm, bankIndex);

    }

    public void buyByCustNo(String custNo, String fundCode, String applyAmount) {
        buy(custNo, null, fundCode, applyAmount, "100000", 1);
    }

    public void buyByCustNo(String custNo, String fundCode, String applyAmount, int bankIndex) {
        buy(custNo, null, fundCode, applyAmount, "100000", bankIndex);
    }

    public void buyByIdNo(String idNo, String fundCode, String applyAmount) {
        buy(null, idNo, fundCode, applyAmount, "100000", 1);
    }

    public void buyByIdNo(String idNo, String fundCode, String applyAmount, int bankIndex) {
        buy(null, idNo, fundCode, applyAmount, "100000", bankIndex);
    }
}
package com.howbuy.simu;

import com.howbuy.tms.counter.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


/**高端产品购买页面
 * Created by yang.zhou on 2017/9/29.
 */
public class BuyHighPage {

    private static final Log logger = LogFactory.getLog(BuyHighPage.class);

    private WebDriver driver;
    private Wait<WebDriver> wait;

    // 基金代码查询
    @FindBy(id = "searchFund_")
    @CacheLookup
    private WebElement searchFundText;

    // 查询确定按钮
    @FindBy(id = "searchFundBtn_")
    @CacheLookup
    private WebElement searchFundBtn;

    // 数据加载框
    @FindBy(className = "dialogLoad")
    private WebElement dialog;

    // 暂无数据元素
    @FindBy(xpath = "//p[text()='暂无数据']")
    private WebElement noFund;

    // 基金购买按钮
    @FindBy(css = "a[href^='buyindex.html']")
    private WebElement  buyIndexBtn;

    // 净购买金额
    @FindBy(id = "buyAmount")
    private WebElement buyAmountText;

    // 支行名称
    @FindBy(css = "input[data-bind*='bankSubName']")
    private WebElement bankSubNameText;

    // 下一步按钮
    @FindBy(linkText = "下一步")
    private WebElement nextStepBtn;

    // 交易密码
    @FindBy(css = "input[data-bind*='txPassword']")
    private WebElement txPasswordText;

    // 购买确认信息按钮
    @FindBy(linkText = "确认")
    private WebElement nextStepTwoBtn;

    // 手机号码
    @FindBy(css = "input[data-bind*='mobile']")
    private WebElement mobileText;

    // 获取短信验证码
    @FindBy(linkText = "获取短信验证码")
    private WebElement getVerifyCodeBtn;

    // 验证码倒计时
    @FindBy(partialLinkText = "秒")
    private WebElement getVerifyCode;

    // 验证码
    @FindBy(id = "verifyCode")
    private WebElement verifyCodeText;

    // 确认购买
    @FindBy(linkText = "确认购买")
    private WebElement checkVerifyCodeBtn;

    // 购买成功
    @FindBy(partialLinkText = "您的购买申请已经受理")
    private WebElement buyingText;


    public BuyHighPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void queryFund(String fundCode){
        wait.until(invisibilityOf(dialog));
        searchFundText.sendKeys(fundCode);
        TestUtils.sleep1s();
        searchFundBtn.click();
        clickBuyButton();
    }

    public void clickBuyButton(){
        try {
            wait.until(invisibilityOf(dialog));
            buyIndexBtn.click();
        } catch (NoSuchElementException n){
            throw  new RuntimeException("该产品无法购买.");
        }
    }

    public void fillInOrder(String buyAmount){
        wait.until(invisibilityOf(dialog));
        buyAmountText.sendKeys(buyAmount);
        TestUtils.scrollEnd(driver);
        bankSubNameText.sendKeys("上海南京西路支行");
        wait.until(elementToBeClickable(nextStepBtn)).click();
    }

    public void confirmPurchase(String txPassword){
        wait.until(invisibilityOf(dialog));
        txPasswordText.sendKeys(txPassword);
        wait.until(elementToBeClickable(nextStepTwoBtn)).click();
        TestUtils.sleep3s();
        getVerifyCodeBtn.click();
        wait.until(visibilityOf(getVerifyCode));
        verifyCodeText.sendKeys("111111");
        wait.until(elementToBeClickable(checkVerifyCodeBtn)).click();
    }

    public Boolean isBuySuccess(){
        try {
            wait.until(invisibilityOf(dialog));
            wait.until(visibilityOf(buyingText));
        }catch (TimeoutException t){
            logger.error("购买产品成功");
            return false;
        }
        return true;
    }

    public void buyHighFund(String fundCode, String buyAmount, String txPassword){
        queryFund(fundCode);
        fillInOrder(buyAmount);
        confirmPurchase(txPassword);
    }
}

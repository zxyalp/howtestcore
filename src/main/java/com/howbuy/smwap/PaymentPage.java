package com.howbuy.smwap;

import com.howbuy.common.PaymentType;
import com.howbuy.common.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * 支付购买页面
 * @author yang.zhou
 * @date 2017/12/21
 */
public class PaymentPage extends BasePage{


    private static final Log logger = LogFactory.getLog(PaymentPage.class);


    /**
     * 加载框
     */
    @FindBy(css = "#loading:empty")
    private WebElement loading;

    /**
     * 买入金额
     * */
    @FindBy(id = "buyAmount")
    private WebElement buyAmount;

    /**
     * 支付金额
     */
    @FindBy(id = "payAmount")
    private WebElement payAmount;

    /**
     * 手续费
     */
    @FindBy(id = "feeAmount")
    private WebElement feeAmount;

    @FindBy(id = "cxgBankListDiv")
    private WebElement cxgBankList;

    /**
     * 更换支付方式
     */
    @FindBy(xpath = "//span[text()='更换支付方式']")
    private WebElement payMethods;

    /**
     * 储蓄罐支付
     */
    @FindBy(id = "pay_byCxg")
    private WebElement payXcg;

    /**
     * 银行卡转账
     */
    @FindBy(id = "pay_byBank_xx")
    private WebElement payBankLine;

    /**
     * 银行卡代扣
     */
    @FindBy(id = "pay_byBank")
    private WebElement payBank;

    /**
     * 银行支行名称
     */
    @FindBy(id = "branchName")
    private WebElement branchName;


    public PaymentPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * 购买第一步
     * @param amount 买入金额
     * @param paymentType 支付方式：0-储蓄罐，1-银行转账，2-银行代扣
     * @param index
     */
    public void pay(String amount, PaymentType paymentType, int index){
        try {
            wait.until(visibilityOf(loading));
            wait.until(visibilityOf(buyAmount)).sendKeys(amount);
            TestUtils.sleep1s();
            if (paymentType==PaymentType.CXG_PAY){

            }

            if (paymentType==PaymentType.BANK_LINE_PAY){

            }

            if (paymentType==PaymentType.BANK_CARD_PAY){

            }


        }catch (TimeoutException e){
            throw  new TimeoutException("下单异常");
        }
    }

}

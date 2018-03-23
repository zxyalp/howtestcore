package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * 订单审核页面
 *
 * @author yang.zhou
 * @date 2017/9/12
 */
public class OrderCheckPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(OrderCheckPage.class.getName());

    private String operatorNo;


    /**
     * 查询按钮
     */
    @FindBy(id = "queryBtn")
    private WebElement queryBtn;

    /**
     * 查询结果列表
     */
    @FindBy(css = "#rsList > tr")
    private WebElement resultsList;

    /**
     * 获取待审核订单的操作员
     */
    @FindBy(xpath = "#rsList > tr > td:nth-last-child(2)")
    private List<WebElement> operatorList;

    /**
     * 复核按钮
     */
    @FindBy(linkText = "复核")
    private List<WebElement> reCheckBtnList;

    /**
     * 暂无审核记录元素
     */
    @FindBy(css = "#rsList td:only-child")
    private WebElement noCheckOrder;


    /**
     * 复核信息详情页面iframe
     */
    @FindBy(id = "layui-layer-iframe6")
    private WebElement reCheckIframe;


    /**
     * 获取订单中基金代码
     */
    @FindBy(id = "fundCode")
    private WebElement fundCodeText;

    /**
     * 获取申请净购买金额
     */
    @FindBy(id = "applyAmount")
    private WebElement applyAmountText;

    /**
     * 获取银行卡信息
     */
    @FindBy(id = "selectCustBank")
    private WebElement selectCustBanks;


    /**
     * 复核信息表单
     */
    @FindBy(id = "checkResult")
    private WebElement checkResult;

    @FindBy(css = "#checkResult #searchFundId")
    private WebElement searchFundId;

    @FindBy(css = "#checkResult [name=appAmt]")
    private WebElement appAmt;

    /**
     * 审核通过
     */
    @FindBy(id = "checkConfirmBtn")
    private WebElement checkConfirmBtn;

    /**
     * 审核拒绝
     */
    @FindBy(className = "checkBackBtn")
    private WebElement checkBackBtn;


    public OrderCheckPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }



    public WebElement getFirstOrder() {
        if (orderDetailList.size() < 2) {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException("无待审核记录.");
            }
        }
        return wait.until(visibilityOf(firstOrder));
    }

    /**
     * 获取地址链接的操作员
     */
    public String getOperatorNo() {
        return driver.getCurrentUrl().split("operatorNo=")[1];
    }

    /**
     * 获取待审核订单操作员
     */

    public String getOperator() {

        if (operatorList.size()==0){
            return null;
        }
        return operatorList.get(0).getText();
    }

    /**
     * 判断订单审核的操作员是否订单创建人员是否是同一个人
     */

    public boolean isSameOperator() {
        if (getOperator().equals(this.operatorNo)) {
            logger.info("订单审核操作员与创建人员是同一个人");
            driver.switchTo().defaultContent();
            return true;
        }
        return false;
    }

    /**
     * 如果返回另一个用户
     */

    public String getOtherOperator() {
        if (this.operatorNo.equals("s001")) {
            return "s002";
        }
        return "s001";
    }

    /**
     * 复核第一条订单
     */

    public void checkFirstOrder() {
        TestUtils.sleep3s();
        WebElement reviewCheckBtn = getFirstOrder().findElement(By.cssSelector(".reCheck"));
        logger.info("点击复核操作按钮");
        reviewCheckBtn.click();
    }

    /**
     * 获取复核信息中基金代码(fundCode)、金额/份额(appAmt)、银行卡尾号4位(bankAcct);
     */

    public Map<String, String> getReviewInfo() {
        appAmtText = wait.until(visibilityOf(appAmtText));
        String appAmt = TestUtils.matcher(appAmtText.getText(), "\\.|\\d");
        String bankAcct = TestUtils.matcher(bankAcctText.getText(), "\\d");
        logger.info("提取金额、银行卡号后4位：" + appAmt + "," + bankAcct);
        Map<String, String> fund = new HashMap<>();
        fund.put("fundCode", fundCodeText.getText());
        fund.put("appAmt", appAmt);
        fund.put("bankAcct", bankAcct);
        logger.info("获取复核信息中基金代码、金额/份额、银行卡尾号4位：" + fund.toString());
        return fund;
    }

    public void checkOrder() {

        Map<String, String> checkResult = getReviewInfo();
        TestUtils.sleep1s();
        fundCodeInput.sendKeys(checkResult.get("fundCode"));
        TestUtils.sleep1s();
        appAmtTextInput.sendKeys(checkResult.get("appAmt"));
        TestUtils.sleep1s();
        bankAcctInput.sendKeys(checkResult.get("bankAcct"));
        TestUtils.sleep1s();
    }

    public void approvedByOrder() {
        checkOrder();
        approvedBtn.click();
    }

    public void refuseByOrder() {
        checkOrder();
        refuseBtn.click();
    }

}

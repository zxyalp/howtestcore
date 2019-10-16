package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * 订单审核页面
 *
 * @author yang.zhou
 * @date 2017/9/12
 */
public class OrderCheckNewPage extends CounterBasePage {

    private final Logger logger = LoggerFactory.getLogger(OrderCheckNewPage.class.getName());

    private final String operator01 = "s007";

    private final String operator02 = "s008";


    /**
     * 查询按钮
     */
    @FindBy(id = "queryBtn")
    private WebElement queryBtn;

    /**
     * 查询结果列表
     */
    @FindBy(css = "#rsList > tr")
    private WebElement resultsCust;

    /**
     * 获取待审核订单的操作员
     */
    @FindBy(css = "#rsList > tr > td:nth-last-child(2)")
    private List<WebElement> operatorList;

    /**
     * 复核按钮列表
     */
    @FindBy(linkText = "复核")
    private List<WebElement> reCheckBtnList;

    /**
     * 复核按钮
     */
    @FindBy(linkText = "复核")
    private WebElement reCheckBtn;

    /**
     * 暂无审核记录元素
     */
    @FindBy(css = "#rsList td:only-child")
    private WebElement noCheckOrder;


    /**
     * 复核信息详情页面iframe
     */
    @FindBy(css = "iframe[src*='viewType']")
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


    public OrderCheckNewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    /**
     * 订单复核
     */
    public void check() {
        try {
            queryApprovedOrdersList(operator01);
            while (reCheckBtnList.size() > 0) {
                if (isSameOperator()) {
                    queryApprovedOrdersList(getOtherOperator());
                }
                logger.info(">>>审核列表的第一条订单复核按钮.");
                reCheckBtnList.get(0).click();
                checkOrderInfo();
                TestUtils.sleep1s();
            }

        } catch (TimeoutException t) {
            throw new TimeoutException("没有待复核的订单.");
        }
    }


    /**
     * 查询待审核列表
     */
    public void queryApprovedOrdersList(String operatorNo) {
        CounterHomePage homePage = PageFactory.initElements(driver, CounterHomePage.class);
        homePage.openCheckPage(operatorNo);
        wait.until(visibilityOf(queryBtn)).click();
        TestUtils.scrollTo(driver, queryBtn.getLocation().getY());
        TestUtils.sleep1s();
        wait.until(visibilityOf(reCheckBtn));
        logger.info("####待审核列表中订单条数：{}", reCheckBtnList.size());
    }


    /**
     * 获取地址链接的操作员
     */
    private String getUrlOperatorNo() {
        return driver.getCurrentUrl().split("operatorNo=")[1];
    }

    /**
     * 获取待审核订单操作员
     */
    private String getOperatorNo() {

        if (operatorList.size() == 0) {
            throw new NoSuchElementException("查询不到订单操作员");
        }
        return operatorList.get(0).getText();
    }

    /**
     * 判断订单审核的操作员是否订单创建人员是否是同一个人
     */
    public boolean isSameOperator() {
        if (getUrlOperatorNo().equals(getOperatorNo())) {
            logger.info("订单审核操作员与创建人员是同一个人");
            return true;
        }
        return false;
    }


    /**
     * 如果审核员与录入员相同，则返回另一个用户
     */
    public String getOtherOperator() {
        if (operator01.equals(getOperatorNo())) {
            return operator02;
        }
        return operator01;
    }


    /**
     * 订单审核详情页面.
     */
    private void checkOrderInfo() {
        wait.until(visibilityOf(reCheckIframe));
        logger.info(">>>进入复核订单详情页面.");
        driver.switchTo().frame(reCheckIframe);
        TestUtils.sleep2s();
        logger.info(">>>下拉滚动条到复核详情页面底部.");
        TestUtils.scrollTo(driver, checkResult.getLocation().getY());
        logger.info(">>>点击审核通过按钮.");
        checkConfirmBtn.click();
        TestUtils.sleep2s();
        driver.switchTo().parentFrame();
    }

}

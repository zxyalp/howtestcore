package com.tms.counter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;


/**
 * Created by yang.zhou on 2017/9/12.
 */
public class OrderCheckPage {

    private WebDriver driver;

    private Wait<WebDriver> wait;

    @FindBy(xpath = "//dt[contains(text(), ' 交易复核')]")
    private WebElement tradeCheckMenu;

    @FindBy(linkText = "柜台交易复核")
    private WebElement counterCheckMenu;

    @FindBy(how = How.CSS, using = "iframe[src*='countercheck.html']")
    private WebElement checkFrame;

    @FindBy(id = "rsList")
    private WebElement resultsList;

    // 获取列表所有的订单记录
    @FindBy(css = "#rsList tr")
    private List<WebElement> orderList;

    // 获取列表第一条订单元素
    @FindBy(css = "#rsList tr")
    private WebElement firstOrderInfo;

    @FindBy(className = "reCheck")
    private List<WebElement> checkElements;

    // 获取订单中基金代码
    @FindBy(xpath = "//*[@class='tabPop']//tr[1]/td[2]")
    private WebElement fundCodeText;

    @FindBy(xpath = "//*[@class='tabPop']//tr[2]/td[2]")
    private WebElement appAmtText;

    @FindBy(xpath = "//*[@class='tabPop']//tr[3]/td[2]")
    private WebElement bankAcctText;

    // 基金代码
    @FindBy(css = "input[name=fundCode]")
    private WebElement fundCodeInput;

    // 申购赎回业务输入金额、份额
    @FindBy(css = "input[name=appAmt]")
    private WebElement appAmtTextInput;

    // 输入银行卡尾号4号
    @FindBy(css = "input[name=bankAcct]")
    private WebElement bankAcctInput;

    // 审核通过
    @FindBy(className = "layui-layer-btn0")
    private WebElement approvedBtn;

    // 审核拒绝
    @FindBy(className = "layui-layer-btn1")
    private WebElement refuseBtn;


    private static final Log logger = LogFactory.getLog(TradeHomePage.class);

    public OrderCheckPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void openCheckPage(String url){
        driver.get(url);
        driver.manage().window().maximize();
        initPage();
    }

    public void initPage(){
        (wait.until(visibilityOf(tradeCheckMenu))).click();
        (wait.until(visibilityOf(counterCheckMenu))).click();
        checkFrame = wait.until(visibilityOf(checkFrame));
        driver.switchTo().frame(checkFrame);
    }


    public WebElement getFirstOrderInfo(){
        firstOrderInfo = wait.until(visibilityOf(firstOrderInfo));

        if (orderList.size()==1)
            try {
                throw new Exception();
            } catch (Exception e) {
                logger.error("暂无待审核记录");
            }
        return firstOrderInfo;
    }

    // 获取地址链接 operatorNo=
    public String getOperatorNo(WebElement element){
        String href = element.getAttribute("_href").split("operatorNo=")[1];
        return href;
    }

    // 获取所有待审核订单列表数量
    public int size(){
        return orderList.size();
    }

    // 获取首条订单子信息
    public List<WebElement> getOrderDetail(){
        return getFirstOrderInfo().findElements(By.cssSelector("td"));
    }

    // 获取订单操作员
    public String getOperator(){
        return getOrderDetail().get(7).getText();
    }

    // 点击复核按钮
    public void clickFirstCheck(){
        logger.info("点击复核操作按钮");
        getFirstOrderInfo().findElement(By.cssSelector("a")).click();
    }

    /**
    * 获取复核信息中基金代码(fundCode)、金额/份额(appAmt)、银行卡尾号4位(bankAcct);
    * */
    public Map<String, String> getReviewInfo(){

        String appAmt = TestUtils.matcher(appAmtText.getText(), "\\.|\\d");
        String bankAcct = TestUtils.matcher(bankAcctText.getText(), "\\d");

        Map<String, String> fund = new HashMap<>();
        fund.put("fundCode", fundCodeText.getText());
        fund.put("appAmt", appAmt);
        fund.put("bankAcct", bankAcct);
        logger.info("获取复核信息中基金代码、金额/份额、银行卡尾号4位：" + fund.toString());
        return fund;
    }

    public void checkOrder(){

        Map<String, String> reviewMap = getReviewInfo();
        TestUtils.sleep1s();
        fundCodeInput.sendKeys(reviewMap.get("fundCode"));
        TestUtils.sleep1s();
        appAmtTextInput.sendKeys(reviewMap.get("appAmt"));
        TestUtils.sleep1s();
        bankAcctInput.sendKeys(reviewMap.get("bankAcct"));
        TestUtils.sleep1s();
    }

    public void approvedByOrder(){
        checkOrder();
        approvedBtn.click();
    }

    public void refuseByOrder(){
        checkOrder();
        refuseBtn.click();
    }

}

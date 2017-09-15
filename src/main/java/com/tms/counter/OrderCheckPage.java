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

import java.util.List;


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

    @FindBy(xpath = "//a[text()='柜台交易复核']")
    private WebElement counterCheckMenu;

    @FindBy(how = How.CSS, using = "iframe[src$='countercheck.html']")
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

    // 获取订单详情
    @FindBy(css = ".tabPop")
    private WebElement reviewInfoTab;


    // 基金代码
    @FindBy(css = "input[name=fundCode]")
    private WebElement fundCodeText;

    // 申购赎回业务输入金额、份额
    @FindBy(css = "input[name=appAmt]")
    private WebElement appAmtText;

    // 输入银行卡尾号4号
    @FindBy(css = "input[name=bankAcct]")
    private WebElement bankAcctText;


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

    // 获取订单子元素信息
    public List<WebElement> getOrderDetail(){
        return getFirstOrderInfo().findElements(By.cssSelector("td"));
    }

    // 获取订单的操作员
    public String getOperator(){
        return getOrderDetail().get(7).getText();
    }

    // 点击复核按钮
    public void clickFirstCheck(){
        getFirstOrderInfo().findElement(By.cssSelector("a")).click();
    }

    /**
    * 获取复核信息中基金代码(fundCode)、金额/份额(appAmt)、银行卡尾号4位(bankAcct);
    * */
    public void getReviewInfo(){

        String fundCode = reviewInfoTab.findElement(By.xpath("//tr[1]/td[2]")).getText();
        String appAmt = reviewInfoTab.findElement(By.xpath("//tr[2]/td[2]")).getText();
        String bankAcct = reviewInfoTab.findElement(By.xpath("//tr[3]/td[2]")).getText();


    }
}

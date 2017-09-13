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
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;


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

    @FindBy(css = "#rsList tr")
    private List<WebElement> orderList;

    @FindBy(className = "reCheck")
    private List<WebElement> checkElements;

    @FindBy(css = ".tabPop tr")
    private List<WebElement> CheckInfoElement;

    private static final Log logger = LogFactory.getLog(TradeHomePage.class.getName());

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

    public WebElement getOrderElement(int i){
        return orderList.get(i);
    }

    public WebElement getOrderElement(){
        return orderList.get(0);
    }

    public List<WebElement> getOrderList(){
        if (orderList.size()==1)
            try {
                throw new Exception();
            } catch (Exception e) {
                logger.error("没有需要审核的订单");
            }
        return orderList;
    }

    public List<WebElement> getOrderDetail(int i){
        return getOrderElement(i).findElements(By.cssSelector("tr"));
    }

    public List<WebElement> getOrderDetail(){
        return getOrderElement(0).findElements(By.cssSelector("tr"));
    }


}

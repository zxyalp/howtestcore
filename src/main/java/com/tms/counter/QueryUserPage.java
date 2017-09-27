package com.tms.counter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by yang.zhou on 2017/9/11.
 */
public class QueryUserPage {

    private static final Log logger = LogFactory.getLog(QueryUserPage.class);

    private WebDriver driver;

    private Wait<WebDriver> wait;

    @FindBy(how = How.ID, using = "custNo")
    private WebElement custNoElement;

    @FindBy(id = "custName")
    private WebElement custNameElement;

    @FindBy(id="idNo")
    private WebElement idNoElement;

    @FindBy(linkText = "查询")
    private WebElement queryBtn;

    // 客户基本信息查询
    @FindBy(xpath = "//*[@id='custInfoId']/tr")
    private WebElement custInfo;

    // 客户预约信息
    @FindBy(xpath = "//*[@id='rsList']/tr[count(td)>2]")
    private WebElement appointmentInfo;



    public QueryUserPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    public void queryCustNo(String custNo){
        custNoElement.clear();
        custNoElement.sendKeys(custNo);
        queryBtn.click();
        isCustInfo();
    }

    private void isCustInfo(){
        try {
            wait.until(visibilityOf(custInfo));
        }catch (TimeoutException e){
            throw new RuntimeException("未查询到客户信息.");
        }
    }

    private void isAppointmentInfo(){
        try {
            wait.until(visibilityOf(custInfo));
        }catch (TimeoutException e){
            throw new RuntimeException("未查询到客户预约信息.");
        }
    }

}

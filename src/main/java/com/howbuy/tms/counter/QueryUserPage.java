package com.howbuy.tms.counter;

import com.howbuy.tms.TmsBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * @author yang.zhou
 * @date 2017/9/11
 */
public class QueryUserPage extends TmsBasePage {

    private final Logger logger = LoggerFactory.getLogger(QueryUserPage.class.getName());

    private WebDriver driver;

    private Wait<WebDriver> wait;

    /**
     * 客户号
     */
    @FindBy(id = "custNo")
    private WebElement custNoInput;

    /**
     * 身份证号码
     */
    @FindBy(id = "idNo")
    private WebElement idNoInput;

    /**
     * 查询按钮
     */
    @FindBy(id = "queryCustInfoBtn")
    private WebElement queryCustInfoBtn;

    /**
     * 客户信息列表
     */
    @FindBy(id = "custInfoId")
    private WebElement custInfo;

    /**
     *  客户列表单选按钮
     */
    @FindBy(css = "[name='checkCust']")
    private WebElement checkCustRdio;

    /**
     * 客户基本信息查询
     */
    @FindBy(xpath = "//*[@id='custInfoId']/tr")
    private WebElement custInfoId;

    /**
     * 客户预约信息
     */
    @FindBy(xpath = "//*[@id='rsList']/tr[count(td)>2]")
    private WebElement appointmentInfo;


    public QueryUserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void queryByCustNo(String custNo) {
        query(custNoInput, custNo);
    }

    public void queryByIdNo(String idNo) {
        query(idNoInput, idNo);
    }

    private void query(WebElement element, String cust) {
        element.clear();
        element.sendKeys(cust);
        queryCustInfoBtn.click();
        isCustInfo();
    }

    private void isCustInfo() {
        try {
            wait.until(visibilityOf(custInfo));
        } catch (TimeoutException e) {
            throw new RuntimeException("未查询到客户信息.");
        }
    }

    private void isAppointmentInfo() {
        try {
            wait.until(visibilityOf(custInfo));
        } catch (TimeoutException e) {
            throw new RuntimeException("未查询到客户预约信息.");
        }
    }

}

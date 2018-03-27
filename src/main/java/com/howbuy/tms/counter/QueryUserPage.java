package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import com.howbuy.tms.TmsBasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
public class QueryUserPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(QueryUserPage.class.getName());

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
     * 分销机构列表
     */
    @FindBy(id = "selectDisCode")
    private WebElement selectDisCode;

    /**
     * 查询按钮
     */
    @FindBy(id = "queryCustInfoBtn")
    private WebElement queryCustInfoBtn;

    /**
     * 客户信息列表
     */
    @FindBy(css = "#custInfoId > tr")
    private WebElement custInfoList;

    /**
     * 客户列表单选按钮
     */
    @FindBy(css = "#custInfoId [name='checkCust']")
    private List<WebElement> checkCustList;


    /**
     * 客户预约信息选择列表
     */
    @FindBy(css = "[name='appointmentInfoIndex']")
    private List<WebElement> appointmentInfoIndexs;


    public QueryUserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    public void queryCustInfo(String custNo, String idNo, String disCodeText) {

        if (StringUtils.isNotEmpty(custNo)) {
            queryByCustNo(custNo, disCodeText);
            return;
        }
        if (StringUtils.isNotEmpty(idNo)) {
            queryByIdNo(idNo, disCodeText);
            return;
        }
        throw new IllegalArgumentException("queryCustInfo参数为空.");
    }

    public void queryByCustNo(String custNo, String disCodeText) {
        query(custNoInput, custNo, disCodeText);
    }

    public void queryByIdNo(String idNo, String disCodeText) {
        query(idNoInput, idNo, disCodeText);
    }

    public void queryIdNoByDisCode(String idNo, String disCodeText) {
        query(idNoInput, idNo, disCodeText);
    }


    private void query(WebElement element, String cust, String disCodeText) throws NoSuchElementException, TimeoutException {
        logger.info("客户信息查询:" + cust);
        TestUtils.sleep1s();
        wait.until(visibilityOf(element));
        element.clear();
        element.sendKeys(cust);
        if (StringUtils.isNotEmpty(disCodeText)) {
            Select disCodeList = new Select(selectDisCode);
            disCodeList.selectByVisibleText(disCodeText);
        }
        TestUtils.sleep1s();
        queryCustInfoBtn.click();
        try {
            wait.until(visibilityOf(custInfoList));
        } catch (TimeoutException n) {
            throw new TimeoutException("未查询到客户：" + cust, n);
        }

        WebElement checkCust = checkCustList.get(0);
        TestUtils.scrollTo(driver, checkCust.getLocation().getY() - 50);
        int count = 0;
        while (!checkCust.isSelected()) {
            count++;
            checkCust.click();
            if (count > 3) {
                logger.info("超过点击次数，跳出循环." + count);
                break;
            }
            logger.info("循环点击次数：" + count);
            TestUtils.sleep1s();
        }
    }


    private void getAppointmentInfo(int index) {

        int size = appointmentInfoIndexs.size();

        if (size > 0 && index <= size) {
            WebElement appointmentInfoIndex = appointmentInfoIndexs.get(index - 1);
            TestUtils.scrollTo(driver, appointmentInfoIndex.getLocation().getY());
            TestUtils.sleep1s();
            appointmentInfoIndex.click();
            logger.info("客户总预约条数，使用第%s条预约.", index);
            return;
        }
        logger.error("未使用预约单，客户总预约条数：%s,待使用第%s的预约.", size, index);
    }

    private Boolean isUseAppointmentInfo(int index) {

        if (index >= 2) {
            return true;
        }
        return false;
    }
}

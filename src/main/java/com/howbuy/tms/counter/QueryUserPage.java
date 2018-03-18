package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import com.howbuy.tms.TmsBasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
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
     *  客户列表单选按钮
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


    public void queryByCustNo(String custNo, int index) {
        query(custNoInput, custNo, index);
    }

    public void queryByIdNo(String idNo, int index) {
        query(idNoInput, idNo, index);
    }


    private void query(WebElement element, String cust, int index) {
        try {
            element.clear();
            element.sendKeys(cust);
            TestUtils.sleep1s();
            queryCustInfoBtn.click();
            try {
                new WebDriverWait(driver,5).until(visibilityOf(custInfoList));
            }catch(NoSuchElementException n){
                throw new NoSuchElementException("未查询到客户："+cust);
            }

            WebElement checkCust = checkCustList.get(0);
            TestUtils.scrollTo(driver, checkCust.getLocation().getY());

            do {
                checkCust.click();
                TestUtils.sleep2s();
            }while (checkCust.isSelected());

            int size = appointmentInfoIndexs.size();

            if ( size > 0 && index <= size){
                WebElement appointmentInfoIndex = appointmentInfoIndexs.get(index-1);
                TestUtils.scrollTo(driver, appointmentInfoIndex.getLocation().getY());
                TestUtils.sleep1s();
                appointmentInfoIndex.click();
                logger.info("使用第"+index+"条预约.");
            }

            TestUtils.sleep2s();

        }catch (NoSuchElementException n){
            logger.error("未找到元素.",n);

        }catch (TimeoutException t){
            logger.error("查询超时.",t);
        }
    }


    private void getAppointmentInfo(int index){
        if (index < 2){
            return;
        }


    }

    private Boolean isUseAppointmentInfo(){
        return true;
    }
}

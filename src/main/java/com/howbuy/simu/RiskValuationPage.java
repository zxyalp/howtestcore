package com.howbuy.simu;

import com.howbuy.common.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**风险测评
 * Created by yang.zhou on 2017/10/18.
 */
public class RiskValuationPage extends BasePage {

    private static final Log logger = LogFactory.getLog(RiskValuationPage.class);

    // 查找所有单选框
    @FindBy(css = "input[name=q1]")
    private List<WebElement> answerRadios;

    // 模态框
    @FindBy(className = "dialogLoad")
    private WebElement dialog;

    // 风险测评页面选项
    @FindBy(xpath = "//ul/ul")
    private List<WebElement> riskViews;

    // submit
    @FindBy(linkText = "提交")
    private WebElement submitBtn;


    public RiskValuationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void riskAssess(){
        TestUtils.sleep2s();
        int[] result = new int[]{4,4,1,4,4,4,3,1,3,4,5,4,1,3,4,4,4,2};
        int i=0;
        for (WebElement element: riskViews){
            logger.info("开始做高端风险问卷："+riskViews.size());
            TestUtils.sleep1s();
            WebElement checkedRadio = element.findElements(By.cssSelector("input[name=q1]")).get(result[i]-1);
            checkedRadio.click();
            TestUtils.scrollTo(driver, checkedRadio.getLocation().getY());
            i++;
        }
        submitBtn.click();
    }

}

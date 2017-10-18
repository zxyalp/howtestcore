package com.howbuy.simu;

import com.howbuy.tms.counter.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;



/**风险测评
 * Created by yang.zhou on 2017/10/18.
 */
public class RiskeValuationPage extends BasePage {

    private static final Log logger = LogFactory.getLog(RiskeValuationPage.class);

    // 查找所有单选框
    @FindBy(css = "input[name=q1]")
    private List<WebElement> answerRadioList;

    // 模态框
    @FindBy(className = "dialogLoad")
    private WebElement dialog;


    public RiskeValuationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void getAnswerList(){
        TestUtils.sleep3s();
        System.out.println(answerRadioList.size());
        System.out.println(answerRadioList);
    }

    public void selectAnswer(){
        Map<String, Integer> answer = new HashMap<>(75);
        answer.put("q1",4);

    }

}

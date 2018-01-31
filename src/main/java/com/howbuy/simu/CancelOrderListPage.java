package com.howbuy.simu;

import com.howbuy.common.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * @author yang.zhou
 * @date 2018/1/31
 */
public class CancelOrderListPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(HighEndBuyPage.class.getName());

    private String cancelListPath = "/newpcsm/cancellist.html";

    /**
     * 模态框
     */
    @FindBy(className = "dialogLoad")
    private WebElement dialog;

    /**
     * 撤单
     */
    @FindBy(linkText = "撤单")
    private List<WebElement> cancelList;

    /**
     * 交易密码输入框
     */
    @FindBy(css = "input[type='password']")
    private WebElement txPasswordInput;

    @FindBy(linkText = "确认撤单")
    private WebElement submitBtn;

    /**
     * 撤单成功文本
     */
    @FindBy(xpath = "//p[contains(text(), '恭喜！您的撤单申请已经受理')]")
    private WebElement successText;


    public CancelOrderListPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    @Override
    public void open(){
        super.open(4085, cancelListPath);
    }


    public void cancelOrder(){
        open();
        try {
            wait.until(invisibilityOf(dialog));
            TestUtils.sleep2s();
            for (;cancelList.size() > 0;){
                addStyle(cancelList.get(0));
                cancelList.get(0).click();
                txPasswordInput = wait.until(visibilityOf(txPasswordInput));
                TestUtils.scrollTo(driver, txPasswordInput.getLocation().getY());
                addStyle(txPasswordInput);
                txPasswordInput.sendKeys("121212");
                addStyle(submitBtn);
                submitBtn.click();
                TestUtils.sleep1s();
                wait.until(visibilityOf(successText));
                open();
                wait.until(invisibilityOf(dialog));
                TestUtils.sleep2s();
            }

        }catch (Exception e){
            TestUtils.screenshort(driver, "撤单失败.");
            throw new RuntimeException(e);
        }
    }
}

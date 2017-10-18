package com.howbuy.simu;

import com.howbuy.tms.counter.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**私募合格投资者认定页面、风险测评页面
 * Created by yang.zhou on 2017/10/17.
 */
public class InvestorSignPage extends BasePage {

    public static final Log logger = LogFactory.getLog(InvestorSignPage.class);

    // 合格投资者认定
    @FindBy(xpath = "//*[contains(text(),'合格投资者认定')]")
    private List<WebElement> investorBook;

    // 合格投资者勾选
    @FindBy(css = "input[type=checkbox]")
    private List<WebElement> checkboxs;

    // 点击下一步按钮
    @FindBy(linkText = "下一步")
    private WebElement nextSetp;

    // 模态框
    @FindBy(className = "dialogLoad")
    private WebElement dialog;

    // 电子签名约定书
    @FindBy(xpath = "//*[contains(text(),'电子签名约定书')]")
    private List<WebElement> electronicSignBook;

    // 电子签名勾选框
    @FindBy(css = "input[type=checkbox]")
    private WebElement checkbox;

    public InvestorSignPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public Boolean isQualifiedInvestor(){
        return investorBook.size() > 0;
    }

    public Boolean isElectronicSignature(){
        return electronicSignBook.size() > 0;
    }

    public void checkInvestorBook(){
        logger.info("勾选合格投资者认定书.");
        for (WebElement element: checkboxs){
            if (!element.isSelected()){
                element.click();
            }
        }
        nextSetp.click();
    }

    public void checkSignatureBook(){
        logger.info("勾选电子签名约定书.");
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        nextSetp.click();
    }

    public void confirmOfInvestors(){
        reopen();
        wait.until(invisibilityOf(dialog));
        if (isQualifiedInvestor()){
            checkInvestorBook();
        }
        wait.until(invisibilityOf(dialog));
        TestUtils.scrollEnd(driver);
        if (isElectronicSignature()){
            checkSignatureBook();
        }

    }



}

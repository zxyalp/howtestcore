package com.howbuy.simu;

import com.howbuy.tms.counter.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**私募合格投资者认定页面、风险测评页面
 *
 * @author yang.zhou
 * @date 2017/10/17
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

    // 风险测评页面
    @FindBy(xpath = "//p[text()='风险评测']")
    private List<WebElement> riskValuationText;


    public InvestorSignPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }


    public Boolean isQualifiedInvestor(){
        return investorBook.size() > 0;
    }

    public Boolean isElectronicSignature(){
        return electronicSignBook.size() > 0;
    }

    public Boolean isRiskeValuation(){return riskValuationText.size() > 0; }

    public Boolean isQualifiedAndRisk(){return isQualifiedInvestor() || isElectronicSignature() || isRiskeValuation();}

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
        TestUtils.scrollTo(driver, nextSetp.getLocation().getY());
        nextSetp.click();
    }

    public void riskAssess(){
        logger.info("开始做风险测评");
        RiskValuationPage risk = PageFactory.initElements(driver, RiskValuationPage.class);
        risk.riskAssess();
    }

    public void confirmOfInvestors(){
        diglog();
        if (isQualifiedInvestor()){
            checkInvestorBook();
        }
        diglog();
        if (isElectronicSignature()){
            checkSignatureBook();
        }
        TestUtils.sleep1s();
        if (isRiskeValuation()){
            riskAssess();
        }
    }

    public void diglog(){
        try {
            wait.until(invisibilityOf(dialog));
        }catch (NoSuchElementException | TimeoutException n){
            logger.info(n);
        }
    }

}

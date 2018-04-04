package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import org.openqa.selenium.support.CacheLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * @author yang.zhou
 * @date 2017/9/11
 */
public class CounterHomePage extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(CounterHomePage.class.getName());

    private String counterPath = "/tms-counter-console/tmscounter/html/index.html";

    @FindBy(xpath = "//dt[contains(text(), '高端业务')]")
    private WebElement highMenu;

    @FindBy(xpath = "//dt[contains(text(), '交易下单')]")
    private WebElement tradeMenu;

    @FindBy(how = How.LINK_TEXT, using = "认申购")
    private WebElement buyMenu;

    @FindBy(how = How.LINK_TEXT, using = "赎回")
    private WebElement sellMenu;

    @FindBy(how = How.CSS, using = "iframe[src*='buy.html']")
    private WebElement buyFrame;

    @FindBy(how = How.CSS, using = "iframe[src*='sell.html']")
    private WebElement sellFrame;


    @FindBy(xpath = "//dt[contains(text(), '业务审核')]")
    private WebElement businessMenu;

    @FindBy(xpath = "//dt[contains(text(), '交易审核(高端)')]")
    private WebElement tradeCheckMenu;

    @FindBy(linkText = "柜台交易复核")
    private WebElement counterCheckMenu;

    @FindBy(how = How.CSS, using = "iframe[src*='countercheck.html']")
    private WebElement checkFrame;


    public CounterHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    public void openBuyPage(String operatorNo){
        openUp(operatorNo, buyFrame, highMenu, tradeMenu, buyMenu);
        logger.info("进入中台柜台认申购买界面.");
    }

    public void openCheckPage(String operatorNo){
        openUp(operatorNo, checkFrame,businessMenu, tradeCheckMenu, counterCheckMenu);
        logger.info("进入柜台交易复核界面.");
    }

    public void openUp(String operatorNo, WebElement frame, WebElement... menus){
        openPage(counterPath, operatorNo);
        for (WebElement menu:menus){
            (wait.until(visibilityOf(menu))).click();
        }
        driver.switchTo().frame(frame);
        TestUtils.sleep2s();
    }
}

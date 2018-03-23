package com.howbuy.tms.counter;

import com.howbuy.common.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    public CounterHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public void openBuyPage(String operatorNo){
        openPage(counterPath, operatorNo);
        (wait.until(visibilityOf(highMenu))).click();
        (wait.until(visibilityOf(tradeMenu))).click();
        (wait.until(visibilityOf(buyMenu))).click();
        driver.switchTo().frame(buyFrame);
        logger.info("进入中台柜台认申购买界面.");
    }


}

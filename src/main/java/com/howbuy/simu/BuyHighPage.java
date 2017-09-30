package com.howbuy.simu;

import com.howbuy.tms.counter.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * Created by yang.zhou on 2017/9/29.
 */
public class BuyHighPage {
    private static final Log logger = LogFactory.getLog(BuyHighPage.class);

    private WebDriver driver;
    private Wait<WebDriver> wait;

    // 基金代码查询
    @FindBy(id = "searchFund_")
    @CacheLookup
    private WebElement searchFundText;

    // 查询确定按钮
    @FindBy(id = "searchFundBtn_")
    @CacheLookup
    private WebElement searchFundBtn;

    // 暂无数据元素
    @FindBy(xpath = "//p[text()='暂无数据']")
    private WebElement noFund;

    // 基金购买按钮
    @FindBy(linkText = "购买")
    private WebElement buyBtn;

    // 基金购买按钮
    @FindBy(css = "a[href*='buyindex.html']")
    private WebElement  buyIndexBtn;

    public BuyHighPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void queryFund(String fundCode){
        wait.until(visibilityOf(searchFundText)).sendKeys(fundCode);
        TestUtils.sleep1s();
        searchFundBtn.click();
        clickBuyButton();
    }

    public void   clickBuyButton(){
        try {
            if (buyBtn.getAttribute("href").contains("buyindex.html"))
                buyBtn.click();
            throw new RuntimeException("该产品无法购买");
        } catch (NoSuchElementException n){
            throw  new RuntimeException("未查到产品.");
        }
    }



}

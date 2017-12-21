package com.howbuy.smwap;

import com.howbuy.common.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by yang.zhou on 2017/12/20.
 */
public class SeachFundPage extends BasePage{

    private static final Log logger = LogFactory.getLog(SeachFundPage.class);

    /**
     * 加载框
     */
    @FindBy(css = "#loading:empty")
    private WebElement loading;

    /**
     * 基金搜索框
     */
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    /**
     * 基金搜索按钮
     */
    @FindBy(css = "input[value='搜索']")
    private WebElement searchBtn;

    @FindBy(className = "buy_list")
    private List<WebElement> buyList;

    /**
     * 结果列表-购买按钮
     */
    @FindBy(css = "input[value='购买']")
    private WebElement buyBtn;

    /**
     * 结果列表-已售罄按钮
     */
    @FindBy(css = "input[value='已售罄']")
    private List<WebElement> floridianBtn;


    public SeachFundPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
    }

    public void seachFund(String fundCode){
        try {
            wait.until(visibilityOf(loading));
            wait.until(visibilityOf(searchInput)).sendKeys(fundCode);
            searchBtn.click();
            wait.until(visibilityOf(loading));
            if (buyList.isEmpty()){
                throw new RuntimeException("没有查到结果");
            }

            if (!buyBtn.isEnabled()){
                throw new RuntimeException("购买按钮不可用");
            }
            if (floridianBtn.size()>0){
                throw new RuntimeException("产品已售罄.");
            }
            buyBtn.click();
        }catch (TimeoutException e){
            throw new RuntimeException("查询产品超时》",e);
        }

    }

}

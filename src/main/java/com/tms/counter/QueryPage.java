package com.tms.counter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yang.zhou on 2017/9/11.
 */
public class QueryPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "custNo")
    private WebElement custNoElement;

    @FindBy(id = "custName")
    private WebElement custNameElement;

    @FindBy(id="idNo")
    private WebElement idNoElement;

    @FindBy(linkText = "查询")
    private WebElement queryBtn;

    public QueryPage(WebDriver driver){
        this.driver = driver;
    }

    public void queryCustNo(String custNo){
        custNoElement.clear();
        custNoElement.sendKeys(custNo);
        queryBtn.click();
    }

}

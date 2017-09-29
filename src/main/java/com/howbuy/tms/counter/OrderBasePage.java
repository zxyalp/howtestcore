package com.howbuy.tms.counter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public abstract class OrderBasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    // 基金代码
    @FindBy(id = "fundCode")
    protected WebElement fundCodeText;

    // 基金代码搜索按钮
    @FindBy(className = "searchIcon")
    protected WebElement searchIcon;

    // 申请时间
    @FindBy(id = "appTm")
    protected WebElement appTmText;

    // 确认提交
    @FindBy(id = "confimSellBtn")
    protected WebElement confimSellBtn;

    // 无预约确认
    @FindBy(css = ".layui-layer-btn0")
    protected WebElement okBtn;

    public OrderBasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

}

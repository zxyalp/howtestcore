package com.howbuy.simu;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

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

    // 确定按钮
    @FindBy(id = "searchFundBtn_")
    @CacheLookup
    private WebElement searchFundBtn;

    // 暂无数据元素
    @FindBy(xpath = "//p[text()='暂无数据']")
    private WebElement noFund;



}

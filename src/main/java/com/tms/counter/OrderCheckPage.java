package com.tms.counter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * Created by yang.zhou on 2017/9/12.
 */
public class OrderCheckPage {

    private WebDriver driver;

    private Wait<WebDriver> wait;

    @FindBy(id = "rsList")
    private WebElement resultsList;

    @FindBy(css = "#rsList tr")
    private List<WebElement> orderList;

    @FindBy(className = "reCheck")
    private List<WebElement> checkElements;

    @FindBy(css = ".tabPop tr")
    private List<WebElement> CheckInfoElement;

    public OrderCheckPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement getOrderElement(int i){
        return orderList.get(i);
    }

    public WebElement getOrderElement(){
        return orderList.get(0);
    }

    public List<WebElement> getOrderList(){
        return orderList;
    }



    public List<WebElement> getOrderDetail(){
        return getOrderElement().findElements(By.cssSelector("tr"));
    }



}

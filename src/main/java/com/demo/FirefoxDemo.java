package com.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by yang.zhou on 2017/6/2.
 */
public class FirefoxDemo {
    public static void main(String[] args) {

//        System.setProperty("webdriver.firefox.marionette", "D:\\selenium\\gecko\\geckodriver.exe");
//        System.setProperty("webdriver.gecko.driver", "D:\\selenium\\gecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.baidu.com/");

        WebElement loginBtn = driver.findElement(By.name("tj_login"));
        loginBtn.click();
    }
}

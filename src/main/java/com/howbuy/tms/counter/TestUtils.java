package com.howbuy.tms.counter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by summe on 2017/5/29.
 */
public class TestUtils {

    public static void sleep1s(){
        sleep3s(1000);
    }
    public static void sleep2s(){
        sleep3s(2000);
    }
    public static void sleep3s(){
        sleep3s(3000);
    }

    public static void sleep3s(long s){
        try {
            Thread.sleep(s);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void scrollTo(WebDriver driver, int ypos){
        scrollTo(driver, 0, ypos);
    }

    public static void scrollTo(WebDriver driver, int xpos, int ypos){
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(%s, %s)", xpos, ypos));
    }


    public static String matcher(String input, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()){
            builder.append(matcher.group());
        }
        return builder.toString();
    }

}

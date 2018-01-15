package com.howbuy.smwap;

import com.howbuy.base.AbstractBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;


/**
 * base page
 * @author yang.zhou
 * @date 2017/12/20
 */
public abstract class BasePage extends AbstractBasePage{


    private static final Logger logger = Logger.getLogger(BasePage.class);

    public int timeOutInSeconds = 10;


    @Override
    public void get(String url){
        get(url,new Dimension(620,725));
    }

}

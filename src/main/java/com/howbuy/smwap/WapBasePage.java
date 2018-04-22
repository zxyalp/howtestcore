package com.howbuy.smwap;

import com.howbuy.base.AbstractBasePage;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * base page
 *
 * @author yang.zhou
 * @date 2017/12/20
 */
public abstract class WapBasePage extends AbstractBasePage {


    private final Logger logger = LoggerFactory.getLogger(WapBasePage.class);

    public int timeOutInSeconds = 10;


    @Override
    public void get(String url) {
        get(url, new Dimension(620, 725));
    }

}

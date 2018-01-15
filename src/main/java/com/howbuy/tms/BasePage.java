package com.howbuy.tms;

import com.howbuy.base.AbstractBasePage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * base page
 * @author yang.zhou
 * @date 2017/12/20
 */
public abstract class BasePage extends AbstractBasePage {


    private static final Log logger = LogFactory.getLog(BasePage.class);

    public int timeOutInSeconds = 7;

}

package com.howbuy.tms;

import com.howbuy.base.AbsBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * base page
 *
 * @author yang.zhou
 * @date 2017/12/20
 */
public abstract class TmsBasePage extends AbsBasePage {


    private final Logger logger = LoggerFactory.getLogger(TmsBasePage.class);

    public int timeOutInSeconds = 7;

}

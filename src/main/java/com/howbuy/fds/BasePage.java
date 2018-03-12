package com.howbuy.fds;

import com.howbuy.base.AbstractBasePage;
import com.howbuy.common.TestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yang.zhou
 * @date 2018/3/9
 */
public class BasePage extends AbstractBasePage{

    private final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public void open(String path){
        super.open(TestContext.TP_HOST, TestContext.FDS_CONSOLE_PORT, path);
    }
}

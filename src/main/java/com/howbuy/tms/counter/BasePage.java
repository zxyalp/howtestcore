package com.howbuy.tms.counter;

import com.howbuy.base.AbsBasePage;
import com.howbuy.common.TestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yang.zhou
 * @date 2018/3/14
 */
public class BasePage extends AbsBasePage {

    private final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public void open(String path){
        super.open(TestContext.TMS_HOST, TestContext.TMS_COUNTER_PORT, path);
    }
}

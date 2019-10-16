package com.howbuy.tms.counter;

import com.howbuy.base.AbstractBasePage;
import com.howbuy.common.TestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yang.zhou
 * @date 2018/3/14
 */
public class CounterBasePage extends AbstractBasePage {

    private final Logger logger = LoggerFactory.getLogger(CounterBasePage.class);

    public int timeOutInSeconds = 5;

    public void open(String path, String query) {
        super.open(TestContext.TMS_HOST, TestContext.TMS_COUNTER_PORT, path, query);
    }

    public void openPage(String path, String operatorNo) {
        String operatorQuery = "operatorNo=" + operatorNo;
        open(path, operatorQuery);
    }
}

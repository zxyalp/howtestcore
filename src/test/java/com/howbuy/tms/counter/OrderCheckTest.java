package com.howbuy.tms.counter;

import com.howbuy.tms.BaseTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class OrderCheckTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(OrderCheckTest.class);

    @Test
    public void checkOrderTest() throws Exception {
        OrderCheckPage checkPage = PageFactory.initElements(driver, OrderCheckPage.class);
        checkPage.check();
    }
}

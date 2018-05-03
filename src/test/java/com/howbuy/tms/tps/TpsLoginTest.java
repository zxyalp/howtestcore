package com.howbuy.tms.tps;

import com.howbuy.fds.LoginFdsPage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by yang.zhou on 2017/9/29.
 */
public class TpsLoginTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(TpsLoginTest.class);


    @Test(enabled = true)
    public void loginTest() throws Exception {
        LoginFdsPage login = PageFactory.initElements(driver, LoginFdsPage.class);
        login.login("s001", "1");
    }

}

package com.howbuy.tms.tps;

import com.howbuy.fds.LoginFdsPage;
import com.howbuy.fds.PayCheckPage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class PayCheckTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(TpsLoginTest.class);


    @Test(enabled = true)
    public void loginTest() throws Exception {
        LoginFdsPage login = PageFactory.initElements(driver, LoginFdsPage.class);
        login.login("s001", "1");

        PayCheckPage payCheck = PageFactory.initElements(driver, PayCheckPage.class);
        payCheck.select();
    }

}

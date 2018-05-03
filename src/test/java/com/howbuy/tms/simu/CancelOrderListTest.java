package com.howbuy.tms.simu;

import com.howbuy.simu.CancelOrderListPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author yang.zhou
 * @date 2018/1/31
 */
public class CancelOrderListTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuySimuFundTest05.class);


    /**
     * 取消订单
     *
     * @throws Exception
     */
    @Test(enabled = true)
    public void cancelOderTest() throws Exception {
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.login("32010119980101286X", "qq1111");
        CancelOrderListPage orderListPage = PageFactory.initElements(driver, CancelOrderListPage.class);
        orderListPage.cancelOrder();
    }
}

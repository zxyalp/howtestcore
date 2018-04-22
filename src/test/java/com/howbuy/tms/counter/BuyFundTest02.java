package com.howbuy.tms.counter;


import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


/**
 * Created by yang.zhou on 2017/9/11.
 */
public class BuyFundTest02 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuyFundTest02.class);

    @Test(enabled = true)
    public void buyFundTest() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320497513643114", "机构", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320497513643114", "机构", "246020", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void buyFundTest02() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101199701016775", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101199701016775", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101199701016775", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101199701016775", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101199701016775", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101199701016775", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101199701016775", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101199701016775", "246020", randomMillAmount(1, 3));
    }


    @Test(enabled = true)
    public void buyFundTest03() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101198401016971", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401016971", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401016971", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401016971", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401016971", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401016971", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401016971", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401016971", "246020", randomMillAmount(1, 3));
    }
}

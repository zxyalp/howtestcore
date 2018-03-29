package com.howbuy.tms.counter;


import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


/**
 * Created by yang.zhou on 2017/9/11.
 */
public class BuyFundTest01 extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(BuyFundTest01.class);

    @Test(enabled = false)
    public void buyFundTest() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101198901012459", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198901012459", "246010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198901012459", "246020", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198901012459", "246020", randomMillAmount(1, 3));
    }

    @Test(enabled = false)
    public void buyFundTest01() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101198801013446", "028050", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198801013446", "028051", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198801013446", "060330", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198801013446", "060628", randomMillAmount(1, 3));
    }

    @Test(enabled = false)
    public void buyFundTest02() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101197301014966", "275052", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197301014966", "275052", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197301014966", "275807", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197301014966", "275807", randomMillAmount(1, 3));
    }

    @Test(enabled = false)
    public void buyFundTest03() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("32010119790101170X", "371021", randomMillAmount(1, 3));
        buyPage.buyByIdNo("32010119790101170X", "371021", randomMillAmount(1, 3));
        buyPage.buyByIdNo("32010119790101170X", "S33873", randomMillAmount(1, 3));
        buyPage.buyByIdNo("32010119790101170X", "S37842", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void buyFundTest04() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101198401019216", "S33873", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401019216", "S33873", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401019216", "S38010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401019216", "S38010", randomMillAmount(1, 3));
    }

    @Test(enabled = false)
    public void buyFundTest05() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101197601014677", "S37842", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601014677", "S37842", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601014677", "P12596", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601014677", "P12596", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void buyFundTest06() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101198701012817", "S21582", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012817", "S21582", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012817", "S21582", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012817", "S38010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012817", "246010", randomMillAmount(1, 3));

    }

    @Test(enabled = false)
    public void buyFundTest07() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101198701012956", "S29837", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012956", "S29837", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601016066", "S29396", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601016066", "S29396", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601016066", "246020", randomMillAmount(1, 3));

    }

}

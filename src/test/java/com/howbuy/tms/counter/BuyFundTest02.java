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
        buyPage.buyByIdNo("320101198401019216", "S33873", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401019216", "S33873", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401019216", "S38010", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198401019216", "S38010", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void buyFundTest01() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101197601014677", "S37842", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601014677", "S37842", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601014677", "P12596", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601014677", "P12596", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void buyFundTest02() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101198701012817", "S21582", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012817", "S21582", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012817", "S21582", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012817", "S38010", randomMillAmount(1, 3));
    }

    @Test(enabled = true)
    public void buyFundTest03() throws Exception {
        BuyPage buyPage = PageFactory.initElements(driver, BuyPage.class);
        buyPage.buyByIdNo("320101198701012956", "S29837", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101198701012956", "S29837", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601016066", "S29396", randomMillAmount(1, 3));
        buyPage.buyByIdNo("320101197601016066", "S29396", randomMillAmount(1, 3));
    }

}

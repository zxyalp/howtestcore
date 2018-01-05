package com.howbuy.tms.simu;

import com.howbuy.simu.HighEndBuyPage;
import com.howbuy.simu.LoginWebPage;
import com.howbuy.tms.BaseTestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/** 非预约申购产品
 * Created by yang.zhou on 2017/11/6.
 */
public class BuySimuFundTest05 extends BaseTestCase{

    private static final Log logger = LogFactory.getLog(BuySimuFundTest05.class);
    

    /**
     * 非预约申购+单张银行卡代扣下单，银行卡限额300万
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser03() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("330100197301013387", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 单卡代扣
        highEndBuyPage.buyHighFund("P09553", randomMillAmount(1,3));
        highEndBuyPage.buyHighFund("P11601", randomMillAmount(1,3));
        highEndBuyPage.buyHighFund("P12596", randomMillAmount(1,3));
        highEndBuyPage.buyHighFund("P24761", randomMillAmount(1,3));
    }


    /**
     * 非预约申购+单张银行卡自划款下单
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser04() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("330100198701013102", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 自划款下单
        highEndBuyPage.buyBankLinePay("P09553", randomMillAmount(1,3));
        highEndBuyPage.buyBankLinePay("P11601", randomMillAmount(1,3));
        highEndBuyPage.buyBankLinePay("P12596", randomMillAmount(1,3));
        highEndBuyPage.buyBankLinePay("P24761", randomMillAmount(1,3));
    }



    /**
     * 非预约申购+多卡银行卡代扣下单
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser05() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("330100199601013265", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 卡1代扣
        highEndBuyPage.buyHighFund("P09553", randomMillAmount(1,3));
        highEndBuyPage.buyHighFund("P11601", randomMillAmount(1,3));
        highEndBuyPage.buyHighFund("P12596", randomMillAmount(1,3));
        highEndBuyPage.buyHighFund("P24761", randomMillAmount(1,3));

        // 卡2代扣
        highEndBuyPage.buyHighFund("P09553", randomMillAmount(1,3),2);
        highEndBuyPage.buyHighFund("P11601", randomMillAmount(1,3),2);
        highEndBuyPage.buyHighFund("P12596", randomMillAmount(1,3),2);
        highEndBuyPage.buyHighFund("P24761", randomMillAmount(1,3),2);
    }


    /**
     * 非预约申购+多卡银行卡自划款下单
     * @throws Exception
     */
    @Test(enabled = true)
    public void loginSimuUser06() throws Exception{
        LoginWebPage login = PageFactory.initElements(driver, LoginWebPage.class);
        login.get(simuUrl);
        login.login("33010019770101213X", "qq1111");
        HighEndBuyPage highEndBuyPage = PageFactory.initElements(driver, HighEndBuyPage.class);

        // 卡1代扣
        highEndBuyPage.buyBankLinePay("P09553", randomMillAmount(1,3));
        highEndBuyPage.buyBankLinePay("P11601", randomMillAmount(1,3));
        highEndBuyPage.buyBankLinePay("P12596", randomMillAmount(1,3));
        highEndBuyPage.buyBankLinePay("P24761", randomMillAmount(1,3));

        // 卡2代扣
        highEndBuyPage.buyBankLinePay("P09553", randomMillAmount(1,3),2);
        highEndBuyPage.buyBankLinePay("P11601", randomMillAmount(1,3),2);
        highEndBuyPage.buyBankLinePay("P12596", randomMillAmount(1,3),2);
        highEndBuyPage.buyBankLinePay("P24761", randomMillAmount(1,3),2);
    }

    

}

package com.howbuy.tms.simu;

import com.howbuy.simu.LoginWebPageSimu;
import com.howbuy.simu.PiggyBankPageSimu;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 储蓄罐测试
 * Created by yang.zhou on 2017/11/9.
 */
public class PiggyBankTest extends BaseTestCase {

    private final Logger logger = LoggerFactory.getLogger(PiggyBankTest.class);


    @Test
    public void piggyDepositTest() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101198801018159", "qq1111");

        PiggyBankPageSimu bankPage = PageFactory.initElements(driver, PiggyBankPageSimu.class);
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
    }

    @Test
    public void piggyDepositTest01() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101199501012550", "qq1111");

        PiggyBankPageSimu bankPage = PageFactory.initElements(driver, PiggyBankPageSimu.class);
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");

    }

    @Test
    public void piggyDepositTest02() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101197901013684", "qq1111");

        PiggyBankPageSimu bankPage = PageFactory.initElements(driver, PiggyBankPageSimu.class);
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
    }

    @Test
    public void piggyDepositTest03() throws Exception {
        LoginWebPageSimu login = PageFactory.initElements(driver, LoginWebPageSimu.class);
        login.login("320101198901018228", "qq1111");

        PiggyBankPageSimu bankPage = PageFactory.initElements(driver, PiggyBankPageSimu.class);
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
        bankPage.savingBox("3000000");
    }
}

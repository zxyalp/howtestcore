package com.howbuy.tms.simu;

import com.howbuy.simu.RegisterUserPageSimu;
import com.howbuy.tms.BaseTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * @author yang.zhou
 * @date 2018/1/9
 */
public class RegisterUserTest extends BaseTestCase {

    @Test
    public void registerUserTest01() throws Exception {
        RegisterUserPageSimu userPage = PageFactory.initElements(driver, RegisterUserPageSimu.class);
        //userPage.createNewUser("35010119460101007X", "安七十一", "18217619891");
        userPage.createNewUser("35020119470101003X", "安七十", "18217871672");
        userPage.createNewUser("35040119920101007X", "安二十五", "18217871673");
        userPage.createNewUser("35050119990101005X", "安十八", "18217871674");
        userPage.createNewUser("35050120000101005X", "安十七", "18217871675");

    }
}

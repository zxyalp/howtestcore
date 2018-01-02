package com.howbuy.simu;

import com.howbuy.common.UrlParse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.howbuy.common.TestUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**交易网站登录
 * @author yang.zhou
 * Created by yang.zhou on 2017/9/29.
 */
public class LoginWebPage extends BasePage{

    private static final Log logger = LogFactory.getLog(LoginWebPage.class);

    /**
     * 交易账号
     */
    @FindBy(id = "idNo")
    @CacheLookup
    private WebElement idNoText;

    /**
     * 登录密码
     */
    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordText;

    /**
     * 登录按钮
     */
    @FindBy(css = "[value='登录']")
    @CacheLookup
    private WebElement loginBtn;

    /**
     * 免费开户
     */
    @FindBy(linkText = "免费开户")
    private WebElement registerLink;

    /**
     * 用户激活
     */
    @FindBy(linkText = "用户激活")
    private WebElement activateacctLink;


    public LoginWebPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public void login(String idNo, String password){
        TestUtils.sleep1s();
        idNoText = wait.until(visibilityOf(idNoText));
        idNoText.clear();
        idNoText.sendKeys(idNo);
        TestUtils.sleep1s();
        passwordText.clear();
        passwordText.sendKeys(password);
        passwordText.submit();
    }

}

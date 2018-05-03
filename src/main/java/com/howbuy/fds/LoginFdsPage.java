package com.howbuy.fds;

import com.howbuy.common.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yang.zhou
 * @date 2018/3/9
 */
public class LoginFdsPage extends FdsBasePage {

    private final Logger logger = LoggerFactory.getLogger(LoginFdsPage.class);

    private String fdsLoginPath = "/fds-console/login.do";

    /**
     * tp登录用户名
     */
    @FindBy(id = "j_username")
    private WebElement userNameInput;

    @FindBy(id = "j_password")
    private WebElement passwordInput;

    @FindBy(css = "input[name='Submit']")
    private WebElement submitBtn;

    public LoginFdsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @Override
    public void open() {
        super.open(fdsLoginPath);
    }


    public void login(String userName, String password) {
        open();
        userNameInput = wait.until(ExpectedConditions.visibilityOf(userNameInput));
        addStyle(userNameInput);
        userNameInput.sendKeys(userName);
        TestUtils.sleep1s();
        addStyle(passwordInput);
        passwordInput.sendKeys(password);
        TestUtils.sleep1s();
        addStyle(submitBtn);
        submitBtn.click();
    }
}

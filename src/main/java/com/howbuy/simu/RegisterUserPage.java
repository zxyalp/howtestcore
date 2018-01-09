package com.howbuy.simu;

import com.howbuy.common.TestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * @author yang.zhou
 * @date 2018/1/9
 */
public class RegisterUserPage extends BasePage {

    private static final Log logger = LogFactory.getLog(RegisterUserPage.class);


    /**
     * 身份证号码
     * */
    @FindBy(id = "certNo")
    private WebElement certNoInput;

    /**
     * 真实姓名
     */
    @FindBy(id = "custName")
    private WebElement custNameInput;

    /**
     * 联系地址
     */
    @FindBy(id = "address")
    private WebElement addressInput;

    /**
     * 手机号码
     */
    @FindBy(id = "mobile")
    private WebElement mobileInput;

    /**
     * 短信验证码
     */
    @FindBy(id = "phoneidentify")
    private WebElement identifyInput;

    /**
     * 获取短信验证码
     */
    @FindBy(css = "input[value='获取验证码']")
    private WebElement identifyBtn;

    /**
     * 验证码输入框
     */
    @FindBy(css = "#idPop_getcode input")
    private WebElement codeInput;


    /**
     * 确认
     */
    @FindBy(css = "#idPop_getcode a[onclick*='verifyCaptcha']")
    private WebElement verifyBtn;


    /**
     * 验证码图片
     */
    @FindBy(id = "checkCodeImg")
    private WebElement checkCodeImg;

    /**
     * 登录密码
     */
    @FindBy(id = "loginPwd")
    private WebElement loginPwdInput;

    /**
     * 确认登录密码
     */
    @FindBy(id = "reLoginPwd")
    private WebElement reLoginPwdInput;

    /**
     * 交易密码
     */
    @FindBy(id = "txPwd")
    private WebElement txPwdInput;

    /**
     * 确认交易密码
     */
    @FindBy(id = "reTxPwd")
    private WebElement reTxPwdInput;

    /**
     * 确认提交
     */
    @FindBy(id = "submitBn")
    private WebElement submitBn;


    public RegisterUserPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
    }


    public void getRegister(String url) {
        super.openRegisterPage(url);
    }


    public void createUser(String certNo, String custName, String address, String mobile, String identify){
        certNoInput.sendKeys(certNo);
        custNameInput.sendKeys(custName);
        addressInput.sendKeys(address);
        mobileInput.sendKeys(mobile);
        identifyInput.sendKeys(identify);
        TestUtils.sleep1s();
        identifyBtn.click();
        TestUtils.sleep1s();
    }


    public String getCodeImg(String url){

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try{

            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/60.0.3112.113 Safari/537.36");

            CloseableHttpResponse response1 = httpClient.execute(httpGet);

            HttpEntity entity = response1.getEntity();

            String content = EntityUtils.toString(entity, "utf-8");

            System.out.println(httpGet.getURI());
            System.out.println(content);

        } catch (ClientProtocolException c){
            c.fillInStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


}

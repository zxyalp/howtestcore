package com.howbuy.fds;

import com.howbuy.common.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/3/9
 */
public class PayCheckPage extends FdsBasePage {

    private final Logger logger = LoggerFactory.getLogger(PayCheckPage.class);

    private String cpPath = "/fds-console/manager/cp/index.do";

    @FindBy(linkText = "资金划付")
    private WebElement cpTablink;

    @FindBy(linkText = "支付机构对账")
    private WebElement payCheckLink;

    @FindBy(id = "checkBtn")
    private WebElement checkBtn;

    @FindBy(id = "pmtInstCode")
    private WebElement pmtInstSelect;


    public PayCheckPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }


    @Override
    public void open() {
        super.open(cpPath);
    }

    public void select() {

        open();

        TestUtils.sleep2s();

        System.out.println("位置：" + payCheckLink.getLocation().getY());

        TestUtils.scrollTo(driver, 200);

        checkBtn.click();

        Select pmtCode = new Select(pmtInstSelect);

        WebElement selected = pmtCode.getFirstSelectedOption();

        System.out.println("默认：" + selected.getText());

        List<WebElement> elements = pmtCode.getAllSelectedOptions();

        for (WebElement element : elements) {

            System.out.println(element.getText());
        }
    }

}

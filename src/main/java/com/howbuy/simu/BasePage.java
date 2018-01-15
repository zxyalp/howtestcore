package com.howbuy.simu;

import com.howbuy.base.AbstractBasePage;
import org.apache.log4j.Logger;

/**基础页面
 *
 * @author yang.zhou
 * @date 2017/9/29
 */
public class BasePage extends AbstractBasePage {

    private static final Logger logger = Logger.getLogger(BasePage.class.getName());

    public int timeOutInSeconds = 10;

}

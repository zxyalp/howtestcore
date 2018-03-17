package com.howbuy.simu;

import com.howbuy.base.AbsBasePage;
import com.howbuy.common.TestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 基础页面
 *
 * @author yang.zhou
 * @date 2017/9/29
 */
public class SimuBasePage extends AbsBasePage {

    private final Logger logger = LoggerFactory.getLogger(SimuBasePage.class.getName());

    public int timeOutInSeconds = 10;

    public void open(String path) {
        super.open(TestContext.TMS_HOST, TestContext.WEB_SIMU_PORT, path);
    }
}

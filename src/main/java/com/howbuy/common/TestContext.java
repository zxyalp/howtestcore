package com.howbuy.common;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 测试context
 *
 * @author yang.zhou
 * @date 2017/12/18
 */
public class TestContext {

    /**
     * 获取应用的端口
     */
    public static final int WEB_SIMU_PORT = PropertyUtils.getIntProperty("web.simu.port");
    public static final int WEB_TRADE_PORT = PropertyUtils.getIntProperty("web.trade.port");
    public static final int TMS_COUNTER_PORT = PropertyUtils.getIntProperty("tms.counter.port");
    public static final int TMS_CONSOLE_PORT = PropertyUtils.getIntProperty("tms.console.port");
    public static final int WAP_SIMU_PORT = PropertyUtils.getIntProperty("wap.simu.port");
    public static final int FDS_CONSOLE_PORT = PropertyUtils.getIntProperty("fds.console.port");
    private static final Logger logger = LoggerFactory.getLogger(TestContext.class.getName());
    public static String IMAGE_DIRECTORY = PropertyUtils.getProperty("user.dir");
    public static String IMAGE_TYPE = PropertyUtils.getProperty("image.type");
    public static String CHROME_DRIVER_PATH = PropertyUtils.getProperty("chrome.driver.path");
    /**
     * 获取服务器IP
     */
    public static String TMS_HOST = PropertyUtils.getProperty("tms.host");
    public static String TP_HOST = PropertyUtils.getProperty("tp.host");
    private static TestContext testContext = null;


    private TestContext() {

    }

    public static TestContext getInstance() {
        if (testContext == null) {
            synchronized (TestContext.class) {
                if (testContext == null) {
                    testContext = new TestContext();
                }
            }
        }
        return testContext;
    }


    public static File getImageFile(String fileName) {

        String dateFile = DateUtils.getNowDate();
        String nowTime = DateUtils.getNowTime();

        File imageDailyFile = new File(IMAGE_DIRECTORY, dateFile);
        System.out.println(imageDailyFile.toString());
        if (!imageDailyFile.exists()) {
            try {
                FileUtils.forceMkdirParent(imageDailyFile);
                logger.info("创建当前日期目录成功:" + dateFile);
            } catch (IOException e) {
                logger.error("在创建当前日期的目录时失败.", e);
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append(fileName).append("_").append(nowTime).append(".").append(IMAGE_TYPE);

        logger.info("截图的文件名称：" + builder.toString());

        return new File(imageDailyFile, builder.toString());
    }
}

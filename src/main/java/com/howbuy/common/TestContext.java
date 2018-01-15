package com.howbuy.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * 测试context
 * @author yang.zhou
 * @date 2017/12/18
 */
public class TestContext {

    private static final Logger logger = Logger.getLogger(TestContext.class.getName());

    private static TestContext testContext = null;

    public static String IMAGE_DIRECTORY = PropertyUtils.getProperty("user.dir");

    public static String IMAGE_TYPE = PropertyUtils.getProperty("image.type");

    public static String CHROME_DRIVER_PATH = PropertyUtils.getProperty("chrome.driver.path");

    private TestContext(){

    }

    public static TestContext getInstance(){
        if (testContext == null){
            synchronized (TestContext.class){
                if (testContext==null){
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
                logger.info("创建当前日期目录成功:"+dateFile);
            } catch (IOException e) {
                logger.error("在创建当前日期的目录时失败.", e);
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append(fileName).append("_").append(nowTime).append(".").append(IMAGE_TYPE);

        logger.info("截图的文件名称："+builder.toString());

        return new File(imageDailyFile, builder.toString());
    }
}

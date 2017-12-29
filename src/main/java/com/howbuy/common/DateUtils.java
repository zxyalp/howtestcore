package com.howbuy.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author yang.zhou
 * @date 2017/12/18
 */
public class DateUtils {

    private static final Log logger = LogFactory.getLog(DateUtils.class);

    private static DateUtils dateUtils;

    private DateUtils(){

    }

    public static DateUtils getInstance(){
        if (dateUtils == null){
            synchronized (DateUtils.class){
                if (dateUtils == null){
                    dateUtils = new DateUtils();
                }
            }
        }
        return dateUtils;
    }

    public static String getNowDate(){
        return getUserDate("yyyy-MM-dd");
    }

    public static String getNowTime(){
        return getUserDate("HHmmss");
    }

    public static String getUserDate(String format){
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(currentTime);
    }

}

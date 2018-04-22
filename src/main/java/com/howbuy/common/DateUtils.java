package com.howbuy.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author yang.zhou
 * @date 2017/12/18
 */
public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class.getName());

    private static DateUtils dateUtils = null;

    public static final String TIME_FORMAT_A = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_B = "yyyyMMddHHmmss";
    public static final String TIME_FORMAT_C = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String TIME_FORMAT_D = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String TIME_FORMAT_E = "yyyyMMddHHmmssSSS";
    public static final String TIME_FORMAT_F = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String TIME_FORMAT_G = "yyyyMMddHHmmssSSS";
    public static final String TIME_FORMAT = "HHmmss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TELCORDIA_DATE_FORMAT = "MM-dd-yyyy";
    public static final String YEAR_FORMAT = "yyyy";
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static final String MONTH_FORMAT_A = "yyyyMM";
    public static final String TIME_FORMAT_SYSTEM = "EEE MMM dd HH:mm:ss zzz yyyy";
    public static final String DATE_FORMAT_B = "yyMMdd";
    public static final String DATE_FORMAT_APM = "yyyy/MM/dd HH:mm a Z";
    public static final String DATE_FORMAT_A = "yyyy/MM/dd";


    private DateUtils() {

    }

    public static DateUtils getInstance() {
        if (dateUtils == null) {
            synchronized (DateUtils.class) {
                if (dateUtils == null) {
                    dateUtils = new DateUtils();
                }
            }
        }
        return dateUtils;
    }

    public static String getNowDate() {
        return getFormatDate(new Date(), DateUtils.DATE_FORMAT);
    }

    public static String getNowTime() {
        return getFormatDate(new Date(), DateUtils.TIME_FORMAT);
    }


    public static String getFormatDate(Date date, String format) {
        String dateStr = null;

        try {
            if (date != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                dateStr = dateFormat.format(date);
            }
        } catch (Exception e) {
            logger.error("", e);
        }

        return dateStr;
    }


    public static Date convertDate(String dateStr, String format) {
        Date date = new Date();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (ParseException p) {
            logger.error("", p);
        }
        return date;
    }


    public static Date convertDate(String dateStr) {

        if (StringUtils.trimToNull(dateStr) == null) {
            return null;
        }

        Date date = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtils.TIME_FORMAT_A);

        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException p) {
            dateFormat = new SimpleDateFormat(DateUtils.DATE_FORMAT);
            try {
                date = dateFormat.parse(dateStr);
            } catch (ParseException p1) {
                try {
                    date = new Date(Long.valueOf(dateStr));
                } catch (Exception e) {
                    logger.error("无法解析未日期格式：{}", dateStr);
                }
            }
        }
        return date;
    }

}

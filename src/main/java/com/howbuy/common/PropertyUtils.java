package com.howbuy.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 读取property文件工具类
 * @author summe
 * @date 2017/12/17
 */
public class PropertyUtils {

    private static final Log logger = LogFactory.getLog(PropertyUtils.class);

    private static Properties props;

    private PropertyUtils(){

    }

    static {
        load();
    }

    private synchronized static void load() {
        logger.info("properties loading....");
        props = new Properties();
        InputStream in = null;
        try {
            in = PropertyUtils.class.getClassLoader().getResourceAsStream("config.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("文件未找到.", e);
        } catch (IOException i) {
            logger.error(i);
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            logger.info("加载properties文件完成");
            logger.info("文件内容：" + props);
        }
    }

    public static String getProperty(String key, String dafaultValue) {
        if (props == null) {
            load();
        }

        return props.getProperty(key, dafaultValue);
    }

    public static String getProperty(String key) {
        if (props == null) {
            load();
        }
        return props.getProperty(key);
    }


    public static void getAllProperty(){
        if (props == null){
            load();
        }

        StringBuilder stringBuilder =  new StringBuilder("获取config.property文件全部信息.\n");

        Set<Map.Entry<Object, Object>> entries = props.entrySet();

        for (Map.Entry<Object, Object> entry: entries){
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
        }

        logger.info(stringBuilder.toString());
    }

}

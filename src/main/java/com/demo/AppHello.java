package com.demo;


import com.howbuy.common.DateUtils;

/**
 * @author yang.zhou
 * @date 2018/3/23
 */
public class AppHello {

    public static void main(String[] args) throws Exception {
//        URIBuilder builder = new URIBuilder();
//        builder.setHost("192.168.221.123");
//        builder.setPort(20380);
//        builder.setScheme("http");
//        builder.setPath("/tms-counter-console/tmscounter/html/index.html");
////        builder.setParameter("operatorNo","s002");
//        builder.setParameter("operatorNo","s001");
//        builder.setCustomQuery(null);
//        System.out.println(builder.build());

        System.out.println(DateUtils.getNowDate());
        System.out.println(DateUtils.getNowTime());


    }

}

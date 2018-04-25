package com.demo;


import com.howbuy.common.DateUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.demo.CustBuyBook;

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

//        System.out.println(DateUtils.getNowDate());
//        System.out.println(DateUtils.getNowTime());
//
//        CustInfo custInfo = new CustInfo("1100876751","320101199001017849","滕玥杰");
//
//        System.out.println(custInfo.getCustName());
//
//        Class<?> custInfoClass = custInfo.getClass();
//
//        Object object = custInfoClass.newInstance();
//
//        Field[] fields = custInfoClass.getDeclaredFields();
//        for (Field field:fields){
//            System.out.println(field);
//        }
//
//
//        Method[] methods = custInfoClass.getDeclaredMethods();
//        for (Method method:methods){
//            System.out.println(method);
//        }
//
//        Method method = custInfoClass.getMethod("getCustName");
//        Object obj =   method.invoke(object, new Object[]{});
//
//        System.out.println(obj);


        getClassTest();

    }


    public static void getClassTest() throws Exception{

        Class<CustInfo> cust = CustInfo.class;

        CustInfo object = cust.newInstance();

        Field[] fields = cust.getDeclaredFields();

        for (Field field:fields){
            System.out.println(field);
        }


        Method[] methods = cust.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method);
        }


        Method method = cust.getMethod("setCustName", String.class);
        method.invoke(object, "test001");
        Method method1 = cust.getMethod("setIdNo", String.class);
        method1.invoke(object, "628729827827027881");


        Field field = cust.getDeclaredField("custNo");
        field.setAccessible(true);
        field.set(object,"S38010");

        System.out.println(object);


    }
}

package com.demo.excelhelper;


import java.lang.reflect.Field;

/**
 * @author yang.zhou
 * @date 2018/4/26
 */
public class ExcelParser<T> {

    public static void main(String[] args) throws Exception{

        ExcelParser<CustInfo> cust = new ExcelParser<>();
        cust.parse(CustInfo.class);

    }


    public void parse(Class<T> c) throws Exception{

        T obj = c.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field:fields){

            if (field.isAnnotationPresent(ExcelFiled.class)){

                ExcelFiled excelFiled = field.getAnnotation(ExcelFiled.class);
                int index = excelFiled.index();

                System.out.println("index:"+index);

            }
        }

    }



}

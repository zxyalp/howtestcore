package com.whatapp;

import com.howbuy.common.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException
    {

//        PropertyUtils.getAllProperty();


        Date date = new Date();

        long times = date.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateString = dateFormat.format(date);

        System.out.println(dateString);

        System.out.println(times);

    }
}

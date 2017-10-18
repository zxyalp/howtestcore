package com.whatapp;

import java.net.MalformedURLException;
import java.net.URL;
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
        //http://192.168.221.216:15080/trade/login/login.htm?targeturl=http://192.168.221.216:4085/newpcsm/buylist.html
        URL u = new URL("http://192.168.221.216:15080/trade/login/login.htm");

        URL u1 = new URL("http", u.getHost(),4085,"/newpcsm/buylist.html");

        System.out.println(u.getHost());
        System.out.println(u.getPath());
        System.out.println(u1.toString());

    }
}

package com.whatapp;


import org.apache.http.HttpHost;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * test
 */
public class Demo {

    public static void main(String[] args) {
//        HttpHost host = new HttpHost("192.168.221.216");
//        System.out.println(host.toURI());

        URIBuilder builder = new URIBuilder();
        builder.setHost("192.168.221.216");
//        URI url=null;
//        try {
//            url = builder.build();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        System.out.println(builder.toString());
    }
}

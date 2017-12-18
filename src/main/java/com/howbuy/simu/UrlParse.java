package com.howbuy.simu;

import java.net.URL;

/**
 * Created by yang.zhou on 2017/10/18.
 */
public class UrlParse {

    private static UrlParse urlParse = null;

    private URL url;

    private UrlParse(){}

    public static UrlParse getInstance(){
        if (urlParse == null){
            urlParse =  new UrlParse();
        }
        return urlParse;
    }


    public void setUrl(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }
}

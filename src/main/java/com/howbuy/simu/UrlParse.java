package com.howbuy.simu;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Url parse
 * @author yang.zhou
 * @date 2017/10/18
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

    public URL urlSpec(int port, String path){
        try {
            if (url == null){
                throw new RuntimeException("未设置Host.");
            }
            return new URL("http", url.getHost(), port, path);
        }catch (MalformedURLException m){
            throw new RuntimeException(m);
        }
    }
}

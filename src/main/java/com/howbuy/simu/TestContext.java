package com.howbuy.simu;

import java.net.URL;

/**
 * Created by yang.zhou on 2017/10/18.
 */
public class TestContext {

    private static TestContext testContext = null;

    private URL url;

    private TestContext(){}

    public static TestContext getInstance(){
        if (testContext == null){
            testContext =  new TestContext();
        }
        return testContext;
    }


    public void setUrl(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }
}

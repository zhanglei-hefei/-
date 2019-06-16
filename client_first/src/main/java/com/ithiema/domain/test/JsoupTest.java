package com.ithiema.domain.test;

import org.jsoup.Jsoup;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class JsoupTest {

    @Test
    public void JsoupTest1() throws Exception {
        //解析URL地址
        Jsoup.parse(new URL("https://fe-api.zhaopin.com/c/i/sou"),1000)
    }
}

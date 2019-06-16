package com.ithiema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ithiema.domain.BigJob;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import sun.net.www.http.HttpClient;
//https://www.zhaopin.com/hefei/

//https://fe-api.zhaopin.com/c/i/sou?pageSize=90&cityId=664&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=java%E5%BC%80%E5%8F%91%E5%B7%A5%E7%A8%8B%E5%B8%88&kt=3&=0&_v=0.40183252&x-zp-page-request-id=fcffeff1fb884b1a8b679742c63d44fd-1560607717090-880946&x-zp-client-id=11db263c-bb8e-4e4c-9cf8-f6738ab11e74
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HttpGetA {
    @Test
    public void get() throws URISyntaxException {
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("https://fe-api.zhaopin.com/c/i/sou");

        uriBuilder.setParameter("pageSize","90").setParameter("cityId","664").setParameter("kw","java").setParameter("kt","3");
        //创建httpGet对象，设置URL地址
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        CloseableHttpResponse execute =null;
        try {
            //使用httpClient发送网址，获取响应对象
            execute=httpClient.execute(httpGet);
            //解析响应
            if (execute.getStatusLine().getStatusCode()==200){//判断响应码是否为200
                String responseHTML = EntityUtils.toString(execute.getEntity(), "utf-8");
                System.out.println(responseHTML);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                execute.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void PoolGet() throws URISyntaxException, IOException {
        //创建连接池
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(50);
        //获取连接
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        //创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("https://fe-api.zhaopin.com/c/i/sou");

        uriBuilder.setParameter("pageSize","90").setParameter("cityId","664").setParameter("kw","java").setParameter("kt","3");
        //设置请求参数
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) //设置连接时长
                .setConnectionRequestTimeout(500)
                .setSocketTimeout(10 * 1000).build();

        //创建httpGet对象，设置URL地址
        HttpGet httpGet = new HttpGet(uriBuilder.build());


        httpGet.setConfig(config);
        CloseableHttpResponse response = null;
        try {
            response=  httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode()==200){
                String responseHTML = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(responseHTML);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            response.close();
        }
    }

    @Test
    public void Json() throws URISyntaxException, IOException {
        //创建连接池
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(50);
        //获取连接
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        //创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("https://fe-api.zhaopin.com/c/i/sou");

        uriBuilder.setParameter("pageSize","90").setParameter("cityId","664").setParameter("kw","java").setParameter("kt","3");
        //设置请求参数
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) //设置连接时长
                .setConnectionRequestTimeout(500)
                .setSocketTimeout(10 * 1000).build();

        //创建httpGet对象，设置URL地址
        HttpGet httpGet = new HttpGet(uriBuilder.build());


        httpGet.setConfig(config);
        CloseableHttpResponse response = null;
        try {
            response=  httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode()==200){
                String responseHTML = EntityUtils.toString(response.getEntity(), "utf-8");
                ObjectMapper objectMapper = new ObjectMapper();
                BigJob bigJob = objectMapper.readValue(responseHTML, BigJob.class);
                System.out.println(bigJob);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            response.close();
        }
    }
}

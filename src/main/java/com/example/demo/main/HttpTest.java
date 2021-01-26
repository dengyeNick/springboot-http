package com.example.demo.main;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpTest {
    public static void main(String[] args){
        SkipHttpsUtil  skipHttpsUtil=new SkipHttpsUtil();
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            httpclient =  (CloseableHttpClient)skipHttpsUtil.wrapClient();
            HttpGet post = new HttpGet("https://www.chdtp.com.cn/staticPage/zhaobiaogg/2021/01/26/zhaobiaogg_2706674_12128.html");
            response = httpclient.execute(post);
            String result = EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

package com.example.demo.main;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpTest {
    public static void main(String[] args){
    	try {
//			get_HD_Http();
    		get_HN_Http();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void get_HD_Http() throws Exception {
    	SkipHttpsUtil  skipHttpsUtil=new SkipHttpsUtil();
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            httpclient =  (CloseableHttpClient)skipHttpsUtil.wrapClient();
            HttpGet get = new HttpGet("https://www.chdtp.com.cn/staticPage/zhaobiaogg/2021/01/26/zhaobiaogg_2706674_12128.html");
//            HttpGet get = new HttpGet("https://www.chdtp.com.cn/pages/wzglS/zbgg/zhaobiaoList.jsp?zbtype=1");
//            HttpGet get = new HttpGet("https://www.chdtp.com.cn/webs/queryWebZbgg.action");
            response = httpclient.execute(get);
            if (response.getStatusLine().getStatusCode()==200) {
            	String result = EntityUtils.toString(response.getEntity(),"UTF-8");
//                System.out.println(result);
			}else {
            	System.out.println("hd_失败");
				throw new Exception();
			}
            
        } catch (Exception e) {
            e.printStackTrace();
        	System.out.println("hd_失败");
            throw new Exception();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void get_HN_Http() throws Exception {
    	SkipHttpsUtil  skipHttpsUtil=new SkipHttpsUtil();
    	CloseableHttpClient httpclient = null;
    	CloseableHttpResponse response = null;
    	try {
    		httpclient =  (CloseableHttpClient)skipHttpsUtil.wrapClient();
            HttpGet get = new HttpGet("http://ec.chng.com.cn/ecmall/announcement/announcementDetail.do?announcementId=11766610");
    		response = httpclient.execute(get);
    		if (response.getStatusLine().getStatusCode()==200) {
    			String result = EntityUtils.toString(response.getEntity(),"UTF-8");
//    			System.out.println(result);
    		}else {
            	System.out.println("hn_失败");
    			throw new Exception();
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
        	System.out.println("hn_失败");
    		throw new Exception();
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

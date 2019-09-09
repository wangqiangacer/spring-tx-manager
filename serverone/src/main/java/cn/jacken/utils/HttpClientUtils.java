package cn.jacken.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 模拟http请求
 */
public class HttpClientUtils {
    public static void main(String[] args) {
         get("https://www.baidu.com");
    }
    public static void get(String url ) {
        //创建默认连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取状态行并获取状态码
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode==200){
            //响应成功
            HttpEntity entity = response.getEntity();
            String result = null;
            try {
                result = EntityUtils.toString(entity, "UTF-8");

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }

    public  static  void post(String url){
        //创建默认连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("username","lisi"));
        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            //获取状态行以及状态码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                HttpEntity entity = response.getEntity();
             String  result = EntityUtils.toString(entity, "UTF-8");
                System.out.println("result:"+result);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.sky.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@SpringBootTest
public class HttpClientTest {
    /**
     * 测试通过Httpclient发送get请求
     */
    @Test
    public void testGET() throws IOException {
//        创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
//        创建请求对象
        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

//        发送请求,接受响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);

//        获取服务端返回的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("服务端返回的状态码："+statusCode);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println("服务端返回的数据："+body);

//        关闭资源
        response.close();
        httpClient.close();
    }

    /**
     * 测试通过Httpclient发送post请求
     */
    @Test
    public void testPOST() throws IOException, JSONException {
//        创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

//        创建请求对象
        HttpPost httpPost = new HttpPost("http://localhost:8080/admin/employee/login");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","admin");
        jsonObject.put("password","123456");

        StringEntity entity=new StringEntity(jsonObject.toString());
//        指定编码
        entity.setContentEncoding("utf-8");
//        数据格式
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

//        发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

//        解析返回结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("响应码："+statusCode);

        HttpEntity entity1 = response.getEntity();
        String body = EntityUtils.toString(entity1);
        System.out.println("响应数据："+body);

//        关闭资源
        response.close();
        httpClient.close();
    }
}

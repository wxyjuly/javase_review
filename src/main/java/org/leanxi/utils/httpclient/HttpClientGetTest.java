/**
 * Project Name:javase_review
 * File Name:HttpClientGetTest.java
 * Package Name:org.leanxi.httpclient
 * Date:2017年11月16日上午10:44:05
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leanxi.utils.httpclient;

import java.io.IOException;
import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * ClassName:HttpClientGetTest <br/>
 * Date:     2017年11月16日 上午10:44:05 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class HttpClientGetTest {

	public static void main(String[] args) throws Exception {
		getTestWithoutParam() ;
		
		System.out.println("separate lines...") ;
		
		getTestWithParam() ;
	}

	public static void getTestWithoutParam() {
		//创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault() ;
		//创建http Get对象
		HttpGet httpGet = new HttpGet("http://www.baidu.com/") ;
		
		CloseableHttpResponse response = null ;
		try {
			//执行请求
			response = httpClient.execute(httpGet) ;
			//判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) { 
				String content = EntityUtils.toString(response.getEntity(),"UTF-8") ;
				System.out.println("内容长度为："+content.length());
				System.out.println("content:"+content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response!=null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getTestWithParam() throws Exception {
		//创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault() ;
		
		//定义请求参数
		URI uri = new URIBuilder("http://www.baidu.com/s").setParameter("wd", "java").build() ;
		System.out.println(uri);
		//创建http Get对象
		HttpGet httpGet = new HttpGet(uri) ;
		
		CloseableHttpResponse response = null ;
		try {
			//执行请求
			response = httpClient.execute(httpGet) ;
			//判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) { 
				String content = EntityUtils.toString(response.getEntity(),"UTF-8") ;
				System.out.println("内容长度为："+content.length());
				System.out.println("content:"+content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response!=null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}


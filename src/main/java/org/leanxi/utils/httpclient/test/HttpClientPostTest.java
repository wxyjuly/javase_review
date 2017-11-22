/**
 * Project Name:javase_review
 * File Name:HttpClientPostTest.java
 * Package Name:org.leanxi.httpclient
 * Date:2017年11月16日上午11:16:05
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leanxi.utils.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * ClassName:HttpClientPostTest <br/>
 * Date:     2017年11月16日 上午11:16:05 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class HttpClientPostTest {

	public static void main(String[] args) {
		testPostWithoutParam(); 

	}
	public static void testPostWithoutParam()   {
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault() ;
		//创建http Post请求
		HttpPost httpPost = new HttpPost("http://www.oschina.net/search") ;
		
		CloseableHttpResponse response = null ;
		
		try {
			//执行请求
			response = httpClient.execute(httpPost) ;
			if (response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(),"UTR-8") ;
				System.out.println("输出内容为："+content);
			}
		} catch (IOException e) {
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
	
	public static void testPostWithParam() throws Exception {
		
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault() ;
		//创建http Post请求
		HttpPost httpPost = new HttpPost("http://www.oschina.net/search") ;
		//设置2个Post参数，一个是scope,一个是q.
		List<NameValuePair> params = new ArrayList<NameValuePair>() ;
		params.add(new BasicNameValuePair("scope", "project")) ;
		params.add(new BasicNameValuePair("q", "java")) ;
		
		//构造一个form表单实体
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params) ;
		httpPost.setEntity(formEntity); 
		
		CloseableHttpResponse response = null ;
		
		try {
			//执行请求
			response = httpClient.execute(httpPost) ;
			if (response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(),"UTR-8") ;
				System.out.println("输出内容为："+content);
			}
		} catch (IOException e) {
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


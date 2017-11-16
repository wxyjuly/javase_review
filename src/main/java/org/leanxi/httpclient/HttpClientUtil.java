/**
 * Project Name:javase_review
 * File Name:HttpClientUtil.java
 * Package Name:org.leanxi.httpclient
 * Date:2017年11月16日上午11:43:14
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 * Tools 4 HttpClients
*/

package org.leanxi.httpclient;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * ClassName:HttpClientUtil <br/>
 * Date:     2017年11月16日 上午11:43:14 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class HttpClientUtil {
	
	private HttpClientUtil() {}
	
	public static String doGet(String url) {
		return doGet(url,null) ;
	}
	
	public static String doGet(String url,Map<String, String> params) {
		String resultStr = null ;
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault() ;
		CloseableHttpResponse response = null ;
		
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url) ;
			//构造请求参数
			if (params!=null) {
				for (String	key : params.keySet()) {
					builder.addParameter(key, params.get(key)) ;
				}
			}
			URI uri = builder.build() ;
			
			HttpGet httpGet = new HttpGet(uri) ;
			
			response = httpClient.execute(httpGet) ;
			if (response.getStatusLine().getStatusCode()==200) {
				resultStr = EntityUtils.toString(response.getEntity(), "UTF-8") ;
			}else {
				//print logs...
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(response!=null) {
				try {
					response.close();
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return resultStr ;
	}

	public static String doPost(String url) {
		return doPost(url,null) ;
	}
	
	public  static String doPost(String url, Map<String, String> params) {
		String retStr = null ;
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault() ;
		
		CloseableHttpResponse response = null ;
		try {
			//创建HttpPost对象
			HttpPost httpPost = new HttpPost(url) ;
			if (params!=null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>() ;
				for (String key : params.keySet()) {
					paramList.add(new BasicNameValuePair(key, params.get(key))) ;
				}
				//构造表单提交(带参数)
				UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramList) ;
				httpPost.setEntity(formEntity);
			}
			response = httpClient.execute(httpPost) ;
			if(response.getStatusLine().getStatusCode() == 200) {
				retStr = EntityUtils.toString(response.getEntity(), "UTF-8") ;
			} else {
				//print logs...
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(response!=null) {
				try {
					response.close() ;
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return retStr ;
	}

	public static void main(String[] args) {
	
	}

}


/**
 * Project Name:javase_review
 * File Name:JsoupParserTest.java
 * Package Name:org.leanxi.jsoup
 * Date:2017年11月16日下午4:04:37
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leanxi.utils.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.leanxi.utils.httpclient.HttpClientUtil;

/**
 * ClassName:JsoupParserTest <br/>
 * Date:     2017年11月16日 下午4:04:37 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 测试Jsoup解析文档
 */
public class JsoupParserTest {

	public static void main(String[] args) {
		String url = "http://www.baidu.com" ;
		String html = HttpClientUtil.doGet(url) ;
		
		Document document = Jsoup.parse(html) ;
	}	

}


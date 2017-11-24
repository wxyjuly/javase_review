/**
 * Project Name:javase_review
 * File Name:JacksonTest.java
 * Package Name:org.leanxi.utils.json.transformer.test
 * Date:2017年11月24日上午9:40:34
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leanxi.utils.json.transformer.test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.leanxi.utils.json.transformer.test.entity.AccountBean;
import org.leanxi.utils.json.transformer.test.entity.Birthday;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/**
 * ClassName:JacksonTest <br/>
 * Date:     2017年11月24日 上午9:40:34 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class JacksonTest {

	private JsonGenerator jsonGenerator ;
	private ObjectMapper objectMapper ;
	private AccountBean accountBean ;
	private Birthday birthday ;
	
	@Before
	public void init() {
		accountBean = new AccountBean() ;
		birthday = new Birthday("2016-05-03") ;
		accountBean.setAddress("Finland...");
		accountBean.setBirthday(birthday);
		accountBean.setEmail("cdxiyang@gmail.com");
		accountBean.setId(01);
		accountBean.setName("LeonXi");
		
		objectMapper = new ObjectMapper() ;
		
		try {
			jsonGenerator = objectMapper
					.getJsonFactory()
					.createJsonGenerator(System.out,JsonEncoding.UTF8) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@After
	public void destroy() {
		try {
			if(null != jsonGenerator) {
				jsonGenerator.close();
			}
			if (!jsonGenerator.isClosed()) {
				jsonGenerator.close();
			}
			jsonGenerator = null ;
			objectMapper = null ;
			accountBean = null ;
			System.gc();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	//transfer
	@Test
	public void writeEntity2Json() {
		try {
			System.out.println("-------use JsonGenerator...");
			jsonGenerator.writeObject(accountBean);
			System.out.println();
			
			System.out.println("-------use ObjectMapper...");
			objectMapper.writeValue(System.out, accountBean);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeMap2Json() {
		try {
			Map<String, Object> map = new HashMap<String, Object>() ;
			map.put("name", accountBean.getName()) ;
			map.put("account", accountBean) ;
			
			accountBean = new AccountBean() ;
			accountBean.setAddress("CD,SiChuan,China...");
			accountBean.setEmail("819365920@qq.com");
			map.put("account2", accountBean) ;
			System.out.println("-------transfer mapp 2 json,use ObjectMapper...");
			objectMapper.writeValue(System.out, map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeList2Json() {
		try {
			List<AccountBean> list = new ArrayList<AccountBean>() ; 
			list.add(accountBean) ;
			
			accountBean = new AccountBean() ;
			accountBean.setAddress("CD,SiChuan,China...");
			accountBean.setEmail("819365920@qq.com");
			accountBean.setId(002);
			list.add(accountBean) ;
			
			System.out.println("-------transfer list 2 json,use jsonGenerator...");
			jsonGenerator.writeObject(list);

			System.out.println("\n-------transfer list 2 json,use ObjectMapper...");
			objectMapper.writeValue(System.out, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeOthersJSON() {
	    try {
	        String[] arr = { "a", "b", "c" };
	        System.out.println("jsonGenerator");
	        String str = "hello world jackson!";
	        //byte
	        jsonGenerator.writeBinary(str.getBytes());
	        //boolean
	        jsonGenerator.writeBoolean(true);
	        //null
	        jsonGenerator.writeNull();
	        //float
	        jsonGenerator.writeNumber(2.2f);
	        //char
	        jsonGenerator.writeRaw("c");
	        //String
	        jsonGenerator.writeRaw(str, 5, 10);
	        //String
	        jsonGenerator.writeRawValue(str, 5, 5);
	        //String
	        jsonGenerator.writeString(str);
	        jsonGenerator.writeTree(JsonNodeFactory.instance.POJONode(str));
	        System.out.println();
	        
	        //Object
	        jsonGenerator.writeStartObject();//{
	        jsonGenerator.writeObjectFieldStart("user");//user:{
	        jsonGenerator.writeStringField("name", "jackson");//name:jackson
	        jsonGenerator.writeBooleanField("sex", true);//sex:true
	        jsonGenerator.writeNumberField("age", 22);//age:22
	        jsonGenerator.writeEndObject();//}
	        
	        jsonGenerator.writeArrayFieldStart("infos");//infos:[
	        jsonGenerator.writeNumber(22);//22
	        jsonGenerator.writeString("this is array");//this is array
	        jsonGenerator.writeEndArray();//]
	        
	        jsonGenerator.writeEndObject();//}
	        
	        
	        AccountBean bean = new AccountBean();
	        bean.setAddress("address");
	        bean.setEmail("email");
	        bean.setId(1);
	        bean.setName("haha");
	        //complex Object
	        jsonGenerator.writeStartObject();//{
	        jsonGenerator.writeObjectField("user", bean);//user:{bean}
	        jsonGenerator.writeObjectField("infos", arr);//infos:[array]
	        jsonGenerator.writeEndObject();//}
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	//revert
	@Test
	public void readJson2List() {
	    String json = "[{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"+
	                "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}]";
	    try {
	        List<LinkedHashMap<String, Object>> list = objectMapper.readValue(json, List.class);
	        System.out.println(list.size());
	        for (int i = 0; i < list.size(); i++) {
	            Map<String, Object> map = list.get(i);
	            Set<String> set = map.keySet();
	            for (Iterator<String> it = set.iterator();it.hasNext();) {
	                String key = it.next();
	                System.out.println(key + ":" + map.get(key));
	            }
	        }
	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void readJson2Array() {
	    String json = "[{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"+
	            "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}]";
	    try {
	        AccountBean[] arr = objectMapper.readValue(json, AccountBean[].class);
	        System.out.println(arr.length);
	        for (int i = 0; i < arr.length; i++) {
	            System.out.println(arr[i]);
	        }
	        
	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void readJson2Map() {
	    String json = "{\"success\":true,\"A\":{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"+
	                "\"B\":{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}}";
	    try {
	        Map<String, Map<String, Object>> maps = objectMapper.readValue(json, Map.class);
	        System.out.println(maps.size());
	        Set<String> key = maps.keySet();
	        Iterator<String> iter = key.iterator();
	        while (iter.hasNext()) {
	            String field = iter.next();
	            System.out.println(field + ":" + maps.get(field));
	        }
	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * <b>function:</b>java对象转换成xml文档
	 * 需要额外的jar包 stax2-api.jar
	 * @author leonXi
	 * @createDate 2010-11-23 下午06:11:21
	 */
	@Test
	public void writeObject2Xml() {
	    //stax2-api-3.0.2.jar
//	    System.out.println("XmlMapper");
//	    XmlMapper xml = new XmlMapper();
//	    try {
//	        //javaBean转换成xml
//	        //xml.writeValue(System.out, bean);
//	        StringWriter sw = new StringWriter();
//	        xml.writeValue(sw, accountBean);
//	        System.out.println(sw.toString());
//	        //List转换成xml
//	        List<AccountBean> list = new ArrayList<AccountBean>();
//	        list.add(accountBean);
//	        list.add(accountBean);
//	        System.out.println(xml.writeValueAsString(list));
//	        
//	        //Map转换xml文档
//	        Map<String, AccountBean> map = new HashMap<String, AccountBean>();
//	        map.put("A", accountBean);
//	        map.put("B", accountBean);
//	        System.out.println(xml.writeValueAsString(map));
//	    } catch (JsonGenerationException e) {
//	        e.printStackTrace();
//	    } catch (JsonMappingException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
	}
	
}


package org.leanxi.utils.solrj ;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * URL: http://192.168.19.140:8080/solr
 * ClassName: SolrJTest <br/>
 * date: 2017年12月14日 上午10:22:36 <br/>
 * @author Leon Xi
 * @version v1.0
 */
public class SolrJTest {
	public static final String SOLR_SERVER_IP = "http://192.168.19.141:8080/solr" ; //vmware 每次变更，IP会变

	@Test
	public void addDocument() throws Exception {
		//创建一连接
		SolrServer solrServer = new HttpSolrServer(SOLR_SERVER_IP);
		//创建一个文档对象
		for (int i = 0; i < 100; i++) {
			
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", "test00"+i);
			document.addField("item_title", "测试商品"+i);
			document.addField("item_price", 54321+i);
			document.addField("item_image", "item_image_"+i);
			
			//把文档对象写入索引库
			solrServer.add(document);
		}
		//提交
		solrServer.commit();
		
		System.out.println("----success---");
	}
	
	@Test
	public void deleteDocument() throws Exception {
		//创建一连接
		SolrServer solrServer = new HttpSolrServer(SOLR_SERVER_IP);
		
		// 按照id删除一行
		String id = "test001" ;
		solrServer.deleteById(id);
		
		//删除全部
//		solrServer.deleteByQuery("*:*");
		
		List<String> ids = new ArrayList<String>() ;
		ids.add("test001") ;
		ids.add("test002") ;
		ids.add("test003") ;
		solrServer.deleteById(ids) ; //ids列表删除指定集合
		
		solrServer.commit();
		System.out.println("----success---");
	}
	
	@Test
	public void queryDocument() throws Exception {
		SolrServer solrServer = new HttpSolrServer(SOLR_SERVER_IP);
		//创建一个查询对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery("*:*");
		query.setStart(0);
		query.setRows(50);
		
		//执行查询
		QueryResponse response = solrServer.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("共查询到记录：" + solrDocumentList.getNumFound());
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.print(solrDocument.get("id")+"\t");
			System.out.print(solrDocument.get("item_title")+"\t");
			System.out.print(solrDocument.get("item_price")+"\t");
			System.out.print(solrDocument.get("item_image")+"\n");
		}
		System.out.println("----success---");
	}
	
}

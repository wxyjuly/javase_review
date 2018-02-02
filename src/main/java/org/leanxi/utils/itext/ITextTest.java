package org.leanxi.utils.itext;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.SimpleBookmark;

/**
 * 打印电子书所有目录
 * ClassName: ITextTest <br/>
 * date: 2018年1月13日 上午8:50:41 <br/>
 * 
 * @author Leon Xi
 * @version v1.0
 */
public class ITextTest {
	private static int indentLevelCnt ; // 缩进层次
	private static final String INDENT_STR = "	" ; //缩进内容 
	private static StringBuilder indentStrBuilder ; //最终缩进内容
	
	/**
	 * 
	 * showBookmark:递归输出目录内容. <br/>
	 * @author Leon Xi
	 * @param bookmark
	 * @param level
	 */
	private static void showBookmark(Map<String, Object> bookmark, int level) {
		indentStrBuilder = new StringBuilder("") ;
		for (int i = 0; i < level; i++) {
			indentStrBuilder.append(INDENT_STR) ;			
		}
		System.out.println(indentStrBuilder.toString()+bookmark.get("Title"));
		level++ ;
		
		List<Object> kids = (List<Object>) bookmark.get("Kids");
		if (kids == null)
			return;
		for (Iterator i = kids.iterator(); i.hasNext();) {
			showBookmark((Map) i.next(), level);
		}
	}
	
	/**
	 * getPDFBookAllContents:打印PDF电子书目录. <br/>
	 * @author Leon Xi
	 * @throws IOException
	 */
	@Test
	public void getPDFBookAllContents() throws IOException {
//		String bookPath = "./src/main/resources/books/JVM.pdf" ;
		
		String relatePath=System.getProperty("user.dir"); 
		System.out.println(relatePath);
		 
//		System.exit(0); 
		String bookPath = relatePath + "/src/main/resources/books/JVM.pdf" ; 
		System.out.println(bookPath);
		PdfReader reader = new PdfReader(bookPath);
		List<HashMap<String, Object>> contentList = SimpleBookmark.getBookmark(reader);
		int cnt = 0;
		for (Iterator<HashMap<String, Object>> contentIter = contentList.iterator(); contentIter.hasNext();) {
			cnt++ ;
			if(cnt<=1) {
				contentIter.next() ;
				continue ; //跳过第一个节点[reading...]
			}
			indentLevelCnt = 0 ;
			showBookmark((Map<String, Object>) contentIter.next(), indentLevelCnt);
		}
	}

}
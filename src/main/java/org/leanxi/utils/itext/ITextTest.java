package org.leanxi.utils.itext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itextpdf.text.log.Level;
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
	private static int level = 0; 
	private static final String LEVEL_T = "  " ;
	private static StringBuilder levelSub ;
	
	private static void showBookmark(Map<String, Object> bookmark, int level) {
		levelSub = new StringBuilder("") ;
		for (int i = 0; i < level; i++) {
			levelSub.append(LEVEL_T) ;			
		}
		System.out.println(levelSub.toString()+bookmark.get("Title"));
		level++ ;
		
		List<Object> kids = (List<Object>) bookmark.get("Kids");
		if (kids == null)
			return;
		for (Iterator i = kids.iterator(); i.hasNext();) {
			showBookmark((Map) i.next(), level);
		}
	}
	
	@Test
	public void getPDFBookAllContents() throws IOException {
		String bookPath = "./src/main/resources/books/JVM.pdf" ;
		PdfReader reader = new PdfReader(bookPath);
		List<HashMap<String, Object>> list = SimpleBookmark.getBookmark(reader);
		for (Iterator<HashMap<String, Object>> i = list.iterator(); i.hasNext();) {
			level = 0 ;
			showBookmark((Map<String, Object>) i.next(), level);
		}
	}

}
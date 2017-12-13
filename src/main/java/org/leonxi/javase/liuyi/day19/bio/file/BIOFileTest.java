/**
 * Project Name:javase_review
 * File Name:BIOFileTest.java
 * Package Name:org.leonxi.javase.liuyi.day19.bio.file
 * Date:2017年12月2日下午1:54:53
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.liuyi.day19.bio.file;
/**
 * ClassName:BIOFileTest <br/>
 * Date:     2017年12月2日 下午1:54:53 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class BIOFileTest {

	/**
	 * 
	 * testFileConstructs:test constructions. <br/>

		File(String pathname) 
		File(String parent, String child) 
		File(File parent, String child) 
		File(URI uri) 

	 * @author Leon Xi
	 */
	@Test
	public void testFileConstructs() {
		String pathname = "" ;
		String pathParent = "";
		File fileParent = null ;
		String child = "" ;
		
		File file1 = new File(pathname) ;
		File file2 = new File(pathParent, child) ;
		File file3 = new File(fileParent, child) ;	
//		File file4 = new File(uri) ;
		System.out.println("out1:" + file1) ;
		System.out.println("out2:" + file2) ;
		System.out.println("out3:" + file3) ;
	}
	
	/**
	 * mkdir()
	 * mkdirs()
	 * createNewFile()
	 * @throws IOException 
	 */
	@Test
	public void testMkdir() throws IOException {
		String pathname1 = "dir/zhangsan.txt" ;
		String pathname2 = "dir/bbb/ccc" ;
		String filePath = "nihao.txt" ;
		
		File file1 = new File(pathname1) ;
		File file2 = new File(pathname2) ;
		File file3 = new File(filePath) ;
		System.out.println("file.mkdirs()--> " + file1.mkdir()) ;
		System.out.println("file.mkdirs()--> " + file2.mkdirs()) ;
		System.out.println("file.createFile()--> " + file3.createNewFile()) ;
	}
	
	/**
	 * 
	 * testDelete:(这里用一句话描述这个方法的作用). <br/>
	 * delete():
	 * deleteOnExit():
	 * 	 Requests that the file or directory denoted by this 
	 *   abstract pathname be deleted when the virtual machine terminates. 
	 * @author Leon Xi
	 */
	@Test
	public void testDelete() {
		String pathname1 = "dir/bbb" ;
		String pathname2 = "dir/bbb/ccc" ;
		File file1 = new File(pathname1) ;
		File file2 = new File(pathname2) ;
		
		System.out.println("file.delete()--> " + file1.delete()) ;
		file2.deleteOnExit() ;
	}
	
	@Test
	public void testRenameFileName() {
		String oldFileNamePath = "nihao.txt" ;
		String newFileName = "good.txt" ;
		
		String destNewFileName = "good.txt" ;
		
		File file1 = new File(oldFileNamePath) ;
		File destFile = new File(newFileName);
		
		System.out.println("renameTo:"+file1.renameTo(destFile)) ;
		
	}
	
}


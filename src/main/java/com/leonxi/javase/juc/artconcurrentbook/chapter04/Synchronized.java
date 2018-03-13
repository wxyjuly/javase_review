/**
 * Project Name:javase_review
 * File Name:Synchronized.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午9:52:33
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:Synchronized <br/>
 * Date:     2018年1月24日 上午9:52:33 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * 4-10
 * 
 */
public class Synchronized {
    public static void main(String[] args) {
        // 对Synchronized Class对象进行加锁
        synchronized (Synchronized.class) {
        }
        // 静态同步方法，对Synchronized Class对象进行加锁
        m();
    }

    public static synchronized void m() {
    }
}

/**
  * javap -v Synchronized.class

	Classfile /F:/GitHub_Repo/00_core_java/javase_review/target/classes/com/leonxi/javase/juc/artconcurrentbook/chapter04/Synchronized.class
	  Last modified 2018-3-7; size 556 bytes
	  MD5 checksum b14146739159d7663f1037684f430694
	  Compiled from "Synchronized.java"
	public class com.leonxi.javase.juc.artconcurrentbook.chapter04.Synchronized
	  minor version: 0
	  major version: 52
	  flags: ACC_PUBLIC, ACC_SUPER
	Constant pool:
	   #1 = Class              #2             // com/leonxi/javase/juc/artconcurrentbook/chapter04/Synchronized
	   #2 = Utf8               com/leonxi/javase/juc/artconcurrentbook/chapter04/Synchronized
	   #3 = Class              #4             // java/lang/Object
	   #4 = Utf8               java/lang/Object
	   #5 = Utf8               <init>
	   #6 = Utf8               ()V
	   #7 = Utf8               Code
	   #8 = Methodref          #3.#9          // java/lang/Object."<init>":()V
	   #9 = NameAndType        #5:#6          // "<init>":()V
	  #10 = Utf8               LineNumberTable
	  #11 = Utf8               LocalVariableTable
	  #12 = Utf8               this
	  #13 = Utf8               Lcom/leonxi/javase/juc/artconcurrentbook/chapter04/Synchronized;
	  #14 = Utf8               main
	  #15 = Utf8               ([Ljava/lang/String;)V
	  #16 = Methodref          #1.#17         // com/leonxi/javase/juc/artconcurrentbook/chapter04/Synchronized.m:()V
	  #17 = NameAndType        #18:#6         // m:()V
	  #18 = Utf8               m
	  #19 = Utf8               args
	  #20 = Utf8               [Ljava/lang/String;
	  #21 = Utf8               SourceFile
	  #22 = Utf8               Synchronized.java
	{
	  public com.leonxi.javase.juc.artconcurrentbook.chapter04.Synchronized();
	    descriptor: ()V
	    flags: ACC_PUBLIC
	    Code:
	      stack=1, locals=1, args_size=1
	         0: aload_0
	         1: invokespecial #8                  // Method java/lang/Object."<init>":()V
	         4: return
	      LineNumberTable:
	        line 21: 0
	      LocalVariableTable:
	        Start  Length  Slot  Name   Signature
	            0       5     0  this   Lcom/leonxi/javase/juc/artconcurrentbook/chapter04/Synchronized;
	
	  public static void main(java.lang.String[]);
	    descriptor: ([Ljava/lang/String;)V
	    flags: ACC_PUBLIC, ACC_STATIC
	    Code:
	      stack=2, locals=1, args_size=1
	         0: ldc           #1                  // class com/leonxi/javase/juc/artconcurrentbook/chapter04/Synchronized
	         2: dup
	         3: monitorenter
	         4: monitorexit
	         5: invokestatic  #16                 // Method m:()V
	         8: return
	      LineNumberTable:
	        line 24: 0
	        line 28: 5
	        line 29: 8
	      LocalVariableTable:
	        Start  Length  Slot  Name   Signature
	            0       9     0  args   [Ljava/lang/String;
	
	  public static synchronized void m();
	    descriptor: ()V
	    flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
	    Code:
	      stack=0, locals=0, args_size=0
	         0: return
	      LineNumberTable:
	        line 32: 0
	      LocalVariableTable:
	        Start  Length  Slot  Name   Signature
	}
	SourceFile: "Synchronized.java"

 */


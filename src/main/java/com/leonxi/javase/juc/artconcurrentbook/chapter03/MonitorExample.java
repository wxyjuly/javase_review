/**
 * Project Name:javase_review
 * File Name:MonitorExample.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月22日下午11:19:25
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03;
/**
 * ClassName:MonitorExample <br/>
 * Date:     2018年1月22日 下午11:19:25 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
class MonitorExample {
    int a = 0;

    public synchronized void writer() { //1
        a++; //2
    } //3

    public synchronized void reader() { //4
        int i = a; //5
        //……
    } //6
}

/*
 F:\GitHub_Repo\00_core_java\javase_review\target\classes\com\leonxi\javase\juc\artconcurrentbook\chapter03>javap -verbose FinalExample.class
 ->执行反编译命令：【javap -verbose FinalExample.class】

Classfile /F:/GitHub_Repo/00_core_java/javase_review/target/classes/com/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample.class
  Last modified 2018-1-22; size 659 bytes
  MD5 checksum a6e627359b244a640ecbcc213ee30823
  Compiled from "FinalExample.java"
public class com.leonxi.javase.juc.artconcurrentbook.chapter03.FinalExample
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Class              #2             // com/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample
   #2 = Utf8               com/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample
   #3 = Class              #4             // java/lang/Object
   #4 = Utf8               java/lang/Object
   #5 = Utf8               i
   #6 = Utf8               I
   #7 = Utf8               j
   #8 = Utf8               obj
   #9 = Utf8               Lcom/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample;
  #10 = Utf8               <init>
  #11 = Utf8               ()V
  #12 = Utf8               Code
  #13 = Methodref          #3.#14         // java/lang/Object."<init>":()V
  #14 = NameAndType        #10:#11        // "<init>":()V
  #15 = Fieldref           #1.#16         // com/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample.i:I
  #16 = NameAndType        #5:#6          // i:I
  #17 = Fieldref           #1.#18         // com/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample.j:I
  #18 = NameAndType        #7:#6          // j:I
  #19 = Utf8               LineNumberTable
  #20 = Utf8               LocalVariableTable
  #21 = Utf8               this
  #22 = Utf8               writer
  #23 = Methodref          #1.#14         // com/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample."<init>":()V
  #24 = Fieldref           #1.#25         // com/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample.obj:Lcom/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample;
  #25 = NameAndType        #8:#9          // obj:Lcom/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample;
  #26 = Utf8               reader
  #27 = Utf8               object
  #28 = Utf8               a
  #29 = Utf8               b
  #30 = Utf8               SourceFile
  #31 = Utf8               FinalExample.java
{
  int i;
    descriptor: I
    flags:

  final int j;
    descriptor: I
    flags: ACC_FINAL

  static com.leonxi.javase.juc.artconcurrentbook.chapter03.FinalExample obj;
    descriptor: Lcom/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample;

    flags: ACC_STATIC

  public com.leonxi.javase.juc.artconcurrentbook.chapter03.FinalExample();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #13                 // Method java/lang/Object."<init>":()V
         4: aload_0
         5: iconst_1
         6: putfield      #15                 // Field i:I
         9: aload_0
        10: iconst_2
        11: putfield      #17                 // Field j:I
        14: return
      LineNumberTable:
        line 24: 0
        line 25: 4
        line 26: 9
        line 27: 14
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      15     0  this   Lcom/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample;

  public static void writer();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=0, args_size=0
         0: new           #1                  // class com/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample
         3: dup
         4: invokespecial #23                 // Method "<init>":()V
         7: putstatic     #24                 // Field obj:Lcom/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample;
        10: return
      LineNumberTable:
        line 30: 0
        line 31: 10
      LocalVariableTable:
        Start  Length  Slot  Name   Signature

  public static void reader();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=3, args_size=0
         0: getstatic     #24                 // Field obj:Lcom/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample;
         3: astore_0
         4: aload_0
         5: getfield      #15                 // Field i:I
         8: istore_1
         9: aload_0
        10: getfield      #17                 // Field j:I
        13: istore_2
        14: return
      LineNumberTable:
        line 34: 0
        line 35: 4
        line 36: 9
        line 37: 14
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            4      11     0 object   Lcom/leonxi/javase/juc/artconcurrentbook/chapter03/FinalExample;
            9       6     1     a   I
           14       1     2     b   I
}
SourceFile: "FinalExample.java" 
*/

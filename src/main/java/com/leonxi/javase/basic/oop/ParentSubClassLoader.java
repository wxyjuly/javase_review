package com.leonxi.javase.basic.oop;

import org.junit.Test;

/**
 * 测试：
 * 子、父类；静态块，非静态块，构造方法执行顺序
 * @author Administrator
 *
 */
class Parent{
	
	public static final String PARENT_FINAL_STATIC_STR = "parent_final_static_str" ;
	public final String PARENT_FINAL_STR = "parent_final_str" ;
	public String PARENT_STR = "parent_str" ;
	
	{
		System.out.println("->. parent [block] {1}");
	}
	
	static {
		System.out.println("->. parent [static block] {1}");
	}
	
	public Parent(){
		System.out.println("->. Parent.Parent()");
	}
	
	static {
		System.out.println("->. parent [static block] {2}");
	}
	
	{
		System.out.println("->. parent [block] {2}");
	}
}

class SubClass extends Parent {
	
	public static final String SUB_CLASS_FINAL_STATIC_STR = "sub_class_final_static_str" ;
	public final String SUB_CLASS_FINAL_STR = "sub_class_final_str" ;
	public String SUB_CLASS_STR = "sub_class_str" ;
	
	static {
		System.out.println("=>. subClass [static block]") ;
	}
	
	public SubClass(){
		System.out.println("=>. SubClass.SubClass()") ;
	}
	
	{
		System.out.println("=>. subClass [block]") ;
	}
}

class ThreeLevelSubClass extends SubClass{
	static {
		System.out.println("|>. ThreeLevelSubClass [static block]") ;
	}
	
	public ThreeLevelSubClass(){
		System.out.println("|>. ThreeLevelSubClass.ThreeLevelSubClass()");
	}
	
	{
		System.out.println("|>. ThreeLevelSubClass [block]") ;
	}
}

public class ParentSubClassLoader {

	@Test
	public void test1st2ndInit() {
		System.out.println("---------1st new subclass---------");
		new SubClass() ;
		System.out.println("\n\n---------2nd new subclass---------");
		new SubClass() ;
		System.out.println("\n\n---------1st new parent---------");
		new Parent() ;
		System.out.println("\n\n---------2nd new parent---------");
		new Parent() ;
	}
	
	@Test
	public void testThreeLevelSubClass() {
		new ThreeLevelSubClass() ;
	}
	/*
		->. parent [static block] {1}
		->. parent [static block] {2}
		=>. subClass [static block]
		|>. ThreeLevelSubClass [static block]
		->. parent [block] {1}
		->. parent [block] {2}
		->. Parent.Parent()
		=>. subClass [block]
		=>. SubClass.SubClass()
		|>. ThreeLevelSubClass [block]
		|>. ThreeLevelSubClass.ThreeLevelSubClass()
	 */
}

/**
 * 静态块 > 非静态块 > 构造方法
 * 先父，后子
 * 静态块先加载（先加载父和子静态块）；在从父到子，依次加载父(非静态块，构造方法),子(非静态块，构造方法)。
 */
/**
---------1st new subclass---------
->. parent [static block] {1}
->. parent [static block] {2}
=>. subClass [static block]
->. parent [block] {1}
->. parent [block] {2}
->. Parent.Parent()
=>. subClass [block]
=>. SubClass.SubClass()

---------2nd new subclass---------
->. parent [block] {1}
->. parent [block] {2}
->. Parent.Parent()
=>. subClass [block]
=>. SubClass.SubClass()

---------1st new parent---------
->. parent [block] {1}
->. parent [block] {2}
->. Parent.Parent()

---------2nd new parent---------
->. parent [block] {1}
->. parent [block] {2}
->. Parent.Parent()
*/

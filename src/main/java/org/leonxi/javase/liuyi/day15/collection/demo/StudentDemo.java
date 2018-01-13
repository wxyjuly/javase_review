package org.leonxi.javase.liuyi.day15.collection.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test ;

public class StudentDemo {
	
	@Test
	public void testStudentList() {
		List<Student> studentList = new ArrayList<>() ;
		Student s1 = new Student("zhangsan","11");
		Student s2 = new Student("lisi","12");
		Student s3 = new Student("wangwu","13");
		Student s4 = new Student("liqi","14");
		Student s5 = new Student("zhaoliu","15");
		
		studentList.add(s1) ;
		studentList.add(s2) ;
		studentList.add(s3) ;
		studentList.add(s4) ;
		studentList.add(s5) ;
		
		for (Student student : studentList) {
			System.out.println("name:"+student.getName()+";age:"+student.getAge());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

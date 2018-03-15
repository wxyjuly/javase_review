package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.singleton;

public class Singleton {
	public static int STATUS=1;
	private Singleton(){
		System.out.println("Singleton is create");
	}
	private static Singleton instance = new Singleton();
	public static Singleton getInstance() {
		return instance;
	} 
}

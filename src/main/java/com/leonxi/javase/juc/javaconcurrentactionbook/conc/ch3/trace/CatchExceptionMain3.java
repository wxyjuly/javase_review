package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch3.trace;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * submit�Ե��쳣
 * 1. ��Future.get()����쳣
 * 2. try-catch
 * @author Geym
 *
 */
public class CatchExceptionMain3 {	public static void main(String[] args) throws InterruptedException, ExecutionException {
	ThreadPoolExecutor pools=new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            0L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());
	
	for(int i=0;i<5;i++){
		Future re=pools.submit(new DivTask(100,i));
		re.get();
	}
}}

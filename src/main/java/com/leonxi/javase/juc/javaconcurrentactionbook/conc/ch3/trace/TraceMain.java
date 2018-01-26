package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch3.trace;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ͨ��TraceThreadPoolExecutor ������֪�� �������ύ���߳�
 * @author Geym
 *
 */
public class TraceMain {

	public static void main(String[] args) {
		ThreadPoolExecutor pools=new TraceThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
		
		/**
		 * �����ջ�п��Կ������������ύ������
		 */
		for(int i=0;i<5;i++){
			pools.execute(new DivTask(100,i));
		}
	}

}

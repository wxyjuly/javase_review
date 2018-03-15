package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch6.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * �����ͨfuture�Ĺ���
 * 
 * ���¼�����������ִ�У�������һ��CompletableFuture����
 * thenApply ת��
 * thenAccept �����
 * @author Geym
 *
 */
public class CFutureMain3 {
    public static Integer calc(Integer para) {
    	try {
    		// ģ��һ����ʱ���ִ��
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
        return para*para;
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {       
    	CompletableFuture<Void> fu=CompletableFuture.supplyAsync(() -> calc(50))
          .thenApply((i)->Integer.toString(i))
          .thenApply((str)->"\""+str+"\"")
          .thenAccept(System.out::println);
        fu.get();
    }
}

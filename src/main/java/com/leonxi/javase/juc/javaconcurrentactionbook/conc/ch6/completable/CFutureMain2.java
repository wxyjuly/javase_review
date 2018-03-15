package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch6.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * �����ͨfuture�Ĺ���
 * 
 * ���¼�����������ִ�У�������һ��CompletableFuture����
 * static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier);
 * static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor);
 * static CompletableFuture<Void> runAsync(Runnable runnable);
 * static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor);
 * @author Geym
 *
 */
public class CFutureMain2 {
    public static Integer calc(Integer para) {
    	try {
    		// ģ��һ����ʱ���ִ��
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
        return para*para;
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> calc(50));
        System.out.println(future.get());
    }
}

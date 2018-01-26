package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch6.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * �����ͨfuture�Ĺ���
 * 
 * exceptionally �쳣���� �����쳣���д������û���쳣����������ԭ�еĽ��
 * 
 * @author Geym
 *
 */
public class CFutureMain4 {

	public static Integer calc(Integer para) {
		return para / 0;
	}

	public static void main(String[] args) throws InterruptedException,ExecutionException {
		CompletableFuture<Void> fu = CompletableFuture
				.supplyAsync(() -> calc(50))
				.exceptionally(ex -> {
					System.out.println(ex.toString());
					return 0;
				})
				.thenApply((i) -> Integer.toString(i))
				.thenApply((str) -> "\"" + str + "\"")
				.thenAccept(System.out::println);
		fu.get();
	}

}

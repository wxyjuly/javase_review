package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch6.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * �����ͨfuture�Ĺ���
 * 
 * thenCompose 
 * 
 * @author Geym
 *
 */
public class CFutureMain5 {
    
    public static Integer calc(Integer para) {
        return para/2;
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Void> fu =
                CompletableFuture.supplyAsync(() -> calc(50))
                .thenCompose((i)->CompletableFuture.supplyAsync(() -> calc(i)))
                .thenApply((str)->"\"" + str + "\"").thenAccept(System.out::println);
        fu.get();
    }

}

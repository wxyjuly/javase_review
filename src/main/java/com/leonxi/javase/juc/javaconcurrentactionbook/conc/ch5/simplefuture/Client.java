package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.simplefuture;

public class Client {
    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        // RealData�Ĺ�������
        new Thread() {                                      
            public void run() {                             
                RealData realdata = new RealData(queryStr);
                future.setRealData(realdata);
            }                                               
        }.start();
        return future;
    }
}

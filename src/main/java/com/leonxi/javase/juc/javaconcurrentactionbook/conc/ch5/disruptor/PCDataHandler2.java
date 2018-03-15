package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.disruptor;

import com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.EventHandler;

public class PCDataHandler2 implements EventHandler<PCData>
{
    public void onEvent(PCData event, long sequence, boolean endOfBatch)
    {
        System.out.println(Thread.currentThread().getId()+":Event: " + event.get());
    }
}
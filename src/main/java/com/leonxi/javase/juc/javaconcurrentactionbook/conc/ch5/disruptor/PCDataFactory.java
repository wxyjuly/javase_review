package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.disruptor;

import com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.EventFactory;

public class PCDataFactory implements EventFactory<PCData>
{
    public PCData newInstance()
    {
        return new PCData();
    }
}
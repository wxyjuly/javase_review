package com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.dsl;

import java.util.concurrent.Executor;

import com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.Sequence;
import com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.SequenceBarrier;

interface ConsumerInfo
{
    Sequence[] getSequences();

    SequenceBarrier getBarrier();

    boolean isEndOfChain();

    void start(Executor executor);

    void halt();

    void markAsUsedInBarrier();

    boolean isRunning();
}

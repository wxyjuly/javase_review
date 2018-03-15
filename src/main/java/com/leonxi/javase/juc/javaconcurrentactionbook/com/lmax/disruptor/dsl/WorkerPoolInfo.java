package com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.dsl;

import java.util.concurrent.Executor;

import com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.Sequence;
import com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.SequenceBarrier;
import com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.WorkerPool;

class WorkerPoolInfo<T> implements ConsumerInfo
{
    private final WorkerPool<T> workerPool;
    private final SequenceBarrier sequenceBarrier;
    private boolean endOfChain = true;

    public WorkerPoolInfo(final WorkerPool<T> workerPool, final SequenceBarrier sequenceBarrier)
    {
        this.workerPool = workerPool;
        this.sequenceBarrier = sequenceBarrier;
    }

    @Override
    public Sequence[] getSequences()
    {
        return workerPool.getWorkerSequences();
    }

    @Override
    public SequenceBarrier getBarrier()
    {
        return sequenceBarrier;
    }

    @Override
    public boolean isEndOfChain()
    {
        return endOfChain;
    }

    @Override
    public void start(final Executor executor)
    {
        workerPool.start(executor);
    }

    @Override
    public void halt()
    {
        workerPool.halt();
    }

    @Override
    public void markAsUsedInBarrier()
    {
        endOfChain = false;
    }

    @Override
    public boolean isRunning()
    {
        return workerPool.isRunning();
    }
}

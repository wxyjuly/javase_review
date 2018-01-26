package com.leonxi.javase.juc.javaconcurrentactionbook.conc.remove.prime;

import java.util.BitSet;

public class SyncBitSet {
    private BitSet bs=null;
    
    public SyncBitSet(int nbits){
        bs=new BitSet(nbits);
        //Ĭ�϶����������޳�����������
        bs.set(0, nbits,true);
    }
    
    public synchronized void set(int bitIndex, boolean value) {
        bs.set(bitIndex,value);
    }
    
    public synchronized void set(int fromIndex, int toIndex, boolean value){
        bs.set(fromIndex,toIndex,value);
    }
    
    public synchronized boolean get(int bitIndex){
        return bs.get(bitIndex);
    }
}

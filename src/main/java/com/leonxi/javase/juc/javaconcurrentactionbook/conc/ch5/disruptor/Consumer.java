package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.disruptor;

import com.leonxi.javase.juc.javaconcurrentactionbook.com.lmax.disruptor.WorkHandler;

public class Consumer implements WorkHandler<PCData> {
	@Override
	public void onEvent(PCData event) throws Exception {
		System.out.println(Thread.currentThread().getId() + ":Event: --"
				+ event.get() * event.get() + "--");
	}
}

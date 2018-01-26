package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.disruptor;

public final class FalseSharing implements Runnable {
	public final static int NUM_THREADS = 2; // change
	public final static long ITERATIONS = 500L * 1000L * 1000L;
	private final int arrayIndex;

	private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];
	static {
		for (int i = 0; i < longs.length; i++) {
			longs[i] = new VolatileLong();
		}
	}

	public FalseSharing(final int arrayIndex) {
		this.arrayIndex = arrayIndex;
	}

	public static void main(final String[] args) throws Exception {
		final long start = System.currentTimeMillis();
		runTest();
		System.out.println("duration = " + (System.currentTimeMillis() - start));
	}

	private static void runTest() throws InterruptedException {
		Thread[] threads = new Thread[NUM_THREADS];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new FalseSharing(i));
		}

		for (Thread t : threads) {
			t.start();
		}

		for (Thread t : threads) {
			t.join();
		}
	}

	public void run() {
		long i = ITERATIONS + 1;
		while (0 != --i) {
			longs[arrayIndex].value = i;
		}
	}

	//JDK 7 ĳЩ�汾 �� JDK 8�� ��Ѳ��õ������Ż� ���� �����Ż��ֶ�ʧЧ
	// Unlock: -XX:-RestrictContended (JDK 8  option)
	//@sun.misc.Contended 
	public final static class VolatileLong {
		public volatile long value = 0L;
		public long p1, p2, p3, p4, p5, p6,p7=8L; // comment out
	}
}

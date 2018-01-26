package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.sort;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ��������
 * 
 * @author Administrator
 *
 */
public class InsertionSort {
//	static int[] arr = { 5, 52, 6, 3, 4, 10, 8, 100, 35, 78, 64, 31, 77, 90,
//			45, 53, 89, 78, 1 };
	static int[] arr = { 5, 52, 6, 3, 4};
	static ExecutorService pool = Executors.newFixedThreadPool(10);

	/**
	 *   j  i
	 *      key 
	 * 
	 */
	public static void insertSort(int[] arr) {
		int length = arr.length;
		int j, i, key;
		for (i = 1; i < length; i++) {
			//keyΪҪ׼�������Ԫ��
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			//�ҵ����ʵ�λ�� ����key
			arr[j + 1] = key;
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void shellSort(int[] arr) {
		// ���������hֵ
		int h = 1;
		while (h <= arr.length / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			System.out.println("h=" + h);
			for (int i = h; i < arr.length; i++) {
				if (arr[i] < arr[i - h]) {
					int tmp = arr[i];
					int j = i - h;
					while (j >= 0 && arr[j] > tmp) {
						arr[j + h] = arr[j];
						j -= h;
					}
					arr[j + h] = tmp;
				}
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(Arrays.toString(arr));
			// �������һ��hֵ
			h = (h - 1) / 3;
		}
	}

	public static class ShellSortTask implements Runnable {
		int i = 0;
		int h = 0;
		CountDownLatch l;

		public ShellSortTask(int i, int h, CountDownLatch latch) {
			this.i = i;
			this.h = h;
			this.l = latch;
		}

		@Override
		public void run() {
			if (arr[i] < arr[i - h]) {
				int tmp = arr[i];
				int j = i - h;
				while (j >= 0 && arr[j] > tmp) {
					arr[j + h] = arr[j];
					j -= h;
				}
				arr[j + h] = tmp;
			}
			l.countDown();
		}
	}

	public static void pShellSort(int[] arr) throws InterruptedException {
		// ���������hֵ
		int h = 1;
		CountDownLatch latch = null;
		while (h <= arr.length / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			System.out.println("h=" + h);
			if (h >= 4)
				latch = new CountDownLatch(arr.length - h);
			for (int i = h; i < arr.length; i++) {
				// �����߳�����
				if (h >= 4) {
					pool.execute(new ShellSortTask(i, h, latch));
				} else {
					if (arr[i] < arr[i - h]) {
						int tmp = arr[i];
						int j = i - h;
						while (j >= 0 && arr[j] > tmp) {
							arr[j + h] = arr[j];
							j -= h;
						}
						arr[j + h] = tmp;
					}
					// System.out.println(Arrays.toString(arr));
				}
			}
			// �ȴ��߳�������ɣ�������һ������
			latch.await();
			// �������һ��hֵ
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args) throws InterruptedException {
//		pShellSort(arr);
		insertSort(arr);
		pool.shutdownNow();
		System.out.println(Arrays.toString(arr));
	}
}

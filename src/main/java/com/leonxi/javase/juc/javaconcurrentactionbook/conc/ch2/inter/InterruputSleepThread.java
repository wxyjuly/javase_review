package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch2.inter;

/**
 * sleep�жϺ� �׳��쳣�������ж�״̬
 * ���ϣ��sleep������ж��ж�״̬���������sleep���쳣�����У��������ж�
 * @author Administrator
 *
 */
public class InterruputSleepThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(){
			@Override
			public void run(){
				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interruted!");
						break;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Interruted When Sleep");
						//�����ж�״̬
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
			}
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}
}

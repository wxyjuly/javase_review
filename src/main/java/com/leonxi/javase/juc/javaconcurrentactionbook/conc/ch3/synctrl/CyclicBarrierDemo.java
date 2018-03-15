
package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch3.synctrl;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        Soldier(CyclicBarrier cyclic, String soldierName) {
            this.cyclic = cyclic;
            this.soldier = soldierName;
        }

        public void run() {
            try {
                //µÈ´ýËùÓÐÊ¿±øµ½Æë
                cyclic.await();
                doWork();
                //µÈ´ýËùÓÐÊ¿±øÍê³É¹¤×÷
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":ÈÎÎñÍê³É");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;
        public BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        public void run() {
            if (flag) {
                System.out.println("Ë¾Áî:[Ê¿±ø" + N + "¸ö£¬ÈÎÎñÍê³É£¡]");
            } else {
                System.out.println("Ë¾Áî:[Ê¿±ø" + N + "¸ö£¬¼¯ºÏÍê±Ï£¡]");
                flag = true;
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        final int N = 10;
        Thread[] allSoldier=new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        //ÉèÖÃÆÁÕÏµã£¬Ö÷ÒªÊÇÎªÁËÖ´ÐÐÕâ¸ö·½·¨
        System.out.println("¼¯ºÏ¶ÓÎé£¡");
        for (int i = 0; i < N; ++i) {
            System.out.println("Ê¿±ø "+i+" ±¨µÀ£¡");
            allSoldier[i]=new Thread(new Soldier(cyclic, "Ê¿±ø " + i));
            allSoldier[i].start();
        }
    }
}

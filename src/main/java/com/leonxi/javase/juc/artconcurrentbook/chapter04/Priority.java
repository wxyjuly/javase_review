/**
 * Project Name:javase_review
 * File Name:Profiler.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午10:06:40
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:Profiler <br/>
 * Date:     2018年1月24日 上午10:06:40 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 6-2
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd   = true;

    public static void main(String[] args) throws Exception {
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        Thread.currentThread().setPriority(8);
        System.out.println("done.");
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;

        for (Job job : jobs) {
            System.out.println("Job Priority : " + job.priority + ", Count : " + job.jobCount);
        }

    }

    static class Job implements Runnable {
        private int  priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}
/**
 * Project Name:javase_review
 * File Name:Piped.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午10:05:12
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:Piped <br/>
 * Date:     2018年1月24日 上午10:05:12 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 4-12
 */
public class Piped {

    public static void main(String[] args) throws Exception {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 将输出流和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);

        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException ex) {
            }
        }
    }
}



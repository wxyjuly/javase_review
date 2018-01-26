package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch4.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
	static AtomicReference<Integer> money=new AtomicReference<Integer>();
	public static void main(String[] args) {
	    money.set(19);
	    //ģ�����߳�ͬʱ���º�̨���ݿ⣬Ϊ�û���ֵ
	    for(int i = 0 ; i < 3 ; i++) {              
            new Thread() {  
                public void run() {  
                    while(true){
                        while(true){
                            Integer m=money.get();
                            if(m<20){
                                if(money.compareAndSet(m, m+20)){
                                    System.out.println("���С��20Ԫ����ֵ�ɹ������:"+money.get()+"Ԫ");
                                    break;
                                }
                            }else{
                                //System.out.println("������20Ԫ�������ֵ");
                                break ;
                            }
                        }
                    }
                }  
            }.start();
        }
	    
	    //�û������̣߳�ģ��������Ϊ
	    new Thread() {  
            public void run() {  
                for(int i=0;i<100;i++){
                    while(true){
                        Integer m=money.get();
                        if(m>10){
                            System.out.println("����10Ԫ");
                            if(money.compareAndSet(m, m-10)){
                                System.out.println("�ɹ�����10Ԫ�����:"+money.get());
                                break;
                            }
                        }else{
                            System.out.println("û���㹻�Ľ��");
                            break;
                        }
                    }
                    try {Thread.sleep(100);} catch (InterruptedException e) {}
                }
            }  
        }.start();  
	}

}

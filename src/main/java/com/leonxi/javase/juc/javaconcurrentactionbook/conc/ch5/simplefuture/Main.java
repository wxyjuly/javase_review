package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.simplefuture;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        
        Data data = client.request("a");
        System.out.println("�������");
        try {
        	//���������һ��sleep�����˶�����ҵ���߼��Ĵ���
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        	//ʹ����ʵ������
        System.out.println("���� = " + data.getResult());
    }
}

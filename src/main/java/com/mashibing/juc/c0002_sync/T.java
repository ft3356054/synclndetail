package com.mashibing.juc.c0002_sync;

/*
synchronized 关键字，主要是操控 markword（2位）
*/
public class T {
    private static int count  =10;
    private Object o = new Object();

    public void m(){
        synchronized (o){
            count --;
            System.out.println(Thread.currentThread().getName()+"count="+count);
        }
    }

    public synchronized void m1(){
            count --;
            System.out.println(Thread.currentThread().getName()+"count="+count);
    }

    public static synchronized void m2(){
        count --;
        System.out.println(Thread.currentThread().getName()+"count="+count);
    }
}

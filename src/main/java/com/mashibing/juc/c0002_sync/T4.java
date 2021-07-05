package com.mashibing.juc.c0002_sync;

import java.util.concurrent.TimeUnit;

/*
* 一个同步方法，可以调用另一个同步方法。
* 一个线程已经拥有某个对象的锁，再次申请的时候，仍然会得到该对象的锁。
* 也就是说 synchronized 获得的锁是可以重入的
* */
public class T4 {
    synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+" m1 start ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println(Thread.currentThread().getName()+" m1 end");
    }

    public void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2");
    }

    public static void main(String [] args){
        new T4().m1();
    }
}

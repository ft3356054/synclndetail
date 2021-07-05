package com.mashibing.juc.c0002_sync;

import java.util.concurrent.TimeUnit;

/*
* 一个同步方法，可以调用另一个同步方法。
* 一个线程已经拥有某个对象的锁，再次申请的时候，仍然会得到该对象的锁。
* 也就是说 synchronized 获得的锁是可以重入的
* 下面的demo是父子类的重入
* */
public class T5 {
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " m start ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m end");
    }

    public static void main(String [] args){
        new T5_1().m();
    }
}

class T5_1 extends T5{
    synchronized void m() {
    System.out.println(Thread.currentThread().getName() + " child m start ");
    super.m();
    System.out.println(Thread.currentThread().getName() + " child m end");
    }
}


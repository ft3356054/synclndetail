package com.mashibing.juc.c0002_sync;

import java.util.concurrent.TimeUnit;

/*
* 程序在执行过程中，如果出现异常，默认情况锁会释放
* 所以，在并发处理的过程中，有异常需要多加小心，不然可能会发生不一致的情况。
* 比如，在一个web app处理过程中，多个servlet线程共同访问一个资源，这时候如果异常处理不合适
* 在第一个线程中抛出异常，其他线程就会进入同步代码区，有可能会访问到异常产生时的数据。
* 因此，要非常小心的处理同步业务逻辑中的异常
* */
public class T6 {
    synchronized void m(){
        int count = 0;
        System.out.println(Thread.currentThread().getName()+"  start ");
        while (true){
            count ++;
            System.out.println(Thread.currentThread().getName()+"  count = "+ count);
            try {
                TimeUnit.SECONDS.sleep(1);
                /*if(3==count)*/
                /*    Thread.currentThread().interrupt();*/
            } catch (InterruptedException e) {
                System.out.println("############"+e.toString());
                e.printStackTrace();
                //Thread.currentThread().interrupt();
            }

            if(5==count){
                int i = 1/0;//此处锁将被释放
                System.out.println(i);
            }
            /*
            if(5==count){
                int i = 0;
                try {
                    i = 1/0;
                } catch (Exception e) {    //如果采用catch，则不会中断线程
                    System.out.println("@@@@@@@@@@@@@"+e.toString());
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            */
        }
    }

    public static void main(String [] args){
        T6 t = new T6();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r,"t2").start();
    }
}

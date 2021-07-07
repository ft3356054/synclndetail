package com.mashibing.juc.c0003_valatile;

import java.util.concurrent.TimeUnit;

/*
volatile
保证线程可见性（每次写都会被线程读到）
禁止指令重排序
*/
public class T1 {
    /*volatile*/ boolean running = true;//对比一下在有volatile的情况下，整个线程运行结果的区别
    void m(){
        System.out.println("m start");
        while (running){
            /*try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("m end");
    }

    public static void main(String [] args){
        T1 t = new T1();
        new Thread(t::m,"t1").start();//lambda表达式,相当于下面
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        });*/
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}

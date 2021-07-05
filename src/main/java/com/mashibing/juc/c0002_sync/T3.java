package com.mashibing.juc.c0002_sync;

/*
* 当一个类中，有同步方法和非同步方法。synchronized会不会对非同步方法限制?
* 答：不限制
* */
public class T3{
    private  int count  =100;
    private Object o = new Object();

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"m1 start ");
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1 end");
    }

    public void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m2");
    }

    public static void main(String [] args){
        T3 t = new T3();
        new Thread(t::m1,"Thread1").start();
        new Thread(t::m2,"Thread2").start();
    }
}

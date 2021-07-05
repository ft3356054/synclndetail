package com.mashibing.juc.c0002_sync;

/*
* 加入volatile 或 synchronized 可以避免线程错误
* */
public class T2 implements Runnable{
    private /*volatile*/ int count  =100;
    private Object o = new Object();

    @Override
    public /*synchronized*/ void run(){
        count --;
        System.out.println(Thread.currentThread().getName()+"count="+count);
    }

    public static void main(String [] args){
        T2 t = new T2();
        for(int i=0;i<100;i++){
            new Thread(t,"Thread:"+i).start();
        }
    }
}

package com.mashibing.juc.c0001_threadBase;

/*
@Author: llb
@Date : 2021/7/2 16:37
*/
public class T02_HowToCreateThread {
    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("hello MyThread");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run(){
            System.out.println("hello MyRun");
        }
    }

    public static void main(String [] args){
        new MyThread().start();;
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("hello lambda");
        }).start();
    }

    //启动线程的3种方式： 1 Thread ；2 Runnable ；3 线程池；4 lambda
}

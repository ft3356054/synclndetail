package com.mashibing.juc.c0001_threadBase;

/*
@Author: llb
@Date : 2021/7/2 16:37
*/
public class T04_ThreadState {
    //不要使用stop方法
    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println(this.getState());
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A"+i);
            }
        }
    }


    public static void main(String [] args){
        Thread t = new MyThread();
        System.out.println(t.getState());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }

}

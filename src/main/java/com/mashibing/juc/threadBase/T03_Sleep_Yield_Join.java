package com.mashibing.juc.threadBase;

/*
@Author: llb
@Date : 2021/7/2 16:37
*/
public class T03_Sleep_Yield_Join {
    public static void main(String [] args){
        //testSleep();
        testYield();
        //testJoin();
    }

    static void testSleep(){
        new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("A"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void testYield(){
        new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("A"+i);
                if(i%10 == 0){
                    System.out.println("A yield"+i);
                    Thread.yield();
                }

            }
        }).start();

        new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("B"+i);
                if(i%10 == 0){
                    System.out.println("B yield"+i);
                    Thread.yield();
                }
            }
        }).start();
    }

    //一个线程调用另一个线程（等待另一个线程结束）
    static void testJoin(){
        Thread t1 = new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("A"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i=0;i<100;i++){
                System.out.println("B"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.start();
    }

}

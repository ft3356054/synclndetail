package com.mashibing.juc.c0003_valatile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
要想保证数据完整，volatile和synchronized都不可缺少
synchronized保证原子性，volatile保证可见性
*/
public class T2 {
    /*volatile*/ int count = 0;
    /*synchronized*/ void m(){
        for(int i=0;i<10000;i++)
            count++;
    }

    public static void main(String [] args){
        T2 t = new T2();

        List<Thread> threads = new ArrayList<>();

        for(int i=0;i<10;i++){
            threads.add( new Thread(t::m,"t-"+i));
        }

        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}

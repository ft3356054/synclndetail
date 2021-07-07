package com.mashibing.juc.c0004_cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
要想保证数据完整，volatile和synchronized都不可缺少
synchronized保证原子性，volatile保证可见性

也可以使用CAS
*/
public class T2 {
    AtomicInteger count = new AtomicInteger();
    /*synchronized*/ void m(){
        for(int i=0;i<10000;i++)
            count.incrementAndGet();//count++
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

package com.mashibing.reference;


import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/*
@Author: llb
@Date : 2021/6/30 14:55
*/
public class T04_PhantomReference {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    //虚引用，主要作用是管理堆外内存。
    //虚引用无法被get到
    public static void main(String [] args){
        PhantomReference<M> phantomReference =
                new PhantomReference<>(new M(),QUEUE);

        new Thread(()->{
            while (true){
                LIST.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        new Thread(()->{
            while (true){
                Reference<? extends M> poll = QUEUE.poll();
                if(null!=poll){
                    System.out.println("虚引用对象被jvm回收了，"+poll);
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

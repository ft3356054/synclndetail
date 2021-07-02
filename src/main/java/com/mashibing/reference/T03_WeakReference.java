package com.mashibing.reference;


import java.lang.ref.WeakReference;

/*
@Author: llb
@Date : 2021/6/30 14:55
*/
public class T03_WeakReference {
    //弱引用，在NIO之中有应用
    public static void main(String [] args){
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();//只要gc，就会被回收。属于一次性
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();//ThreadLocal是一个容器
        tl.set(new M());//此对象放入tl中，只有tl可以get到
        tl.remove();
    }
}

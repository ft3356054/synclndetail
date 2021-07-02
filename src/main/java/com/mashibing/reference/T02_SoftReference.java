package com.mashibing.reference;

import java.lang.ref.SoftReference;

/*
@Author: llb
@Date : 2021/6/30 14:55
*/
public class T02_SoftReference {
    //软引用 适合缓存使用
    public static void main(String [] args){
        //前半部分为强引用，软引用部分为new SoftReference<>(new byte[1024*1024*10]);
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        //m = null;
        System.out.println(m.get());
        System.gc();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());

        //设置堆内存 VM options: -Xmx20M
        //再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会软引用干掉
        byte[] b = new byte[1024*1024*15];
        System.out.println(m.get());
    }
}

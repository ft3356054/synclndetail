package com.mashibing.cas;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

/*
@Author: llb
@Date : 2021/6/30 14:55
*/
public class T01 {
    public static void main(String [] args){
        //1、讲解 CAS
        AtomicInteger atomicInteger = new AtomicInteger();

        //2、新建对象占用多少内存
        // maven 导入jar-JOL(java object layout)
        Object o = new Object();
        //3、执行此行代码和不执行，打印出来的内容不同
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        //对对象o上锁，而不是对{}内的代码上锁。加上synchronized，是上了偏向锁
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}

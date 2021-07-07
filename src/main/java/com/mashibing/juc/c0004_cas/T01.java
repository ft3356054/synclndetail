package com.mashibing.juc.c0004_cas;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

/*
CAS 无锁优化 自旋
cas(v,expected,newValue)
    if v==expected
        v=new
    else
        try again or fail

CAS会有ABA问题： 期望值是1 ，但操作过程中，有其他线程把1改为2 ，又改回1
    想解决ABA问题，则需要加入版本号，多检查一个version

    ABA主要是影响对象的修改，对数值修改，并不会有影响
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

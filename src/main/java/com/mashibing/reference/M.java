package com.mashibing.reference;

/*
@Author: llb
@Date : 2021/7/2 8:47
*/
public class M {
    //当对象被回收时，finalize会被调用
    protected void finalize() throws Throwable{
        System.out.println("finalize");
    }
}

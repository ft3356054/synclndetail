package com.mashibing.reference;

import java.io.IOException;
import java.lang.ref.WeakReference;

/*
@Author: llb
@Date : 2021/6/30 14:55
*/
public class T01_NormalReference {
    //强引用
    public static void main(String [] args) throws IOException {
        M m = new M();
        m = null;

        System.gc();

        System.in.read();
    }
}

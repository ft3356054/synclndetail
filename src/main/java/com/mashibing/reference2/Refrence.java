package com.mashibing.reference2;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/*
@Author: llb
@Date : 2021/7/2 15:05
*/
public class Refrence {
    public static void main(String... args) {


        RefrenceStuduet studentA = new RefrenceStuduet("AA",1);
        RefrenceStuduet studentB = new RefrenceStuduet("BB",2);
        RefrenceStuduet studentC = new RefrenceStuduet("CC",3
        );

        //强引用strongStudentA
        RefrenceStuduet strongStudentA = studentA;
        //软引用softStudentB
        SoftReference<RefrenceStuduet> softStudentB = new SoftReference<>(studentB);
        //弱引用weekStudentC
        WeakReference<RefrenceStuduet> weekStudentC = new WeakReference<>(studentC);
        //直接弱引用
        WeakReference<RefrenceStuduet> weekStudentD = new WeakReference<>(new RefrenceStuduet("DD",4));


        //引用都变为null
        studentA = null;
        studentB = null;
        studentC = null;

        //gc之前 输出RefrenceStuduet的toString方法的内容
        System.out.println("Before gc...");
        System.out.println(String.format("strongA = %sn, softB = %s, weakC = %s, weakD = %s", strongStudentA, softStudentB.get(), weekStudentC.get(), weekStudentD.get()));
        System.out.println("Run GC...");
        //执行系统gc
        System.gc();
        //gc之后输出
        System.out.println("After gc...");
        System.out.println(String.format("strongA = %s, softB = %s, weakC = %s, weakD = %s", strongStudentA, softStudentB.get(), weekStudentC.get(), weekStudentD.get()));
    }

}

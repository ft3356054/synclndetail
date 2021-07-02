package com.mashibing.reference2;

/*
@Author: llb
@Date : 2021/7/2 15:05
*/
public class RefrenceStuduet {
    private String name;
    private int age;

    public RefrenceStuduet(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "学生姓名："+this.name+" 年龄："+this.age;
    }
}

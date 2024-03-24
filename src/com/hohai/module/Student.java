package com.hohai.module;

import java.util.SplittableRandom;

public class Student {
    private int id;
    private int age;
    private String name;

    public Student(int id,  String name,int age) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "$id: " + id +
                        ", age=" + age +
                        ", name=" + name + '\t';
    }
}

package com.zjh.administrat.fresco_demo01;

public class Student {

    private String name;
    private String sex;
    private int age;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String show1(String name){
       return "bean里面中定义的数据";

    }

    public void show2(int age){

    }

}

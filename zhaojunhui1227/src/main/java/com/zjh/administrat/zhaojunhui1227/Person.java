package com.zjh.administrat.zhaojunhui1227;

public class Person {
    private String mName;
    private String mGender;
    private int mAge;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    private void show1(String name){
        mName = name;
    }

    public void show2(String gender){
        mGender = gender;
    }

    public void show3(int age){
        mAge = age;
    }

}

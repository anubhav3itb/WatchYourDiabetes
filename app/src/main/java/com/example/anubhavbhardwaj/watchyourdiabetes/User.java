package com.example.anubhavbhardwaj.watchyourdiabetes;

/**
 * Created by anubhavbhardwaj on 21/04/2017.
 */

public class User {
    int id;
    String name;
    int age;
    String sex;

    public User(){
    }

    public User(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getId() { return id; }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

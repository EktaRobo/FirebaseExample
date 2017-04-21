package com.example.ekta.firebaseexample;

/**
 * Created by ekta on 21/4/17.
 */

import com.google.gson.annotations.Expose;

public class Model {

    @Expose
    private String Name;
    @Expose
    private long Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public long getAge() {
        return Age;
    }

    public void setAge(long age) {
        this.Age = age;
    }

    @Override
    public String toString() {
        return "Model{" +
                "Name='" + Name + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }
}

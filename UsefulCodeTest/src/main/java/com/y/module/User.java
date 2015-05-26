package com.y.module;

/**
 * Created by zf on 2015/5/14.
 */
public class User {
    public final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

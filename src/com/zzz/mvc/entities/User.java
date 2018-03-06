package com.zzz.mvc.entities;

public class User {
    private String User_id;
    private String User_name;

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
        User_id = user_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_id='" + User_id + '\'' +
                ", User_name='" + User_name + '\'' +
                '}';
    }
}

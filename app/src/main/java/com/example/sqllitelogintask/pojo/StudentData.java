package com.example.sqllitelogintask.pojo;

public class StudentData {

    String id;
    String name;
    String phonenumber;
    String password;

    public StudentData(String id, String name, String phonenumber, String password) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public StudentData(String name, String phonenumber, String password) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

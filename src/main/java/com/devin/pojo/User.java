package com.devin.pojo;

import java.util.Date;

public class User {
    private String username;
    private Long id;
    private String password;
    private String email;
    private String phoneNum;
    private Date birthday;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String username, Long id, String password, String email, String phoneNum, Date birthday) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
    }
}

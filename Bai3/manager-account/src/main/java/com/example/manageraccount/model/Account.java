package com.example.manageraccount.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {

    private static  int count=0;
    private int id;
    private LocalDate birthday;
    private String username;
    private String password;
    private String avatar;

    public Account() {
        this.id = ++count;
        this.birthday=LocalDate.now();
    }

    public Account(String birthday, String username, String password, String avatar) {
        this.id = ++count;
        this.birthday = LocalDate.parse(birthday,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday.toString();
    }

    public void setBirthday(String birthday) {

        this.birthday = LocalDate.parse(birthday,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", birthday=" + birthday +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

}

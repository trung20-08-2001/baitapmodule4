package com.login.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate birthday;
    private String username;
    private String password;
    private boolean status=true;
    private String avatar;
    @ManyToOne
    private Role role;

    public Account() {
    }

    public Account(int id, String birthday, String username, String password, boolean status, String avatar, Role role) {
        this.id = id;
        this.birthday = LocalDate.parse(birthday,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.username = username;
        this.password = password;
        this.status = status;
        this.avatar = avatar;
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
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
                ", status=" + status +
                ", avatar='" + avatar + '\'' +
                ", role=" + role +
                '}';
    }
}

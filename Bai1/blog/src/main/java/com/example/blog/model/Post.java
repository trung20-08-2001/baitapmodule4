package com.example.blog.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private int idPost;
    private LocalDateTime creationTime;
    private String title;
    private String image;
    private String content;

    public Post() {
    }

    public Post(int idPost, LocalDateTime creationTime, String title, String image, String content) {
        this.idPost = idPost;
        this.creationTime = creationTime;
        this.title = title;
        this.image = image;
        this.content = content;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public  String creationTimeString(){
        LocalDateTime localDateTime = this.creationTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return localDateTime.format(formatter);
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", creationTime=" + creationTime +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

package com.example.blog.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryDeletePost extends Post{
    private LocalDateTime deleteTime;

    public HistoryDeletePost() {
    }

    public HistoryDeletePost(int idPost, LocalDateTime creationTime, String title, String image, String content, LocalDateTime deleteTime) {
        super(idPost, creationTime, title, image, content);
        this.deleteTime = deleteTime;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String deleteTimeString(){
        LocalDateTime localDateTime=this.deleteTime;
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    @Override
    public String toString() {
        return "HistoryDeletePost{" +
                "deleteTime=" + deleteTime +
                '}' +super.toString();
    }
}

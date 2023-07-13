package com.appplaymusicsimp.model;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String artist;
    private String category;
    private String nameFile;

    public Song() {
    }

    public Song(int id, String name, String artist, String category, String file) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.nameFile = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String file) {
        this.nameFile = file;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", category='" + category + '\'' +
                ", nameFile='" + nameFile + '\'' +
                '}';
    }
}

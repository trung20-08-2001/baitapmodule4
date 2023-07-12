package com.musicplayapp.model;

public class Sing {
    private String name;
    private String artist;
    private String category;
    private String file;

    public Sing() {
    }

    public Sing(String name, String artist, String category, String file) {
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.file = file;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

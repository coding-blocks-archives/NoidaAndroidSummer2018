package com.codingblocks.fragmentpager;

public class Student {

    String name, bio, url;

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getUrl() {
        return url;
    }

    public Student(String name, String bio, String url) {
        this.name = name;
        this.bio = bio;
        this.url = url;
    }
}

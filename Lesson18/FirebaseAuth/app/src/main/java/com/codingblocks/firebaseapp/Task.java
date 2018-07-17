package com.codingblocks.firebaseapp;

public class Task {

    private String title, subtitle;
    private Long id;

    public Task() {
    }

    public Task(String title, String subtitle, Long id) {
        this.title = title;
        this.subtitle = subtitle;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

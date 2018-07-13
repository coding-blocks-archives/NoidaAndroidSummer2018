package com.example.robin.taskdatabase;

public class Task {

    long id;
    String title;
    int isComp;

    public Task(long id, String title) {

        this.id = id;
        this.title = title;
        this.isComp = 0;
    }
    public Task(long id, String title, int isComp) {

        this.id = id;
        this.title = title;
        this.isComp = isComp;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public int getIsComp() {
        return isComp;
    }

    public void setIsComp(int isComp) {
        this.isComp = isComp;
    }
}

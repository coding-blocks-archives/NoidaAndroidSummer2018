package com.example.robin.recyclerview;

import android.widget.ImageView;

public class task {
    private  String task,time;
    private int i;


    public task(String task, String time) {
        this.task = task;
        this.time = time;
        this.i=0;

    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

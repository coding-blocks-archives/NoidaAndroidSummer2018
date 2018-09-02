package com.example.dell.listhw;

public class id {
    private  String text,time;
    public id(String text,String time)
    {
        this.text=text;
        this.time=time;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

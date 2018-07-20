package com.example.dell.recyclerview;

public class id {
    private  String text,time;
    private String color;

    public id(String text,String time,String color)
    {
        this.text=text;
        this.time=time;
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

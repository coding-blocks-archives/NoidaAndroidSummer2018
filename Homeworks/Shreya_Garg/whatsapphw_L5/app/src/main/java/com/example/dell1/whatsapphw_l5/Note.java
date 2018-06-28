package com.example.dell1.whatsapphw_l5;

public class Note {
    String title,detail,time;

    public Note(String title, String detail, String time) {
        this.title = title;
        this.detail = detail;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

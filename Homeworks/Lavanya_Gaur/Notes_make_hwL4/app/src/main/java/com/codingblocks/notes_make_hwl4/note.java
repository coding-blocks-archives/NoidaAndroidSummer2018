package com.codingblocks.notes_make_hwl4;

public class note {
    private String text , time;

    //use command N
    public note(String text, String time) {
        this.text = text;
        this.time = time;
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

package com.example.dhirajchhabraeng.allnotes;

public class Note {
    String timeText = "";
    String titleText = "";
    String noteText = "";

    public Note(String timeText, String titleText, String noteText) {
        this.timeText = timeText;
        this.titleText = titleText;
        this.noteText = noteText;
    }

    public String getTimeText() {
        return timeText;
    }

    public String getTitleText() {
        return titleText;
    }

    public String getNoteText() {
        return noteText;
    }
}

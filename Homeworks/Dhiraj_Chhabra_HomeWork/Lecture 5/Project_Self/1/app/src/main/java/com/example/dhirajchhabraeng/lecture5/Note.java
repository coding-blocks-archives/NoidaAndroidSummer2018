package com.example.dhirajchhabraeng.lecture5;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

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

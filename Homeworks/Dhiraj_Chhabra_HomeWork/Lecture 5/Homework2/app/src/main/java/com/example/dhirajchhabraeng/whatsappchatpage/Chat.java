package com.example.dhirajchhabraeng.whatsappchatpage;

import android.graphics.drawable.Drawable;

import java.net.MalformedURLException;
import java.net.URL;

public class Chat {

    private URL personImage;
    private String personName;
    private String timeText;
    private Drawable seenFlag;
    private String lastMessage = "dhiraj chhabra is a really good guy";

    public Chat(String personImageURL, String personName, String timeText, Drawable seenFlag) {
        try {
            this.personImage = new URL(personImageURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.personName = personName;
        this.timeText = timeText;
        this.seenFlag = seenFlag;
    }

    public URL getPersonImage() {
        return personImage;
    }

    public String getPersonName() {
        return personName;
    }

    public String getTimeText() {
        return timeText;
    }

    public Drawable getSeenFlag() {
        return seenFlag;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}

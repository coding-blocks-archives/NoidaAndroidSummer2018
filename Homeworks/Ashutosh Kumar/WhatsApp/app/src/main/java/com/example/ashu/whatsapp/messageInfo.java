package com.example.ashu.whatsapp;

public class messageInfo {
    String mTitle,mContent,mDate,mImageResourceId;

    public messageInfo(String mTitle, String mContent, String mDate, String mImageResourceId) {
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.mDate = mDate;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmImageResourceId() {
        return mImageResourceId;
    }
}

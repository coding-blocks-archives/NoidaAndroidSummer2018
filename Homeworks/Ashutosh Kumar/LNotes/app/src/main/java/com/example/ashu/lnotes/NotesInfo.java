package com.example.ashu.lnotes;

import android.os.Parcel;
import android.os.Parcelable;

import javax.crypto.spec.DESedeKeySpec;

public class NotesInfo implements Parcelable{

    public static final  Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public NotesInfo createFromParcel(Parcel in){
            return new NotesInfo(in);
        }

        public NotesInfo[] newArray(int size){
            return new NotesInfo[size];
        }
    };

    String mTitle,mTime,mContent;

    public NotesInfo(String mTitle, String mContent, String mTime) {
        this.mTitle = mTitle;
        this.mTime = mTime;
        this.mContent = mContent;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmContent() {
        return mContent;
    }

    public NotesInfo(Parcel in){
        this.mTitle = in.readString();
        this.mContent = in.readString();
        this.mTime = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mContent);
        dest.writeString(this.mTime);

    }
}

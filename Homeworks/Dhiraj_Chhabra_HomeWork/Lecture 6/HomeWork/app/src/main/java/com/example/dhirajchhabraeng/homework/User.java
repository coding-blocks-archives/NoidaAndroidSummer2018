package com.example.dhirajchhabraeng.homework;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

class User implements Parcelable {
    private String imageUrl;
    private String userName;
    private String bio;
    private String facebookUrl;
    private String twitterUrl;
    private int gender = -1;

    Random r = new Random();
    int i = r.nextInt(80 - 10) + 10;

    public User(String imageUrl, String userName, String bio, String facebookUrl, String twitterUrl, int gender) {
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.bio = bio;
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.gender = gender;
    }

    protected User(Parcel in) {
        imageUrl = in.readString();
        userName = in.readString();
        bio = in.readString();
        facebookUrl = in.readString();
        twitterUrl = in.readString();
        gender = in.readInt();
        i = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getImageUrl() {
        if (gender == 0) {
            return imageUrl + "men/" + i + ".jpg";
        } else {
            return imageUrl + "women/" + i + ".jpg";
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getBio() {
        return bio;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(imageUrl);
        dest.writeString(userName);
        dest.writeString(bio);
        dest.writeString(facebookUrl);
        dest.writeString(twitterUrl);
        dest.writeInt(gender);
        dest.writeInt(i);
    }
}


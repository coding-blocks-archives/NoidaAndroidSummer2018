package com.codingblocks.okhttppostbroadcast;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{

    private String email, password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    protected User(Parcel in) {
        email = in.readString();
        password = in.readString();
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(password);
    }
}

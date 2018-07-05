package com.example.delllatitude.lec6hwspaceapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Star implements Parcelable {
    private String starName, starData, starUrl, starImage;

    public Star(String starName, String starData, String starUrl, String starImage) {
        this.starName = starName;
        this.starData = starData;
        this.starUrl = starUrl;
        this.starImage = starImage;
    }

    protected Star(Parcel in) {
        starName = in.readString();
        starData = in.readString();
        starUrl = in.readString();
        starImage = in.readString();
    }

    public static final Creator<Star> CREATOR = new Creator<Star>() {
        @Override
        public Star createFromParcel(Parcel in) {
            return new Star(in);
        }

        @Override
        public Star[] newArray(int size) {
            return new Star[size];
        }
    };

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getStarData() {
        return starData;
    }

    public void setStarData(String starData) {
        this.starData = starData;
    }

    public String getStarUrl() {
        return starUrl;
    }

    public void setStarUrl(String starUrl) {
        this.starUrl = starUrl;
    }

    public String getStarImage() {
        return starImage;
    }

    public void setStarImage(String starImage) {
        this.starImage = starImage;
    }

    public static ArrayList<Star> getStarArrayList() {
       ArrayList<Star> starArrayList = new ArrayList<>();

       return starArrayList;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(starName);
      dest.writeString(starData);
      dest.writeString(starUrl);
      dest.writeString(starImage);
    }
}

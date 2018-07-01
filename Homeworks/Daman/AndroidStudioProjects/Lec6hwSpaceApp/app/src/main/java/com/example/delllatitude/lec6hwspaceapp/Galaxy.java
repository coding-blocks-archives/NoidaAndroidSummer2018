package com.example.delllatitude.lec6hwspaceapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Galaxy implements Parcelable {
private String galaxyName, galaxyData, galxyUrl, GalaxyUrl;

    public Galaxy(String galaxyName, String galaxyData, String galxyUrl, String galaxyUrl) {
        this.galaxyName = galaxyName;
        this.galaxyData = galaxyData;
        this.galxyUrl = galxyUrl;
        GalaxyUrl = galaxyUrl;
    }

    protected Galaxy(Parcel in) {
        galaxyName = in.readString();
        galaxyData = in.readString();
        galxyUrl = in.readString();
        GalaxyUrl = in.readString();
    }

    public static final Creator<Galaxy> CREATOR = new Creator<Galaxy>() {
        @Override
        public Galaxy createFromParcel(Parcel in) {
            return new Galaxy(in);
        }

        @Override
        public Galaxy[] newArray(int size) {
            return new Galaxy[size];
        }
    };

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    public String getGalaxyData() {
        return galaxyData;
    }

    public void setGalaxyData(String galaxyData) {
        this.galaxyData = galaxyData;
    }

    public String getGalxyUrl() {
        return galxyUrl;
    }

    public void setGalxyUrl(String galxyUrl) {
        this.galxyUrl = galxyUrl;
    }

    public String getGalaxyUrl() {
        return GalaxyUrl;
    }

    public void setGalaxyUrl(String galaxyUrl) {
        GalaxyUrl = galaxyUrl;
    }


    public static ArrayList<Galaxy> getGalaxyArrayList(){
        ArrayList<Galaxy> galaxyArrayList = new ArrayList<>();
        galaxyArrayList.add(new Galaxy("Earth", "", "https://en.wikipedia.org/wiki/Earth",""));

        return galaxyArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(galaxyName);
        dest.writeString(galaxyData);
        dest.writeString(galxyUrl);
        dest.writeString(GalaxyUrl);
    }
}

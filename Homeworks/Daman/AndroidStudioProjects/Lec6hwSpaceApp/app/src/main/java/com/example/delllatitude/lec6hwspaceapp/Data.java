package com.example.delllatitude.lec6hwspaceapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Data implements Parcelable{
    private String Name, Data, imageUrl, Url;

    protected Data(Parcel in) {
        Name = in.readString();
        Data = in.readString();
        imageUrl = in.readString();
        Url = in.readString();
    }

    public Data(String name, String data, String imageUrl, String url) {
        Name = name;
        Data = data;
        this.imageUrl = imageUrl;
        Url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Data);
        dest.writeString(imageUrl);
        dest.writeString(Url);
    }

    public static ArrayList<Data> getGalaxyArrayList(){
        ArrayList<Data> galaxyArrayList = new ArrayList<>();
        galaxyArrayList.add(new Data("Earth", "Hello", "https://en.wikipedia.org/wiki/Earth",""));

        return galaxyArrayList;
    }

    public static ArrayList<Data> getPlanetArrayList(){
        ArrayList<Data> planetArrayList = new ArrayList<>();
        planetArrayList.add(new Data("Earth","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));
        planetArrayList.add(new Data("Mars","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));
        planetArrayList.add(new Data("Jupiter","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));
        planetArrayList.add(new Data("Neptune","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));
        planetArrayList.add(new Data("Venus","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));

        return planetArrayList;
    }

    public static ArrayList<Data> getStarArrayList() {
        ArrayList<Data> starArrayList = new ArrayList<>();

        return starArrayList;
    }
}

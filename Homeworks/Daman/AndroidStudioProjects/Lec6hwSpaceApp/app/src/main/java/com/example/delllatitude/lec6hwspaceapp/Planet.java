package com.example.delllatitude.lec6hwspaceapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Planet implements Parcelable {
    private String planetName, planetData, planetUrl, planetImage;

    public Planet(String planetName, String planetData, String planetUrl, String planetImage) {
        this.planetName = planetName;
        this.planetData = planetData;
        this.planetUrl = planetUrl;
        this.planetImage = planetImage;
    }

    protected Planet(Parcel in) {
        planetName = in.readString();
        planetData = in.readString();
        planetUrl = in.readString();
        planetImage = in.readString();
    }

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetData() {
        return planetData;
    }

    public void setPlanetData(String planetData) {
        this.planetData = planetData;
    }

    public String getPlanetUrl() {
        return planetUrl;
    }

    public void setPlanetUrl(String planetUrl) {
        this.planetUrl = planetUrl;
    }

    public String getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(String planetImage) {
        this.planetImage = planetImage;
    }

    public static ArrayList<Planet> getPlanetArrayList(){
        ArrayList<Planet> planetArrayList = new ArrayList<>();
        planetArrayList.add(new Planet("Earth","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));
        planetArrayList.add(new Planet("Mars","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));
        planetArrayList.add(new Planet("Jupiter","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));
        planetArrayList.add(new Planet("Neptune","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));
        planetArrayList.add(new Planet("Venus","This is the third planet from Sun",
                "https://en.wikipedia.org/wiki/Earth",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/1024px-The_Earth_seen_from_Apollo_17.jpg"));

        return planetArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(planetName);
        dest.writeString(planetData);
        dest.writeString(planetUrl);
        dest.writeString(planetImage);
    }
}
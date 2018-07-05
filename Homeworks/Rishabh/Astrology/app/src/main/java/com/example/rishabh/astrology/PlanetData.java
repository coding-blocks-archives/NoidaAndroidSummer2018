package com.example.rishabh.astrology;

import java.util.ArrayList;

public class PlanetData {

    String Name,ImageUrl;

    public PlanetData(String name, String imageUrl) {
        Name = name;
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public static ArrayList<PlanetData> getPlanetData()
    {
        ArrayList<PlanetData> planetData = new ArrayList<PlanetData>();

        planetData.add(new PlanetData("Mercury","https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg"));
        planetData.add(new PlanetData("Venus","https://en.wikipedia.org/wiki/Earth#/media/File:The_Earth_seen_from_Apollo_17.jpg"));
        planetData.add(new PlanetData("Earth","https://en.wikipedia.org/wiki/Earth#/media/File:The_Earth_seen_from_Apollo_17.jpg"));
        planetData.add(new PlanetData("Mars","https://en.wikipedia.org/wiki/Earth#/media/File:The_Earth_seen_from_Apollo_17.jpg"));
        planetData.add(new PlanetData("Jupiter","https://en.wikipedia.org/wiki/Earth#/media/File:The_Earth_seen_from_Apollo_17.jpg"));
        planetData.add(new PlanetData("Saturn","https://en.wikipedia.org/wiki/Earth#/media/File:The_Earth_seen_from_Apollo_17.jpg"));
        planetData.add(new PlanetData("Uranus","https://en.wikipedia.org/wiki/Earth#/media/File:The_Earth_seen_from_Apollo_17.jpg"));
        planetData.add(new PlanetData("Neptune","https://en.wikipedia.org/wiki/Earth#/media/File:The_Earth_seen_from_Apollo_17.jpg"));

        return planetData;
    }
}

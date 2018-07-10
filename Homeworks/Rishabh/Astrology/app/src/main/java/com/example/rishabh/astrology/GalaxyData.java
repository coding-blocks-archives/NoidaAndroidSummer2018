package com.example.rishabh.astrology;

import java.util.ArrayList;

public class GalaxyData {

    String Name , ImageUrl;

    public GalaxyData(String name, String imageUrl) {
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

    public static ArrayList<GalaxyData> getGalaxyData()
    {

        ArrayList<GalaxyData> GalaxyData = new ArrayList<GalaxyData>();

        GalaxyData.add(new GalaxyData("Milky Way","https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg"));
        GalaxyData.add(new GalaxyData("Andromeda","https://en.wikipedia.org/wiki/File:Andromeda_Galaxy_(with_h-alpha).jpg"));
        GalaxyData.add(new GalaxyData("Black Eye Galaxy","https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg"));
        GalaxyData.add(new GalaxyData("Bode's Galaxy","https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg"));
        GalaxyData.add(new GalaxyData("Cigar Galaxy","https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg"));
        GalaxyData.add(new GalaxyData("Comet Galaxy","https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg"));
        GalaxyData.add(new GalaxyData("Cosmos Redshift 7","https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg"));

        return GalaxyData;
    }
}

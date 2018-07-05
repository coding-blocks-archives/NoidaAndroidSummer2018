package com.example.rishabh.astrology;

import java.util.ArrayList;

public class StarData {

    String Name , ImageUrl;

    public StarData(String name, String imageUrl) {
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


    public static ArrayList<StarData> getStarData()
    {
        ArrayList<StarData> StarData = new ArrayList<StarData>();

        StarData.add(new StarData("Sirius","https://www.thoughtco.com/thmb/I-wTt6kjuR8b0mdn5WKB0kGIOig=/768x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Sirius-58d14cc33df78c3c4fbc0ddf.jpg"));
        StarData.add(new StarData("Canopus","https://www.thoughtco.com/thmb/nszbypFqBIHLJbZts_yku07r7dg=/768x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Canopus-58d14d585f9b581d7245ccc7.jpg"));
        StarData.add(new StarData("Rigel Kentaurus","https://www.thoughtco.com/thmb/0qLiliiATyA7np6giXzA8-a_rEM=/768x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/1280px-Alpha-_Beta_and_Proxima_Centauri-58b82f915f9b58808098a7fd.jpg"));
        StarData.add(new StarData("Arcturus","https://en.wikipedia.org/wiki/Star#/media/File:Starsinthesky.jpg"));
        StarData.add(new StarData("Sun","https://en.wikipedia.org/wiki/Star#/media/File:Starsinthesky.jpg"));
        StarData.add(new StarData("Vega","https://en.wikipedia.org/wiki/Star#/media/File:Starsinthesky.jpg"));
        StarData.add(new StarData("Rigel","https://en.wikipedia.org/wiki/Star#/media/File:Starsinthesky.jpg"));

        return StarData;
    }
}

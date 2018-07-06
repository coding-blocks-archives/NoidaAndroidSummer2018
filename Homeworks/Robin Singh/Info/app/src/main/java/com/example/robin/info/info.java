package com.example.robin.info;

import java.util.ArrayList;

public class info  {
    private String name,profession,imageurl;

    public info(String name, String profession, String imageurl) {
        this.name = name;
        this.profession = profession;
        this.imageurl = imageurl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public static ArrayList<info> getinfo(){
        ArrayList<info> infoArrayList = new ArrayList<>();
        infoArrayList.add(new info("kelly matthews","Android developer","https://randomuser.me/api/portraits/women/22.jpg"));
        infoArrayList.add(new info("nina fernandez","web developer","https://randomuser.me/api/portraits/women/54.jpg"));
        return infoArrayList;
    }
}

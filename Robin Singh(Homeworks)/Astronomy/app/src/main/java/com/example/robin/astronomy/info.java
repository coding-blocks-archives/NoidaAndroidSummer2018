package com.example.robin.astronomy;

import java.util.ArrayList;

public class info {

    private String name, detail,imgurl,url;
    int i;

    public info(String name, String detail, String imgurl ,int i,String url) {
        this.name = name;
        this.detail = detail;
        this.imgurl = imgurl;
        this.i=i;
        this.url=url;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public static ArrayList<info> getinfo(){
        ArrayList<info> infoArrayList = new ArrayList<>();


        return infoArrayList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.example.shabnamkhatun.jsonh;

public class Article {

    String author, title, desc, url, imageUrl, date;

    public Article(String author, String title, String desc, String url, String imageUrl, String date) {
        this.author = author;
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.imageUrl = imageUrl;
        this.date = date;
//        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDate() {
        return date;
    }
}

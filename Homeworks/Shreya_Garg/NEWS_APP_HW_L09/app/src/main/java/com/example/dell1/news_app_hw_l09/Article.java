package com.example.dell1.news_app_hw_l09;

public class Article {

    String title,author,date,image,desc,link;

    public Article(String title, String author, String date, String image, String desc, String link) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.image = image;
        this.desc = desc;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }

    public String getLink() {
        return link;
    }
}

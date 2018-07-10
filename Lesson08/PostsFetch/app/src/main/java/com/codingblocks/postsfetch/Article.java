package com.codingblocks.postsfetch;

class Article {

    String author, title, desc, url, imageUrl, date;
    Source source;

    public Article(String author, String title, String desc, String url, String imageUrl, String date, Source source) {
        this.author = author;
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.imageUrl = imageUrl;
        this.date = date;
        this.source = source;
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

    public Source getSource() {
        return source;
    }
}

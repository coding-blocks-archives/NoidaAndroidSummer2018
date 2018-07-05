package com.codingblocks.newspaper;

public class News {
    String title, url,urltoImage;

    public News(String title,  String url, String urltoImage) {
        this.title = title;
//        this.description = description;
        this.url = url;
        this.urltoImage = urltoImage;
    }


    public String getTitle() {
        return title;
    }

//    public String getDescription() {
//        return description;
//    }

    public String getUrl() {
        return url;
    }

    public String getUrltoImage() {
        return urltoImage;
    }
}

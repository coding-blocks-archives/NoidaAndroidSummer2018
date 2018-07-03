package com.example.dell1.github_profiles_hw_l09;

public class User {

    String login,id,image,url;

    public User(String login, String id, String image, String url) {
        this.login = login;
        this.id = id;
        this.image = image;
        this.url = url;

    }

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }


}

package com.example.shabnamkhatun.githubapp2;

import com.google.gson.annotations.SerializedName;

public class User {

    String login;
    @SerializedName("avatar_url")
    String avatarurl;
    @SerializedName("html_url")
    String htmlurl;

    public String getLogin() {
        return login;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public String getHtmlurl() {
        return htmlurl;
    }
}

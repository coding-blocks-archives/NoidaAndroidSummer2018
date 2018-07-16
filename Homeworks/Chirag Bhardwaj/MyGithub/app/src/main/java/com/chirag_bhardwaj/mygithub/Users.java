package com.chirag_bhardwaj.mygithub;

import com.google.gson.annotations.SerializedName;

class Users {
    public String getLogin() {
        return login;
    }

    String login;
    @SerializedName("html_url")
    String htmlUrl;

    @SerializedName("avatar_url")
    String avatarUrl;

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
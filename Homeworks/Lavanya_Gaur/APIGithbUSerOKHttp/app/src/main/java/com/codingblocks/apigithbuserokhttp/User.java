package com.codingblocks.apigithbuserokhttp;

import com.google.gson.annotations.SerializedName;

public class User {

    private String login;

    private String url;

    public String getUrl() {
        return url;
    }

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }


}

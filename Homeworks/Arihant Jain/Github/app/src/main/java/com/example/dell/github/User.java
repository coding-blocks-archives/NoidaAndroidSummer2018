package com.example.dell.github;

import com.google.gson.annotations.SerializedName;



class User {



    private String login;



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
package com.codingblocks.apigithbuserokhttp;

import com.google.gson.annotations.SerializedName;

public class Details {

    private String name;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("avatar_url")
    private String avatarUrl;

    private String company , location ;


    public String getName() {
        return name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }
}

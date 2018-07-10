package com.codingblocks.apisearchusers;

public class GithubUsers {

    String login,html_url;
    String avatar_url;
    Integer id;
    Double score;


    public GithubUsers(String login, String html_url, String avatar_url, Integer id, Double score) {
        this.login = login;
        this.html_url = html_url;
        this.avatar_url = avatar_url;
        this.id = id;
        this.score = score;
    }

    public String getLogin() {
        return login;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public Integer getId() {
        return id;
    }

    public Double getScore() {
        return score;
    }
}

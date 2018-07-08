package garg.sarthik.github;

class Items {

    String login;
    String avatar_url;
    String url;

    public Items(String login, String avatar_url, String url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.url = url;
    }

    public String getLogin() {

        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getUrl() {
        return url;
    }
}

package garg.sarthik.github;

public class user_detail {

    String avatar_url;
    String name;
    String login;
    String bio;
    String location;
    String company;
    String blog;
    String repos_url;

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public String getCompany() {
        return company;
    }

    public String getBlog() {
        return blog;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public user_detail(String avatar_url, String name, String login, String bio, String location, String company, String blog, String repos_url) {

        this.avatar_url = avatar_url;
        this.name = name;
        this.login = login;
        this.bio = bio;
        this.location = location;
        this.company = company;
        this.blog = blog;
        this.repos_url = repos_url;
    }
}

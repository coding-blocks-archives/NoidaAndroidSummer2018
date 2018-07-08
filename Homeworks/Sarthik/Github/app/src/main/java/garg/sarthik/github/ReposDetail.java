package garg.sarthik.github;

public class ReposDetail {

    String name;
    String full_name;

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public ReposDetail(String name, String full_name) {

        this.name = name;
        this.full_name = full_name;
    }
}

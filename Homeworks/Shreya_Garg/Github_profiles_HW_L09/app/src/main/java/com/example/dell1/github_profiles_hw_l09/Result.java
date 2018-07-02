package com.example.dell1.github_profiles_hw_l09;

import java.util.ArrayList;

public class Result {

    private Integer totalCount;
    private Boolean incompleteResults;
    private ArrayList<User> users=new ArrayList<>();

    public Result(Integer totalCount, Boolean incompleteResults, ArrayList<User> users) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.users = users;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

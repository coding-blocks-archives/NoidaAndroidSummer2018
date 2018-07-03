package com.example.dell1.news_app_hw_l09;

import java.util.ArrayList;

public class Result {

    private String status;
    private Integer totalResults;
    private ArrayList<Article> articleArrayList=new ArrayList<>();

    public Result(String status, Integer totalResults, ArrayList<Article> articleArrayList) {
        this.status = status;
        this.totalResults = totalResults;
        this.articleArrayList = articleArrayList;
    }

    public String getStatus() {
        return status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public ArrayList<Article> getArticleArrayList() {
        return articleArrayList;
    }
}

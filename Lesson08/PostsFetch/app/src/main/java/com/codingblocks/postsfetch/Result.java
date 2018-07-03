package com.codingblocks.postsfetch;

import android.content.Intent;

import java.util.ArrayList;

public class Result {
    String status;
    Integer totalResults;
    ArrayList<Article> articles;

    public Result(String status, Integer totalResults, ArrayList<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }
}

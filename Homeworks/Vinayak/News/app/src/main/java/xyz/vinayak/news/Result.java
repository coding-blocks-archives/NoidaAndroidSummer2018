package xyz.vinayak.news;

import java.util.ArrayList;

public class Result {
    String status;
    int totalResults;
    ArrayList<Article> articleArrayList;

    public Result(String status, int totalResults, ArrayList<Article> articleArrayList) {
        this.status = status;
        this.totalResults = totalResults;
        this.articleArrayList = articleArrayList;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public ArrayList<Article> getArticleArrayList() {
        return articleArrayList;
    }
}

package garg.sarthik.news;

import java.util.ArrayList;

public class News {

    private ArrayList<Articles> articlesArrayList;

    public News(ArrayList<Articles> articlesArrayList) {

        this.articlesArrayList = articlesArrayList;
    }


    public ArrayList<Articles> getArticlesArrayList() {
        return articlesArrayList;
    }
}

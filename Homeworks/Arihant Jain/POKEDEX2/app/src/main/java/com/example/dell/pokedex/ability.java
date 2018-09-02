package com.example.dell.pokedex;

import java.io.Serializable;

public class ability implements Serializable {
    private String url;
    private String name;

    public ability(String name,String url)
    {
        this.name=name;
        this.url=url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}

package com.example.dell.pokedex;

import java.io.Serializable;

public class sprites implements Serializable{
    private String front_default;
    public sprites(String front_default){
        this.front_default=front_default;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }
}

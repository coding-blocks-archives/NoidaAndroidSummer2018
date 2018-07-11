package com.chirag_bhardwaj.pokedex;

import java.io.Serializable;

class Sprites implements Serializable {
    String front_default;

    public Sprites(String front_default) {
        this.front_default = front_default;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }
}
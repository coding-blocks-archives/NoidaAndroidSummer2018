package com.chirag_bhardwaj.pokedex;

import java.io.Serializable;

class Stat implements Serializable {
    String name;

    public Stat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
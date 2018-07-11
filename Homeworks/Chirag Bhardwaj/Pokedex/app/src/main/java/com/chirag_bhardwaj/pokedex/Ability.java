package com.chirag_bhardwaj.pokedex;

import java.io.Serializable;


class Ability implements Serializable{
    String name;

    public Ability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
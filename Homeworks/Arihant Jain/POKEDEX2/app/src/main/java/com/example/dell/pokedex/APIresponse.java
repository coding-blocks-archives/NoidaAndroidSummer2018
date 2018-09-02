package com.example.dell.pokedex;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;



public class APIresponse implements Serializable {
    private int id,height,weight;
    private String name;
    private ArrayList<abilities> abilities;
    private sprites sprites;
    private ArrayList<moves> moves;

    public APIresponse(int id,int height,int weight,String name,ArrayList<abilities> abilities,sprites sprites,ArrayList<moves> moves){
        this.id=id;
        this.height=height;
        this.weight=weight;
        this.name=name;
        this.abilities=abilities;
        this.sprites=sprites;
        this.moves=moves;
    }

    public ArrayList<com.example.dell.pokedex.moves> getMoves() {
        return moves;
    }

    public String getName() {
        return name;
    }

    public int getid() { return id; }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public ArrayList<com.example.dell.pokedex.abilities> getAbilities() {
        return abilities;
    }


    public sprites getSprites() {
        return sprites;
    }

}

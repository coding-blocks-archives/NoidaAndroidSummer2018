package com.example.shabnamkhatun.pokemonapi;

import android.widget.ArrayAdapter;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable {
    String name;
    Sprites sprites;
    Integer weight;
    Integer height;
    Integer id, order;
    @SerializedName("base_experience")
    Integer baseexperience;


    ArrayList<Ability> abilities;
    ArrayList<type> types;

    public String getName() {
        return name;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrder() {
        return order;
    }

    public Integer getBaseexperience() {
        return baseexperience;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public ArrayList<type> getTypes() {
        return types;
    }
}

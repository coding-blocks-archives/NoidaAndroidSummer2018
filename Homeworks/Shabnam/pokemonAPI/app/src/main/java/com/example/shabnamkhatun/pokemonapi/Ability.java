package com.example.shabnamkhatun.pokemonapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


class Ability implements Serializable {

//    @SerializedName("is_hidden")
//    String ishidden;
//    String slot;
//    String name;
//
//    public String getIshidden() {
//        return ishidden;
//    }
//
//    public String getSlot() {
//        return slot;
//    }
//
//    public String getName() {
//        return name;
//    }

    Name ability;

    public Name getAbility() {
        return ability;
    }
}
package com.codingblocks.pokedox;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class APIresponse implements Parcelable {

    private String name;
    private String weight;
    private String height;

    @SerializedName("base_experience")
    private String baseExp;

    private ArrayList<Types> types;

    Sprites sprites;

     private ArrayList<Abilities> abilities;

    public ArrayList<Abilities> getAbilities() {
        return abilities;
    }


    public APIresponse() {
    }



    public APIresponse(String name, String weight, String height, String baseExp, ArrayList<Types> types, Sprites sprites, ArrayList<Abilities> abilities) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.baseExp = baseExp;
        this.types = types;
        this.sprites = sprites;
        this.abilities = abilities;
    }

    protected APIresponse(Parcel in) {
        name = in.readString();
        weight = in.readString();
        height = in.readString();
        baseExp = in.readString();
        types = in.createTypedArrayList(Types.CREATOR);
        sprites = in.readParcelable(Sprites.class.getClassLoader());
    }

    public static final Creator<APIresponse> CREATOR = new Creator<APIresponse>() {
        @Override
        public APIresponse createFromParcel(Parcel in) {
            return new APIresponse(in);
        }

        @Override
        public APIresponse[] newArray(int size) {
            return new APIresponse[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getBaseExp() {
        return baseExp;
    }

    public ArrayList<Types> getTypes() {
        return types;
    }

    public Sprites getSprites() {
        return sprites;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(weight);
        parcel.writeString(height);
        parcel.writeString(baseExp);
        parcel.writeTypedList(types);
        parcel.writeParcelable(sprites, i);
    }
}

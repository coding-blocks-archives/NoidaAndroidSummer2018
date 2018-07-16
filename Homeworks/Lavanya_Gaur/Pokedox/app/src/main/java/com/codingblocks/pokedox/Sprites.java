package com.codingblocks.pokedox;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Sprites implements Parcelable {

    @SerializedName("back_default")
    private String backDefault;

    protected Sprites(Parcel in) {
        backDefault = in.readString();
    }

    public static final Creator<Sprites> CREATOR = new Creator<Sprites>() {
        @Override
        public Sprites createFromParcel(Parcel in) {
            return new Sprites(in);
        }

        @Override
        public Sprites[] newArray(int size) {
            return new Sprites[size];
        }
    };

    public String getBackDefault() {
        return backDefault;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(backDefault);
    }
}

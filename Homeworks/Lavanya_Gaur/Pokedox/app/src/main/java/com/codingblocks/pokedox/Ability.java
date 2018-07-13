package com.codingblocks.pokedox;

import android.os.Parcel;
import android.os.Parcelable;

public class Ability implements Parcelable {
    String name;

    protected Ability(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Ability> CREATOR = new Creator<Ability>() {
        @Override
        public Ability createFromParcel(Parcel in) {
            return new Ability(in);
        }

        @Override
        public Ability[] newArray(int size) {
            return new Ability[size];
        }
    };

    public String getName() {
        return name;
    }

    public Ability(String name) {

        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}

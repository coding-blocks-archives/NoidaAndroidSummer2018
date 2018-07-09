package com.codingblocks.pokedox;

import android.os.Parcel;
import android.os.Parcelable;

public class Type implements Parcelable{
    String name;

    protected Type(Parcel in) {
        name = in.readString();
    }

    public Type() {
    }

    public String getName() {
        return name;
    }

    public static final Creator<Type> CREATOR = new Creator<Type>() {
        @Override
        public Type createFromParcel(Parcel in) {
            return new Type(in);
        }

        @Override
        public Type[] newArray(int size) {
            return new Type[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}

package com.codingblocks.pokedox;

import android.os.Parcel;
import android.os.Parcelable;

public class Types implements Parcelable {

    Type type;

    public Types() {
    }

    protected Types(Parcel in) {
        type = in.readParcelable(Type.class.getClassLoader());
    }

    public static final Creator<Types> CREATOR = new Creator<Types>() {
        @Override
        public Types createFromParcel(Parcel in) {
            return new Types(in);
        }

        @Override
        public Types[] newArray(int size) {
            return new Types[size];
        }
    };

    public Type getType() {
        return type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(type, i);
    }
}

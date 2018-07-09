package com.codingblocks.pokedox;

import android.os.Parcel;
import android.os.Parcelable;

public class Abilities implements Parcelable {

    Integer slot;
    Ability ability;

    public Abilities() {
    }

    public Abilities(Integer slot, Ability ability) {

        this.slot = slot;
        this.ability = ability;
    }

    protected Abilities(Parcel in) {
        if (in.readByte() == 0) {
            slot = null;
        } else {
            slot = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (slot == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(slot);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Abilities> CREATOR = new Creator<Abilities>() {
        @Override
        public Abilities createFromParcel(Parcel in) {
            return new Abilities(in);
        }

        @Override
        public Abilities[] newArray(int size) {
            return new Abilities[size];
        }
    };

    public Integer getSlot() {
        return slot;
    }

    public Ability getAbility() {
        return ability;
    }
}

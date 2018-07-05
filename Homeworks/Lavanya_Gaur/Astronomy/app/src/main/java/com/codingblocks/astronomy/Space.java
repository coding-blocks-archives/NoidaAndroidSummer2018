package com.codingblocks.astronomy;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Space implements Parcelable{

    private String name, imageUrl, details , wikiUrl;
    private int type_item;


    protected Space(Parcel in) {
        name=in.readString();
        imageUrl=in.readString();
        details=in.readString();
        type_item=in.readInt();
        wikiUrl=in.readString();

    }

    public static final Creator<Space> CREATOR = new Creator<Space>() {
        @Override
        public Space createFromParcel(Parcel in) {
            return new Space(in);
        }

        @Override
        public Space[] newArray(int size) {
            return new Space[size];
        }
    };

    public Space(String name, String imageUrl, String details, String wikiUrl, int type_item) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.details = details;
        this.wikiUrl = wikiUrl;
        this.type_item = type_item;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public int getType_item() {
        return type_item;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(imageUrl);
        parcel.writeInt(type_item);
        parcel.writeString(details);
        parcel.writeString(wikiUrl);

    }
}

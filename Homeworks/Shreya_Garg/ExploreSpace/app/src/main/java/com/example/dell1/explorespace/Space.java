package com.example.dell1.explorespace;


import android.os.Parcel;
import android.os.Parcelable;


public class Space implements Parcelable {

    private String name, imageUrl,details,wikiUrl;

    private int type_item;

    protected Space(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
        type_item = in.readInt();
        details=in.readString();
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

    public Space(String name, String imageUrl, int type_item,String details,String wikiUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.type_item = type_item;
        this.details=details;
        this.wikiUrl=wikiUrl;
    }


    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getType_item() {
        return type_item;
    }

    public String getDetails() {
        return details;
    }

    public String getWikiUrl() {
        return wikiUrl;
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
package garg.ayush.astronomyapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Astronomy implements Parcelable {
    protected Astronomy(Parcel in) {
        urlImage = in.readString();
        name = in.readString();
        description = in.readString();
        urlDescription = in.readString();
    }

    public static final Creator<Astronomy> CREATOR = new Creator<Astronomy>() {
        @Override
        public Astronomy createFromParcel(Parcel in) {
            return new Astronomy(in);
        }

        @Override
        public Astronomy[] newArray(int size) {
            return new Astronomy[size];
        }
    };

    public String getUrlImage() {
        return urlImage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlDescription() {
        return urlDescription;
    }

    private String urlImage, name, description, urlDescription;

    public Astronomy(String urlImage, String name, String description, String urlDescription) {
        this.urlImage = urlImage;
        this.name = name;
        this.description = description;
        this.urlDescription = urlDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(urlImage);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(urlDescription);
    }
}

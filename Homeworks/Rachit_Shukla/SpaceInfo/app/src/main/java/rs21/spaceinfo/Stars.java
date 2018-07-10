package rs21.spaceinfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Stars implements Parcelable {
    private String name, url;

    public Stars(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


    public static ArrayList<Stars> getStars() {
        ArrayList<Stars> stars = new ArrayList<>();
        stars.add(new Stars("Sun", "https://en.wikipedia.org/wiki/Sun"));
        return stars;
    }

    protected Stars(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<Stars> CREATOR = new Creator<Stars>() {
        @Override
        public Stars createFromParcel(Parcel in) {
            return new Stars(in);
        }

        @Override
        public Stars[] newArray(int size) {
            return new Stars[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
    }
}

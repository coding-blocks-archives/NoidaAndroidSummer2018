package rs21.spaceinfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Galaxies implements Parcelable {
    private String name, url;

    public Galaxies(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


    public static ArrayList<Galaxies> getGalaxies() {
        ArrayList<Galaxies> galaxies = new ArrayList<>();
        galaxies.add(new Galaxies("Milky Way", "https://en.wikipedia.org/wiki/Milky_Way"));
        return galaxies;
    }

    protected Galaxies(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<Galaxies> CREATOR = new Creator<Galaxies>() {
        @Override
        public Galaxies createFromParcel(Parcel in) {
            return new Galaxies(in);
        }

        @Override
        public Galaxies[] newArray(int size) {
            return new Galaxies[size];
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

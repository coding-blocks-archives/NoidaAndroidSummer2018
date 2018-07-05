package rs21.spaceinfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Planets implements Parcelable {
    private String name, url;

    public Planets(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


    public static ArrayList<Planets> getPlanets() {
        ArrayList<Planets> planets = new ArrayList<>();
        planets.add(new Planets("Mercury", "https://en.wikipedia.org/wiki/Mercury_(planet)"));
        planets.add(new Planets("Venus", "https://en.wikipedia.org/wiki/Venus"));
        planets.add(new Planets("Earth", "https://en.wikipedia.org/wiki/Earth"));
        planets.add(new Planets("Mars", "https://en.wikipedia.org/wiki/Mars"));
        planets.add(new Planets("Jupiter", "https://en.wikipedia.org/wiki/Jupiter"));
        planets.add(new Planets("Saturn", "https://en.wikipedia.org/wiki/Saturn"));
        planets.add(new Planets("Uranus", "https://en.wikipedia.org/wiki/Uranus"));
        planets.add(new Planets("Neptune", "https://en.wikipedia.org/wiki/Neptune"));
        return planets;
    }

    protected Planets(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Creator<Planets> CREATOR = new Creator<Planets>() {
        @Override
        public Planets createFromParcel(Parcel in) {
            return new Planets(in);
        }

        @Override
        public Planets[] newArray(int size) {
            return new Planets[size];
        }
    };


}

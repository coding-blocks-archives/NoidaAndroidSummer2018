package rs21.infoviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class abc implements Parcelable {
    String name;
    int age;
    String url;

    public abc(String name, int age, String url) {
        this.name = name;
        this.age = age;
        this.url = url;
    }

    public static ArrayList<abc> getPersons() {
        ArrayList<abc> persons = new ArrayList<>();
        persons.add(new abc("Charlene", (int) 21, "https://randomuser.me/api/portraits/women/88.jpg"));
        persons.add(new abc("Henry", (int) 23, "https://randomuser.me/api/portraits/men/88.jpg"));
        persons.add(new abc("Leta", (int) 18, "https://randomuser.me/api/portraits/women/8.jpg"));
        persons.add(new abc("Moreno", (int) 51, "https://randomuser.me/api/portraits/men/21.jpg"));
        persons.add(new abc("Hazel", (int) 21, "https://randomuser.me/api/portraits/women/28.jpg"));
        persons.add(new abc("Sameer", (int) 32, "https://randomuser.me/api/portraits/men/48.jpg"));
        persons.add(new abc("Emma", (int) 40, "https://randomuser.me/api/portraits/women/83.jpg"));
        persons.add(new abc("Harry", (int) 20, "https://randomuser.me/api/portraits/men/32.jpg"));
        persons.add(new abc("Rohan", (int) 22, "https://randomuser.me/api/portraits/men/43.jpg"));
        persons.add(new abc("John", (int) 25, "https://randomuser.me/api/portraits/men/68.jpg"));
        return persons;
    }

    protected abc(Parcel in) {
        name = in.readString();
        age = in.readInt();
        url = in.readString();
    }

    public static final Creator<abc> CREATOR = new Creator<abc>() {
        @Override
        public abc createFromParcel(Parcel in) {
            return new abc(in);
        }

        @Override
        public abc[] newArray(int size) {
            return new abc[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(url);
    }
}
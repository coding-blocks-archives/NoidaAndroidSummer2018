package com.example.ashu.profile;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Profile implements Parcelable {

    String mImageUrl, mName, mLocation, mEmail, mJob, mBio;

    public Profile(String mImageUrl, String mName, String mLocation, String mEmail, String mJob, String mBio) {
        this.mImageUrl = mImageUrl;
        this.mName = mName;
        this.mLocation = mLocation;
        this.mEmail = mEmail;
        this.mJob = mJob;
        this.mBio = mBio;
    }


    protected Profile(Parcel in) {
        mImageUrl = in.readString();
        mName = in.readString();
        mLocation = in.readString();
        mEmail = in.readString();
        mJob = in.readString();
        mBio = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mImageUrl);
        dest.writeString(mName);
        dest.writeString(mLocation);
        dest.writeString(mEmail);
        dest.writeString(mJob);
        dest.writeString(mBio);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmName() {
        return mName;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmJob() {
        return mJob;
    }

    public String getmBio() {
        return mBio;
    }


    public static ArrayList<Profile> getProfile() {
        ArrayList<Profile> profileArrayList = new ArrayList<>();
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageM5.jpg",
                "Anthony Edwards", "Milwaukee", "anthony.edwards@example.com", "Product Designer",
                "I have a cat named Simon and a dog called Jon. Love the outdoors."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF31.jpg",
                "Diana Allen", "Phoenix", "anthony.edwards@example.com", "Software Engineer",
                "Deep thinker. Like talking about the world, religion and politics."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF18.jpg",
                "Lauren Harrison", "Detroit", "lauren.harrison@test.com", "Massage Therapist",
                "I'm passionate about making things fun and simple. Love Anime."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageM42.jpg",
                "Christopher Davis", "Indianapolis", "christopher.davis@fakemail.com", "Editor",
                "Originally from New York. I love golfing, running and rainy days."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageM45.jpg",
                "Adam Murray", "Cleveland", "adam.murray@test.com", "Librarian",
                "I have a passion for games and books. Avocado is my fuel."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF48.jpg",
                "Andrea Murphy", "New York", "andrea.murphy@fakemail.com", "Back End Developer",
                "Originally from New York City. Sports and music enthusiast."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageM15.jpg",
                "Leonardo Anderson", "Denver", "leonardo.anderson@fakemail.com", "Massage Therapist",
                "Social media lover and beer specialist. Love cats."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF39.jpg",
                "Maria Jackson", "New Orleans", "maria.jackson@fakemail.com", "Insurance Agent",
                "I have a passion for games and books. Avocado is my fuel."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF17.jpg",
                "Nicole Thomas", "Philadelphia", "nicole.thomas@example.com", "Chef",
                "I have a passion for architecture. Always eager to learn new things."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF8.jpg",
                "Nicole Morgan", "Pittsburgh", "nicole.morgan@example.com", "Executive Assistant",
                "I like minimalist furniture and comfortable chairs. Love orange juice."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF51.jpg",
                "Veronica Jenkins", "Atlanta", "veronica.jenkins@fakemail.com", "Public Relations Specialist",
                "Originally from Berlin. I love dubstep, kittens and hot coffee."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF3.jpg",
                "Courtney Clarke", "New York", "courtney.clarke@example.com", "Creative Director",
                "Dreamer who loves tee shirts, travelling and meeting new people."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageM28.jpg",
                "William Green", "Oakland", "william.green@example.com", "Motion Designer",
                "I have a passion to music, games and tennis. Love apple juice."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageF34.jpg",
                "Mary Anderson", "Seattle", "mary.anderson@fakemail.com", "Web Developer",
                "I love playing tennis, running and watching cat videos. Coffee is my friend."));
        profileArrayList.add(new Profile("http://www.designskilz.com/random-users/images/imageM46.jpg",
                "Mary Anderson", "Kansas City", "peter.wagner@test.com", "Front End Developer",
                "Friend of animals everywhere. Hardcore internet enthusiast and avid reader."));

      return profileArrayList;
    }
}

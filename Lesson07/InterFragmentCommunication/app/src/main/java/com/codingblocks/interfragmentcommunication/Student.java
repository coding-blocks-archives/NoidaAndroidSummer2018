package com.codingblocks.interfragmentcommunication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Parcelable{

    private String name, imageUrl, bio;

    public Student(String name, String imageUrl, String bio) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.bio = bio;
    }

    protected Student(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
        bio = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBio() {
        return bio;
    }

    public static ArrayList<Student> getStudents() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Harshit",
                "https://randomuser.me/api/portraits/women/80.jpg",
                "Janakpuri East"));
        studentArrayList.add(new Student("Shivam",
                "https://randomuser.me/api/portraits/women/81.jpg",
                "Greater Noida"));
        studentArrayList.add(new Student("Daman",
                "https://randomuser.me/api/portraits/women/82.jpg",
                "Noida Sector 15"));
        studentArrayList.add(new Student("Dheeraj",
                "https://randomuser.me/api/portraits/women/83.jpg",
                "Pitampura"));
        studentArrayList.add(new Student("Pranav",
                "https://randomuser.me/api/portraits/women/84.jpg",
                "Dwarka"));
        studentArrayList.add(new Student("Harshit",
                "https://randomuser.me/api/portraits/women/85.jpg",
                "Dwarka"));
        studentArrayList.add(new Student("Rishabh",
                "https://randomuser.me/api/portraits/women/86.jpg",
                "Noida"));
        studentArrayList.add(new Student("Sarthik",
                "https://randomuser.me/api/portraits/women/87.jpg",
                "Noida"));
        studentArrayList.add(new Student("Harshit",
                "https://randomuser.me/api/portraits/women/89.jpg",
                "Janakpuri East"));
        studentArrayList.add(new Student("Shivam",
                "https://randomuser.me/api/portraits/women/90.jpg",
                "Greater Noida"));
        studentArrayList.add(new Student("Daman",
                "https://randomuser.me/api/portraits/women/91.jpg",
                "Noida Sector 15"));
        studentArrayList.add(new Student("Dheeraj",
                "https://randomuser.me/api/portraits/women/92.jpg",
                "Pitampura"));
        studentArrayList.add(new Student("Pranav",
                "https://randomuser.me/api/portraits/women/93.jpg",
                "Dwarka"));
       return studentArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(imageUrl);
        parcel.writeString(bio);
    }
}

package com.codingblocks.debugger;

public class Student {

    private String name, location, batch;

    public Student(String name, String location, String batch) {
        this.name = name;
        this.location = location;
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}

package com.example.dell1.hw_lesson06;

public class Name {
    String name,imgUrl,nameText,BioDescription;

    public Name(String name,String imgUrl, String nameText, String bioDescription) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.nameText = nameText;
        BioDescription = bioDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    public String getBioDescription() {
        return BioDescription;
    }

    public void setBioDescription(String bioDescription) {
        BioDescription = bioDescription;
    }
}

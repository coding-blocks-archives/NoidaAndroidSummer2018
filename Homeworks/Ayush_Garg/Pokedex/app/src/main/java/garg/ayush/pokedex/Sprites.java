package garg.ayush.pokedex;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class Sprites implements Serializable {

    @SerializedName("front_default")
    public String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }
}

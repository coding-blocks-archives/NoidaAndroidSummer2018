package garg.ayush.pokedex;

import org.json.JSONObject;

import java.util.ArrayList;

public class Pokemon {


    ArrayList<Abilities> abilities;
    ArrayList<Stats> stats;
    ArrayList<Moves> moves;
    String name, id;
    Sprites sprites;

    public ArrayList<Moves> getMoves() {
        return moves;
    }

    public ArrayList<Stats> getStats() {
        return stats;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Abilities> getAbilities() {
        return abilities;
    }
}

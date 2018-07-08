package garg.ayush.astronomyapp;

import java.util.ArrayList;

public class Planets {

    public static ArrayList<Astronomy> getPlanets(){
        ArrayList<Astronomy> PlanetsArrayList = new ArrayList<>();
        PlanetsArrayList.add(new Astronomy("http://www.nasa.gov/centers/goddard/images/content/638831main_globe_east_2048.jpg",
                "Earth",
                "Earth is the third planet from the Sun and the only astronomical object known to harbor life. According to radiometric dating and other sources of evidence, Earth formed over 4.5 billion years ago.",
                "https://en.wikipedia.org/wiki/Earth"));
        PlanetsArrayList.add(new Astronomy("https://upload.wikimedia.org/wikipedia/commons/0/02/OSIRIS_Mars_true_color.jpg",
                "Mars",
                "Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury.",
                "https://en.wikipedia.org/wiki/Mars"));
        PlanetsArrayList.add(new Astronomy("https://upload.wikimedia.org/wikipedia/commons/0/02/OSIRIS_Mars_true_color.jpg",
                "Jupiter",
                "Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a giant planet with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined.",
                "https://en.wikipedia.org/wiki/Jupiter"));
        PlanetsArrayList.add(new Astronomy("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtM-aGBInBp2qlOhAZNNFA9nweddfaX8uvuyK4XrmbyPU5V15b",
                "Saturn",
                "Saturn is the sixth planet from the Sun and the second-largest in the Solar System, after Jupiter. It is a gas giant with an average radius about nine times that of Earth. ",
                "https://en.wikipedia.org/wiki/Saturn"));
        PlanetsArrayList.add(new Astronomy("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnGh_RbQJYADlSiRgaWaNaefZ-TTsR6KKTDTJkADWUVSDRhtSYsQ",
                "Venus",
                "Venus is the second planet from the Sun, orbiting it every 224.7 Earth days. It has the longest rotation period of any planet in the Solar System and rotates in the opposite direction to most other planets. ",
                "https://en.wikipedia.org/wiki/Venus"));
        PlanetsArrayList.add(new Astronomy("https://upload.wikimedia.org/wikipedia/commons/d/d9/Mercury_in_color_-_Prockter07-edit1.jpg",
                "Mercury",
                "Mercury is the smallest and innermost planet in the Solar System. Its orbital period around the Sun of 87.97 days is the shortest of all the planets in the Solar System.",
                "https://en.wikipedia.org/wiki/Mercury_(planet)"));
        return PlanetsArrayList;
    }
}

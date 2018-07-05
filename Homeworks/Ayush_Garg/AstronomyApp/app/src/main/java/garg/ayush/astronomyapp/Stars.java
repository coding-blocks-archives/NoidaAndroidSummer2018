package garg.ayush.astronomyapp;

import java.util.ArrayList;

public class Stars {


    public static ArrayList<Astronomy> getStars() {
        ArrayList<Astronomy> StarsArrayList = new ArrayList<>();
        StarsArrayList.add(new Astronomy("https://www.universetoday.com/wp-content/uploads/2009/11/opo9604b-e1432589560732-1024x739.jpg",
                "Betelgeuse",
                "Betelgeuse, also designated Alpha Orionis, is the ninth-brightest star in the night sky and second-brightest in the constellation of Orion.",
                "https://en.wikipedia.org/wiki/Betelgeuse"));
        StarsArrayList.add(new Astronomy("https://s23711.pcdn.co/wp-content/uploads/2017/06/Polaris-Star-Graphic-i466605914_1457x2061.jpg",
                "Polaris",
                "Polaris, designated Alpha Ursae Minoris , commonly the North Star or Pole Star, is the brightest star in the constellation of Ursa Minor. ",
                "https://en.wikipedia.org/wiki/Polaris"));
        StarsArrayList.add(new Astronomy("https://s23711.pcdn.co/wp-content/uploads/2017/06/Polaris-Star-Graphic-i466605914_1457x2061.jpg",
                "Sirius",
                "Sirius is a star system and the brightest star in the Earth's night sky.",
                "https://en.wikipedia.org/wiki/Sirius"));
        StarsArrayList.add(new Astronomy("https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Alpha%2C_Beta_and_Proxima_Centauri_%281%29.jpg/1200px-Alpha%2C_Beta_and_Proxima_Centauri_%281%29.jpg",
                "Alpha Centauri",
                "Alpha Centauri is the star system closest to the Solar System, being 4.37 light-years from the Sun.",
                "https://en.wikipedia.org/wiki/Alpha_Centauri"));
        StarsArrayList.add(new Astronomy("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdEWvqDX1zlgzQiO6pNkl-fWa9BwdpqNcjRx5Wg66wYj1AIdCq",
                "Pleiades",
                "The Pleiades, are an open star cluster containing middle-aged, hot B-type stars located in the constellation of Taurus.",
                "https://en.wikipedia.org/wiki/Pleiades"));
        StarsArrayList.add(new Astronomy("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPmba2bYcsQOlTMvMf1X7bdYcYMPSFKplVjQNwaaB0nKwLSBELNg",
                "Vega",
                "Vega, also designated Alpha Lyrae, is the brightest star in the constellation of Lyra, the fifth-brightest star in the night sky, and the second-brightest star in the northern celestial hemisphere, after Arcturus.",
                "https://en.wikipedia.org/wiki/Vega"));

        return StarsArrayList;
    }
}

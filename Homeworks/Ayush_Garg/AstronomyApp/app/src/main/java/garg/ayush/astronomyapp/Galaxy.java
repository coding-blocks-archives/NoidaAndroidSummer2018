package garg.ayush.astronomyapp;

import java.util.ArrayList;

public class Galaxy {

        public static ArrayList<Astronomy> getGalaxy() {
            ArrayList<Astronomy> GalaxyArrayList = new ArrayList<>();

            GalaxyArrayList.add(new Astronomy("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Milky_Way_Night_Sky_Black_Rock_Desert_Nevada.jpg/220px-Milky_Way_Night_Sky_Black_Rock_Desert_Nevada.jpg",
                    "Milky Way",
                    "The Milky Way is the galaxy that contains our Solar System.",
                    "https://en.wikipedia.org/wiki/Milky_Way"));
            GalaxyArrayList.add(new Astronomy("http://www.nasa.gov/sites/default/files/thumbnails/image/m51-and-companion_0.jpg",
                    "Whirlpool Galaxy",
                    "The Whirlpool Galaxy, also known as Messier 51a, M51a, and NGC 5194, is an interacting grand-design spiral galaxy with a Seyfert 2 active galactic nucleus.",
                    "https://en.wikipedia.org/wiki/Whirlpool_Galaxy"));
            GalaxyArrayList.add(new Astronomy("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/WISE-_Andromeda.jpg/220px-WISE-_Andromeda.jpg",
                    "Andromeda Galaxy",
                    "The Andromeda Galaxy, also known as Messier 31, M31, or NGC 224, is a spiral galaxy approximately 780 kiloparsecs from Earth, and the nearest major galaxy to the Milky Way.",
                    "https://en.wikipedia.org/wiki/Andromeda_Galaxy"));
            GalaxyArrayList.add(new Astronomy("http://coolcosmos.ipac.caltech.edu/cosmic_classroom/multiwavelength_astronomy/multiwavelength_museum/images/m82color.jpg",
                    "Messier 82",
                    "Messier 82 is a starburst galaxy approximately 12 million light-years away in the constellation Ursa Major.",
                    "https://en.wikipedia.org/wiki/Messier_82"));
            GalaxyArrayList.add(new Astronomy("http://www.nasa.gov/sites/default/files/thumbnails/image/black-eye-galaxy-print.jpg",
                    "Black Eye Galaxy",
                    "The Black Eye Galaxy is a galaxy which was discovered by Edward Pigott in March 1779, and independently by Johann Elert Bode in April of the same year, as well as by Charles Messier in 1780.",
                    "https://en.wikipedia.org/wiki/Black_Eye_Galaxy"));
            GalaxyArrayList.add(new Astronomy("https://upload.wikimedia.org/wikipedia/commons/f/f7/Sombrero_Galaxy_%28also_known_as_Messier_Object_104%2C_M104_or_NGC_4594%29_%28cropped%29.jpg",
                    "Sombrero Galaxy\n",
                    "The Sombrero Galaxy is a spiral galaxy in the constellation Virgo located 9.55 Mpc from Earth. The galaxy has a diameter of approximately 15kpc, 30% the size of the Milky Way. ",
                    "https://en.wikipedia.org/wiki/Sombrero_Galaxy"));

            return GalaxyArrayList;

        }
}

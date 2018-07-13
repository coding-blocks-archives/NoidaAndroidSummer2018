package com.example.shabnamkhatun.astronomy;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Celestial> planetsarrayList = new ArrayList<>();
    ArrayList<Celestial> starsArrayList = new ArrayList<>();
   ArrayList<Celestial> galaxyArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planetsarrayList.add(new Celestial("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Jupiter_and_its_shrunken_Great_Red_Spot.jpg/330px-Jupiter_and_its_shrunken_Great_Red_Spot.jpg",
                "Jupiter",
                "Jupiter is the fifth planet from the Sun and the largest in the Solar System.",
                "https://en.wikipedia.org/wiki/Jupiter"
                ));
        planetsarrayList.add((new Celestial("http://www.nasa.gov/centers/goddard/images/content/638831main_globe_east_2048.jpg",
                "Earth",
                "Earth is the third planet from the Sun and the only astronomical object known to harbor life. According to radiometric dating and other sources of evidence, Earth formed over 4.5 billion years ago.",
                "https://en.wikipedia.org/wiki/Earth")));


        starsArrayList.add(new Celestial("https://www.universetoday.com/wp-content/uploads/2009/11/opo9604b-e1432589560732-1024x739.jpg",
                "Betelgeuse",
                "Betelgeuse, also designated Alpha Orionis, is the ninth-brightest star in the night sky and second-brightest in the constellation of Orion.",
                "https://en.wikipedia.org/wiki/Betelgeuse"));
        starsArrayList.add(new Celestial("https://s23711.pcdn.co/wp-content/uploads/2017/06/Polaris-Star-Graphic-i466605914_1457x2061.jpg",
                "Polaris",
                "Polaris, designated Alpha Ursae Minoris , commonly the North Star or Pole Star, is the brightest star in the constellation of Ursa Minor. ",
                "https://en.wikipedia.org/wiki/Polaris"));

        galaxyArrayList.add(new Celestial("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/NGC_4414_%28NASA-med%29.jpg/465px-NGC_4414_%28NASA-med%29.jpg"," NGC 4414","NGC 4414, a typical spiral galaxy in the constellation Coma Berenices, " +
                "is about 55,000 light-years in diameter and approximately 60 million light-years away from Earth.","https://en.wikipedia.org/wiki/File:NGC_4414_(NASA-med).jpg"));


        ViewPager viewPager = findViewById(R.id.ViewPager);
        TabLayout tabLayout = findViewById(R.id.TabLayout);
        viewPager.setAdapter(new MyPager(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


    }

    class MyPager extends FragmentPagerAdapter{

        public MyPager(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return "Planet";
                case 1:
                    return "Stars";
                case 2:
                    return "Galaxies";
            }
            return "";
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0 :
                    Log.e("TAG", "getItem: ");
                    return new FragmentA(planetsarrayList);
                case 1:
                    Log.e("TAG", "getItem: ");
                    return new FragmentA(starsArrayList);
                case 2:
                    Log.e("TAG", "getItem: ");
                    return  new FragmentA(galaxyArrayList);
            }
            return null;
        }


        @Override
        public int getCount() {
            return 3;
        }
    }
}

package com.chirag_bhardwaj.myspaceapp;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity implements Communicator{

    ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp=findViewById(R.id.viewPager);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(vp);
    }

    public void startFragmentDetail(Fragment detailFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.detailfragment,detailFragment).commit();

    }


    class MyPagerAdapter extends FragmentPagerAdapter{

        FragmentPlanet fragmentPlanet=new FragmentPlanet();
        FragmentStar fragmentStar=new FragmentStar();
        FragmentGalaxy fragmentGalaxy=new FragmentGalaxy();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return fragmentPlanet  ;
                case 1:
                    return fragmentStar   ;
                case 2:
                    return fragmentGalaxy;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "PLANETS";
                case 1:
                    return "STARS";
                case 2:
                    return "GALAXIES";
            }
            return "";
        }
    }

}
package com.example.rishabh.astrology;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.viewpager);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tl = findViewById(R.id.tablayout);
        tl.setupWithViewPager(vp);


    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0: {
                    return new Fragment_planet();
                }
                case 1: {
                    return new Fragment_star();
                }
                case 2: {
                    return new Fragment_galaxy();
                }
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: {
                    return "PLANET";
                }
                case 1: {
                    return "STAR";
                }
                case 2: {
                    return "GALAXY";
                }
                default:
                    return null;

            }
        }
    }
}

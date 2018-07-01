package com.example.robin.astronomy;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(vp);
    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Planet";
                case 1:
                    return "Stars";
                case 2:
                    return "Galaxy";
            }
            return " ";
        }
        @Override
        public Fragment getItem(int position) {

            switch(position){
                case 0:
                    return new Planet();
                case 1 :
                    return  new Stars();
                case 2:
                    return  new Galaxy();
            }
            return  null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}

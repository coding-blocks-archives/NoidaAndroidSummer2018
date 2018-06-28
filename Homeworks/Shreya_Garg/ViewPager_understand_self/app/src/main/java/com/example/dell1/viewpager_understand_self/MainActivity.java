package com.example.dell1.viewpager_understand_self;

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
        ViewPager vp=findViewById(R.id.viewPager);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tb=findViewById(R.id.tabLayout);
        tb.setupWithViewPager(vp);
    }

    ///this extends FragmentPagerAdapter which includes a member named Fragment Mangager fm(Click+ctrl to see) which itself internally does all the work of adding
    ///fragment to the activity.So it is mandatory to create the constructor of our own pagerAdapter
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Home";
                case 1:
                    return "Chats";
                case 2:
                    return "Help";
            }
            return "";
        }
        @Override
        ///ith page pe jo bhi item chahiye woh bta do
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new FragmentA();
                case 1:
                    return new FragmentB();
                case 2:
                    return new FragmentC();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}

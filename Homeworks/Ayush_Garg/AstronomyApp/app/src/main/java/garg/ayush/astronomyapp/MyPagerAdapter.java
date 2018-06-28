package garg.ayush.astronomyapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Planets";
            case 1:
                return "Stars";
            case 2:
                return "Galaxy";
        }
        return "";
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentPlanets();
            case 1:
                return new FragmentStars();
            case 2 :
                return new FragmentGalaxy();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
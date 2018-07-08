package rs21.spaceinfo;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rs21.spaceinfo.Galaxy.FragDetailGalaxy;
import rs21.spaceinfo.Galaxy.FragGalaxies;
import rs21.spaceinfo.Planet.FragDetailPlanet;
import rs21.spaceinfo.Planet.FragPlanets;
import rs21.spaceinfo.Star.FragDetailStar;
import rs21.spaceinfo.Star.FragStars;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.viewPager);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(vp);
    }

    public void addFragG(FragDetailGalaxy b) {
        getSupportFragmentManager().beginTransaction().replace(R.id.detail, b).commit();
    }

    public void addFragP(FragDetailPlanet b) {
        getSupportFragmentManager().beginTransaction().replace(R.id.detail, b).commit();
    }

    public void addFragS(FragDetailStar b) {
        getSupportFragmentManager().beginTransaction().replace(R.id.detail, b).commit();
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
                    return "Planets";
                case 1:
                    return "Stars";
                case 2:
                    return "Galaxies";
            }
            return "";
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new FragPlanets();
                case 1:
                    return new FragStars();
                case 2:
                    return new FragGalaxies();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}


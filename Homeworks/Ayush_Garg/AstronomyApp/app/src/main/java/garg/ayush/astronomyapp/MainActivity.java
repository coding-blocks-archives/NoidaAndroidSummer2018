package garg.ayush.astronomyapp;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "onCreate: ");
        setContentView(R.layout.activity_main);
        LinearLayout ll = findViewById(R.id.activity_main_detail);
        if (ll != null) {
            ViewPager vp = findViewById(R.id.ViewPager);
            vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
            TabLayout tabLayout = findViewById(R.id.TabLayout);
            tabLayout.setupWithViewPager(vp);
        } else {
            ViewPager vp = findViewById(R.id.ViewPager);
            vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
            TabLayout tabLayout = findViewById(R.id.TabLayout);
            tabLayout.setupWithViewPager(vp);
        }
    }

    void addFragment(FragmentDetailsLandscape fragmentDetailsLandscape) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_detail, fragmentDetailsLandscape)
                .commit();
    }
}

package com.codingblocks.masterdetaillistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerListFragment, new ListFragment())
                .commit();

    }

    void startFragmentDetail(DetailFragment detailFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerDetailFragment, detailFragment)
                .commit();
    }

}

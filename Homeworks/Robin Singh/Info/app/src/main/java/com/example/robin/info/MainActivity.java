package com.example.robin.info;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<info> infoArrayList = new ArrayList<>();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //infoArrayList.add(new info("kelly matthews","Android developer","https://randomuser.me/api/portraits/women/22.jpg"));
        //infoArrayList.add(new info("nina fernandez","web developer","https://randomuser.me/api/portraits/women/54.jpg"));
        FragmentA fragmentA = new FragmentA();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl1, fragmentA)
                .commit();

    }

    void startFragmentDetail(FragmentB detailFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl2, detailFragment)
                .commit();
    }

}

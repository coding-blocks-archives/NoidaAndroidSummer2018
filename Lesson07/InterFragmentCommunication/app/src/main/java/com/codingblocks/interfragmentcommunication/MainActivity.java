package com.codingblocks.interfragmentcommunication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerListFragment, new ListFragment())
                .commit();
    }

    @Override
    public void startFragmentB(DetailFragment detailFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerDetailFragment, detailFragment)
                .commit();
    }
}

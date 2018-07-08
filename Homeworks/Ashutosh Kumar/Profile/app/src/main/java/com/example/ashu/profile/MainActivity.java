package com.example.ashu.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.listFragmentContainer,new ListFragment())
                .commit();
    }

    @Override
    public void startFragmentDetail(DetailFragment detailFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detailFragmentContainer,detailFragment)
                .commit();

    }

}

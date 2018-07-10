package com.example.dhirajchhabraeng.homework;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserListFragment userListFragment = new UserListFragment();
        startFragmentList(userListFragment);
    }

    @Override
    public void startFragmentList(Fragment listFragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.userList_fragment, listFragment)
                .commit();
    }

    @Override
    public void startFragmentDetails(Fragment detailsFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.userDetails_fragment, detailsFragment).commit();
    }

    @Override
    public void onHandleClick(Fragment fragment) {
        if (findViewById(R.id.userDetails_fragment) == null) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("Fragment", (Serializable) fragment);
            startActivity(intent);
        } else {
            startFragmentDetails(fragment);
        }
    }
}

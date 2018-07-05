package com.example.dhirajchhabraeng.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDetailsFragment userDetailsFragment = (UserDetailsFragment) getIntent().getSerializableExtra("Fragment");

        getSupportFragmentManager().beginTransaction().replace(R.id.userList_fragment, userDetailsFragment).commit();
    }
}

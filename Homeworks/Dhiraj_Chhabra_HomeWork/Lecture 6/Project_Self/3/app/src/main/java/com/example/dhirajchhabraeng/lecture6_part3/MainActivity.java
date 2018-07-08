package com.example.dhirajchhabraeng.lecture6_part3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragA, new FragmentA())
                .commit();
    }

    void addFragmentB(FragmentB fragmentB) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragB, fragmentB)
                .commit();
    }
}

package com.codingblocks.dynamicfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add fragment A here

        FragmentA fragmentA = new FragmentA();
//        FragmentA fragmentA1 = new FragmentA();
//        FragmentA fragmentA2 = new FragmentA();
//        FragmentA fragmentA3 = new FragmentA();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragAContainer, fragmentA)
//                .add(R.id.fragAContainer,fragmentA1)
//                .add(R.id.fragAContainer,fragmentA2)
//                .add(R.id.fragAContainer,fragmentA3)
//                .remove(fragmentA3)
//                .remove(fragmentA2)
                .commit();
    }

    void addFragmentB(FragmentB fragmentB) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragBContainer, fragmentB)
                .commit();
    }

}

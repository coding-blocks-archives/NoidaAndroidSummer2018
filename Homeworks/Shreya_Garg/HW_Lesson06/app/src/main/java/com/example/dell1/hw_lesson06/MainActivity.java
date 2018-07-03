package com.example.dell1.hw_lesson06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment_1 f1=new Fragment_1();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_1,f1).commit(); //instead of f1 can write new Fragment_1()

    }
    void addFragment2(Fragment_2 f2){
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_2,f2).commit();
    }
}

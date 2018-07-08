package com.example.dhirajchhabraeng.lecture6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Object> objectsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objectsList.add(new ImageData("https://randomuser.me/api/portraits/women/64.jpg"));
        objectsList.add(new TextData("dhiraj"));
        objectsList.add(new ImageData("https://randomuser.me/api/portraits/women/65.jpg"));
        objectsList.add(new TextData("daman"));

    }
}

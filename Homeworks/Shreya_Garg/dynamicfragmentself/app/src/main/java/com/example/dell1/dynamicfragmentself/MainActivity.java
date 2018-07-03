package com.example.dell1.dynamicfragmentself;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override

    //we want fragment_1 in the display as soon as it is created so it should be added in this onCreate() and
    //inflated in its own method onCreateView() .However , we want fragment_2 as soon as the the button of increment is pressed
    //so it should be created in the onClick event of increment i.e. after creation of fragement_1 and its inflation.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment_1 f1=new fragment_1();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_1_layout,f1).commit();
    }
    void addFragment2(fragment_2 f2)
    {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_2_layout,f2).commit();
    }
}

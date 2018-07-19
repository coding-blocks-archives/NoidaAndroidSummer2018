package com.codingblocks.workmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSchedule = findViewById(R.id.btnSchedule);
        btnSchedule.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {



    }
}

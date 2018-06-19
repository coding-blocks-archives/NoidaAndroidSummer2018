package com.codingblocks.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String enteredvalue = i.getStringExtra("KEY");
        int receivedInt = i.getIntExtra("KEY2",0);

        TextView textView = findViewById(R.id.tvSecond);

        textView.setText(enteredvalue);

//        Bundle b = new Bundle();
//        b.putInt("KEY",1);
    }

}

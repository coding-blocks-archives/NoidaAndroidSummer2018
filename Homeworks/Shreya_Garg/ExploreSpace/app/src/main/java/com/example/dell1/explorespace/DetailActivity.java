package com.example.dell1.explorespace;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    Space s;
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailfragment_layout);
        Intent i = getIntent();
        String url = i.getStringExtra("url");
        iv = (ImageView) findViewById(R.id.spaceimg);
    }

}

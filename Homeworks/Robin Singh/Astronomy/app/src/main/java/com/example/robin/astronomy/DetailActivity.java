package com.example.robin.astronomy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    String name,imgurl,detail;
    ImageView img;
    TextView Name,Detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        imgurl = i.getStringExtra("imgurl");
        detail = i.getStringExtra("detail");

        Name = findViewById(R.id.namea);
        Detail = findViewById(R.id.detaila);
        img = findViewById(R.id.imga);

        Name.setText(name);
        Detail.setText(detail);
        Picasso.get().load(imgurl).into(img);

    }
}

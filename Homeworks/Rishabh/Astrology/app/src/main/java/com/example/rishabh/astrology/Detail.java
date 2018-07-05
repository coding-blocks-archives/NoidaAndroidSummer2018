package com.example.rishabh.astrology;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {

   TextView te;
    ImageView iv ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent i = getIntent();
        String ImageURL = i.getStringExtra("url");
        String detailName = i.getStringExtra("name");


        iv = (ImageView)findViewById(R.id.detail_image);
        te = (TextView)findViewById(R.id.detail_name);
        Picasso.get().load(ImageURL).resize(500,500).error(R.drawable.ic_launcher_background).into(iv);

//        iv.setImageURI(Uri.parse(ImageURL));
        te.setText(detailName);
    }
}

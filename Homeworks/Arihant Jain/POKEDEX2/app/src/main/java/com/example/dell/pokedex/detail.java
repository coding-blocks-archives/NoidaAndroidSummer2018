package com.example.dell.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class detail extends AppCompatActivity {
    ImageView img;
    TextView txt1,txt2,txt3,txt4,txt5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        img=findViewById(R.id.image);
        txt1=findViewById(R.id.name);
        txt2=findViewById(R.id.heig);
        txt3=findViewById(R.id.wei);
        txt4=findViewById(R.id.na);
        txt5=findViewById(R.id.url);

        Intent i=getIntent();
        String image=i.getStringExtra("KEY0");
        String name=i.getStringExtra("KEY");
        int h=i.getIntExtra("KEY1",0);
        int w=i.getIntExtra("KEY2",0);
        String na=i.getStringExtra("KEY3");
        String[] url=new String[];
              for()
               url[i] =i.getStringExtra("KEY5");
        Picasso.get().load(image).into(img);
        txt1.setText("NAME:  "+name);
        txt2.setText("HEIGHT:  "+h);
        txt3.setText("WEIGHT:  "+w);
        txt4.setText("ABILITY NAME:  "+na);
        txt5.setText("MOVE NAME  "+url);


    }
}

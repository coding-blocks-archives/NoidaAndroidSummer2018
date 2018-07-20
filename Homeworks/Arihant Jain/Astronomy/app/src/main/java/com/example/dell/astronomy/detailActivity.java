package com.example.dell.astronomy;



import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.support.annotation.Nullable;

import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.ImageView;

import android.widget.TextView;



import com.squareup.picasso.Picasso;







public class detailActivity extends AppCompatActivity implements  communicator{







    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.detailfragment_layout);



        Intent i = getIntent();

        String url = i.getStringExtra("url");

        String type=i.getStringExtra("type");

        String name=i.getStringExtra("name");

        String detail=i.getStringExtra("detail");

        final String wikilink=i.getStringExtra("wikiLink");

        ImageView iv =findViewById(R.id.spaceimg);

        TextView typetv=findViewById(R.id.typespacetv);

        TextView nametextview=findViewById(R.id.nametv);

        TextView detailtextview=findViewById(R.id.detailtv);

        FloatingActionButton fab=findViewById(R.id.fabWiki);

        typetv.setText(type);

        nametextview.setText(name);

        Picasso.with(getApplicationContext()).load(url).into(iv);

        detailtextview.setText(detail);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent i2=new Intent(Intent.ACTION_VIEW);

                i2.setData(Uri.parse(wikilink));

                startActivity(i2);

            }

        });

    }



    @Override

    public void startFragmentDetail(Fragment detailFragment) {



    }

}
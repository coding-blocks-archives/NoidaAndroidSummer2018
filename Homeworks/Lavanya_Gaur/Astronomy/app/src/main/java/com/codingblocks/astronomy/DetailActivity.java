package com.codingblocks.astronomy;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_fragment);
        Intent i = getIntent();
        String url = i.getStringExtra("url");
        String type = i.getStringExtra("type");
        String name = i.getStringExtra("name");
        String detail = i.getStringExtra("detail");

        final String wikilink = i.getStringExtra("wikilink");
        ImageView iv = findViewById(R.id.spaceimg);
        TextView typetv = findViewById(R.id.typespacetv);
        TextView nametextView = findViewById(R.id.nametv);
        TextView detailtextView = findViewById(R.id.detailtv);

        FloatingActionButton fab = findViewById(R.id.fabwiki);

        typetv.setText(type);

        Picasso.get().load(Uri.parse(url)).into(iv);
        nametextView.setText(name);
        detailtextView.setText(detail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(wikilink));
                startActivity(i2);
            }
        });


    }



    @Override
    public void startfragmentdetail(Fragment detailfragment) {

    }
}

package com.example.dell1.hw_lesson06;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Fragment_2 extends Fragment {


    Name currentname;

    public Fragment_2(Name currentname) {
        this.currentname=currentname;
               }

    ImageView photo;
    TextView namefield;
    TextView Bio;
    Button google;
    Button Twitter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.detailsdisplay_fragment,container,false);
        photo=view.findViewById(R.id.photoiv);
        namefield=view.findViewById(R.id.nametv);
        Bio=view.findViewById(R.id.biotv);
        google=view.findViewById(R.id.googlebtn);
        Twitter=view.findViewById(R.id.twitterbtn);
        Picasso.with(getContext()).load(currentname.getImgUrl()).into(photo);
        namefield.setText(currentname.getNameText());
        Bio.setText(currentname.getBioDescription());
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://www.google.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        Twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://twitter.com/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
//        namefield.setText(currentdetail.getNameText());
//        Bio.setText(currentdetail.getBioDescription());
        return view;
    }
}

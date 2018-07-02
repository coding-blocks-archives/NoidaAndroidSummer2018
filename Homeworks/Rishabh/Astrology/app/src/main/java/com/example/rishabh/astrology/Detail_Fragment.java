package com.example.rishabh.astrology;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

public class Detail_Fragment extends Fragment {

Object object;
String name;
String url;
    @SuppressLint("ValidFragment")
    public Detail_Fragment(Object object) {


           this.object = object;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail,container,false);

//        Bundle bundle = getArguments();

        TextView te = view.findViewById(R.id.detail_name);
        ImageView imageView = view.findViewById(R.id.detail_image);

//        Objects objects = bundle.getParcelable()
        if(object instanceof StarData)
        {
            StarData sd = (StarData) object;
            name = sd.getName();
            url = sd.ImageUrl;
        }
        else if(object instanceof PlanetData)
        {
            PlanetData pd = (PlanetData) object;
            name = pd.getName();
            url = pd.ImageUrl;
        } if(object instanceof GalaxyData)
        {
            GalaxyData gd = (GalaxyData) object;
            name = gd.getName();
            url = gd.ImageUrl;
        }


        te.setText(name);

        Picasso.get().load(url).resize(500,500).error(R.drawable.ic_launcher_background).into(imageView);



        return view;
    }

}

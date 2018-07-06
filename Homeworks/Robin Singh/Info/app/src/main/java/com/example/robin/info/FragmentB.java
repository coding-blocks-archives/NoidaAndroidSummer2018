package com.example.robin.info;

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

public class FragmentB extends Fragment {

    String name,prof,url;

    public FragmentB(String name, String prof, String url) {
        this.name = name;
        this.prof = prof;
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_b,container,false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView name1 = view.findViewById(R.id.name);
        TextView prof1 = view.findViewById(R.id.prof);
        ImageView imageView = view.findViewById(R.id.img);
        Picasso.get().load(url).into(imageView);
        name1.setText(name);
        prof1.setText(prof);
    }
}

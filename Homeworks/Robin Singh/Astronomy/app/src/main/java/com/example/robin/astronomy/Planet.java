package com.example.robin.astronomy;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Planet extends Fragment {

    RecyclerView rv;
    ArrayList<info> list1 = new ArrayList<info>();

    public Planet() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list1.add(new info("Mercury","Mercury is the smallest and innermost planet in the Solar System. Its orbital period around the Sun of 87.97 days is the shortest of all the planets in the Solar System. It is named after the Roman deity Mercury, the messenger of the gods.","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Mercury_in_color_-_Prockter07-edit1.jpg/225px-Mercury_in_color_-_Prockter07-edit1.jpg",1,"https://en.wikipedia.org/wiki/Mercury_(planet)"));
        list1.add(new info("Venus","Venus is the second planet from the Sun, orbiting it every 224.7 Earth days.[12] It has the longest rotation period (243 days) of any planet in the Solar System and rotates in the opposite direction to most other planets (meaning the Sun would rise in the west and set in the east).","https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Venus-real_color.jpg/260px-Venus-real_color.jpg",1,"https://en.wikipedia.org/wiki/Venus"));
        list1.add(new info("Earth","Earth is the third planet from the Sun and the only astronomical object known to harbor life. According to radiometric dating and other sources of evidence, Earth formed over 4.5 billion years ago","https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/The_Earth_seen_from_Apollo_17.jpg/225px-The_Earth_seen_from_Apollo_17.jpg",1,"https://en.wikipedia.org/wiki/Earth"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_planet, container, false);
        infoAdapter infoAdapter1= new infoAdapter(getContext(),list1);
        rv = view.findViewById(R.id.planet);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(infoAdapter1);
        return  view;
    }


}

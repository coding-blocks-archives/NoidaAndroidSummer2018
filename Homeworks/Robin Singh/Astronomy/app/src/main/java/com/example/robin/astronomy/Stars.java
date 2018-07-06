package com.example.robin.astronomy;


import android.os.Bundle;
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
public class Stars extends Fragment {


    RecyclerView rv;
    ArrayList<info> list2 = new ArrayList<info>();

    public Stars() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list2.add(new info("Sun","The Sun is the star at the center of the Solar System. It is a nearly perfect sphere of hot plasma,[14][15] with internal convective motion that generates a magnetic field via a dynamo process.[16] It is by far the most important source of energy for life on Earth","https://www.nationalgeographic.com/content/dam/science/photos/000/065/6594.ngsversion.1509199314694.adapt.1900.1.jpg",2,"https://en.wikipedia.org/wiki/Sun"));
        list2.add(new info("Polaris","Polaris, designated Alpha Ursae Minoris (α Ursae Minoris, abbreviated Alpha UMi, α UMi), commonly the North Star or Pole Star, is the brightest star in the constellation of Ursa Minor.","http://astropixels.com/stars/images/Polaris-01w.jpg",2,"https://en.wikipedia.org/wiki/Polaris"));
        list2.add(new info("Sirius","Sirius (/ˈsɪriəs/, a romanization of Greek Σείριος, Seirios, lit. \"glowing\" or \"scorching\") is a star system and the brightest star in the Earth's night sky. With a visual apparent magnitude of −1.46, it is almost twice as bright as Canopus, the next brightest star.","data:image/jpeg;base64,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",2,"https://en.wikipedia.org/wiki/Sirius"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stars, container, false);
        infoAdapter infoAdapter1= new infoAdapter(getContext(),list2);
        rv = view.findViewById(R.id.star);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(infoAdapter1);
        return  view;
    }

}

package com.example.dell.astronomy;


import android.os.Bundle;

import android.support.annotation.NonNull;

import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;

import android.util.Log;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;



import java.util.ArrayList;



public class fragmentStar extends Fragment{





    @Nullable

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        RecyclerView rv;

        ArrayList<space> starArrayLiat=new ArrayList<>();

        View view=inflater.inflate(R.layout.space_layout,container,false);



        starArrayLiat.add(new space("RIGEL", "https://i.ytimg.com/vi/wfo2UnVtJqY/hqdefault.jpg", 1,"Rigel (/ˈraɪdʒəl, -ɡəl/), also designated Beta Orionis (β Orionis, abbreviated Beta Ori, β Ori), is generally the seventh-brightest star in the night sky and the brightest star in the constellation of Orion—though periodically it is outshone within the constellation by the variable Betelgeuse.","https://en.wikipedia.org/wiki/Rigel"));

        starArrayLiat.add(new space("SIRIUS", "http://cdn.spacetelescope.org/archives/images/screen/heic0516f.jpg", 1,"Sirius (/ˈsɪriəs/, a romanization of Greek Σείριος, Seirios, lit. \"glowing\" or \"scorching\") is a star system and the brightest star in the Earth's night sky. With a visual apparent magnitude of −1.46, it is almost twice as bright as Canopus, the next brightest star. The system has the Bayer designation Alpha Canis Majoris (α CMa).","https://en.wikipedia.org/wiki/Sirius"));

        starArrayLiat.add(new space("VEGA", "http://astrologyking.com/wp-content/uploads/vega-star-alpha-lyrae.jpg", 1,"Vega, also designated Alpha Lyrae (α Lyrae, abbreviated Alpha Lyr or α Lyr), is the brightest star in the constellation of Lyra, the fifth-brightest star in the night sky, and the second-brightest star in the northern celestial hemisphere, after Arcturus.","https://en.wikipedia.org/wiki/Vega"));

        starArrayLiat.add(new space("POLARIS", "http://astrologyking.com/wp-content/uploads/polaris-star-alpha-ursar-minoris.jpg", 1,"Polaris, designated Alpha Ursae Minoris (α Ursae Minoris, abbreviated Alpha UMi, α UMi), commonly the North Star or Pole Star, is the brightest star in the constellation of Ursa Minor. It is very close to the north celestial pole, making it the current northern pole star. ","https://en.wikipedia.org/wiki/Polaris"));

        starArrayLiat.add(new space("POLLUX", "http://en.es-static.us/upl/2009/06/hyades-aldebaran-telescope.jpg", 1,"Pollux, also designated Beta Geminorum (β Geminorum, abbreviated Beta Gem, β Gem), is an orange-hued evolved giant star approximately 34 light-years from the Sun in the northern constellation of Gemini. It is the closest giant star to the Sun.","https://en.wikipedia.org/wiki/Pollux_(star)"));







        rv=view.findViewById(R.id.space_list_rv);

        LinearLayoutManager llm=new LinearLayoutManager(getContext());

        rv.setLayoutManager(llm);

        spaceAdapter spaceAdapter=new spaceAdapter(getContext(),starArrayLiat,(communicator) getActivity());

        rv.setAdapter(spaceAdapter);

        return view;

    }

}
package com.example.dell1.explorespace;

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

public class FragmentPlanet extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        RecyclerView rv;
        ArrayList<Space> planetarraylist=new ArrayList<>();


        View view=inflater.inflate(R.layout.space_layout,container,false);
        Log.e("TAG","onPLANET");
        planetarraylist.add(new Space("MERCURY", "https://assets.classicfm.com/2012/32/mercury-1344337458-view-0.jpg", 0));
        planetarraylist.add(new Space("VENUS", "https://www.scienceabc.com/wp-content/uploads/2017/06/Venus-planet.jpg", 0));
        planetarraylist.add(new Space("EARTH", "https://lph5i1b6c053kq7us26bdk75-wpengine.netdna-ssl.com/wp-content/uploads/2015/02/planet-earth-facts.jpg", 0));
        planetarraylist.add(new Space("MARS", "http://wanderlord.com/wp-content/uploads/2016/04/Mars.jpg", 0));
        planetarraylist.add(new Space("JUPITER","https://i.ytimg.com/vi/BLhRShCm8Ws/hqdefault.jpg",0));
        planetarraylist.add(new Space("SATURN", "https://ak9.picdn.net/shutterstock/videos/21571639/thumb/1.jpg", 0));
        planetarraylist.add(new Space("URANUS", "http://www.alex-bernardini.fr/espace/images/planetes/uranus.jpg", 0));
        planetarraylist.add(new Space("NEPTUNE", "https://media.indiatimes.in/media/content/2017/May/vengage_1494569602.jpg", 0));

        rv=view.findViewById(R.id.space_list_rv);
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        SpaceAdapter spaceAdapter=new SpaceAdapter(getContext(),planetarraylist,(Communicator) getActivity());
        rv.setAdapter(spaceAdapter);
        return view;
    }
}

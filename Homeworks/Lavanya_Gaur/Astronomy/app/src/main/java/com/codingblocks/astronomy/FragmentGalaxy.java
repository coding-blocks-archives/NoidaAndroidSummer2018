package com.codingblocks.astronomy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentGalaxy extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView rv;
        ArrayList<Space> galaxyArrayList =new ArrayList<>();
        View view=inflater.inflate(R.layout.space_layout,container,false);

        galaxyArrayList.add(new Space("MilkyWay","https://en.wikipedia.org/wiki/Milky_Way#/media/File:ESO-VLT-Laser-phot-33a-07.jpg","click link","https://en.wikipedia.org/wiki/Milky_Way",2));
        galaxyArrayList.add(new Space("Sirius","https://en.wikipedia.org/wiki/Andromeda_Galaxy#/media/File:Andromeda_Galaxy_(with_h-alpha).jpg","click link","https://en.wikipedia.org/wiki/Andromeda_Galaxy",2));


        rv=view.findViewById(R.id.space_list_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        SpaceAdapter spaceAdapter=new SpaceAdapter(getContext(),galaxyArrayList,(Communicator)getActivity());
        rv.setAdapter(spaceAdapter);
        return view;

    }
}

package com.codingblocks.astronomy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentPlanets extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView rv;
        ArrayList<Space> planetArrayList =new ArrayList<>();
        View view=inflater.inflate(R.layout.space_layout,container,false);

        planetArrayList.add(new Space("Mercury","https://en.wikipedia.org/wiki/Mercury_(planet)#/media/File:Mercury_in_color_-_Prockter07-edit1.jpg","click link","https://en.wikipedia.org/wiki/Mercury_(planet)",0));
        planetArrayList.add(new Space("Earth","https://en.wikipedia.org/wiki/Earth#/media/File:The_Earth_seen_from_Apollo_17.jpg","click link","https://en.wikipedia.org/wiki/Earth",0));


      rv=view.findViewById(R.id.space_list_rv);
      rv.setLayoutManager(new LinearLayoutManager(getContext()));
      SpaceAdapter spaceAdapter=new SpaceAdapter(getContext(),planetArrayList,(Communicator)getActivity());
      rv.setAdapter(spaceAdapter);
      return view;

    }

}

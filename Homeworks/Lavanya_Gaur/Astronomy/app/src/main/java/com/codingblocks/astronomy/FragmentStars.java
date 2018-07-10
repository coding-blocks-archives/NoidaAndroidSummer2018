package com.codingblocks.astronomy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentStars extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView rv;
        ArrayList<Space> starArrayList =new ArrayList<>();
        View view=inflater.inflate(R.layout.space_layout,container,false);

        starArrayList.add(new Space("Polaris","https://en.wikipedia.org/wiki/Polaris#/media/File:Ursa_Minor_IAU.svg","click link","https://en.wikipedia.org/wiki/Polaris",1));
        starArrayList.add(new Space("Sirius","https://en.wikipedia.org/wiki/Sirius#/media/File:Canis_Major_constellation_map.svg","click link","https://en.wikipedia.org/wiki/Sirius",1));

        rv=view.findViewById(R.id.space_list_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        SpaceAdapter spaceAdapter=new SpaceAdapter(getContext(),starArrayList,(Communicator)getActivity());
        rv.setAdapter(spaceAdapter);
        return view;

    }

}

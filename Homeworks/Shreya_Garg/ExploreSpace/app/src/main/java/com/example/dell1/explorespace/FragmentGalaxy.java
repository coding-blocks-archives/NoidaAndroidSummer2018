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

public class FragmentGalaxy extends Fragment {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        RecyclerView rv;
        ArrayList<Space> galaxyArrayList=new ArrayList<>();


        View view=inflater.inflate(R.layout.space_layout,container,false);
        Log.e("TAG","onGALAXY");
        
        galaxyArrayList.add(new Space("MILKY WAY", "https://i.ytimg.com/vi/0La58bUNNzQ/maxresdefault.jpg", 2));
        galaxyArrayList.add(new Space("CIGAR", "https://i.ytimg.com/vi/by3dy94-mw8/maxresdefault.jpg", 2));
        galaxyArrayList.add(new Space("LMC", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/A_long-dead_star_DEM_L316A.jpg/220px-A_long-dead_star_DEM_L316A.jpg", 2));
        galaxyArrayList.add(new Space("PINWHEEL", "https://apod.nasa.gov/apod/image/0303/m101_cfht.jpg", 2));
        galaxyArrayList.add(new Space("HOAG'S","https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Hoag%27s_object.jpg/300px-Hoag%27s_object.jpg",2));
        
        rv=view.findViewById(R.id.space_list_rv);
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        SpaceAdapter spaceAdapter=new SpaceAdapter(getContext(),galaxyArrayList,(Communicator) getActivity());
        rv.setAdapter(spaceAdapter);
        return view;
    }
}

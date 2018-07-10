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

public class FragmentStar extends Fragment{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RecyclerView rv;
        ArrayList<Space> starArrayLiat=new ArrayList<>();
        View view=inflater.inflate(R.layout.space_layout,container,false);
        Log.e("TAG","onSTAR");
        starArrayLiat.add(new Space("POLARIS", "http://astrologyking.com/wp-content/uploads/polaris-star-alpha-ursar-minoris.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Polaris"));
        starArrayLiat.add(new Space("SIRIUS", "http://cdn.spacetelescope.org/archives/images/screen/heic0516f.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Sirius"));
        starArrayLiat.add(new Space("BETELGEUSE", "http://www.pcbheaven.com/opendir/images/thumbs/od_1342_7_1350819287.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Betelgeuse"));
        starArrayLiat.add(new Space("RIGEL", "https://i.ytimg.com/vi/wfo2UnVtJqY/hqdefault.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Rigel"));
        starArrayLiat.add(new Space("VEGA", "http://astrologyking.com/wp-content/uploads/vega-star-alpha-lyrae.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Vega"));
        starArrayLiat.add(new Space("PLEIADES", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Chandra_X-ray_View_of_Orion.jpg/300px-Chandra_X-ray_View_of_Orion.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Pleiades"));
        starArrayLiat.add(new Space("ANTARES", "http://en.es-static.us/upl/2016/07/Antares-AstroPixels-Fred-Espenak-2-e1467228071849.jpg",1,"For detailed information click button","https://en.wikipedia.org/wiki/Antares"));
        starArrayLiat.add(new Space("CANOPUS", "https://upload.wikimedia.org/wikipedia/commons/1/17/Canopus.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Canopus"));
        starArrayLiat.add(new Space("CASTOR", "https://i.pinimg.com/236x/bd/c2/37/bdc2378ee200a48451606a966f9692e9.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Castor_(star)"));
        starArrayLiat.add(new Space("MIRACH", "https://i.pinimg.com/originals/2c/f2/92/2cf292909d3415b8ef8a8b32d09c25d0.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Beta_Andromedae"));
        starArrayLiat.add(new Space("PROCYON", "http://www.armaghplanet.com/blog/wp-content/uploads/2011/12/Image-of-Sirius-system.jpg",1,"For detailed information click button","https://en.wikipedia.org/wiki/Procyon"));
        starArrayLiat.add(new Space("POLLUX", "http://en.es-static.us/upl/2009/06/hyades-aldebaran-telescope.jpg", 1,"For detailed information click button","https://en.wikipedia.org/wiki/Pollux_(star)"));



        rv=view.findViewById(R.id.space_list_rv);
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        SpaceAdapter spaceAdapter=new SpaceAdapter(getContext(),starArrayLiat,(Communicator) getActivity());
        rv.setAdapter(spaceAdapter);
        return view;
    }
}

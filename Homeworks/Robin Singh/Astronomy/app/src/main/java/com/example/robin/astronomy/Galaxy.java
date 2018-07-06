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
public class Galaxy extends Fragment {

    RecyclerView rv;
    ArrayList<info> list3 = new ArrayList<info>();

    public Galaxy() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list3.add(new info("Milky Way","The Milky Way is the galaxy[nb 1] that contains our Solar System. The descriptive \"milky\" is derived from the appearance from Earth of the galaxy – a band of light seen in the night sky formed from stars that cannot be individually distinguished by the naked eye. The term Milky Way is a translation of the Latin via lactea, from the Greek γαλαξίας κύκλος (galaxías kýklos, \"milky circle\")","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Milky_Way_Night_Sky_Black_Rock_Desert_Nevada.jpg/220px-Milky_Way_Night_Sky_Black_Rock_Desert_Nevada.jpg",3,"https://en.wikipedia.org/wiki/Milky_Way"));
        list3.add(new info("Cartwheel Galaxy","The Cartwheel Galaxy (also known as ESO 350-40) is a lenticular galaxy and ring galaxy about 500 million light-years away in the constellation Sculptor. It is an estimated 150,000 light-years diameter, and has a mass of about 2.9–4.8 × 109 solar masses; it rotates at 217 km/s.","http://amazingspace.org/uploads/resource_image/image/55/thumb_low_ff_cartwheel_galaxy_lg.png",1,"hhttps://en.wikipedia.org/wiki/Cartwheel_Galaxy"));
        list3.add(new info("Cosmos Redshift 7","Cosmos Redshift 7 (also known as COSMOS Redshift 7, Galaxy Cosmos Redshift 7, Galaxy CR7 or CR7) is a high-redshift Lyman-alpha emitter galaxy (meaning CR7 is one of the oldest, most distant galaxies), in the constellation Sextans, about 12.9 billion light travel distance years from Earth, reported to contain the first stars (first generation; Population III)—formed soon after the Big Bang during the reionisation epoch.","https://mk0astronomynow9oh6g.kinstacdn.com/wp-content/uploads/2015/06/brightest_early_galaxy_940x400-326x245.jpg",3,"https://en.wikipedia.org/wiki/Cosmos_Redshift_7"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galaxy, container, false);
        infoAdapter infoAdapter1= new infoAdapter(getContext(),list3);
        rv = view.findViewById(R.id.galaxy);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(infoAdapter1);
        return  view;
    }

}

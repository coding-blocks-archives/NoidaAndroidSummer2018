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



public class fragmentGalaxy extends Fragment {









    @Nullable

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {





        RecyclerView rv;

        ArrayList<space> galaxyArrayList=new ArrayList<>();





        View view=inflater.inflate(R.layout.space_layout,container,false);

        Log.e("TAG","onGALAXY");



        galaxyArrayList.add(new space("MILKY WAY", "https://i.ytimg.com/vi/0La58bUNNzQ/maxresdefault.jpg", 2,"The descriptive \"milky\" is derived from the appearance from Earth of the galaxy – a band of light seen in the night sky formed from stars that cannot be individually distinguished by the naked eye.","https://en.wikipedia.org/wiki/Milky_Way"));

        galaxyArrayList.add(new space("CIGAR", "https://i.ytimg.com/vi/by3dy94-mw8/maxresdefault.jpg", 2,"Messier 82 (also known as NGC 3034, Cigar Galaxy or M82) is a starburst galaxy approximately 12 million light-years away in the constellation Ursa Major. A member of the M81 Group, it is about five times more luminous than the whole Milky Way and has a center one hundred times more luminous than our galaxy's center.","https://en.wikipedia.org/wiki/Messier_82"));

        galaxyArrayList.add(new space("LMC", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/A_long-dead_star_DEM_L316A.jpg/220px-A_long-dead_star_DEM_L316A.jpg", 2,"The Large Magellanic Cloud (LMC) is a satellite galaxy of the Milky Way.[5] At a distance of about 50 kiloparsecs (≈163,000 light-years),[2][6][7][8] the LMC is the second or third-closest galaxy to the Milky Way, after the Sagittarius Dwarf Spheroidal (~ 16 kpc) and the possible dwarf irregular galaxy known as the Canis Major Overdensity.","https://en.wikipedia.org/wiki/Large_Magellanic_Cloud"));

        galaxyArrayList.add(new space("PINWHEEL", "https://apod.nasa.gov/apod/image/0303/m101_cfht.jpg", 2,"The Pinwheel Galaxy (also known as Messier 101, M101 or NGC 5457) is a face-on spiral galaxy distanced 21 million light-years (six megaparsecs)[3] away from Earth in the constellation Ursa Major. First discovered by Pierre Méchain on March 27, 1781, it was communicated to Charles Messier who verified its position for inclusion in the Messier Catalogue as one of its final entries","https://en.wikipedia.org/wiki/Pinwheel_Galaxy"));

        galaxyArrayList.add(new space("HOAG'S","https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Hoag%27s_object.jpg/300px-Hoag%27s_object.jpg",2,"Hoag's Object is a non-typical galaxy of the type known as a ring galaxy. The galaxy is named after Arthur Hoag who discovered it in 1950 and identified it as either a planetary nebula or a peculiar galaxy[3] with eight billion stars.","https://en.wikipedia.org/wiki/Hoag%27s_Object"));



        rv=view.findViewById(R.id.space_list_rv);

        LinearLayoutManager llm=new LinearLayoutManager(getContext());

        rv.setLayoutManager(llm);

        spaceAdapter spaceAdapter=new spaceAdapter(getContext(),galaxyArrayList,(communicator) getActivity());

        rv.setAdapter(spaceAdapter);

        return view;

    }

}
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
        planetarraylist.add(new Space("MERCURY", "https://assets.classicfm.com/2012/32/mercury-1344337458-view-0.jpg", 0,"The smallest planet in our solar system and nearest to the Sun, Mercury is only slightly larger than Earth's moon. From the surface of Mercury, the Sun would appear more than three times as large as it does when viewed from Earth, and the sunlight would be as much as 11 times brighter.","https://en.wikipedia.org/wiki/Mercury_(planet)"));
        planetarraylist.add(new Space("VENUS", "https://www.scienceabc.com/wp-content/uploads/2017/06/Venus-planet.jpg", 0,"Venus, the second planet from the sun, is named for the Roman goddess of love and beauty. The planet — the only planet named after a female — may have been named for the most beautiful deity of her pantheon because it shone the brightest of the five planets known to ancient astronomers.","https://en.wikipedia.org/wiki/Venus"));
        planetarraylist.add(new Space("EARTH", "https://lph5i1b6c053kq7us26bdk75-wpengine.netdna-ssl.com/wp-content/uploads/2015/02/planet-earth-facts.jpg", 0,"Earth is the only planet whose English name does not derive from Greek/Roman mythology. The name derives from Old English and Germanic. There are, of course, hundreds of other names for the planet in other languages. In Roman Mythology, the goddess of the Earth was Tellus - the fertile soil ","https://en.wikipedia.org/wiki/Earth"));
        planetarraylist.add(new Space("MARS", "http://wanderlord.com/wp-content/uploads/2016/04/Mars.jpg", 0,"Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. In English, Mars carries a name of the Roman god of war, and is often referred to as the Red Planet because the reddish iron oxide prevalent on its surface gives it a reddish appearance.","https://en.wikipedia.org/wiki/Mars"));
        planetarraylist.add(new Space("JUPITER","https://i.ytimg.com/vi/BLhRShCm8Ws/hqdefault.jpg",0,"Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a giant planet with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined. Jupiter and Saturn are gas giants; the other two giant planets, Uranus and Neptune are ice giants.","https://en.wikipedia.org/wiki/Jupiter"));
        planetarraylist.add(new Space("SATURN", "https://ak9.picdn.net/shutterstock/videos/21571639/thumb/1.jpg", 0,"Saturn is the sixth planet from the Sun and the second-largest in the Solar System, after Jupiter. It is a gas giant with an average radius about nine times that of Earth.[10][11] It has only one-eighth the average density of Earth, but with its larger volume Saturn is over 95 times more massive","https://en.wikipedia.org/wiki/Saturn"));
        planetarraylist.add(new Space("URANUS", "http://www.alex-bernardini.fr/espace/images/planetes/uranus.jpg", 0,"Uranus is the seventh planet from the Sun. It has the third-largest planetary radius and fourth-largest planetary mass in the Solar System. Uranus is similar in composition to Neptune, and both have different bulk chemical composition from that of the larger gas giants Jupiter and Saturn.","https://en.wikipedia.org/wiki/Uranus"));
        planetarraylist.add(new Space("NEPTUNE", "https://media.indiatimes.in/media/content/2017/May/vengage_1494569602.jpg", 0,"Neptune is the eighth and farthest known planet from the Sun in the Solar System. In the Solar System, it is the fourth-largest planet by diameter, the third-most-massive planet, and the densest giant planet. Neptune is 17 times the mass of Earth and is slightly more massive than its near-twin Uranus.","https://en.wikipedia.org/wiki/Neptune"));

        rv=view.findViewById(R.id.space_list_rv);
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        SpaceAdapter spaceAdapter=new SpaceAdapter(getContext(),planetarraylist,(Communicator) getActivity());
        rv.setAdapter(spaceAdapter);
        return view;
    }
}

package com.example.dell1.hw_lesson06;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment_1 extends Fragment {

    ArrayList<Name> namelist=new ArrayList<>();
    RecyclerView rv;
//    NameAdapter nameAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.namedisplay_fragment,container,false);
        namelist.add(new Name("Shreya","https://randomuser.me/api/portraits/women/81.jpg","Shreya","Learning Android"));
        namelist.add(new Name("Priya","https://randomuser.me/api/portraits/women/44.jpg","Priya","I am Priya"));
        namelist.add(new Name("harry","https://randomuser.me/api/portraits/men/40.jpg","Harry","I am Harry potter"));
        namelist.add(new Name("ron","https://randomuser.me/api/portraits/men/24.jpg","Ron","I am Ron Weasley"));
        namelist.add(new Name("hermoine","https://randomuser.me/api/portraits/women/68.jpg","Hermoine","I know magic"));
        namelist.add(new Name("rachel","https://randomuser.me/api/portraits/women/54.jpg","Rachel","Hi rachel here"));
        namelist.add(new Name("monica","https://randomuser.me/api/portraits/women/13.jpg","Monica","Hi"));
        namelist.add(new Name("chandler","https://randomuser.me/api/portraits/men/68.jpg","Chandler","I know sarcasm"));
        namelist.add(new Name("phoebe","https://randomuser.me/api/portraits/women/63.jpg","Phoebe","Hi"));
        namelist.add(new Name("joey","https://randomuser.me/api/portraits/men/62.jpg","Joey","Joey doesnt share food"));
        namelist.add(new Name("Ross","https://randomuser.me/api/portraits/men/61.jpg","Ross","hi"));
        namelist.add(new Name("Gunther","https://randomuser.me/api/portraits/men/60.jpg","Gunther","hi") );
        namelist.add(new Name("Betty","https://randomuser.me/api/portraits/women/65.jpg","Betty","hi"));
        namelist.add(new Name("Archie","https://randomuser.me/api/portraits/men/69.jpg","Archie","hi"));
        namelist.add(new Name("Veronica","https://randomuser.me/api/portraits/women/69.jpg","Vernonica","hi"));
        namelist.add(new Name("Jughead","https://randomuser.me/api/portraits/men/48.jpg","Jughead","Hello"));
        namelist.add(new Name("Regina","https://randomuser.me/api/portraits/women/48.jpg","Regina","I am regina"));
        namelist.add(new Name("sonali","https://randomuser.me/api/portraits/women/38.jpg","Sonali","I am sonali"));
        namelist.add(new Name("Varun","https://randomuser.me/api/portraits/men/63.jpg","Varun","I am varun "));
        namelist.add(new Name("Ganesh","https://randomuser.me/api/portraits/men/28.jpg","Ganesh","I am ganesh"));
        rv=view.findViewById(R.id.namelistrv);
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        NameAdapter nameAdapter=new NameAdapter(namelist,getContext(),(MainActivity)getActivity());

        rv.setAdapter(nameAdapter);

        return view;
    }
}

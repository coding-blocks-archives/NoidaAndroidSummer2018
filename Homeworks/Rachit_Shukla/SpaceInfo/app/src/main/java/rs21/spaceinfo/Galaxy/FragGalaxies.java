package rs21.spaceinfo.Galaxy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rs21.spaceinfo.Planet.FragPlanets;
import rs21.spaceinfo.MainActivity;
import rs21.spaceinfo.R;

public class FragGalaxies extends Fragment {

    public static FragPlanets newInstance() {

        Bundle args = new Bundle();
        FragPlanets fragment = new FragPlanets();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_galaxies, container, false);
        MainActivity communicator = (MainActivity) getActivity();
        GalaxyAdapter l = new GalaxyAdapter(getContext(), Galaxies.getGalaxies(), communicator);

        RecyclerView rvList = view.findViewById(R.id.galaxyNames);
        rvList.setAdapter(l);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}

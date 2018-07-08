package garg.ayush.astronomyapp;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class FragmentGalaxy extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_galaxy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Configuration newConfig = getResources().getConfiguration();
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            RecyclerView recyclerView = view.findViewById(R.id.RVGalaxy);
            MainActivity mainActivity = (MainActivity) getActivity();
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new MyRecyclerViewAdapterLandscape(Galaxy.getGalaxy(),getContext(),mainActivity));

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            RecyclerView recyclerView = view.findViewById(R.id.RVGalaxy);
            MainActivity mainActivity = (MainActivity) getActivity();
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new MyRecyclerViewAdapter(Galaxy.getGalaxy(),getContext(),mainActivity));
        }


    }
}

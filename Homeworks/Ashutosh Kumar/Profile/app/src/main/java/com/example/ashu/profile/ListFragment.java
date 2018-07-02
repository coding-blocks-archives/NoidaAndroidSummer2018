package com.example.ashu.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListFragment extends Fragment {

//    public static ListFragment newInstance(){
//        Bundle bundle = new Bundle();
//        ListFragment fragment = new ListFragment();
//        fragment.setArguments(bundle);
//        return fragment;
//
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.rvList);
      //  MainActivity ma = (MainActivity) getActivity();
        Communicator communicator = (Communicator) getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ProfileAdapter(Profile.getProfile(),getContext(),communicator));





    }
}

package com.codingblocks.dynamicfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends Fragment {

    int count = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);

        Button btn = view.findViewById(R.id.btnFragA);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                MainActivity mi = (MainActivity) getActivity();
                mi.addFragmentB(new FragmentB(count));
                //Do something on clicking button
            }
        });

        return view;
    }
}

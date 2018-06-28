package com.example.dell1.dynamicfragmentself;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment_2 extends Fragment{

    int count;
    public fragment_2(int count) {
        this.count=count;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_2,container,false);

        TextView tv=view.findViewById(R.id.fragment_2_tv);
        tv.setText(String.valueOf(count));
        return view;
    }
}

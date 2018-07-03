package com.example.dell1.viewpager_understand_self;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.e("TAG","ONCREATE: B");
//                                          Toast.makeText(getContext(),"CHATS",Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_b,container,false);
    }

}

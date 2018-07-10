package com.example.robin.astronomy;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    String name,detail,imgurl;

    public DetailFragment() {
        // Required empty public constructor
    }


    public  static  DetailFragment newInstance(info f){

        Bundle args = new Bundle();
        args.putParcelable("Info", (Parcelable) f);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        info f = (info) bundle.getParcelable("Info");
        TextView Name  =view.findViewById(R.id.name);
        TextView Detail = view.findViewById(R.id.detail);
        ImageView imageView = view.findViewById(R.id.img);
        Picasso.get().load(imgurl).into(imageView);
        Name.setText(name);
        Detail.setText(detail);



    }
}

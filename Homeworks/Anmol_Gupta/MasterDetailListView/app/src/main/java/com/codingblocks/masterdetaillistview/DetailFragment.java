package com.codingblocks.masterdetaillistview;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {
    String name, url, bio;

    public DetailFragment(String name, String url, String bio) {
        this.name = name;
        this.url = url;
        this.bio = bio;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView nameTv = view.findViewById(R.id.tvStudentNameDetail);
        TextView bioTv = view.findViewById(R.id.tvStudentDetails);
        ImageView imageView = view.findViewById(R.id.ivStudentImage);
        Picasso.get().load(url).into(imageView);
        nameTv.setText(name);
        bioTv.setText(bio);

    }
}

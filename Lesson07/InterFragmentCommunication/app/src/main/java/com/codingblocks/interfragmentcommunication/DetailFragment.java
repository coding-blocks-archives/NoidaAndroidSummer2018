package com.codingblocks.interfragmentcommunication;


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

    Student student;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(Student s) {

        Bundle args = new Bundle();
        args.putParcelable("STUDENT", s);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


//    public DetailFragment(String name, String url, String bio) {
//        this.name = name;
//        this.url = url;
//        this.bio = bio;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();

//        String name = bundle.getString("NAME");
//        String bio = bundle.getString("BIO");
//        String url = bundle.getString("URL");

        Student student = (Student) bundle.getParcelable("STUDENT");

        TextView nameTv = view.findViewById(R.id.tvStudentNameDetail);
        TextView bioTv = view.findViewById(R.id.tvStudentDetails);
        ImageView imageView = view.findViewById(R.id.ivStudentImage);
        Picasso.get().load(url).into(imageView);
        nameTv.setText(name);
        bioTv.setText(bio);

    }
}

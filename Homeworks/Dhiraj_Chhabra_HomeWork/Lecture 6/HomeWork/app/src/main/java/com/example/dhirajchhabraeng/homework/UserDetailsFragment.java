package com.example.dhirajchhabraeng.homework;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class UserDetailsFragment extends Fragment implements Serializable {

    ImageView userImage;
    TextView userName;
    TextView userBio;
    String userFacebookUrl;
    String userTwitterUrl;
    User currentUser;

    public UserDetailsFragment(){

    }

    public static UserDetailsFragment newInstance(User user) {
        Bundle args = new Bundle();
        args.putParcelable("currentUser", user);

        UserDetailsFragment fragment = new UserDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.user_details_view, container, false);
        userImage = view.findViewById(R.id.userDetailsImage_view);
        userName = view.findViewById(R.id.userDetailsName_view);
        userBio = view.findViewById(R.id.userDetailsBio_view);

        currentUser = getArguments().getParcelable("currentUser");

        Picasso.get().load(currentUser.getImageUrl()).placeholder(R.mipmap.ic_launcher_round).into(userImage);
        userName.setText(currentUser.getUserName());
        userBio.setText(currentUser.getBio());

        return view;
    }
}

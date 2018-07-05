package com.example.ashu.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;



public class DetailFragment extends Fragment{

    Profile profile;

    String name,imageUrl,bio,location,job,email;

    public DetailFragment(){

    }

    public static DetailFragment newInstance(Profile profile){
        Bundle bundle = new Bundle();
        bundle.putParcelable("Profile",profile);

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

//    public DetailFragment(String name, String imageUrl, String bio, String location, String job, String email) {
//        this.name = name;
//        this.imageUrl = imageUrl;
//        this.bio = bio;
//        this.location = location;
//        this.job = job;
//        this.email = email;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        Bundle bundle = getArguments();

        Profile profile = (Profile)bundle.getParcelable("Profile");
        name = profile.getmName();
        imageUrl = profile.getmImageUrl();
        bio = profile.getmBio();
        location = profile.getmLocation();
        job = profile.getmJob();
        email = profile.getmEmail();

        TextView nameTextView = view.findViewById(R.id.nameView);
        CircleImageView imageView = view.findViewById(R.id.detailImageView);
        TextView bioTextView = view.findViewById(R.id.bioView);
        TextView locationTextView = view.findViewById(R.id.locationView);
        TextView jobTextView = view.findViewById(R.id.jobView);
        TextView emailTextView = view.findViewById(R.id.emailView);

        nameTextView.setText(name);
        Picasso
                .get()
                .load(imageUrl)
                .into(imageView);
        bioTextView.setText(bio);
        locationTextView.setText(location);
        jobTextView.setText(job);
        emailTextView.setText(email);

        ImageView googleImage = view.findViewById(R.id.gsearch);
        googleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.google.com"));
                startActivity(i);
            }
        });


        ImageView twitterImage = view.findViewById(R.id.twitter);
        twitterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.twitter.com"));
                startActivity(i);

            }
        });


    }
}

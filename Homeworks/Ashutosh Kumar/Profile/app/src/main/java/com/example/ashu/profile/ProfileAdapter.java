package com.example.ashu.profile;

import android.content.Context;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder> {

    private ArrayList<Profile> profileArrayList;
    private Context context;
//    MainActivity mainActivity;
    Communicator communicator;

    public ProfileAdapter(ArrayList<Profile> profileArrayList, Context context, Communicator ma) {
        this.profileArrayList = profileArrayList;
        this.context = context;
        this.communicator = ma;
    }


    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new ProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileHolder profileHolder, int position) {
        Profile profile = profileArrayList.get(position);
        Picasso
              .get()
              .load(profile.getmImageUrl())
                .placeholder(R.drawable.ic_search)
              .into(profileHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return profileArrayList.size();
    }


    class ProfileHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView ;


        public ProfileHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.listImageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.e("ProfileAdapter", "On Click ");
                  Profile currentProfile = profileArrayList.get(getAdapterPosition());
                  DetailFragment detailFragment = DetailFragment.newInstance(currentProfile);
                    communicator.startFragmentDetail(detailFragment);
                }
            });
        }
    }
}

package com.example.dhirajchhabraeng.homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    Context ctx;
    ArrayList<User> usersList;
    Communicator communicator;

    public UsersAdapter(Context context, ArrayList<User> usersList, Activity activity) {
        this.ctx = context;
        this.usersList = usersList;
        this.communicator = (Communicator) activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(ctx).inflate(R.layout.recycler_view_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(inflatedView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User currentUser = usersList.get(position);

        Picasso.get()
                .load(currentUser.getImageUrl())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.drawable.ic_error_outline_black_80dp)
                .into(holder.userImageView);

        holder.userNameView.setText(currentUser.getUserName());

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userImageView;
        TextView userNameView;

        public ViewHolder(View itemView) {
            super(itemView);

            userImageView = itemView.findViewById(R.id.user_image_view);
            userNameView = itemView.findViewById(R.id.user_name_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    UserDetailsFragment userDetailsFragment = UserDetailsFragment.newInstance(usersList.get(position));

                    communicator.onHandleClick(userDetailsFragment);
                }
            });
        }
    }
}

package com.codingblocks.apigithbuserokhttp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class APIAdapter extends RecyclerView.Adapter<APIAdapter.viewHolder> {

    ArrayList<User> users;
    Context ctx;

    public APIAdapter(ArrayList<User> users, Context ctx) {
        this.users = users;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public APIAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View inflateView=layoutInflater.inflate(R.layout.item_row,viewGroup,false);
        viewHolder holder=new viewHolder(inflateView);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull APIAdapter.viewHolder viewHolder, int i) {
        final User user= users.get(i);
        viewHolder.login.setText(user.getLogin());
        Picasso.get().load(Uri.parse(user.getAvatarUrl())).into(viewHolder.image);
        viewHolder.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ctx,DetailAct.class);
                i.putExtra("url",user.getUrl());
                ctx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView login;
        ImageView image;

        viewHolder(View itemView) {
            super(itemView);
            login=itemView.findViewById(R.id.tvView_login);
            image =itemView.findViewById(R.id.userImg);


        }
    }

}

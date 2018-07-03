package com.example.dell1.github_profiles_hw_l09;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private Context ctx;
    private Result result;

    public ProfileAdapter(Result result,Context ctx) {
        this.ctx = ctx;
        this.result = result;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        TextView login;
        TextView id;
        ImageView imageView;
        TextView link;
        public ViewHolder(View itemView) {
            super(itemView);
            login=itemView.findViewById(R.id.userid_tv);
            imageView=itemView.findViewById(R.id.userImage_iv);
        }
    }


    @NonNull
    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View inflatedView=layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(inflatedView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ArrayList<User> userArrayList=result.getUsers();
        final User currentUser=userArrayList.get(position);
        if(currentUser.getLogin()!=null)
        {holder.login.setText(currentUser.getLogin());}
        else
        {
            holder.login.setText("");
        }
        if(currentUser.getImage()!=null)
        {
            Picasso.with(ctx).load(currentUser.getImage()).into(holder.imageView);
        }
        holder.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ctx,ProfileDetail.class);
                i.putExtra("login",currentUser.getLogin());
                i.putExtra("image",currentUser.getImage());
                i.putExtra("id",currentUser.getId());
                i.putExtra("link",currentUser.getUrl());
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.getUsers().size();
    }
}

package com.example.dell.astronomy;

import android.app.FragmentTransaction;

import android.content.Context;

import android.content.Intent;

import android.content.res.Configuration;

import android.net.Uri;

import android.os.Bundle;

import android.support.annotation.NonNull;

import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.RecyclerView;

import android.util.Log;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;



import com.squareup.picasso.Picasso;



import java.util.ArrayList;

public class spaceAdapter extends RecyclerView.Adapter<spaceAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<space> arraylist = new ArrayList<>();
    communicator communicator;

    public spaceAdapter(Context ctx, ArrayList<space> arraylist,communicator ma){
        this.arraylist=arraylist;
        this.ctx=ctx;
        communicator=ma;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUrl;
        TextView itemName;

        public ViewHolder(View itemView) {
            super(itemView);
            imgUrl=itemView.findViewById(R.id.space_image_item);
            itemName=itemView.findViewById(R.id.space_tv_item);
        }
    }

    @NonNull
    @Override
    public spaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View inflatedView=layoutInflater.inflate(R.layout.space_item_row,parent,false);
        ViewHolder mvholder=new ViewHolder(inflatedView);
        return mvholder;
    }
    @Override
    public void onBindViewHolder(@NonNull spaceAdapter.ViewHolder holder, int position){

        final space currentplanetitem = arraylist.get(position);
        holder.itemName.setText(currentplanetitem.getName());
        Picasso.with(ctx).load(currentplanetitem.getImageUrl()).into(holder.imgUrl);
        if(ctx.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
        {holder.itemName.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent i=new Intent(ctx,detailActivity.class);
                i.putExtra("url",currentplanetitem.getImageUrl());
                int x=currentplanetitem.getType_item();
                switch (x){
                    case 0:
                        i.putExtra("type","PLANET");
                        break;
                    case 1:
                        i.putExtra("type","STAR");
                        break;
                    case 2:
                        i.putExtra("type","GALAXY");
                        break;
                }
                i.putExtra("name",currentplanetitem.getName());
                i.putExtra("detail",currentplanetitem.getDetails());
                i.putExtra("wikiLink",currentplanetitem.getWikiUrl());
                ctx.startActivity(i);
            }

        });}
        if(ctx.getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            holder.itemName.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {
                    communicator.startFragmentDetail(detailFragment.newInstance(currentplanetitem));
                }

            });
        }
    }
    @Override
    public int getItemCount() {
        return arraylist.size();
    }
}
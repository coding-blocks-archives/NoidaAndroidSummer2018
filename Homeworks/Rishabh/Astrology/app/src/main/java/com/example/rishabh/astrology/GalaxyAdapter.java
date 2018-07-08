package com.example.rishabh.astrology;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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

public class GalaxyAdapter extends RecyclerView.Adapter<GalaxyAdapter.GalaxyHolder> {

    ArrayList<GalaxyData> galaxyData;
    MainActivity mainActivity;
    Context ctx;

    public GalaxyAdapter(ArrayList<GalaxyData> galaxyData, MainActivity mainActivity, Context ctx) {
        this.galaxyData = galaxyData;
        this.mainActivity = mainActivity;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public GalaxyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_list,parent ,false);
        return new GalaxyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalaxyHolder holder, int position) {

        final GalaxyData galaxyData1 = galaxyData.get(position);
        holder.galaxyName.setText(galaxyData1.getName());
//        holder.galaxyImage.setImageURI(Uri.parse(galaxyData1.getImageUrl()));
        Picasso.get().load(galaxyData1.getImageUrl()).resize(500,500).error(R.drawable.ic_launcher_background).into(holder.galaxyImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int orientation = ctx.getResources().getConfiguration().orientation;

                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Intent i = new Intent(ctx, Detail.class);
                    i.putExtra("name", galaxyData1.getName());
                    i.putExtra("url", galaxyData1.getImageUrl());
                    ctx.startActivity(i);
                }
                else
                {
                    MainActivity ma = (MainActivity) ctx;
                    ma.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.detail_container , new Detail_Fragment(galaxyData1))
                            .commit();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return galaxyData.size();
    }


    class GalaxyHolder extends RecyclerView.ViewHolder{
        TextView galaxyName;
        ImageView galaxyImage;

        public GalaxyHolder(View itemView) {
            super(itemView);
            galaxyName = itemView.findViewById(R.id.name_list);
            galaxyImage = itemView.findViewById(R.id.image_list);


        }

    }
}

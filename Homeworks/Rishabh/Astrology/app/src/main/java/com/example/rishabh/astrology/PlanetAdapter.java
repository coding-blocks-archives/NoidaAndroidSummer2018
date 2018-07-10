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

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {
    @NonNull
//    @Override
    ArrayList<PlanetData> planetData;
    MainActivity mainActivity;
    Context ctx;

    public PlanetAdapter(@NonNull ArrayList<PlanetData> planetData, Context ctx) {
        this.planetData = planetData;
//        this.mainActivity = mainActivity;
        this.ctx = ctx;
        mainActivity = (MainActivity)ctx;
    }


    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_list,parent ,false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {
        final PlanetData planetdata = planetData.get(position);

        holder.planetName.setText(planetdata.getName());
//        holder.planetImage.setImageURI(Uri.parse(planetdata.getImageUrl()));
        Picasso.get().load(planetdata.getImageUrl()).resize(500,500).error(R.drawable.ic_launcher_background).into(holder.planetImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int orientation = ctx.getResources().getConfiguration().orientation;

                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Intent i = new Intent(ctx, Detail.class);
                    i.putExtra("name", planetdata.getName());
                    i.putExtra("url", planetdata.getImageUrl());
                    ctx.startActivity(i);
                }
                else
                {
                    MainActivity ma = (MainActivity) ctx;
                    ma.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.detail_container , new Detail_Fragment(planetdata))
                            .commit();

                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return planetData.size();
    }


    class PlanetHolder extends RecyclerView.ViewHolder{

        TextView planetName;
        ImageView planetImage;
        public PlanetHolder(View itemView) {
            super(itemView);
             planetName = itemView.findViewById(R.id.name_list);
             planetImage = itemView.findViewById(R.id.image_list);

        }
    }

}

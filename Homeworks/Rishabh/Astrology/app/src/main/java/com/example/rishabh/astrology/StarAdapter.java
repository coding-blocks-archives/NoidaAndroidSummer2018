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

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarHolder>
{

    ArrayList<StarData> starData;
    MainActivity mainActivity;
    Context ctx;

    public StarAdapter(ArrayList<StarData> starData, MainActivity mainActivity, Context ctx) {
        this.starData = starData;
        this.mainActivity = mainActivity;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public StarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_list,parent ,false);
        return new StarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarHolder holder, int position) {

        final StarData starData1 = starData.get(position);
        holder.starName.setText(starData1.getName());
//        holder.starImage.setImageURI(Uri.parse(starData1.getImageUrl()));
        Picasso.get().load(starData1.getImageUrl()).resize(500,500).error(R.drawable.ic_launcher_background).into(holder.starImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int orientation = ctx.getResources().getConfiguration().orientation;

                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Intent i = new Intent(ctx, Detail.class);
                    i.putExtra("name", starData1.getName());
                    i.putExtra("url", starData1.getImageUrl());
                    ctx.startActivity(i);
                }
                else
                {
                    MainActivity ma = (MainActivity) ctx;
                    ma.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.detail_container , new Detail_Fragment(starData1))
                            .commit();

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return starData.size();
    }


    class StarHolder extends RecyclerView.ViewHolder {

        TextView starName;
        ImageView starImage;

        public StarHolder(View itemView) {
            super(itemView);
            starName = itemView.findViewById(R.id.name_list);
            starImage = itemView.findViewById(R.id.image_list);

        }
    }
}

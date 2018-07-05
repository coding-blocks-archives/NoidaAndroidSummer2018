package com.codingblocks.astronomy;

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

public class SpaceAdapter extends RecyclerView.Adapter<SpaceAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<Space> arrayList;
    Communicator communicator;

    public SpaceAdapter(Context ctx, ArrayList<Space> arrayList, Communicator communicator) {
        this.ctx = ctx;
        this.arrayList = arrayList;
        this.communicator = communicator;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li=LayoutInflater.from(ctx);
        View inflatedview =li.inflate(R.layout.space_itemrow,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(inflatedview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     final Space currentitem =arrayList.get(i);
    viewHolder.itemName.setText(currentitem.getName());
   Picasso.get().load(Uri.parse(currentitem.getImageUrl())).into(viewHolder.imgUrl);

   if(ctx.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
       viewHolder.itemName.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(ctx,DetailActivity.class);

               int x=currentitem.getType_item();
               switch (x){
                   case 0:i.putExtra("type","PLANET");
                   break;
                   case 1:i.putExtra("type","STAR");
                       break;
                   case 2:i.putExtra("type","GALAXY");
                       break;
               }

               i.putExtra("url",currentitem.getImageUrl());
               i.putExtra("name",currentitem.getName());
               i.putExtra("detail",currentitem.getDetails());
               i.putExtra("wikilink",currentitem.getWikiUrl());

               ctx.startActivity(i);



           }
       });
   }
        if(ctx.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
            viewHolder.itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    communicator.startfragmentdetail(DetailFragment.newInstance(currentitem));
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        ImageView imgUrl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUrl=itemView.findViewById(R.id.space_imageItem);
            itemName=itemView.findViewById(R.id.space_tvItem);

        }
    }
}

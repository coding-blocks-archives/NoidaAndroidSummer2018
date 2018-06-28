package com.example.dell1.explorespace;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
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

public class SpaceAdapter extends RecyclerView.Adapter<SpaceAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<Space> arraylist = new ArrayList<>();
    Communicator communicator;

    public SpaceAdapter(Context ctx, ArrayList<Space> arraylist,Communicator ma){
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
    public SpaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View inflatedView=layoutInflater.inflate(R.layout.space_item_row,parent,false);
        ViewHolder mvholder=new ViewHolder(inflatedView);
        return mvholder;
    }
    @Override
    public void onBindViewHolder(@NonNull final SpaceAdapter.ViewHolder holder, int position){

            final Space currentplanetitem = arraylist.get(position);
            holder.itemName.setText(currentplanetitem.getName());
            Picasso.with(ctx).load(currentplanetitem.getImageUrl()).into(holder.imgUrl);
            holder.itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(ctx,DetailActivity.class);
                    i.putExtra("url",currentplanetitem.getImageUrl());
                    ctx.startActivity(i);
//                     MainActivity mi=(MainActivity) view.getContext();
//                     Space s=arraylist.get(holder.getAdapterPosition());
//                     DetailFragment detailFragment= DetailFragment.newInstance(s);
//                     Log.e("TAG","onClick:"+s.getType_item() + " " + s.getName());
//                    mi.startFragmentDetail(detailFragment);
//                    mi.handleClick(s);
                    fragmentJump(currentplanetitem);

                }
            });

//            Space currentstaritem = Space.getSpaceArrayList(1).get(position);
//            holder.itemName.setText(currentstaritem.getName());
//            Picasso.with(ctx).load(currentstaritem.getImageUrl()).into(holder.imgUrl);
    }
    DetailFragment mFragment;
    Bundle mBundle;
    public void fragmentJump(Space s){
        mFragment=new DetailFragment();
        mBundle=new Bundle();
        mBundle.putParcelable("SPACE",s);
        mFragment.setArguments(mBundle);
        switchContent(R.id.fragmentcontainer,mFragment);
    }
    public void switchContent(int id,Fragment f){
        if(ctx==null){
            return;
        }
        if(ctx instanceof MainActivity){
            MainActivity mi=(MainActivity) ctx;
            Fragment frag=f;
            mi.switchContent(id,frag);
        }
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }
}

package com.chirag_bhardwaj.mygithub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Users> arrayList;


    public MyAdapter(Context ctx, ArrayList<Users> arrayList) {
        this.ctx = ctx;
        this.arrayList = arrayList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = arrayList.get(position);
        holder.textView.setText(users.login);
        Picasso.get().load(users.avatarUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(arrayList.size()==0)
            return Integer.parseInt(null);
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.nameDisplay);
        }
    }


}
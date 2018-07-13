package com.example.robin.info;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class infoAdapter extends RecyclerView.Adapter<infoAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<info> infoArrayList ;
    private MainActivity mainActivity;


    public infoAdapter(Context ctx, ArrayList<info> infoArrayList,MainActivity ma) {
        this.ctx = ctx;
        this.infoArrayList = infoArrayList;
        mainActivity=ma;
    }

    @NonNull
    @Override
    public infoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.item_row,parent,false);
        ViewHolder vh= new ViewHolder(inflatedView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull infoAdapter.ViewHolder holder, int position) {
            info f = infoArrayList.get(position);
            holder.name.setText(f.getName());

    }

    @Override
    public int getItemCount() {
        return infoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    info i = infoArrayList.get(getAdapterPosition());
                   // int cp = getAdapterPosition();
                    mainActivity.startFragmentDetail(new FragmentB(i.getName(),i.getProfession(),i.getImageurl()));
                }
            });
        }
    }
}

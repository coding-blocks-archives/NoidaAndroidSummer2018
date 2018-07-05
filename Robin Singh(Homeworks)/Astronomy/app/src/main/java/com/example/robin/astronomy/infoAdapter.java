package com.example.robin.astronomy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class infoAdapter extends RecyclerView.Adapter<infoAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<info> infoArrayList ;

    public infoAdapter(Context ctx, ArrayList<info> infoArrayList) {
        this.ctx = ctx;
        this.infoArrayList = infoArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.item_row,parent,false);
        ViewHolder vh= new ViewHolder(inflatedView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        info f = infoArrayList.get(position);
        holder.name.setText(f.getName());
        holder.name.setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    public int getItemCount() {
        return infoArrayList.size();
    }
    public void setItems(ArrayList<info> orderList){
        orderList.clear();
        orderList.addAll(orderList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public ViewHolder(final View inflatedView) {
            super(inflatedView);
            name = inflatedView.findViewById(R.id.item_name);

            inflatedView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    info f = infoArrayList.get(getAdapterPosition());
                    Intent i = new Intent(ctx,DetailActivity.class);
                    i.putExtra("name",f.getName());
                    i.putExtra("imgurl",f.getImgurl());
                    i.putExtra("detail",f.getDetail());
                    ctx.startActivity(i);

                }
            });
        }
    }
}

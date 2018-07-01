package com.example.delllatitude.lec6hwspaceapp;

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

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context ctx;
    ArrayList<Data> dataArrayList;
    Communicator communicator;

    public DataAdapter(Context ctx, ArrayList<Data> dataArrayList, Communicator communicator) {
        this.ctx = ctx;
        this.dataArrayList = dataArrayList;
        this.communicator = communicator;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.list_row_layout, parent, false);
        DataViewHolder planetViewHolder = new DataViewHolder(view);
        return planetViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data currData = dataArrayList.get(position);
//        holder.iv = currData.getImageUrl();
//        Picasso.get().load(currData.getImageUrl().into(holder.iv);
//                .error(R.drawable.ic_error)
        Picasso.get().load(currData.getImageUrl()).placeholder(R.mipmap.ic_launcher).into(holder.iv);
        holder.tvName.setText(currData.getName());
        holder.tvDetail.setText(currData.getData());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }


    class DataViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvName, tvDetail;

        public DataViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.ivListRow);
            tvName=itemView.findViewById(R.id.tvNameListRow);
            tvDetail=itemView.findViewById(R.id.tvDetailLstRow);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }
    }
}

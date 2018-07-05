package garg.ayush.astronomyapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    ArrayList<Astronomy> arrayList;
    Context ctx;
    MainActivity mainActivity;

    public MyRecyclerViewAdapter(ArrayList<Astronomy> arrayList, Context ctx, MainActivity mainActivity) {
        this.arrayList = arrayList;
        this.ctx = ctx;
        this.mainActivity = mainActivity;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView photo;
        TextView name;


        public ViewHolder(View itemView) {
            super(itemView);
            photo=itemView.findViewById(R.id.item_row_image);
            name=itemView.findViewById(R.id.item_row_name);
//            context=itemView.getContext();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Astronomy astronomy = arrayList.get(position);
        holder.name.setText(astronomy.getName());
        Picasso.get().load(astronomy.getUrlImage()).into(holder.photo);
        final ViewHolder vh =holder;
        vh.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,ActivityDetail.class);
                Log.e("TAG", "onClick: " +ctx+"   ");
                intent.putExtra("name",astronomy.getName());
                intent.putExtra("URLImage",astronomy.getUrlImage());
                intent.putExtra("Description",astronomy.getDescription());
                intent.putExtra("URLDescription",astronomy.getUrlDescription());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

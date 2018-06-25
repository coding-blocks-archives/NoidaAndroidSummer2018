package com.codingblocks.heterogeneousrecyclerview;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyHeterogeneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Object> objectArrayList;
    Context ctx;

    public MyHeterogeneousAdapter(ArrayList<Object> objectArrayList, Context ctx) {
        this.objectArrayList = objectArrayList;
        this.ctx = ctx;
    }

    @Override
    public long getItemId(int position) {
        Object currentObject = objectArrayList.get(position);
        if (currentObject instanceof TextMessage) {
            return 0;
        } else if (currentObject instanceof ImageMessage) {
            return 1;
        } else
            return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        if (i == 0) {
            View view = layoutInflater.inflate(R.layout.item_text, viewGroup, false);
            return new TextHolder(view);
        } else if (i == 1) {
            View view = layoutInflater.inflate(R.layout.item_image, viewGroup, false);
            return new ImageHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Object currentObject = objectArrayList.get(i);
        Log.e("TAG", "onBindViewHolder: " + getItemId(i));
        if (getItemId(i) == 0) {
            TextHolder th = (TextHolder) viewHolder;
            TextMessage tm = (TextMessage) currentObject;
            th.userName.setText(tm.getMessage());
        } else if (getItemId(i) == 1) {
            ImageHolder ih = (ImageHolder) viewHolder;
            ImageMessage im = (ImageMessage) currentObject;
            Picasso.get().load(im.getImageUrl()).into(ih.userImage);
        }

    }

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        ImageView userImage;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.imageItemTwo);
        }
    }

    class TextHolder extends RecyclerView.ViewHolder {
        TextView userName;

        public TextHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.tvItemOne);
        }
    }


}

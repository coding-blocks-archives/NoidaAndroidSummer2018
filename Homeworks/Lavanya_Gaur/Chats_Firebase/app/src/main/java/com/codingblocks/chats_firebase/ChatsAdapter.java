package com.codingblocks.chats_firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<Chats> chatsArrayList;

    public ChatsAdapter(Context ctx, ArrayList<Chats> chatsArrayList) {
        this.ctx = ctx;
        this.chatsArrayList = chatsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.item_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflatedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Chats chats=chatsArrayList.get(position);
       holder.displaytext.setText(chats.getText());

        Picasso.get().load(chats.getImageUrl()).into(holder.imageView);




    }

    @Override
    public int getItemCount() {
        return chatsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView displaytext;
        ImageView imageView;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            displaytext = itemView.findViewById(R.id.text);
            imageView=itemView.findViewById(R.id.image);


        }
    }
}

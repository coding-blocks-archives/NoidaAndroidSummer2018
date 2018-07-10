package com.example.dhirajchhabraeng.whatsappchatpage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder> {
    Context ctx;
    ArrayList<Chat> chatsList;

    public ChatsAdapter(Context ctx, ArrayList<Chat> chatsList) {
        this.ctx = ctx;
        this.chatsList = chatsList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        de.hdodenhof.circleimageview.CircleImageView personImageView;
        ImageView seenFlagImageView;
        TextView personNameView, timeTextView, lastMessageTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            personImageView = itemView.findViewById(R.id.person_image);
            personNameView = itemView.findViewById(R.id.person_name);
            timeTextView = itemView.findViewById(R.id.time_view);
            lastMessageTextView = itemView.findViewById(R.id.lastMessage_view);
            seenFlagImageView = itemView.findViewById(R.id.seen_flag);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(ctx).inflate(R.layout.list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(inflatedView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        de.hdodenhof.circleimageview.CircleImageView personImageView = holder.personImageView;

        DownloadFileTask downloadFileTask = new DownloadFileTask(personImageView, ctx);
        downloadFileTask.execute(chatsList.get(position).getPersonImage());

        holder.personNameView.setText(chatsList.get(position).getPersonName());
        holder.timeTextView.setText(chatsList.get(position).getTimeText());
        holder.seenFlagImageView.setImageDrawable(chatsList.get(position).getSeenFlag());
        holder.lastMessageTextView.setText(chatsList.get(position).getLastMessage());
    }

    @Override
    public int getItemCount() {
        return chatsList.size();
    }


}

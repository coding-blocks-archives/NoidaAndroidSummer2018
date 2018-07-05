package com.example.ashu.whatsapp;

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
import java.util.Random;
import java.util.zip.GZIPInputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    String gTitle,gContent,gDate;
    String gImage;
   Context ctx;
   public ArrayList<messageInfo> messageInfoArrayList;

    public NoteAdapter(Context ctx, ArrayList<messageInfo> messageInfoArrayList) {
        this.ctx = ctx;
        this.messageInfoArrayList = messageInfoArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder =new ViewHolder(inflatedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
//        Random r = new Random();
//       NoteAdapter noteAdapter = messageInfoArrayList.get(position);
//        gContent = messageInfoArrayList.get(r.nextInt(messageInfoArrayList.size())).getmContent();
//        gTitle =  messageInfoArrayList.get(r.nextInt(messageInfoArrayList.size())).getmTitle();
//        gDate =  messageInfoArrayList.get(r.nextInt(messageInfoArrayList.size())).getmDate();
//        gImage = messageInfoArrayList.get(position).getmImageResourceId();

        viewHolder.mTitle.setText(messageInfoArrayList.get(position).getmTitle());
        viewHolder.mContent.setText(messageInfoArrayList.get(position).getmContent());
        viewHolder.mDate.setText(messageInfoArrayList.get(position).getmDate());
        Picasso
                .get()
                .load(messageInfoArrayList.get(position).getmImageResourceId())
                .resize(80,80)
                .placeholder(R.drawable.u1)
                .into(viewHolder.mImage);

    }

    @Override
    public int getItemCount() {
        return messageInfoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle,mContent,mDate;
        CircleImageView mImage;


        public ViewHolder(View itemView) {
            super(itemView);
           mTitle = itemView.findViewById(R.id.titleView);
           mContent = itemView.findViewById(R.id.contentView);
           mImage = itemView.findViewById(R.id.profile_image);
           mDate = itemView.findViewById(R.id.dateView);

        }
    }
}

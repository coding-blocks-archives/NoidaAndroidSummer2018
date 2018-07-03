package com.example.dell1.whatsapphw_l5;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder>{
    private Context ctx;
    private ArrayList<Note> noteArrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vhtitle;
        TextView vhdetail;
        TextView vhtime;
        ImageView vhimage;
        public MyViewHolder(View itemView) {
            super(itemView);
            vhtitle=itemView.findViewById(R.id.titletv);
            vhdetail=itemView.findViewById(R.id.detailtv);
            vhtime=itemView.findViewById(R.id.timetv);
            vhimage=itemView.findViewById(R.id.iv1);
            String url="https://randomuser.me/api/?inc=picture and format=xml";
            Picasso.with(ctx).load(Uri.parse(url)).fit().into(vhimage);

        }
    }


    public NotesAdapter(ArrayList<Note> noteArrayList,Context ctx) {
        this.noteArrayList = noteArrayList;
        this.ctx=ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li=LayoutInflater.from(ctx);
        View inflatedview=li.inflate(R.layout.item_row,parent,false);
        MyViewHolder mvholder=new MyViewHolder(inflatedview);
        return mvholder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position) {

        Note currentnote=noteArrayList.get(position);
        holder.vhtitle.setText(currentnote.getTitle());
        holder.vhdetail.setText(currentnote.getDetail());
        holder.vhtime.setText(currentnote.getTime());
    }
    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }


}

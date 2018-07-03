package com.example.dell1.notetakingl5_hw1;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder>{

    private Context ctx;
    private ArrayList<Note> noteArrayList;
    private RecyclerView rvNote;
    
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vhnote;
        public MyViewHolder(View itemView) {
            super(itemView);
            vhnote=itemView.findViewById(R.id.notetv);
            vhnote.setOnClickListener(new View.OnClickListener() {
                int itemclickcount=0;
                @Override
                public void onClick(View view) {
                    itemclickcount++;
                    itemclickcount=(itemclickcount)%3;
                         if(itemclickcount==1)
                         {
                            vhnote.setBackgroundColor(Color.parseColor("#ffff00"));
//                            NotesAdapter.this.notifyDataSetChanged();
                            Toast.makeText(ctx,"Note is set important!",Toast.LENGTH_SHORT).show();
                             Log.e("NotesAdapter","click:"+itemclickcount);
//                            vhnote.notify();  incorrect
                         }
                         else if(itemclickcount==2)
                         {
                             vhnote.setBackgroundColor(Color.parseColor("#ff0000"));
//                             NotesAdapter.this.notifyDataSetChanged();
                             Toast.makeText(ctx,"Note is set urgent!",Toast.LENGTH_SHORT).show();
                             Log.e("NotesAdapter","click:"+itemclickcount);
//                             vhnote.notify();    incorrect
                         }
                         else if(itemclickcount==0)
                         {
                             vhnote.setBackgroundColor(Color.parseColor("#00ff00"));
//                             NotesAdapter.this.notifyDataSetChanged();
                             Log.e("NotesAdapter","click:"+itemclickcount);
                         }
                }
            });
//
        }
    }


    public NotesAdapter(ArrayList<Note> noteArrayList,Context ctx,RecyclerView rvNote) {
        this.noteArrayList = noteArrayList;
        this.ctx=ctx;
        this.rvNote=rvNote;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li=LayoutInflater.from(ctx);
        View inflatedview=li.inflate(R.layout.list_item,parent,false);
        MyViewHolder mvholder=new MyViewHolder(inflatedview);
        return mvholder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Note currentnote=noteArrayList.get(position);
        holder.vhnote.setText(currentnote.getNote());
        holder.vhnote.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
                public boolean onLongClick(View view) {
                   noteArrayList.remove(position);
                   notifyItemRemoved(position);
                   notifyItemRangeChanged(position,getItemCount());
                    Toast.makeText(ctx,"Note deleted!",Toast.LENGTH_SHORT).show();
                    Log.e("NotesAdapter","onremoval" + (position));
                    return true;
                }});

        }
    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }
}

package com.example.dell.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<id> noteArraylist;
    private id note;

    public NoteAdapter(Context ctx, ArrayList<id> noteArraylist,id a) {
        this.ctx = ctx;
        this.noteArraylist = noteArraylist;
        note=a;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedview = li.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflatedview);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        note = noteArraylist.get(position);

        holder.idtext.setText(note.getText() + note.getText());
        holder.idtime.setText(note.getTime());

/*final ViewHolder vh=holder;
        holder.idtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (note.getColor()) {
                    case "#17f505": vh.idtext.setBackgroundColor(Color.parseColor("#fa1010"));
                        note.setColor("#fa1010");
                        break;
                    case "#fa1010": itemView.setBackgroundColor(Color.parseColor("#e7e72d"));
                        note.setColor("#e7e72d");
                        break;
                    case "#e7e72d": itemView.setBackgroundColor(Color.parseColor("#17f505"));
                        note.setColor("#17f505");
                        break;
                    default:    itemView.setBackgroundColor(Color.parseColor("#17f505"));
                        note.setColor("#17f505");
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return noteArraylist.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView idtext, idtime;
        int a=0;
String TAG="gghh";

        public ViewHolder(final View itemView) {
            super(itemView);
            idtext = itemView.findViewById(R.id.item);
            idtime = itemView.findViewById(R.id.item1);
            itemView.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    noteArraylist.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    return false;
                }
            });
          //  Log.e(TAG, "ViewHolder:"+note );
            // final String color=note.getColor();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (note.getColor()) {
                        case "#17f505": itemView.setBackgroundColor(Color.parseColor("#fa1010"));
                                        note.setColor("#fa1010");
                                        break;
                        case "#fa1010": itemView.setBackgroundColor(Color.parseColor("#e7e72d"));
                                        note.setColor("#e7e72d");
                                        break;
                        case "#e7e72d": itemView.setBackgroundColor(Color.parseColor("#17f505"));
                                        note.setColor("#17f505");
                                        break;
                        default:    itemView.setBackgroundColor(Color.parseColor("#17f505"));
                                    note.setColor("#17f505");
                    }
                }
            });
        }
    }
}
package com.codingblocks.recyclerviewcustomadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<Note> noteArrayList;

    public NotesAdapter(Context ctx, ArrayList<Note> noteArrayList) {
        this.ctx = ctx;
        this.noteArrayList = noteArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.item_row,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(inflatedView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Note note = noteArrayList.get(i);
        viewHolder.noteTitle.setText(note.getNote());
        viewHolder.noteDetail.setText(note.getNote() + note.getNote());
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle,noteDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            noteDetail = itemView.findViewById(R.id.tvDetails);
            noteTitle = itemView.findViewById(R.id.tvNote);

            getAdapterPosition();  //Current position

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            noteTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }

}

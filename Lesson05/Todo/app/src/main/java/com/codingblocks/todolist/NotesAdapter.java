package com.codingblocks.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {

    Context ctx;
    ArrayList<Note> noteArrayList;

    public NotesAdapter(ArrayList<Note> notes, Context context) {
        noteArrayList = notes;
        ctx = context;
    }

    @Override
    public int getCount() {
        return noteArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder{
        TextView noteTitle,noteDetail;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View inflatedView;
        if (view == null){
            LayoutInflater li = LayoutInflater.from(ctx);
            inflatedView = li.inflate(R.layout.item_row,viewGroup,false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.noteTitle = inflatedView.findViewById(R.id.tvNote);
            viewHolder.noteDetail = inflatedView.findViewById(R.id.tvDetails);
            inflatedView.setTag(viewHolder);
        }else {
            inflatedView = view;
        }
        final Note note = noteArrayList.get(i);
        inflatedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteArrayList.remove(i);
                notifyDataSetChanged();
            }
        });

        ViewHolder vh = (ViewHolder) inflatedView.getTag();

        vh.noteTitle.setText(note.getNote());
        vh.noteDetail.setText(note.getNote() + note.getNote());
//        noteText.setText(note.getNote());
//        detailsText.setText(note.getNote() + note.getNote());
        return inflatedView;
    }
}

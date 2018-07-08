package com.example.dhirajchhabraeng.lecture5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {

    Context ctx;
    ArrayList<Note> notesList = new ArrayList<>();

    public NotesAdapter(Context ctx, ArrayList<Note> notesList) {
        this.ctx = ctx;
        this.notesList = notesList;
    }

    class ViewHolder {
        TextView noteTime, noteTitle, noteNotes;

        public ViewHolder(View v) {
            noteTime = v.findViewById(R.id.time_view);
            noteTitle = v.findViewById(R.id.title_view);
            noteNotes = v.findViewById(R.id.notes_view);
        }
    }

    @Override
    public int getCount() {
        return notesList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View inflatedView = convertView;

        if (inflatedView == null) {
            inflatedView = LayoutInflater.from(ctx).inflate(R.layout.list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflatedView);
            inflatedView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) inflatedView.getTag();

        Note currentNote = notesList.get(position);

        viewHolder.noteTime.setText(currentNote.getTimeText());

        viewHolder.noteTitle.setText(currentNote.getTitleText());

        viewHolder.noteNotes.setText(currentNote.getNoteText());

        inflatedView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                notesList.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });

        return inflatedView;
    }

}

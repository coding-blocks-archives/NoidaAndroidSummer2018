package com.example.dhirajchhabraeng.allnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dhirajchhabraeng.allnotes.R;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<Note> notesList;
    private TextView timeTextView,titleTextView,notesTextView;

    public NotesAdapter(Context ctx, ArrayList<Note> notesList) {
        this.ctx = ctx;
        this.notesList = notesList;
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

        if(inflatedView == null){
            inflatedView = LayoutInflater.from(ctx).inflate(R.layout.list_item, parent, false);
        }

        Note currentNote = notesList.get(position);

        timeTextView = inflatedView.findViewById(R.id.time_view);
        titleTextView = inflatedView.findViewById(R.id.title_view);
        notesTextView = inflatedView.findViewById(R.id.notes_view);

        timeTextView.setText(currentNote.getTimeText());
        titleTextView.setText(currentNote.getTitleText());
        notesTextView.setText(currentNote.getNoteText());

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

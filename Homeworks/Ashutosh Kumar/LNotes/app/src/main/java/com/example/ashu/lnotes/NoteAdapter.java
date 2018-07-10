package com.example.ashu.lnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends BaseAdapter {
   public Context ctx;
    public ArrayList<NotesInfo> myNotes;
    public NoteAdapter(Context ctx, ArrayList<NotesInfo> myNotes) {
        this.ctx = ctx;
        this.myNotes = myNotes;

    }

    @Override
    public int getCount() {
        return myNotes.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View inflatedView;
        if (view == null) {
            inflatedView = li.inflate(R.layout.list_item, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.noteTitle = inflatedView.findViewById(R.id.titleView);
            viewHolder.detail =  inflatedView.findViewById(R.id.contentView);
            viewHolder.time =  inflatedView.findViewById(R.id.timeView);
            inflatedView.setTag(viewHolder);
        } else {
            inflatedView = view;
        }


        final NotesInfo notesInfo = myNotes.get(position);
        ViewHolder vh =(ViewHolder) inflatedView.getTag();
        vh.noteTitle.setText(notesInfo.getmTitle());
        vh.detail.setText(notesInfo.getmContent());
        vh.time.setText(notesInfo.getmTime());



        return inflatedView;
    }
}
class ViewHolder {
    TextView noteTitle,detail,time;
}

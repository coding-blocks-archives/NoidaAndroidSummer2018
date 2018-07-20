package garg.ayush.noteappusingroomandlivedata;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {


    Context ctx;
    ArrayList<Notes> notesArrayList;


    public NotesAdapter(Context ctx, ArrayList<Notes> notesArrayList) {
        this.ctx = ctx;
        this.notesArrayList = notesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
        View inflatedView = li.inflate(R.layout.item_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflatedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//        Log.e("TAG", "onCreateViewHolder: " + notesArrayList.get(position).id);
        final Notes note = notesArrayList.get(position);
        String title = note.title;
        holder.noteDes.setText(note.des);
        holder.noteTitle.setText(title);


        if (note.status % 2 == 1)
            holder.noteDes.setPaintFlags(holder.noteDes.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        else
           holder.noteDes.setPaintFlags(0);

        holder.noteTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.status++;

                NotesApplication.getDb().getNotesDao().updateNotes(note);
//                NotesDatabase.updateNote(notesDatabase.getNoteWithID((long) note.id),note.status);
                if (note.status % 2 == 1) {
                    holder.noteDes.setPaintFlags(holder.noteDes.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else
                    holder.noteDes.setPaintFlags(0);
            }
        });

        holder.noteTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                notesArrayList.remove(position);
                NotesApplication.getDb().getNotesDao().deleteNotes(note);
                notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView noteTitle;
        private TextView noteDes;

        public ViewHolder(View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.tvTitle);
            noteDes = itemView.findViewById(R.id.tvDes);
        }
    }
}

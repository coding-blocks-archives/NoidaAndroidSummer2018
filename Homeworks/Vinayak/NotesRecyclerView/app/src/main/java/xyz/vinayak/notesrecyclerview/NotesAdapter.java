package xyz.vinayak.notesrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    ArrayList<Note> noteArrayList;
    Context context;

    public NotesAdapter(ArrayList<Note> noteArrayList, Context context) {
        this.noteArrayList = noteArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View inflatedView = li.inflate(R.layout.item_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(inflatedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note currentNote = noteArrayList.get(position);
        holder.noteTv.setText(currentNote.getNote());
        holder.noteDateTimeTv.setText(currentNote.getDateTime());
    }


    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView noteTv,noteDateTimeTv;
        Button btnNoteDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            noteTv = itemView.findViewById(R.id.noteTv);
            noteDateTimeTv = itemView.findViewById(R.id.noteDateTimeTv);
            btnNoteDelete = itemView.findViewById(R.id.btnNoteDelete);

            btnNoteDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    noteArrayList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });

        }
    }
}

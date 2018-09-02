package garg.ayush.notetakingappusingfirebase;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

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

        holder.noteDes.setText(note.descreiption);

    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView noteDes;

        public ViewHolder(View itemView) {
            super(itemView);
            noteDes = itemView.findViewById(R.id.text);
        }
    }
}

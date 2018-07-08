package rs21.colourednotes;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import rs21.colourednotes.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class NotesAdaptor extends RecyclerView.Adapter<NotesAdaptor.ViewHolder> {
    ArrayList<row> data;
    Context ctx;

    public NotesAdaptor(Context ctx, ArrayList<row> al) {
        this.ctx = ctx;
        this.data = al;
    }

    @NonNull
    @Override
    public NotesAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        ViewHolder vh;
        LayoutInflater li = (LayoutInflater) (ctx.getSystemService(LAYOUT_INFLATER_SERVICE));
        v = li.inflate(R.layout.item_list, parent, false);
        vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final NotesAdaptor.ViewHolder holder, final int position) {
        row curr = data.get(position);
        holder.txt1.setText(curr.text);
        if (curr.colNo == 0) {
            holder.txt1.setBackgroundResource(R.color.g);
        } else if (curr.colNo == 1) {
            holder.txt1.setBackgroundResource(R.color.y);
        } else {
            holder.txt1.setBackgroundResource(R.color.r);
        }

        holder.txt1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                data.remove(position);
                Toast.makeText(ctx, "Note Deleted!", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
                return false;
            }
        });

        holder.txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).colNo++;
                data.get(position).colNo = data.get(position).colNo % 3;
                if (data.get(position).colNo == 0) {
                    holder.txt1.setBackgroundResource(R.color.g);
                    Toast.makeText(ctx, "Note set as Important!", Toast.LENGTH_SHORT).show();
                } else if (data.get(position).colNo == 1) {
                    holder.txt1.setBackgroundResource(R.color.y);
                    Toast.makeText(ctx, "Note set as Very Important!", Toast.LENGTH_SHORT).show();

                } else {
                    holder.txt1.setBackgroundResource(R.color.r);
                    Toast.makeText(ctx, "Note set as Most Important!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1;

        public ViewHolder(View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.tvNote);
        }
    }
}

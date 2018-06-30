package rs21.infoviewer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import rs21.infoviewer.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    ArrayList<abc> data;
    Context ctx;
    Communicator communicator;

    public ListAdapter(Context ctx, ArrayList<abc> al, Communicator communicator) {
        this.ctx = ctx;
        this.data = al;
        this.communicator = communicator;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        ViewHolder vh;
        LayoutInflater li = (LayoutInflater) (ctx.getSystemService(LAYOUT_INFLATER_SERVICE));
        v = li.inflate(R.layout.item, parent, false);
        vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, final int position) {
        final abc a = data.get(position);
        holder.txt1.setText(a.name);
        holder.txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ctx.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    FragmentInfo b = FragmentInfo.newInstance(a);
                    communicator.addFragB(b);
                } else {
                    Intent i = new Intent(ctx, SecondActivity.class);
                    i.putExtra("a", a);
                    ctx.startActivity(i);
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
            txt1 = itemView.findViewById(R.id.item);
        }
    }
}

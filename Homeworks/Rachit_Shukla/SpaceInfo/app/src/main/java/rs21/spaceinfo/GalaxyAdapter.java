package rs21.spaceinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class GalaxyAdapter extends RecyclerView.Adapter<GalaxyAdapter.ViewHolder> {
    ArrayList<Galaxies> data;
    Context ctx;
    MainActivity communicator;

    public GalaxyAdapter(Context ctx, ArrayList<Galaxies> al, MainActivity communicator) {
        this.ctx = ctx;
        this.data = al;
        this.communicator = communicator;
    }

    @NonNull
    @Override
    public GalaxyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        ViewHolder vh;
        LayoutInflater li = (LayoutInflater) (ctx.getSystemService(LAYOUT_INFLATER_SERVICE));
        v = li.inflate(R.layout.item, parent, false);
        vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull GalaxyAdapter.ViewHolder holder, final int position) {
        final Galaxies a = data.get(position);
        holder.txt1.setText(a.getName());
        holder.txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout x = v.findViewById(R.id.detail);
                if (x == null) {

                } else {
                    FragDetailGalaxy.newInstance(a);
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

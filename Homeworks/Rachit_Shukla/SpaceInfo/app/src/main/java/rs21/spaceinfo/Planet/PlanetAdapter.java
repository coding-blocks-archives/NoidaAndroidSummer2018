package rs21.spaceinfo.Planet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import rs21.spaceinfo.MainActivity;
import rs21.spaceinfo.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {
    ArrayList<Planets> data;
    Context ctx;
    MainActivity communicator;

    public PlanetAdapter(Context ctx, ArrayList<Planets> al, MainActivity communicator) {
        this.ctx = ctx;
        this.data = al;
        this.communicator = communicator;
    }

    @NonNull
    @Override
    public PlanetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        ViewHolder vh;
        LayoutInflater li = (LayoutInflater) (ctx.getSystemService(LAYOUT_INFLATER_SERVICE));
        v = li.inflate(R.layout.item, parent, false);
        vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.ViewHolder holder, final int position) {
        final Planets a = data.get(position);
        holder.txt1.setText(a.getName());
        holder.txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ctx.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Intent i = new Intent(ctx, PlanetActivity.class);
                    i.putExtra("xyz", a);
                    ctx.startActivity(i);
                } else {
                    FragDetailPlanet b = FragDetailPlanet.newInstance(a);
                    communicator.addFragP(b);
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

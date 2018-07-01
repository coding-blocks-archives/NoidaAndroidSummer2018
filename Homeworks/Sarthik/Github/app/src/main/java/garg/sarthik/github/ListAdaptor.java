package garg.sarthik.github;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdaptor extends RecyclerView.Adapter<ListAdaptor.ViewHolder> {

    ArrayList<Items> itemsArrayList;
    Context ctx;

    public ListAdaptor(ArrayList<Items> itemsArrayList, Context ctx) {
        this.itemsArrayList = itemsArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_itemlist,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Items items = itemsArrayList.get(position);

        holder.tvLogin.setText(items.getLogin());
        Log.e("TAG", items.getLogin());
        Picasso.get()
                .load(items.getAvatar_url())
                .placeholder(R.drawable.ic_report)
                .resize(250,250)
                .error(R.drawable.ic_wallpaper)
                .into(holder.ivList);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity)ctx;
                ma.addIntent(items);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvLogin;
        ImageView ivList;

        public ViewHolder(View itemView) {
            super(itemView);

            tvLogin = itemView.findViewById(R.id.tvLogin);
            ivList = itemView.findViewById(R.id.ivUser);
        }
    }
}

package com.example.dell1.hw_lesson06;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<Name> namesarraylist;

    private MainActivity mi;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView namerow;
        public ViewHolder(View itemView) {
            super(itemView);
            namerow=itemView.findViewById(R.id.namelisttv);
        }
    }


    public NameAdapter(ArrayList<Name> namesarraylist,Context ctx,MainActivity mi) {
        this.namesarraylist =namesarraylist;
        this.ctx=ctx;
        this.mi=mi;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Name currentname=namesarraylist.get(position);
        holder.namerow.setText(currentname.getName());
        holder.namerow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                       mi.addFragment2(new Fragment_2(currentname));
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li=LayoutInflater.from(ctx);
        View inflatedview=li.inflate(R.layout.namedisplaylistitem_row,parent,false);
        ViewHolder mvholder=new ViewHolder(inflatedview);
        return mvholder;
    }
    @Override
    public int getItemCount() {
        return namesarraylist.size();
    }
}

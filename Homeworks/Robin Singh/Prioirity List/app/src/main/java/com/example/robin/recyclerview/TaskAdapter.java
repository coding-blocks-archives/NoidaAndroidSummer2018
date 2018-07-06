package com.example.robin.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

   // private task t;
    private Context ctx;
    private ArrayList<task> taskArrayList;
    private int[] ar = new int[]{(Color.parseColor("#2ca43b")),(Color.parseColor("#eddf08")),(Color.parseColor("#ce3037"))};

    public TaskAdapter(Context ctx,ArrayList<task> taskArrayList){
        this.ctx = ctx;
        this.taskArrayList = taskArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.item_list,parent,false);
        inflatedView.setBackgroundColor((Color.parseColor("#2ca43b")));
        ViewHolder vh= new ViewHolder(inflatedView);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        task t = taskArrayList.get(position);
        holder.task.setText(t.getTask());
        holder.time.setText(t.getTime());
        holder.i = t.getI();
        holder.relativeLayout.setBackgroundColor(ar[t.getI()]);

    }


    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView task,time;
        RelativeLayout relativeLayout;
        int i,a;
        public  ViewHolder(View itemView){
            super(itemView);
            task = itemView.findViewById(R.id.tx1);
            time = itemView.findViewById(R.id.tx2);
            relativeLayout = itemView.findViewById(R.id.rel);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    a = getAdapterPosition();
                    i= taskArrayList.get(a).getI();
                    ++i;
                    if(i==0){
                        view.setBackgroundColor(Color.parseColor("#2ca43b"));
                        taskArrayList.get(a).setI(i);
                    }
                    else if (i==1){
                        view.setBackgroundColor(Color.parseColor("#eddf08"));
                        taskArrayList.get(a).setI(i);
                    }
                    else if (i==2){
                        view.setBackgroundColor(Color.parseColor("#ce3037"));
                        taskArrayList.get(a).setI(i);
                    }
                    else{
                        i=0;
                        view.setBackgroundColor(Color.parseColor("#2ca43b"));
                        taskArrayList.get(a).setI(i);
                    }

                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int j = getAdapterPosition();
                    Log.e("TAG","j: "+j);
                    taskArrayList.remove(j);
                    notifyDataSetChanged();
                    return true;
                }
            });
        }
    }
}

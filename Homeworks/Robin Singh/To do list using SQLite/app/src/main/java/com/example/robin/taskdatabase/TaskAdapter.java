package com.example.robin.taskdatabase;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.robin.taskdatabase.db.TaskDb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    // private task t;
    TaskDb taskDb;
    private Context ctx;
    private ArrayList<Task> taskArrayList;

    //private int[] ar = new int[]{(Color.parseColor("#2ca43b")),(Color.parseColor("#eddf08")),(Color.parseColor("#ce3037"))};

    public TaskAdapter(Context ctx,ArrayList<Task> taskArrayList){
        this.ctx = ctx;
        this.taskArrayList = taskArrayList;
        taskDb = new TaskDb(ctx,
                "taskdb",
                null,
                2);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.item_row,parent,false);
        // inflatedView.setBackgroundColor((Color.parseColor("#2ca43b")));
        ViewHolder vh= new ViewHolder(inflatedView);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task t = taskArrayList.get(position);
        holder.task.setText(t.getTitle());
        DateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.US);
        //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String text = formatter.format(new Date(t.getId()));

        holder.time.setText(text);
        if(t.getIsComp()==0)
            holder.task.setPaintFlags(holder.task.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
        else
            holder.task.setPaintFlags(holder.task.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


    }


    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView task,time;
        int isComp,a;
        RelativeLayout relativeLayout;
        public  ViewHolder(final View itemView){
            super(itemView);
            task = itemView.findViewById(R.id.tx1);
            time = itemView.findViewById(R.id.tx2);
            relativeLayout = itemView.findViewById(R.id.rel);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x = getAdapterPosition();
                    a = taskArrayList.get(x).getIsComp();
                    if(a==0)
                        a=1;
                    else
                        a=0;
                    if(a==1)
                        task.setPaintFlags(task.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    else
                        task.setPaintFlags(task.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));

                    taskArrayList.get(getAdapterPosition()).setIsComp(a);
                    notifyDataSetChanged();
                    ContentValues cv = new ContentValues();
                    cv.put("isComp",a);
                    cv.put("tasktitle",taskArrayList.get(x).getTitle());
                    cv.put("id",taskArrayList.get(x).getId());
                    taskDb.getWritableDatabase().update("task",cv,"id = ?", new String[]{taskArrayList.get(x).getId()+""});
                    Log.e("TAG", "onClick: "+ taskArrayList.get(x).getIsComp() );



                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int j = getAdapterPosition();
                    Log.e("TAG","j: "+j);
                    taskDb.getWritableDatabase().delete("task","id = ?",new String[]{taskArrayList.get(j).getId() + ""});

                    taskArrayList.remove(j);
                    notifyDataSetChanged();
                    return true;
                }
            });
        }
    }
}


package com.example.robin.taskdatabase;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.robin.taskdatabase.db.TaskDb;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TaskDb taskDb;
    EditText edt;
    ArrayList<Task> tasks = new ArrayList<>();
    RecyclerView rv;
    TaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        taskDb = new TaskDb(this,
                "taskdb",
                null,
                2);
        if(getAlltask()!=null){
            tasks = getAlltask();
        }
        taskAdapter= new TaskAdapter(this,tasks);
        rv.setAdapter(taskAdapter);
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_view, null, true);
        final AlertDialog customDialog = new AlertDialog.Builder(this)
                .setTitle("Add a new Task")
                .setView(dialogView)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edt = dialogView.findViewById(R.id.edt1);
                        String t = edt.getText().toString();
                        Task task = new Task(System.currentTimeMillis(), t, 0);
                        long position = insertTask(task);
                        Log.e("TAG", "onCreate: task inserted at position " + position );
                        edt.setText("");
                        Log.e("TAG","Size: "+ getAlltask().size());

                        //tasks.add(task);
                        //taskAdapter.notifyDataSetChanged();


                    }
                })
                .create();


        FloatingActionButton mfab = findViewById(R.id.fab);
        mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.show();
            }

        });
    }


    public  ArrayList<Task>  getAlltask() {


        tasks.clear();
        if(taskDb!=null) {
            Cursor c = taskDb.getReadableDatabase().query("task",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);

            while (c.moveToNext()) {
                //tasks.clear();
                Long id = c.getLong(c.getColumnIndex("id"));
                String title = c.getString(c.getColumnIndex("tasktitle"));
                Integer isComp = c.getInt(c.getColumnIndex("isComp"));
                Task task = new Task(id, title, isComp);
                tasks.add(task);
            }
            c.close();
            return tasks;
        }
        else
            return null;


    }


    public  Task getTaskId(long id){

        Cursor c = taskDb.getReadableDatabase().query("task",
                null,
                "id = ? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        Task tk = null;

        while(c.moveToNext()) {
            Long fetchId = c.getLong(0);
            String fetchTitle = c.getString(1);
            Integer isComp = c.getInt(2);

            tk = new Task(fetchId, fetchTitle, isComp);
        }
        c.close();
        return tk;
    }

    long insertTask(Task task){

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", task.getId());
        contentValues.put("tasktitle",task.getTitle());
        contentValues.put("isComp", task.getIsComp());
        long l = taskDb.getWritableDatabase()
                .insert("task",
                        null,
                        contentValues);
        return  l;

    }
}



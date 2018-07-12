package com.codingblocks.taskdatabase;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.codingblocks.taskdatabase.db.TaskDb;
import com.codingblocks.taskdatabase.models.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TaskDb taskDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInsert = findViewById(R.id.btnInsert);
        taskDb = new TaskDb(getBaseContext());

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task(System.currentTimeMillis(),
                        "Hello World, the time is " + System.currentTimeMillis());
                long position = taskDb.insertTask(task);
                Log.e("TAG", "onCreate: task inserted at position" + position);
            }
        });

        Log.e("TAG", "onCreate: data size " + fetchTasks()
                .get(16).getTitle());

        Log.e("TAG", "onCreate: cursor with id 1531395872943" + taskDb
                .getTaskWithID(1531395872943L).getTitle());

    }

    ArrayList<Task> fetchTasks() {
        return taskDb.getAllTasks();
    }


}

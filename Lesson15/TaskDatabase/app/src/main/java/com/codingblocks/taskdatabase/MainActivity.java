package com.codingblocks.taskdatabase;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codingblocks.taskdatabase.db.TaskDb;
import com.codingblocks.taskdatabase.models.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TaskDb taskDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskDb = new TaskDb(this);

        Task task = new Task(System.currentTimeMillis(), "Hello World");

        long position = insertTask(task);

        Log.e("TAG", "onCreate: task inserted at position" + position );
    }

    long insertTask(Task task) {
//        String insertQuery = "INSERT INTO task VALUES( " +
//                task.getId() +
//                ", ); DROP TABLE task;"
//                + " );";

        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.COLUMN_ID, task.getId());
        contentValues.put(Constants.COLUMN_TITLE, task.getTitle());

        //Store this to the database
        long position = taskDb.getWritableDatabase()
                .insert(Constants.TABLE_NAME,
                        null,
                        contentValues);

        return  position;
    }

    Task getTaskWithID(Long id) {
        //return a task with the given ID
        return null;
    }

    ArrayList<Task> getAllTasks() {

        //return an arraylist of all the tasks stored in the db
        return null;
    }

}

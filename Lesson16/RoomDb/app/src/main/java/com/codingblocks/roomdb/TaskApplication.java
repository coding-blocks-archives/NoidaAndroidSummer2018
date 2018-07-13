package com.codingblocks.roomdb;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.codingblocks.roomdb.db.TaskDatabase;

public class TaskApplication extends Application {

    static TaskDatabase taskDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        taskDatabase = Room.
                databaseBuilder(getApplicationContext(),
                        TaskDatabase.class,
                        "task-db")
                .fallbackToDestructiveMigration()
                //This allows ROOM to run the db queries on the Main Thread
                .allowMainThreadQueries()
                .build();
    }

    public static TaskDatabase getDb() {
//        if (taskDatabase == null) {
//            //initialize taskDatabase
//        }
        return taskDatabase;
    }

}

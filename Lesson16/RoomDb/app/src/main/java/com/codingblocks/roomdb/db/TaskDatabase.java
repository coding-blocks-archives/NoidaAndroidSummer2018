package com.codingblocks.roomdb.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.codingblocks.roomdb.model.Task;

@Database(entities = {Task.class}, version = 2)
public abstract class TaskDatabase extends RoomDatabase {

    public abstract TaskDao getTaskDao();

}

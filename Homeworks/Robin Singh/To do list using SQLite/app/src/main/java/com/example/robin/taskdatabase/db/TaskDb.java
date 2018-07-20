package com.example.robin.taskdatabase.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDb extends SQLiteOpenHelper {

    public TaskDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query  = "CREATE TABLE task "+
                        "( id INTEGER PRIMARY KEY, "+
                        "tasktitle TEXT NOT NULL , " +
                        "isComp INTEGER );";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.codingblocks.taskdatabase.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.codingblocks.taskdatabase.Constants;
import com.codingblocks.taskdatabase.Constants.*;

import static com.codingblocks.taskdatabase.Constants.*;

public class TaskDb extends SQLiteOpenHelper{

    public TaskDb(Context context) {
        super(context, "taskdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Called when the db was created for the first time, or its version
        //was incremented.
        //You can use this callback to create as many tables as you want
        //or fill them with some random data for the first launch of your app.
        String query = CREATE + TABLE_NAME +
                RBR + COLUMN_ID + INTEGER + PRIMARY_KEY + COMMA
                + COLUMN_TITLE + TEXT + NOT_NULL + LBR
                + TERMINATION;

        Log.e("TAG", "onCreate: SQLiteOpenHelper" + query);
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //perform table alterations here, or let the default implementation
        // happen which deletes the database and creates it again
    }
}

package garg.ayush.noteappusingsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static garg.ayush.noteappusingsqlite.Constants.*;

public class TaskDb extends SQLiteOpenHelper {


    public TaskDb(Context context) {
        super(context, DB_NAME,  null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = CREATE + TABLE_NAME +
                RBR + COLUMN_ID + INTEGER + PRIMARY_KEY + COMMA
                + COLUMN_TITLE + TEXT + NOT_NULL + COMMA
                +COLUMN_DESCRIPTION+ TEXT+NOT_NULL+COMMA
                +COLUMN_STATUS+INTEGER+NOT_NULL+ LBR
                + TERMINATION;

        sqLiteDatabase.execSQL(query);
    }


    public void updateNote(Notes notes,int num){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, notes.id);
        contentValues.put(COLUMN_TITLE, notes.title);
        contentValues.put(COLUMN_DESCRIPTION,notes.des);
        contentValues.put(COLUMN_STATUS,num);

        getWritableDatabase()
                .update(TABLE_NAME,contentValues,COLUMN_ID+" = "+notes.id ,null);

    }


    public void deleteNote(Notes notes){
        getWritableDatabase()
                .delete(TABLE_NAME,COLUMN_ID+" = "+notes.id,null);
    }
    public long insertNote(Notes notes) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, notes.id);
        contentValues.put(COLUMN_TITLE, notes.title);
        contentValues.put(COLUMN_DESCRIPTION,notes.des);
        contentValues.put(COLUMN_STATUS,notes.status);

        long position = getWritableDatabase()
                .insert(TABLE_NAME,
                        null,
                        contentValues);
        return position;
    }

    public Notes getTaskWithID(Long id) {
        //return a task with the given ID
        Notes notes = null;

        Cursor cursor = getReadableDatabase().query(TABLE_NAME,
                null,
                COLUMN_ID + " = ?",
                new String[]{id.toString()},
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            int fetchedId = (int) cursor.getLong(0);
            String fetchedTitle = cursor.getString(1);
            String fetchedDescripton = cursor.getString(2);
            int fetchedStatus = cursor.getInt(3);
            notes = new Notes(fetchedId, fetchedTitle,fetchedDescripton,fetchedStatus);
        }

        cursor.close();

        return notes;
    }

    public ArrayList<Notes> getAllNotes() {

        ArrayList<Notes> notesArrayList= new ArrayList<>();

        Cursor c = getReadableDatabase().query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        while (c.moveToNext()) {

            int id = (int) c.getLong(c.getColumnIndex(COLUMN_ID.trim()));
            String title = c.getString(c.getColumnIndex(COLUMN_TITLE.trim()));
            String desc = c.getString(c.getColumnIndex(COLUMN_DESCRIPTION.trim()));
            int status = c.getInt(c.getColumnIndex(COLUMN_STATUS.trim()));
            Notes notes = new Notes(id, title,desc,status);
            notesArrayList.add(notes);
        }

        c.close();
        return notesArrayList;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}

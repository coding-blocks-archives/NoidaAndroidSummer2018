package garg.ayush.noteappusingroomandlivedata;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Notes.class},version = 1)
public abstract class NotesDatabase extends RoomDatabase{

    public abstract NotesDao getNotesDao();

}

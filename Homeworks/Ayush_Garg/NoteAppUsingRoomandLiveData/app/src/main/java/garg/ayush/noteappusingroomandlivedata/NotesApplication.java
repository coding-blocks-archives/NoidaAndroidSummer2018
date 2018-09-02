package garg.ayush.noteappusingroomandlivedata;

import android.app.Application;
import android.arch.persistence.room.Room;

public class NotesApplication extends Application {
    static NotesDatabase notesDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        notesDatabase= Room.
                databaseBuilder(getApplicationContext(),
                        NotesDatabase.class,
                        "notes-db")
                .allowMainThreadQueries()
                .build();
//                .fallbackToDestructiveMigration()

    }

    public static NotesDatabase getDb(){
        return notesDatabase;
    }
}

package garg.ayush.noteappusingroomandlivedata;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes")
    List<Notes> getAllNotes();

    @Query("SELECT * FROM notes WHERE id = :id")
    Notes noteWithID(int id);

    @Insert
    void insertNotesList(List<Notes> notes);

    @Insert
    void insertNotes(Notes... notes);

    @Update
    void updateNotes(Notes notes);

    @Delete
    void deleteNotes(Notes notes);
}

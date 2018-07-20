package garg.ayush.noteappusingroomandlivedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {

    private List<Notes> notesListLiveData;

    List<Notes> getNoteFromDatabase() {
        if (notesListLiveData == null)
            notesListLiveData= NotesApplication.getDb().getNotesDao().getAllNotes();
        return notesListLiveData;
    }
}

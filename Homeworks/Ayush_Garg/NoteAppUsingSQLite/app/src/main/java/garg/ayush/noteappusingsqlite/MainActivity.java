package garg.ayush.noteappusingsqlite;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TaskDb taskDb;
//    int count=0;
    FloatingActionButton fab;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskDb = new TaskDb(this);
        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<Notes> notesArrayList = fetchNotes();
//        count=notesArrayList.size();
        final NotesAdapter notesAdapter = new NotesAdapter(getBaseContext(),notesArrayList,taskDb);
        recyclerView.setAdapter(notesAdapter);
//        Log.e("TAG", "onClick:=============================================== "+notesArrayList.size() );

        final View DialogView = LayoutInflater.from(this).inflate(R.layout.dialog, null, true);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Add Note")
                .setView(DialogView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText title = DialogView.findViewById(R.id.title);
                        EditText desc = DialogView.findViewById(R.id.desc);
                        Notes notes = new Notes((int) System.currentTimeMillis(),title.getText().toString(),desc.getText().toString(),0);
                        desc.setText("");
                        title.setText("");
                        long position = taskDb.insertNote(notes);
//                        Log.e("TAG", "onClick: " + position );
//                        Log.e("TAG", "onClick:=============================================== "+notesArrayList.size() );
                        notesArrayList.add(notes);
                        notesAdapter.notifyDataSetChanged();
                    }
                })
                .create();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });
    }


    ArrayList<Notes> fetchNotes() {
        return taskDb.getAllNotes();
    }
}

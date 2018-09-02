package garg.ayush.noteappusingroomandlivedata;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    ArrayList<Notes> notesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewModel myViewModel = ViewModelProviders
                .of(this)
                .get(MyViewModel.class);


        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesArrayList = new ArrayList<>();
        if (NotesApplication.getDb().getNotesDao().getAllNotes().size()!=0) {
            notesArrayList = (ArrayList<Notes>) NotesApplication.getDb().getNotesDao().getAllNotes();
        }
        final NotesAdapter notesAdapter = new NotesAdapter(getBaseContext(), notesArrayList);
        recyclerView.setAdapter(notesAdapter);

        final View DialogView = LayoutInflater.from(this).inflate(R.layout.dialog, null, true);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Add Note")
                .setView(DialogView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText title = DialogView.findViewById(R.id.title);
                        EditText desc = DialogView.findViewById(R.id.desc);
                        Notes notes = new Notes((int) System.currentTimeMillis(), title.getText().toString(), desc.getText().toString(), 0);
                        desc.setText("");
                        title.setText("");

                        NotesApplication.getDb().getNotesDao().insertNotes(notes);
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


}

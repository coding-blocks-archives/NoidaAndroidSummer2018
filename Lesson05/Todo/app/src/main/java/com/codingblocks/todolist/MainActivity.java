package com.codingblocks.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    ArrayList<Note> notesArrayList = new ArrayList<>();
    EditText etNote;
    ListView lvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.btnAddNote);
        etNote = findViewById(R.id.noteEt);
        lvNote = findViewById(R.id.notesLV);
        final NotesAdapter notesAdapter = new NotesAdapter(notesArrayList,this);
        lvNote.setAdapter(notesAdapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = etNote.getText().toString();
                notesArrayList.add(new Note(note));
                notesAdapter.notifyDataSetChanged(); //Tells the adapter to render the changed dataset
            }
        });

    }
}

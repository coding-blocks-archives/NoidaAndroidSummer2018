package com.codingblocks.recyclerviewcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    ArrayList<Note> notesArrayList = new ArrayList<>();
    EditText etNote;
    RecyclerView rvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.btnAddNote);
        etNote = findViewById(R.id.noteEt);
        rvNote = findViewById(R.id.rvNotes);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager glm = new GridLayoutManager(this,2);
        StaggeredGridLayoutManager stgm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        rvNote.setLayoutManager(stgm);
        final NotesAdapter notesAdapter = new NotesAdapter(this,notesArrayList);
        rvNote.setAdapter(notesAdapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = etNote.getText().toString();
                notesArrayList.add(new Note(note));
                notesAdapter.notifyDataSetChanged();
            }
        });
    }
}

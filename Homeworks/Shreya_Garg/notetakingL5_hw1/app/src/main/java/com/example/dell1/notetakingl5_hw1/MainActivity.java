package com.example.dell1.notetakingl5_hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    ArrayList<Note> notesArrayList = new ArrayList<>();
    EditText etNote;
    RecyclerView rvNote;
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn=findViewById(R.id.addbutton);
        etNote=findViewById(R.id.et1);
        rvNote=findViewById(R.id.recycleview);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        rvNote.setLayoutManager(llm);
        notesAdapter=new NotesAdapter(notesArrayList,this,rvNote);
        rvNote.setAdapter(notesAdapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yournote=etNote.getText().toString();
                etNote.setText(null);
                notesArrayList.add(new Note(yournote));
                notesAdapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(),"your note is added",Toast.LENGTH_SHORT).show();
                Log.e("MainActivity","after add" + yournote);
            }
        });
    }
}

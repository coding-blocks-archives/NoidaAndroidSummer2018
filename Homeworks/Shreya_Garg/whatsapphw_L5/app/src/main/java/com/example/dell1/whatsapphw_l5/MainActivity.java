package com.example.dell1.whatsapphw_l5;

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

    ArrayList<Note> notesArrayList = new ArrayList<>();
    RecyclerView rvnote;
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesArrayList.add(new Note("Shreya","Hi shreya","7:16"));
        notesArrayList.add(new Note("Rishabh","Hi rishabh","5:12"));
        notesArrayList.add(new Note("Mom","Hi Mom","22:06"));
        notesArrayList.add(new Note("Saakshi","Hi saakshi","1:16"));
        notesArrayList.add(new Note("Papa","Hi papa","9:12"));
        notesArrayList.add(new Note("CB android","Hello android","2:45"));
        notesArrayList.add(new Note("B-10","Hi B-10","23:00"));
        notesArrayList.add(new Note("Jiit Noida","Hi noida","6:10"));
        notesArrayList.add(new Note("Saurabh","Hi saurabh","5:30"));
        notesArrayList.add(new Note("Vaishali","Hi vaishali","20:22"));
        notesArrayList.add(new Note("Aditi","Hi aditi","12:15"));
        notesArrayList.add(new Note("Ganesh","Hi ganeshji","10:55"));
        notesArrayList.add(new Note("All the best!","good luck!","14:09"));
        rvnote=findViewById(R.id.rvNote);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        rvnote.setLayoutManager(llm);
        notesAdapter=new NotesAdapter(notesArrayList,this);
        rvnote.setAdapter(notesAdapter);
    }
}

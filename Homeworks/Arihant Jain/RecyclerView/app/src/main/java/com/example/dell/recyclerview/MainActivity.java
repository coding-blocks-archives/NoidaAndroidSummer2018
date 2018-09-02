package com.example.dell.recyclerview;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
Button addbtn;
EditText etNote;
RecyclerView rvNote;
ArrayList<id> noteArrayList=new ArrayList<>();
id q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addbtn=findViewById(R.id.btn1);
        etNote=findViewById(R.id.text);
        rvNote=findViewById(R.id.rec);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        GridLayoutManager glm=new GridLayoutManager(this,2);
        StaggeredGridLayoutManager stgm=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        rvNote.setLayoutManager(llm);

     //   SharedPreferences sharedPreferences = getSharedPreferences("my_shared_prefs", MODE_PRIVATE);
       // String a = sharedPreferences.getString("COUNT",null);
       // tvName.setText(String.valueOf(count));

        final NoteAdapter noteAdapter=new NoteAdapter(this,noteArrayList,q);
        rvNote.setAdapter(noteAdapter);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note=etNote.getText().toString();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                String time = "" + format.format(c.getTime());
                String color="dede";
                q=new id(note,time,color);
                noteArrayList.add(q);
                noteAdapter.notifyDataSetChanged();
            }
        });
    }
}

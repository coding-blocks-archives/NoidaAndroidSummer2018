package com.example.ashu.lnotes;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<NotesInfo> myNotesArrayList = new ArrayList<>();
    EditText updateTitleView,updateContentView;
    TextView t1,t2;

    NotesInfo myNotesInfo;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        updateContentView = findViewById(R.id.setContentView);
//        updateTitleView = findViewById(R.id.setTitleView);
        FloatingActionButton button = findViewById(R.id.fabBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(),EditActivity.class);
                startActivity(myIntent);

            }
        });
        NoteAdapter noteAdapter = new NoteAdapter(MainActivity.this, myNotesArrayList);
        myNotesInfo = getIntent().getParcelableExtra("Notes");
            listView = findViewById(R.id.list_view);
            listView.setAdapter(noteAdapter);

        if(myNotesInfo!= null) {
            myNotesArrayList.add(new NotesInfo(myNotesInfo.getmTitle(),myNotesInfo.getmContent(),myNotesInfo.getmTime()));
             noteAdapter.notifyDataSetChanged();
        }

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////               updateTitleView = view.findViewById(R.id.setTitleView);
////               updateContentView = view.findViewById(R.id.setContentView);
//                t1 = view.findViewById(R.id.)
//                  Toast.makeText(getBaseContext(),""+)
//
//            }
//        });
//
//

    }
}

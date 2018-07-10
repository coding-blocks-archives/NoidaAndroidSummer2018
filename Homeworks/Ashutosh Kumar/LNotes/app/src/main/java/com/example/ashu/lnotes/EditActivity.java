package com.example.ashu.lnotes;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class EditActivity extends AppCompatActivity {
    ArrayList<NotesInfo> myNotes = new ArrayList<>();
    EditText getTitleText,getContentText;
    FloatingActionButton saveButton;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        getTitleText = findViewById(R.id.setTitleView);
        getContentText = findViewById(R.id.setContentView);
        saveButton = findViewById(R.id.saveView);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                myNotes.add(new NotesInfo(getTitleText.getText().toString(),getContentText.getText().toString(),getDate()));
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                Toast.makeText(getBaseContext(),"Note Saved",Toast.LENGTH_SHORT).show();
                intent.putExtra("Notes", new NotesInfo(getTitleText.getText().toString(),getContentText.getText().toString(),getDate()));
                 startActivity(intent);
            }
        });


    }

    public String getDate() {

        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
// you can get seconds by adding  "...:ss" to it
  //      date.setTimeZone(TimeZone.getDefault());

        String localTime = date.format(currentLocalTime);
        return localTime;
    }
}

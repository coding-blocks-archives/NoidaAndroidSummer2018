package com.example.dhirajchhabraeng.lecture5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button addButton;
    private ListView listView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.inputNotes);
        addButton = findViewById(R.id.add_button);
        listView = findViewById(R.id.list_view);

        final ArrayList<Note> notesList = new ArrayList<>();

        final NotesAdapter notesAdapter = new NotesAdapter(this, notesList);

        listView.setAdapter(notesAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss a");
                String strTime = sdf.format(c.getTime());

                String inputText = editText.getText().toString();
                editText.setText("");

                notesList.add(new Note("" + strTime,
                        "" + inputText,
                        "note=>" + inputText + " <= note"));

                notesAdapter.notifyDataSetChanged();
            }
        });
    }
}

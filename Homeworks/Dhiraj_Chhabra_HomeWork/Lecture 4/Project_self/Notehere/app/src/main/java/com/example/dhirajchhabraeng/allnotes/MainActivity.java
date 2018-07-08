package com.example.dhirajchhabraeng.allnotes;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhirajchhabraeng.allnotes.R;
import com.example.dhirajchhabraeng.allnotes.NotesAdapter;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText notesEditText;
    private EditText titleEditText;
    private FloatingActionButton tickBox;
    private android.support.design.widget.FloatingActionButton addButton;
    private ListView listView;
    private Drawable imageId;
    private RelativeLayout mainScreenRootLayout;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesEditText = findViewById(R.id.input_text);
        notesEditText.setVisibility(View.GONE);

        addButton = findViewById(R.id.add_button);
        tickBox = findViewById(R.id.tickbox);
        tickBox.setVisibility(View.GONE);
        mainScreenRootLayout = findViewById(R.id.mainScreenRoot_layout);
        imageId = mainScreenRootLayout.getBackground();
        mainScreenRootLayout.setBackground(getResources().getDrawable(R.drawable.intital));

        final ArrayList<Note> notesList = new ArrayList<>();

        final NotesAdapter notesAdapter = new NotesAdapter(this, notesList);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(notesAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Title");
                alertDialog.setMessage("Enter Title");

                titleEditText = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);

                titleEditText.setLayoutParams(lp);

                alertDialog.setView(titleEditText);

                alertDialog.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String titleText = titleEditText.getText().toString();
                                tickBox.setVisibility(View.VISIBLE);
                                notesEditText.setVisibility(View.VISIBLE);
                                addButton.setVisibility(View.GONE);
                            }
                        });

                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }

        });

        tickBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notesText = notesEditText.getText().toString();
                notesEditText.setText("");
                tickBox.setVisibility(View.GONE);
                notesEditText.setVisibility(View.GONE);
                addButton.setVisibility(View.VISIBLE);

                String titleText = titleEditText.getText().toString();

                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
                String strTime = sdf.format(c.getTime());

                Note note = new Note("" + strTime, "" + titleText, "" + notesText);

                if (notesList.size() == 0) {
                    mainScreenRootLayout.setBackground(imageId);
                }

                notesList.add(note);

                notesAdapter.notifyDataSetChanged();
            }
        });

    }
}



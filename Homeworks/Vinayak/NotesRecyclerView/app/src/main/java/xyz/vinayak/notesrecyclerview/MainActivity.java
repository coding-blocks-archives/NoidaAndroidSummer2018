package xyz.vinayak.notesrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    ArrayList<Note> noteArrayList = new ArrayList<>();
    EditText noteEt;
    Button btnNoteAdd;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteEt = findViewById(R.id.noteEt);
        btnNoteAdd = findViewById(R.id.btnNoteAdd);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager glm = new GridLayoutManager(this,2);
        StaggeredGridLayoutManager stglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

//        recyclerView.setLayoutManager(stglm);

        final NotesAdapter notesAdapter = new NotesAdapter(noteArrayList,this);

        recyclerView.setAdapter(notesAdapter);

        btnNoteAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteText = noteEt.getText().toString();
                if(! noteText.equals("")){
                    noteEt.setText("");
                    noteArrayList.add(new Note(noteText,getDateTime()));
                    notesAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    private String getDateTime() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm aa");
        String datetime = dateformat.format(c.getTime());
        return datetime;
    }
}

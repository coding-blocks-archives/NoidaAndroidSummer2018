package garg.ayush.notetakingapp;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    ArrayList<Note> notesArrayList = new ArrayList<>();
    EditText etNote;
    int count= 0;
    RecyclerView recyclerView;

    class Note {
        String noteString;
        int count;

        public Note(String noteString, int count) {
            this.noteString = noteString;
            this.count = count;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPreferences = getSharedPreferences("Notes",MODE_PRIVATE);
        if(sharedPreferences.contains("Size")){
            count=sharedPreferences.getInt("Size",0);
            for(int i=0;i<count;i++){
                String text = sharedPreferences.getString(String.valueOf(i),"");
                notesArrayList.add(new Note(text,i));
            }
        }
        addBtn = findViewById(R.id.btnAddNote);
        etNote = findViewById(R.id.noteEt);
        recyclerView = findViewById(R.id.notesRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final NotesAdapter notesAdapter = new NotesAdapter();
        recyclerView.setAdapter(notesAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String note = etNote.getText().toString();
                notesArrayList.add(new Note(note, count));
                count++;
                notesAdapter.notifyDataSetChanged();
                etNote.setText("");
            }
        });
    }

    class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflatedView = li.inflate(R.layout.item_row, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflatedView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            Note note = notesArrayList.get(position);
            String enteredText = note.noteString;
            holder.noteText.setText(enteredText);

            final Note finalnote = note;
            final ViewHolder vh = holder;

            final int i = position;
            holder.deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vh.noteText.setBackgroundColor(android.graphics.Color.parseColor("#3d96e9"));
                    notesArrayList.remove(i);
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return notesArrayList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private TextView noteText;
            private Button deletebtn;

            public ViewHolder(View itemView) {
                super(itemView);
                noteText = itemView.findViewById(R.id.text);
                deletebtn = itemView.findViewById(R.id.delete_btn);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences("Notes", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int num=0;
        for (int i = 0; i < notesArrayList.size(); i++) {
            Note note= notesArrayList.get(i);
            editor.putString(String.valueOf(num), note.noteString);
            num++;
        }
        editor.putInt("Size", num);
        editor.apply();
    }
}
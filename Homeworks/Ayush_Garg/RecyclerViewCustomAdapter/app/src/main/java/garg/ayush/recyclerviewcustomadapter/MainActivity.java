package garg.ayush.recyclerviewcustomadapter;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    ArrayList<Note> notesArrayList = new ArrayList<>();
    EditText etNote;
    RecyclerView recyclerView;

    class Note{
        public String getNoteString() {
            return noteString;
        }

        public void setNoteString(String noteString) {
            this.noteString = noteString;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Note(String noteString, int count) {
            this.noteString = noteString;
            this.count = count;
        }

        String noteString;
        int count;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.btnAddNote);
        etNote = findViewById(R.id.noteEt);
        recyclerView= findViewById(R.id.notesRV);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager glm = new GridLayoutManager(this,2);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        final NotesAdapter notesAdapter= new NotesAdapter();
        recyclerView.setAdapter(notesAdapter);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(MainActivity.this, "HI", Toast.LENGTH_SHORT).show();
                String note = etNote.getText().toString();
                notesArrayList.add(new Note(note,0));
                notesAdapter.notifyDataSetChanged(); //Tells the adapter to render the changed dataset;
                etNote.setText("");
                Log.e("hi", "onClick: ");

            }
        });

    }


    class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater li = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflatedView = li.inflate(R.layout.item_row, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflatedView);
            return  viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            Note note=notesArrayList.get(position);
            String enteredText = note.noteString;
            holder.noteText.setText(enteredText);


            //Time Set
            long currentTimeAndDate= System.currentTimeMillis();
            Calendar calendar =Calendar.getInstance();
            String day = calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());
            String date = DateFormat.getDateInstance().format(new Date());
            String time = DateFormat.getTimeInstance().format(new Date());
            calendar.setTimeInMillis(currentTimeAndDate);
            holder.noteTime.setText(calendar.getTime()+"");
            holder.noteTime.setText(day+" "+date+" "+time);



            int Count = note.getCount();
            if(Count%3==0){
                holder.noteText.setBackgroundColor(android.graphics.Color.parseColor("#5bf403"));
            }else if (Count%3==1){
                holder.noteText.setBackgroundColor(android.graphics.Color.parseColor("#FFFFEA00"));
            }else{
                holder.noteText.setBackgroundColor(android.graphics.Color.parseColor("#FFFF0000"));
            }

            final Note finalnote = note;
            final ViewHolder vh=holder;

            vh.noteText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int count=finalnote.getCount();
                    finalnote.setCount(count+1);
                    int clickCount = finalnote.getCount();

                    if(clickCount%3==0){
                        vh.noteText.setBackgroundColor(android.graphics.Color.parseColor("#5bf403"));
                    }else if (clickCount%3==1){
                        vh.noteText.setBackgroundColor(android.graphics.Color.parseColor("#FFFFEA00"));
                    }else{
                        vh.noteText.setBackgroundColor(android.graphics.Color.parseColor("#FFFF0000"));
                    }
//                    notifyDataSetChanged();
                }
            });

            final int i= position;
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

        class ViewHolder extends RecyclerView.ViewHolder{

            private TextView noteText,noteTime;
            private Button deletebtn;
            private RelativeLayout relativeLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                noteText=itemView.findViewById(R.id.text);
                noteTime=itemView.findViewById(R.id.idtime_date);
                deletebtn=itemView.findViewById(R.id.delete_btn);
                relativeLayout=itemView.findViewById(R.id.relativeLayoutid);
            }
        }
    }
}
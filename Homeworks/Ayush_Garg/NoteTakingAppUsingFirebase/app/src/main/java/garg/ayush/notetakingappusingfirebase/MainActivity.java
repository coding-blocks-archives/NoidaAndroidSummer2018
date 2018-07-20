package garg.ayush.notetakingappusingfirebase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FirebaseAuth.AuthStateListener{

    RecyclerView recyclerView;
    EditText editText;
    Button button;
    DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);

        button = findViewById(R.id.btn);

        editText = findViewById(R.id.note);

        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


        rootRef = firebaseDatabase.getReference();


    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if(firebaseAuth.getCurrentUser() == null){

        }else{

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = editText.getText().toString();
                    Notes notes = new Notes(text);
                    rootRef.push().setValue(notes);
                }
            });





            rootRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                    ArrayList<Notes> notesArrayList = new ArrayList<>();

                    for (DataSnapshot ds : dataSnapshots) {
                        Notes currentNote = ds.getValue(Notes.class);
                        notesArrayList.add(currentNote);

//                    Log.e("TAG", "onDataChange: " + currentTask.id);
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                    final NotesAdapter notesAdapter = new NotesAdapter(getBaseContext(), notesArrayList);
                    recyclerView.setAdapter(notesAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });


            rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                    ArrayList<Notes> notesArrayList = new ArrayList<>();


//                for(int i=0;i<notesArrayList.size();i++) {
//                    DataSnapshot ds = dataSnapshot[i];
//                }

                    for (DataSnapshot ds : dataSnapshots) {
                        Notes currentNote = ds.getValue(Notes.class);
                        notesArrayList.add(currentNote);

                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext());
//                        .getReverseLayout(true));

                    final NotesAdapter notesAdapter = new NotesAdapter(getBaseContext(), notesArrayList);
                    recyclerView.setAdapter(notesAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            rootRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();

                    for (DataSnapshot ds : dataSnapshots) {
                        Task currentTask = ds.getValue(Task.class);
                        Log.e("TAG", "onDataChange: " + currentTask.id);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
            rootRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Task currentTask = dataSnapshot.getValue(Task.class);

                    //Add ths task to the ArrayList.
                    //call notify data set changed
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}

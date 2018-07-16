package com.codingblocks.firebaseapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ChildEventListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etName = findViewById(R.id.etName);

        Button btnPush = findViewById(R.id.btnPush);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference rootRef = firebaseDatabase.getReference();

        btnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredName = etName.getText().toString();
                //Submit the entered data to firebase

                Task task = new Task(enteredName,
                        " Current time is ",
                        System.currentTimeMillis());

                DatabaseReference newRef = rootRef.push();
                newRef.setValue(task);
            }
        });

//        rootRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
////                Task currentTask = dataSnapshot.getValue(Task.class);
//
//                Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
//
//                for (DataSnapshot ds : dataSnapshots) {
//                    Task currentTask = ds.getValue(Task.class);
//                    Log.e("TAG", "onDataChange: " + currentTask.getId());
//                    Log.e("TAG", "onDataChange: " + currentTask.getTitle());
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //Fetch the data
//                //Attach the listener for childEventListener
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        rootRef.addChildEventListener(this);
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        Task task = dataSnapshot.getValue(Task.class);
        //Add this task to the arraylist
        //Call notifyDatasetChanged on the adapter

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
}
